function loadDriverList(pageInfo) {
    if (pageInfo == undefined) {
        var pageInfo = { pageNumber: 1, pageSize: 13 };
    }
    $("#DriverTable").bootstrapTable('destroy').bootstrapTable({
        // url: 'http://localhost/car/defcar/json/driverList.json',
        url: allurl + '/car-management/driver/CarDriverList.action',
        dataType: 'json',
        striped: true, //是否显示行间隔色
        toggle: "table",
        toolbar: "toolbar_DriverTable",
        pagination: "true", //是否显示分页（*）
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: pageInfo.pageNumber, //初始化加载第一页，默认第一页
        pageSize: pageInfo.pageSize, //每页的记录行数（*）
        paginationShowPageGo: true,
        pageList: [10, 20, 30, 40, 50, 100, 150], //可供选择的每页的行数（*）
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
        showExport: true, //是否显示导出按钮  
        buttonsAlign: "right", //按钮位置  
        exportTypes: ['excel'], //导出文件类型  
        exportOptions: {
            ignoreColumn: [0, 11], //忽略某一列的索引  
            fileName: '测试车辆-驾驶员管理列表', //文件名称设置  
            worksheetName: 'sheet1', //表格工作区名称  
            type: 'excel',
            tableName: '测试车辆-驾驶员管理列表',
            excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
        },
        exportDataType: "selected",
        uniqueId: "id", // 每一行的唯一标识  
        //得到查询的参数
        queryParams: function(params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                size: params.limit, //页面大小
                page: (params.offset / params.limit) + 1, //页码
                sort: params.sort, //排序列名  
                sortOrder: params.order, //排位命令（desc，asc） 
                driverName: $("#toolbar_DriverTable .driver_name").val(),
                driverGroup: $("#toolbar_DriverTable .driver_groups").val(),
            };
            return temp;
        },
        onLoadSuccess: function(res) {
            console.log(res);
            if (window.islogin == undefined || window.islogin == null) {
                $('#DriverTable').bootstrapTable('hideColumn', 'operate');
            } else if (window.islogin.data.roles.length > 0) {
                var userrole = [];
                for (var i = 0; i < window.islogin.data.roles.length; i++) {
                    userrole.push(window.islogin.data.roles[i].name);
                }
                var userroleString = userrole.toString();
                if (userroleString.indexOf("超级管理员") != -1 || userroleString.indexOf("驾驶员管理员") != -1) {
                    $('#DriverTable').bootstrapTable('showColumn', 'operate');
                    $("#driver_add_btn").show();
                    $("#del_driver_all").show();
                    $("#approve_all").show();
                    $("#driver_add_btn").show();
                    $("#cancel_approve_all").show();
                    $("#upload").show();
                } else {
                    $('#DriverTable').bootstrapTable('hideColumn', 'operate');
                    $("#driver_add_btn").hide();
                    $("#del_driver_all").hide();
                    $("#approve_all").hide();
                    $("#cancel_approve_all").hide();
                    $("#upload").hide();
                }
            }
        },
        onLoadError: function(res) {
            console.log(res);
            console.log(allurl + '/car-management/driver/CarDriverList.action');
            // console.log(url);
        },
        onPageChange: function(page, size) {
            var pageInfo = { pageNumber: page, pageSize: size };
            window.sessionStorage.pageInfo = JSON.stringify(pageInfo);
        },
        columns: [
            [{
                "title": "测试车辆-驾驶员管理列表",
                "halign": "center",
                "align": "center",
                "colspan": 11
            }],
            [{
                    field: "checkbox",
                    title: "全选",
                    checkbox: true,
                    align: 'center'
                }, {
                    field: 'index',
                    title: "序号",
                    valign: "middle",
                    align: "center",
                    width: "5%",
                    formatter: function(value, row, index) {
                        var pageSize = $('#DriverTable').bootstrapTable('getOptions').pageSize; //通过表的#id 可以得到每页多少条
                        var pageNumber = $('#DriverTable').bootstrapTable('getOptions').pageNumber; //通过表的#id 可以得到当前第几页
                        return pageSize * (pageNumber - 1) + index + 1; //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
                    }
                },
                { field: "name", title: "姓名", align: 'center', valign: "middle" },
                { field: "employeeCard", title: "员工卡号", align: 'center', valign: "middle" },
                { field: "iccard", title: "iccard", align: 'center', valign: "middle" },
                { field: "telephone", title: "电话", align: 'center', valign: "middle" },
                {
                    field: "groups",
                    title: "授权分组",
                    align: 'center',
                    formatter: function(value, row, index) {
                        var a = "";
                        if (value == null) {
                            a = '--';
                        } else {
                            for (var i = 0; i < value.length; i++) {
                                if (i == value.length - 1) {
                                    a += '<span>' + value[i].name + '</span>';
                                } else {
                                    a += '<span>' + value[i].name + '</span>,';
                                }
                            }
                        }
                        return a;
                    }
                }, {
                    field: "isallow",
                    title: "授权状态",
                    align: 'center',
                    formatter: function(value, row, index) {
                        var a = "";
                        if (value == null) {
                            a = '';
                        } else if (value == "禁止") {
                            a = '<span style="color:red">禁用</span>';
                        } else if (value == "正常") {
                            a = '<span style="color:green">正常</span>';
                        }
                        return a;
                    }
                }, { field: "allowStartTime", title: "起始日期", align: 'center' },
                { field: "allowEndTime", title: "终止日期", align: 'center' }, {
                    field: 'operate',
                    title: '操作',
                    align: 'center',
                    events: driveroperateEvents,
                    formatter: driveroperateFormatter
                }
            ]
        ]
    });
}
// 查询
$("#driver_search").unbind('click').bind('click', function() {
    loadDriverList();
})

function driveroperateFormatter(value, row, index) {
    if (row.isallow == "正常") {
        return [
            '<button type="button" id="btn_driverdel" class="my_btn btn btn-default  btn-sm" style="margin-right:15px;">删除</button>',
            '<button type="button" id="btn_driverup" class="my_btn btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
            '<button type="button" id="btn_drivercancelimpower" class="my_btn btn btn-default  btn-sm">禁用</button>'
        ].join('');
    } else {
        return [
            '<button type="button" id="btn_driverdel" class="my_btn btn btn-default  btn-sm" style="margin-right:15px;">删除</button>',
            '<button type="button" id="btn_driverup" class="my_btn btn btn-default  btn-sm" style="margin-right:15px;">修改</button>',
            '<button type="button" id="btn_driverimpower" class="my_btn btn btn-default  btn-sm">授权</button>'
        ].join('');
    }
}

window.driveroperateEvents = {
    'click #btn_driverdel': function(e, value, row, index) { //删除
        var delrow = [];
        delrow.push(row);
        deletAll(delrow, "driverdel");
    },
    'click #btn_driverup': function(e, value, row, index) { //修改
        console.log(row);
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("驾驶员修改");
        creatForm(addDrverInfo, "#add_model .modal-body form", "editDriver_btn");
        showData("#add_model .modal-body form", row); // 编辑时数据回显
        $(".editDriver_btn").unbind('click').bind('click', function() {
            var sub_data = $("#add_model .modal-body form").serialize();
            sub_data = sub_data + "&id=" + row.id;
            var sub_url = allurl + "/car-management/driver/update.action";
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "get", "editDriver_btn");
        })
    },
    'click #btn_driverimpower': function(e, value, row, index) { //授权
        loadDriverGroup();
        setTimeout(function() {
            var delrow = [];
            delrow.push(row);
            deletAll(delrow, "approve_all");
        }, 10);
    },
    'click #btn_drivercancelimpower': function(e, value, row, index) { //取消授权、禁用
        var delrow = [];
        delrow.push(row);
        deletAll(delrow, "cancelimpower");
    }
};
$("#driver_add_btn").unbind('click').bind('click', function() {
    $("#add_model").modal();
    $("#add_model #myModalLabel").html("驾驶员录入");
    creatForm(addDrverInfo, "#add_model .modal-body form", "subdriver_btn");
    $(".subdriver_btn").unbind('click').bind('click', function() {
        var sub_data = $("#add_model .modal-body form").serialize();
        var sub_url = allurl + "/car-management/driver/add.action";
        $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
        subData(sub_url, sub_data, "get", "subDriver_btn");
    })
});



// 删除选中的驾驶员
$("#del_driver_all").unbind('click').bind('click', function() {
    var driver_del_Arr = $("#DriverTable").bootstrapTable('getSelections');
    deletAll(driver_del_Arr, "driverdel");
});
// 取消授权
$("#cancel_approve_all").unbind('click').bind('click', function() {
    var driver_del_Arr = $("#DriverTable").bootstrapTable('getSelections');
    deletAll(driver_del_Arr, "cancelimpower");
});
//批量授权del_driver_all
$("#approve_all").unbind('click').bind('click', function() {
    loadDriverGroup();
    setTimeout(function() {
        var approve_Arr = $("#DriverTable").bootstrapTable('getSelections');
        deletAll(approve_Arr, "approve_all");
    }, 10);
});
// 新增驾驶员
var addDrverInfo = [
    { "name": "姓名", "type": "text", "inputName": "name", "must": "*" },
    { "name": "电话", "type": "text", "inputName": "telephone", "must": "" },
    { "name": "员工卡号", "type": "text", "inputName": "employeeCard", "must": "*" },
    { "name": "iccard", "type": "text", "inputName": "iccard", "must": "" },
    { "name": "准驾车型", "type": "text", "inputName": "allowcartype", "must": "*" },
    { "name": "备注", "type": "text", "inputName": "remark", "must": "" }
];