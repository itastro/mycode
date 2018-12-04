// 申请
var maintainApply = [
    { "name": "车辆编号", "type": "text", "inputName": "vSn", "must": "*" },
    { "name": "停放地点", "type": "text", "inputName": "send_park", "must": "*" },
    { "name": "维修项目", "type": "text", "inputName": "item", "must": "*" },
    { "name": "备注", "type": "text", "inputName": "applyRemark", "must": "" },
];
// 完成
var finishMaintain = [
    { "name": "车辆编号", "type": "text", "inputName": "vSn", "must": "*" },
    { "name": "停放地点", "type": "text", "inputName": "fin_park", "must": "" },
    { "name": "备注", "type": "text", "inputName": "remark", "must": "" },
];
// 分配
var dividedInfo = [
    { "name": "车辆编号", "type": "text", "inputName": "vSn", "must": "*" },
    { "name": "预计完成时间", "type": "end-3date", "inputName": "forecastTime", "must": "*" },
    {
        "name": "操作员",
        "type": "select",
        "inputName": "operator",
        "must": "*",
        "option": [{ "name": "成存玉" }]
    },
    { "name": "操作员电话", "type": "text", "inputName": "operatorTEL", "must": "*" },
    { "name": "工作内容", "type": "text", "inputName": "workContent", "must": "*" }
];

// 车辆编号校验
$("#maintainTypeIn .vSn").bind('input porpertychange', function() {
    console.log($("#maintainTypeIn .vSn").val());
    if ($("#maintainTypeIn .vSn").val() == null || $("#maintainTypeIn .vSn").val() == "") {
        return;
    } else {
        $.ajax({
            url: allurl + "/car-management/car/check/" + $("#maintainTypeIn .vSn").val() + "/1.action",
            type: "get",
            "dataType": "jsonp", // 数据类型为jsonp
            "jsonp": "jsonpCallback", // 服务端用于接收callback调用的function名的参数
            success: function(res) {
                console.log(res);
                if (res.ret == false) {
                    $(".m_vSn_tips").html("车辆编号正确");
                    $("#send_btn").attr("disabled", false);
                    $.ajax({
                        type: "get",
                        url: allurl + "/car-management/carMaintain/check/" + $("#maintainTypeIn .vSn").val() + ".action",
                        "dataType": "jsonp", // 数据类型为jsonp
                        "jsonp": "jsonpCallback", // 服务端用于接收callback调用的function名的参数
                        data: {},
                        success: function(dat) {
                            console.log(dat);
                            if (dat.ret == false) {
                                $(".send_tips").html("车辆已在维修列表");
                                $(".m_vSn_tips").html("车辆已在维修列表");
                                $("#send_btn").attr("disabled", true);
                            } else {
                                $("#send_btn").attr("disabled", false);
                                $(".send_tips").html("");
                            }
                        }
                    });
                } else {
                    $("#send_btn").attr("disabled", true);
                    $(".m_vSn_tips").html("车辆编号不正确");
                }
            }
        });

    }
});
// 初始化加载维修列表
function loadMaintainList(pageInfo) {
    if (pageInfo == undefined) {
        var pageInfo = { pageNumber: 1, pageSize: 7 };
    }
    $("#maintainTable").bootstrapTable('destroy').bootstrapTable({
        url: allurl + "/car-management/carmaintain/query.action",
        dataType: 'json',
        striped: true, // 是否显示行间隔色
        toggle: "table",
        toolbar: "toolbar_maintainTable",
        pagination: "true", // 是否显示分页（*）
        sortOrder: "asc", // 排序方式
        sidePagination: "server", // 分页方式：client客户端分页，server服务端分页（*）
        pageNumber: pageInfo.pageNumber, // 初始化加载第一页，默认第一页
        pageSize: pageInfo.pageSize, // 每页的记录行数（*）
        paginationShowPageGo: true,
        pageList: [10, 30, 50, 70, 100, 150], // 可供选择的每页的行数（*）
        search: false, // 是否搜索查询
        showColumns: true, // 是否显示所有的列
        showRefresh: false, // 是否显示刷新按钮
        sortable: true, // 是否启用排序
        minimumCountColumns: 2, // 最少允许的列数
        clickToSelect: true, // 是否启用点击选中行
        searchOnEnterKey: true, // 设置为 true时，按回车触发搜索方法
        strictSearch: false, // 设置为 true启用全匹配搜索， 否则为模糊搜索
        showToggle: true, // 是否显示切换视图（table/card）按钮
        searchAlign: "right",
        showExport: true,
        exportDataType: "selected",
        buttonsAlign: "right", // 按钮位置
        exportTypes: ['excel'], // 导出文件类型
        exportOptions: {
            ignoreColumn: [17], // 忽略某一列的索引
            fileName: '测试车辆-车辆维修列表', // 文件名称设置
            worksheetName: 'sheet1', // 表格工作区名称
            tableName: '测试车辆-车辆维修列表',
            excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
                // onMsoNumberFormat: DoOnMsoNumberFormat
        },
        uniqueId: "vSn", // 每一行的唯一标识
        onLoadSuccess: function(res) {
            console.log(res);
            if (window.islogin == undefined || window.islogin == null) {
                $('#maintainTable').bootstrapTable('hideColumn', 'operate');
            } else if (window.islogin.data.roles.length > 0) {
                var userrole = [];
                for (var i = 0; i < window.islogin.data.roles.length; i++) {
                    userrole.push(window.islogin.data.roles[i].name);
                }
                var userroleString = userrole.toString();
                if (userroleString.indexOf("超级管理员") != -1 || (userroleString.indexOf("维修管理员") != -1 || userroleString.indexOf("维修技师") != -1)) {
                    $('#maintainTable').bootstrapTable('showColumn', 'operate');
                } else {
                    $('#maintainTable').bootstrapTable('hideColumn', 'operate');
                }
            }
        },
        onLoadError: function() {
            console.log("数据加载失败！");
        },
        onPageChange: function(page, size) {
            var pageInfo = { pageNumber: page, pageSize: size };
            window.sessionStorage.pageInfo = JSON.stringify(pageInfo);
        },
        // 得到查询的参数
        queryParams: function(params) {
            // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                size: params.limit, // 页面大小
                page: (params.offset / params.limit) + 1, // 页码
                sortOrder: "desc", // 排位命令（desc 降序，asc）
                vSn: $(".maintain_top .mainList_vSn").val(),
                applyPeople: $(".maintain_top .applyPeople").val(),
                applyStartTime: $(".maintain_top .applyStartTime").val(),
                applyEndTime: $(".maintain_top .applyEndTime").val(),
                workContent: $(".maintain_top .workContent").val(),
                operator: $(".maintain_top .operator").val(),
                status: $("#mainList_status option:selected").val()
            };
            
            return temp;
        },
        columns: [
            [{
                "title": "测试车辆维修列表",
                "halign": "center",
                "align": "center",
                "colspan": 17
            }],
            [{ field: "checkbox", title: "全选", checkbox: true, valign: "middle", align: 'center', width: "4%", colspan: 1, rowspan: 2 },
                {
                    field: 'ids',
                    title: "序号",
                    valign: "middle",
                    align: "center",
                    width: "4%",
                    colspan: 1,
                    rowspan: 2,
                    formatter: function(value, row, index) {
                        var pageSize = $("#maintainTable").bootstrapTable('getOptions').pageSize; // 通过表的#id
                        var pageNumber = $("#maintainTable").bootstrapTable('getOptions').pageNumber; // 通过表的#id
                        return pageSize * (pageNumber - 1) + index + 1; // 返回每条的序号：
                    }
                },
                { title: "送修申请表", valign: "middle", align: "center", colspan: 7, rowspan: 1 },
                {
                    field: 'status',
                    title: "维修状态",
                    valign: "middle",
                    align: "center",
                    colspan: 1,
                    rowspan: 2,
                    width: "5%",
                    background: '#BFEBEB',
                    formatter: function(value, row, index) {
                        var a = "";
                        if (value == null) {
                            var a = '';
                        } else if (value == "排队中") {
                            var a = '<span style="color:red">排队中</span>';
                        } else if (value == "维修中") {
                            var a = '<span style="color:green">维修中</span>';
                        } else if (value == "已完成") {
                            var a = '<span style="color:blue">已完成</span>';
                        }
                        return a;
                    }
                }, {
                    title: "维修协调员填写",
                    valign: "middle",
                    align: "center",
                    colspan: 7,
                    rowspan: 1
                }
            ],
            [{ field: 'vSn', title: '车辆编号', valign: "middle", align: "center", width: "6%" },
                { field: 'item', title: '维修项目', valign: "middle", align: "center", width: "8%" },
                { field: 'send_park', title: '停放地点', valign: "middle", align: "center", width: "6%" },
                { field: 'applyRemark', title: '备注', valign: "middle", align: "center", width: "5%" },
                { field: 'applyPeople', title: '申请人', valign: "middle", align: "center", width: "6%" },
                { field: 'applyTEL', title: '电话', valign: "middle", align: "center", width: "6%" },
                { field: 'applytime', title: '申请日期', valign: "middle", align: "center", width: "7%" },
                { field: 'workContent', title: '工作内容', valign: "middle", align: "center", width: "6%" },
                { field: 'operator', title: '操作员', valign: "middle", align: "center", width: "5%" },
                { field: 'operatorTEL', title: '电话', valign: "middle", align: "center", width: "5%" },
                { field: 'forecastTime', title: '预计完成时间', valign: "middle", align: "center", width: "5%" },
                { field: 'fin_park', title: '停放地点', valign: "middle", align: "center", width: "5%" },
                { field: 'remark', title: '备注', valign: "middle", align: "center", width: "5%" },
                {
                    field: 'operate',
                    title: '操作',
                    valign: "middle",
                    align: 'center',
                    width: "12%",
                    events: maintainListoperateEvents,
                    formatter: maintainListFormatter
                }
            ]
        ]
    })
}

function maintainListFormatter(value, row, index) {
    if (window.islogin == undefined || window.islogin == null) {
        return "";
    } else if (window.islogin.data.roles.length > 0) {
        var userrole = [];
        for (var i = 0; i < window.islogin.data.roles.length; i++) {
            userrole.push(window.islogin.data.roles[i].name);
        }
        var userroleString = userrole.toString();
        if (userroleString.indexOf("超级管理员") != -1 || userroleString.indexOf("维修管理员") != -1) {
            if (row.status == "排队中") {
                return [
                    '<button type="button" id="btn_ChangeStatus" class="RoleOfA btn btn-default  btn-sm my_btn" style="margin-right:10px;margin-top:5px;">分配</button>',
                    '<a href="#" data-toggle="tab"><button type="button" disabled="disabled" id="finish_btn" class="RoleOfB btn btn-default  btn-sm my_btn" style="margin-right:10px;margin-top:5px;">完成</button></a>',
                    '<button type="button" id="btn_maintainTop" class="RoleOfA btn btn-default  btn-sm my_btn" style="margin-right:10px;">优先</button>',
                    '<button type="button" id="btn_upkeep" class="RoleOfA btn btn-default  btn-sm my_btn" style="margin-right:10px;">保养</button>'
                ].join('');
            } else {
                return [
                    '<button type="button" id="btn_ChangeStatus" class="RoleOfA btn btn-default  btn-sm my_btn" style="margin-right:10px;margin-top:5px;">分配</button>',
                    '<a href="#" data-toggle="tab"><button type="button" id="finish_btn" class="RoleOfB btn btn-default  btn-sm my_btn" style="margin-right:10px;margin-top:5px;">完成</button></a>',
                    '<button type="button" id="btn_maintainTop" class="RoleOfA btn btn-default  btn-sm my_btn" style="margin-right:10px;">优先</button>',
                    '<button type="button" id="btn_upkeep" class="RoleOfA btn btn-default  btn-sm my_btn" style="margin-right:10px;">保养</button>'
                ].join('');
            }
        } else if (userroleString.indexOf("维修技师") != -1) {
            if (row.status == "维修中") {
                return [
                    '<a href="#" data-toggle="tab"><button type="button" id="finish_btn" class="RoleOfB btn btn-default  btn-sm my_btn" style="margin-right:10px;margin-top:5px;">完成</button></a>',
                    '<button type="button" id="btn_upkeep" class="RoleOfA btn btn-default  btn-sm my_btn" style="margin-right:10px;">保养</button>'
                ].join('');
            } else if (row.status == "已完成") {
                return [
                    '<button type="button" id="btn_upkeep" class="RoleOfA btn btn-default  btn-sm my_btn" style="margin-right:10px;">保养</button>'
                ].join('');
            }

        } else { return ""; }
    }
}
window.maintainListoperateEvents = {
    'click #btn_upkeep': function(e, value, row, index) { // 保养
        $('#upkeep_model').modal();
        $('#upkeep_model .vSn').val(row.vSn);
        $('#upkeep_model .vSn').attr("readonly", true);
        window.sessionStorage.carInfo = JSON.stringify(row);
    },
    // 修改维修状态操作，分配任务-维修中
    'click #btn_ChangeStatus': function(e, value, row, index) {
        findEmployee();
        // console.log(row);
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("分配任务");
        creatForm(dividedInfo, "#add_model .modal-body form", "divided_btn");
        $("#add_model .workContent").val(row.workContent);
        $("#add_model .tel").val(operatetel[0]);
        $("#add_model .operator").change(function() {
            console.log(this.selectedIndex);
            $("#add_model .operatorTEL").val(operatetel[this.selectedIndex]);
        });
        $("#add_model .modal-body .vSn").val(row.vSn);
        $(".divided_btn").unbind('click').bind('click', function() { // 分配任务
            var sub_data = $("#add_model .modal-body form").serializeObject();
            sub_data.id = row.id;
            sub_data.operator = $("#add_model .operator option:selected").attr("value");
            sub_data = JSON.stringify(sub_data);
            var sub_url = allurl + "/car-management/carmaintain/assign.action";
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "post", "subdivided_btn");
        })
    },
    'click #finish_btn': function(e, value, row, index) { // 完成
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("维修完成");
        creatForm(finishMaintain, "#add_model .modal-body form", "finish_btn");
        $("#add_model .modal-body .vSn").val(row.vSn);
        $(".finish_btn").unbind('click').bind('click', function() { // 完成维修
            var sub_data = $("#add_model .modal-body form").serializeObject();
            sub_data.id = row.id;
            var sub_url = allurl + "/car-management/carmaintain/complete.action";
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            sub_data = JSON.stringify(sub_data);
            subData(sub_url, sub_data, "post", "finish_btn");
        });
    },
    // 置顶操作
    'click #btn_maintainTop': function(e, value, row, index) {
        var sub_url = allurl + "/car-management/carmaintain/top.action";
        var sub_data = { "id": row.id }
        subData(sub_url, sub_data, "get", "maintaintop");
    }
};

// 删除维修记录
$("#delmaintain_all").unbind('click').bind('click', function() {
    var maintainList_Arr = $("#maintainTable").bootstrapTable('getSelections');
    console.log(maintainList_Arr);
    deletAll(maintainList_Arr, "maintainList_del");
});
// 修改维修申请
$("#editApply").unbind('click').bind('click', function() {
    var a = $("#maintainTable").bootstrapTable('getSelections');
    if (a.length >= 1) {
        if (a.length > 1) {
            toastr.warning('只能选中一行进行修改', '提示', errormessageOpts);
            return;
        }
        creatForm(maintainApply, "#add_model .modal-body form", "editApply");
        showData("#add_model .modal-body form", a[0]); // 
        $("#add_model").modal();
        $(".editApply").unbind('click').bind('click', function() {
            var subcar_data = $("#add_model .modal-body form").serialize();
            
            subcar_data += "&applyTEL="+islogin.data.telephone;
            subcar_data += "&id="+ a[0].id;
//            subcar_data.id = a[0].id;
            console.log(subcar_data);
            var subcar_url = allurl + "/car-management/carmaintain/editApply.action";
//            subcar_data = JSON.stringify(subcar_data);
            
            subData(subcar_url, subcar_data, "get", "editApply");
            $(this).attr({
                "data-dismiss": "modal",
                "aria-label": "Close"
            });
        });
    } else {
        toastr.warning('请先选择要修改的行', '提示', errormessageOpts);
        return;
    }

});
// 新增维修申请
creatForm(maintainApply, "#add_maintain_apply .form-horizontal", "subMainApply_btn");
$(".subMainApply_btn").unbind('click').bind('click', function() {
    var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
    var subcar_data = $("#add_maintain_apply .form-horizontal").serializeObject();
    subcar_data.applyTEL = islogin.data.telephone;
    console.log(subcar_data);
    var subcar_url = allurl + "/car-management/carmaintain/apply.action";
    subcar_data = JSON.stringify(subcar_data);
    subData(subcar_url, subcar_data, "post", "subMaintainApply_btn");
});

// 保养记录提交
$("#upkeep_btn").unbind('click').bind('click', function() { // /car/maintenance/save/{vSn}/{mm}/{nt}.action
    var carInfo = window.sessionStorage.getItem("carInfo");
    carInfo = JSON.parse(carInfo);
    if ($(".upkeepForm .upkeep_odm").val() == "") {
        $(".upkeepForm .upkeep_odm").val(0)
    }
    var sub_url = allurl + "/car-management/car/maintenance/save/" + carInfo.vSn + "/" + $(".upkeepForm .upkeep_odm").val() +
        "/" + $(".upkeepForm #nextupkeepTime").val() + "/" + carInfo.id + ".action";
    var upkeep_item_arr = [];
    var itemname = $(".upkeepForm input[name='upkeepItem']:checked");
    var brandAndlabel = $(".upkeepForm input[name='upkeepItem']:checked").parent().siblings().children("input");
    for (var i = 0; i < itemname.length; i++) {
        upkeep_item_arr.push({ "itemName": itemname[i].value, "brandAndlabel": brandAndlabel[i].value })
    }
    sub_url = decodeURI(sub_url)
    var sub_data = JSON.stringify(upkeep_item_arr);
    subData(sub_url, sub_data, "post", "upkeep_btn");
    $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
})

// 保养记录查询
$("#auditLit_upkeep_record").unbind('click').bind('click', function() {
    window.sessionStorage.opterator = "upkeepRecord";
    var Arr = $("#maintainTable").bootstrapTable('getSelections');
    deletAll(Arr, "upkeepRecord");
});
// 维修记录
$("#auditLit_maintain_record").unbind('click').bind('click', function() {
    window.sessionStorage.opterator = "maintainRecord";
    var Arr = $("#maintainTable").bootstrapTable('getSelections');
    deletAll(Arr, "maintainRecord");
})

// 维修查询
$("#auditLit_search_btn").unbind('click').bind('click', function() {
    loadMaintainList();
}) 
var operatetel = [];
// 维修操作员管理
function findEmployee() { // 查询所有的维修技师
    $.ajax({
        url: allurl + "/car-management/carmaintain/findEmployee.action",
        success: function(res) {
            if (res.length <= 0) {
                toastr.warning('维修技师为空，请联系管理员', '提示', messageOpts);
                return;
            }
            operatetel = [];
            dividedInfo[2].option = [];
            for (var i = 0; i < res.length; i++) {
                operatetel.push(res[i].telephone);
                dividedInfo[2].option.push({ id: res[i].uid, name: res[i].nickname, remark: res[i].telephone })
            }
        }
    })
}