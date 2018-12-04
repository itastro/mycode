function loadPlateList(pageInfo) {
    if (pageInfo == undefined) {
        var pageInfo = { pageNumber: 1, pageSize: 10 };
    }
    $("#plateTable").bootstrapTable('destroy').bootstrapTable({
        url: allurl + '/car-management/license/query.action',
        dataType: 'json',
        striped: true, // 是否显示行间隔色
        toggle: "table",
        toolbar: "plateTable_toolbar",
        pagination: "true", // 是否显示分页（*）
        sortOrder: "asc", // 排序方式
        sidePagination: "server", // 分页方式：client客户端分页，server服务端分页（*）
        pageNumber: pageInfo.pageNumber, // 初始化加载第一页，默认第一页
        pageSize: pageInfo.pageSize, // 每页的记录行数（*）
        paginationShowPageGo: true,
        pageList: [10, 50, 100, 200, 300, 400, 500], // 可供选择的每页的行数（*）
        search: false, // 是否搜索查询
        showColumns: true, // 是否显示所有的列
        showRefresh: false, // 是否显示刷新按钮
        sortable: true, // 是否启用排序
        minimumCountColumns: 2, // 最少允许的列数
        clickToSelect: true, // 是否启用点击选中行
        searchOnEnterKey: true, // 设置为 true时，按回车触发搜索方法
        strictSearch: false, // 设置为 true启用全匹配搜索， 否则为模糊搜索
        onPageChange: function(page, size) {
            console.log('切换页事件 当前页数：第' + page + "页，每页显示数量" + size + "条");
            var pageInfo = { pageNumber: page, pageSize: size };
            window.sessionStorage.pageInfo = JSON.stringify(pageInfo);
        },
        showToggle: true, // 是否显示切换视图（table/card）按钮
        searchAlign: "right",
        showExport: true,
        exportDataType: "selected",
        buttonsAlign: "right", // 按钮位置
        exportTypes: ['excel'], // 导出文件类型
        exportOptions: {
            ignoreColumn: [0, 23], // 忽略某一列的索引
            fileName: '测试车辆-车牌列表', // 文件名称设置
            worksheetName: 'sheet1', // 表格工作区名称
            tableName: '测试车辆-车牌列表',
            excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
                // onMsoNumberFormat: DoOnMsoNumberFormat
        },
        uniqueId: "vSn", // 每一行的唯一标识
        queryParams: function(params) {
            var temp = {
                size: params.limit, // 页面大小
                page: (params.offset / params.limit) + 1, // 页码
                sort: params.sort, // 排序列名
                sortOrder: params.order, // 排位命令（desc，asc）
                vSn: $(".plate_top .vSn").val(), // 车辆编号
                lNo: $(".plate_top .lNo").val(), // 车牌号
                engineNumber: $(".plate_top .engineNumber").val(), // 发动机号
                vin: $(".plate_top .vin").val(), // 车架号
                applyTime: $(".plate_top .plate_applydata").val(), // 验车申请日
                lEndTime: $(".plate_top .plate_enddata").val(), // 车牌到期日
                maketime: $(".plate_top .maketime").val(), //车牌录入日
                vehicleInspection: $(".plate_top .yanche_state").val() // 验车状态
            };
            console.log(temp);
            return temp;
        },
        onLoadSuccess: function(res) {
            console.log(res);
            if (window.islogin == undefined || window.islogin == null) {
                $('#plateTable').bootstrapTable('hideColumn', 'operate');
            } else if (window.islogin.data.roles.length > 0) {
                var userrole = [];
                for (var i = 0; i < window.islogin.data.roles.length; i++) {
                    userrole.push(window.islogin.data.roles[i].name);
                }
                var userroleString = userrole.toString();
                if (userroleString.indexOf("超级管理员") != -1 || userroleString.indexOf("车牌管理员") != -1 || userroleString.indexOf("实习生") != -1) {
                    $('#plateTable').bootstrapTable('showColumn', 'operate');
                    $("#cancel_yanche").show();
                } else {
                    $('#plateTable').bootstrapTable('hideColumn', 'operate');
                    $("#cancel_yanche").hide();
                }
            }
        },
        onLoadError: function() {
            toastr.error('数据加载失败', "提示", messageOpts);
        },
        columns: [
            [{
                "title": "测试车辆-车牌列表",
                "halign": "center",
                "align": "center",
                "colspan": 24
            }],
            [{ field: "checkbox", title: "全选", checkbox: true, align: 'center', valign: "middle" },
                { field: 'index', title: "序号", valign: "middle", align: "center", width: "3%", formatter: function(value, row, index) { return index + 1; } },
                { field: "vSn", title: "车辆编号", align: 'center', valign: "middle", events: carVsnoperateEvents, formatter: carVsnoperateFormatter },
                { field: "project", title: "项目编号", align: 'center', valign: "middle", formatter: function(value, row, index) { return value.project_sn; } },
                { field: "project", title: "项目状态", align: 'center', valign: "middle", formatter: function(value, row, index) { return value.project_status; } },
                { field: "projectEngineer", title: "主管工程师", align: 'center', valign: "middle" },
                {
                    field: "customer",
                    title: "客户",
                    align: 'center',
                    valign: "middle",
                    formatter: function(value, row, index) {
                        if (value == null) {
                            return '';
                        } else {
                            return '<span style="width:85px;">' + value + '</span>';
                        }
                    }
                },
                { field: "car_status", title: "车辆状态", align: 'center', valign: "middle" },

                { field: "brandModeltwo", title: "厂牌型号（保）", align: 'center', valign: "middle" },
                { field: "vehicleQuality", title: "吨位", align: 'center', valign: "middle" },
                {
                    field: "engineNumber",
                    title: "发动机号",
                    align: 'center',
                    valign: "middle",
                    formatter: function(value, row, index) {
                        if (value == null) {
                            return '';
                        } else {
                            return '<span style="width:40px;word-break:break-all; word-wrap:break-all;">' + value + '</span>';
                        }
                    }
                },
                {
                    field: "vin",
                    title: "车架号",
                    align: 'center',
                    valign: "middle",
                    formatter: function(value, row, index) {
                        if (value == null) {
                            return '';
                        } else {
                            return '<span style="width:40px;word-break:break-all; word-wrap:break-all;">' + value + '</span>';
                        }
                    }
                },
                {
                    field: "endTime",
                    title: "保险终止日",
                    align: 'center',
                    valign: "middle",
                    formatter: function(value, row, index) {
                        if (value == "" || value == "1970-10-01") {
                            return "";
                        } else if (value == null) {
                            return "";
                        } else {
                            return '<span style="color:red">' + value + '</span>';
                        }
                    }
                },
                { field: "insRemark", title: "保险备注", align: 'center', valign: "middle" },
                {
                    field: "licenseEndTime",
                    title: "车牌到期日",
                    align: 'center',
                    valign: "middle",
                    formatter: function(value, row, index) {
                        if (value == "" || value == "1970-10-01") {
                            return "";
                        } else if (value == null) {
                            return "";
                        } else {
                            return '<span style="color:red">' + value + '</span>';
                        }
                    }
                },
                { field: "licenseNo", title: "车牌号", align: 'center', valign: "middle" },
                {
                    field: "llave",
                    title: "车牌剩余日期",
                    align: 'center',
                    valign: "middle",
                    formatter: function(value, row, index) {
                        var a = "";
                        if (value <= 0 && value != null) {
                            a = '<span style="color:red">过期' + value + '天</span>';
                        } else if (value > 0 && value <= 90) {
                            a = '<span style="color:blue">剩余' + value + '天</span>';
                        } else if (value != null) {
                            a = '<span style="color:green">剩余' + value + '天</span>';
                        } else if (value == null) {
                            a = "";
                        }
                        return a;
                    }
                },
                { field: "checkStaionType", title: "检测站车型", align: 'center', valign: "middle" },
                { field: "applytime", title: "验车申请日", align: 'center', valign: "middle" },
                {
                    field: "vehicleInspection",
                    title: "验车状态",
                    align: 'center',
                    valign: "middle",
                    formatter: function(value, row, index) {
                        var a = "";
                        if (value == null) {
                            var a = '';
                        } else if (value == "未申请") {
                            var a = '<span style="color:red">未申请</span>';
                        } else if (value == "已申请") {
                            var a = '<span style="color:green">已申请</span>';
                        }
                        return a;
                    }
                },
                { field: "remark", title: "车牌备注", align: 'center', valign: "middle" },
                { field: "adminName", title: "车管", align: 'center', valign: "middle" },
                { field: "maketime", title: "车牌录入日", align: 'center', valign: "middle" },
                { field: 'operate', title: '操作', align: 'center', valign: "middle", events: plateoperateEvents, formatter: plateoperateFormatter }
            ]
        ]
    });
}


function plateoperateFormatter(value, row, index) {
    if (window.islogin == undefined || window.islogin == null) {
        return '';
    } else {
        var userrole = [];
        for (var i = 0; i < window.islogin.data.roles.length; i++) {
            userrole.push(window.islogin.data.roles[i].name);
        }
        var userroleString = userrole.toString();
        if (userroleString.indexOf("超级管理员") != -1 || userroleString.indexOf("车牌管理员") != -1 || userroleString.indexOf("实习生") != -1) {
            return [
                '<button type="button" id="plate_update" class="my_btn btn btn-default btn-sm" >修改</button>',
                '<button type="button" id="plate_apply" class="my_btn btn btn-default btn-sm" >录入</button>',
            ].join('');
        } else {
            return '';
        }
    }


}
window.plateoperateEvents = {
    'click #plate_apply': function(e, value, row, index) { // 录入
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("车牌录入");
        creatForm(plateInfo, "#add_model .modal-body form", "plate_apply_btn");
        $("#add_model .modal-body .vSn").val(row.vSn);
        $("#add_model .modal-body input:text[name='licenseNo']").parent().parent().hide();
        $("#add_model .modal-body .licenseEndTime").parent().parent().hide();
        $("input:radio[name='whether']").change(function() {
            console.log($(this).val());
            if ($(this).val() == "是") {
                $("#add_model .modal-body input:text[name='licenseNo']").parent().parent().show();
                $("#add_model .modal-body .licenseEndTime").parent().parent().show();
            } else {
                $("#add_model .modal-body input:text[name='licenseNo']").parent().parent().hide();
                $("#add_model .modal-body .licenseEndTime").parent().parent().hide();
            }
        });
        $(".plate_apply_btn").unbind('click').bind('click', function() {
            var sub_data = $("#add_model .modal-body form").serializeObject();
            var sub_url = allurl + "/car-management/license/addLicense.action";
            sub_data = JSON.stringify(sub_data);
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "post", "sub_plate");
        });
    },
    'click #plate_update': function(e, value, row, index) { // 修改
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("车牌状态");
        creatForm(plateInfo, "#add_model .modal-body form", "plate_status_btn");
        showData("#add_model .modal-body", row);
        $("input:radio[name='whether'][value='是']").attr("checked", true);
        $("input:radio[name='whether']").change(function() {
            console.log($(this).val());
            if ($(this).val() == "是") {
                $("#add_model .modal-body input:text[name='licenseNo']").parent().parent().show();
                $("#add_model .modal-body input:text[name='licenseEndTime']").parent().parent().show();
            } else {
                $("#add_model .modal-body input:text[name='licenseNo']").parent().parent().hide();
                $("#add_model .modal-body input:text[name='licenseEndTime']").parent().parent().hide();
            }
        });
        $(".plate_status_btn").unbind('click').bind('click', function() {
            var sub_data = $("#add_model .modal-body form").serializeObject();
            var sub_url = allurl + "/car-management/license/updateLicense.action";
            sub_data = JSON.stringify(sub_data);
            subData(sub_url, sub_data, "post", "sub_plate");
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
        });
    }
};

$("#plate_search").unbind('click').bind('click', function() {
    loadPlateList();
})
$("#cancel_yanche").unbind('click').bind('click', function() { // 取消验车
    var yanche_Arr = $("#plateTable").bootstrapTable('getSelections');
    deletAll(yanche_Arr, "cancel_yanche");
});
// 车牌录入
var plateInfo = [
    { "name": "车辆编号", "type": "text", "inputName": "vSn", "must": "*" },
    {
        "name": "是否拿到车牌",
        "type": "radio",
        "inputName": "whether",
        "must": "*",
        "option": [{ "name": "是", "val": "是" }, { "name": "否", "val": "否" }]
    },
    { "name": "临时牌照号码", "type": "text", "inputName": "licenseNo", "must": "*" },
    { "name": "临时牌照终止日", "type": "end-platedate", "inputName": "licenseEndTime", "must": "*" },
    { "name": "车牌备注", "type": "text", "inputName": "remark", "must": "*" }
];