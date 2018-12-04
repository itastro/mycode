// 添加车辆分组
$(".addGroup_btn").unbind('click').bind('click', function() {
    $.ajax({
        "url": allurl + "/car-management/group/add.action",
        "type": "get",
        contentType: 'application/json;charset=UTF-8', //contentType很重要 
        // crossDomain: true, //cors解决post跨域问题，后台要进行相关配置
        "data": {
            "name": $("#groupForm .groupName").val(),
            "remark": $("#groupForm .groupRemark").val()
        },
        "success": function(res) {
            if (res.ret == true) {
                toastr.success('车辆分组添加成功', '添加车辆分组', messageOpts);
            } else {
                toastr.warning('车辆分组添加失败', '添加车辆分组', messageOpts);
            }
        }
    })
});
var role_checks = window.role_checks = [];
// 数据库 加载权限选项
function loadrightsList(paramsid) {
    $.ajax({
        "url": allurl + "/car-management/permission/permissionList.action",
        "type": "get",
        "dataType": "jsonp", //数据类型为jsonp  
        "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数  
        "success": function(res) {
            console.log(res);
            var checkboxHtml = "";
            var obj = res.rows;
            for (var i = 0; i < res.rows.length; i++) {
                checkboxHtml += '<input name="" type="checkbox" value="' + obj[i].name + '" pid="' + obj[i].pid + '"><label>' + obj[i].name + '</label>&nbsp;&nbsp;&nbsp;';
            }
            $(paramsid).html(checkboxHtml);
            var role_checkobjs = $("#apply_model .checkbox_group input");
            console.log(role_checkobjs);
            for (var k = 0; k < role_checkobjs.length; k++) {
                role_checkobjs[k].onclick = function() {
                    console.log(this);
                    console.log(this.checked);
                    if (this.checked) {
                        console.log(this.getAttribute("pid"));
                        window.role_checks.push(this.getAttribute("pid"));
                    } else {
                        if ($.inArray(this.getAttribute("pid"), role_checks) != -1) {
                            window.role_checks.remove(this.getAttribute("pid"));
                        }
                    }
                    console.log(window.role_checks);
                }
            }
        },
        "error": function(res) {
            console.log(res);
        }
    })
}
//加载 权限table列表
function loadRightsList() {
    $("#rightsList").bootstrapTable('destroy').bootstrapTable({
        url: allurl + '/car-management/permission/permissionList.action',
        dataType: 'json',
        striped: true, //是否显示行间隔色
        toggle: "table",
        toolbar: "rightsList_toolbar",
        pagination: "true", //是否显示分页（*）
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1, //初始化加载第一页，默认第一页
        pageSize: 15, //每页的记录行数（*）
        pageList: [15, 30, 50, 100], //可供选择的每页的行数（*）
        search: false, //是否搜索查询
        showColumns: true, //是否显示所有的列
        showRefresh: false, //是否显示刷新按钮
        sortable: true, //是否启用排序
        minimumCountColumns: 2, //最少允许的列数
        clickToSelect: true, //是否启用点击选中行
        searchOnEnterKey: true, //设置为 true时，按回车触发搜索方法
        strictSearch: false, //设置为 true启用全匹配搜索， 否则为模糊搜索
        showToggle: true, //是否显示切换视图（table/card）按钮
        searchAlign: "right",
        showExport: true,
        exportDataType: "selected",
        buttonsAlign: "right", //按钮位置  
        exportTypes: ['excel'], //导出文件类型 
        exportOptions: {
            ignoreColumn: [0, 11], //忽略某一列的索引  
            fileName: '测试车辆-车辆列表', //文件名称设置  
            worksheetName: 'sheet1', //表格工作区名称  
            tableName: '测试车辆-车辆列表',
            excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
        },
        exportDataType: "selected",
        uniqueId: "vSn", // 每一行的唯一标识  
        //得到查询的参数
        queryParams: carlistqueryParams,
        onLoadSuccess: function(res) {
            console.log(res);
        },
        onLoadError: function() {
            console.log("数据加载失败！");
        },
        columns: [
            [{
                "title": "测试车辆-车辆列表",
                "halign": "center",
                "align": "center",
                "colspan": 12
            }],
            [{ field: "checkbox", title: "全选", checkbox: true, align: 'center', valign: 'middle' },
                {
                    field: 'index',
                    title: "序号",
                    valign: "middle",
                    align: "center",
                    width: "5%",
                    formatter: function(value, row, index) {
                        var pageSize = $('#rightsList').bootstrapTable('getOptions').pageSize; //通过表的#id 可以得到每页多少条
                        var pageNumber = $('#rightsList').bootstrapTable('getOptions').pageNumber; //通过表的#id 可以得到当前第几页
                        return pageSize * (pageNumber - 1) + index + 1; //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号 } }
                    }
                },
                { field: "pid", title: "权限编号", align: 'center', valign: 'middle' },
                { field: "name", title: "权限名称", align: 'center', valign: 'middle' },
                { field: "keyWord", title: "关键字", align: 'center', valign: 'middle' },
                { field: "remark", title: "备注", align: 'center', valign: 'middle' },
                { field: "operator", title: "创建人", align: 'center', valign: 'middle' },
                { field: "createTime", title: "创建日期", align: 'center', valign: 'middle' },
                { field: 'operate', title: '操作', align: 'center', valign: 'middle', events: rightsOperateEventsDel, formatter: rightsOperateFormatterDel }
            ]
        ]
    });
    var rightsinfo = [
        { "name": "名称", "type": "text", "inputName": "name", "must": "*" },
        { "name": "关键字", "type": "text", "inputName": "keyWord", "must": "*" },
        { "name": "备注", "type": "text", "inputName": "remark", "must": "" }
    ];
    // 新增权限
    $("#btn_add_rights").unbind('click').bind('click', function() {
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("添加权限");
        creatForm(rightsinfo, "#add_model .modal-body form", "btn_add_rights");
        $(".btn_add_rights").unbind('click').bind('click', function() {
            var sub_url = allurl + "/car-management/permission/addPermission.action";
            var sub_data = $("#add_model .modal-body form").serialize();
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "get", "btn_add_rights");
        })
    });
}

var $tableRightsList = $('#rightsList');

function rightsOperateFormatterDel(value, row, index) {
    return [
        '<button type="button" id="rights_btn_mydel" class="RoleOfA btn btn-default optionBth  btn-sm">删除</button>'
    ].join('');
}
var rightsdelarr = [];
window.rightsOperateEventsDel = {
    'click #rights_btn_mydel': function(e, value, row, index) {
        console.log(row);
        rightsdelarr.push(row.pid);
        $(this).parent().parent().remove();
        // 删除权限操作
        $.ajax({
            "url": allurl + "/car-management/permission/deletePermission.action",
            "type": "get",
            "data": {
                "pids[]": rightsdelarr
            },
            "dataType": "jsonp", //数据类型为jsonp  
            "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数
            "success": function(res) {
                toastr.success(res.msg, '提示', messageOpts);
                loadRightsList();
            },
            "error": function(res) {
                console.log(res);
            }
        })
    }
};