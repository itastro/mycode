// 车辆录入
var addcarInfo = [
    { "name": "车辆编号", "type": "text", "inputName": "vSn", "must": "*" },
    { "name": "客户", "type": "text", "inputName": "customer", "must": "*" },
    { "name": "车辆名称", "type": "text", "inputName": "carName", "must": "*" },
    {
        "name": "项目编号",
        "type": "select",
        "inputName": "project_sn",
        "must": "*",
        "option": [{ "name": "请选择", "val": "请选择" }]
    },
    { "name": "车辆类型", "type": "text", "inputName": "vCarType", "must": "*" },
    { "name": "项目名称", "type": "text", "inputName": "project_name", "must": "" },
    { "name": "车管", "type": "text", "inputName": "adminName", "must": "*" },
    { "name": "项目工程师", "type": "text", "inputName": "projectEngineer", "must": "*" },
    {
        "name": "车辆分组",
        "type": "select",
        "inputName": "groupName",
        "must": "*",
        "option": [{ "name": "成存玉", "val": "成存玉" }, { "name": "方伟新", "val": "方伟新" },
            { "name": "刘琼组", "val": "刘琼组" }, { "name": "桂旭阳组", "val": "桂旭阳组" },
            { "name": "魏少华", "val": "魏少华" }, { "name": "吴宁", "val": "吴宁" },
            { "name": "贾俊峰", "val": "贾俊峰" }, { "name": "胡志明", "val": "胡志明" },
            { "name": "马欣", "val": "马欣" }
        ]
    },
    { "name": "联系电话", "type": "text", "inputName": "contactNumber", "must": "*" },
    { "name": "车辆颜色", "type": "text", "inputName": "color", "must": "*" },

    { "name": "发动机排量", "type": "text", "inputName": "engineCapacity", "must": "L*" },

    { "name": "车辆吨位", "type": "text", "inputName": "vehicleQuality", "must": "Kg*" },
    { "name": "发动机型号", "type": "text", "inputName": "engineType", "must": "*" },
    { "name": "座位容纳", "type": "text", "inputName": "seats", "must": "人*" },
    { "name": "车辆价值", "type": "text", "inputName": "price", "must": "万*" },
    { "name": "机油规格", "type": "text", "inputName": "oilspecification", "must": "*" },
    {
        "name": "车辆标签卡",
        "type": "select",
        "inputName": "iccard",
        "must": "",
        "option": [{ "name": "请选择", "val": "" }]
    },
    { "name": "轮胎规格", "type": "text", "inputName": "tyresize", "must": "*" },
    {
        "name": "车辆尾卡",
        "type": "select",
        "inputName": "backCard",
        "must": "",
        "option": [{ "name": "请选择", "val": "" }]
    },
    { "name": "前轮胎压力", "type": "text", "inputName": "frontTireP", "must": "*" },
    { "name": "变速箱油规格", "type": "text", "inputName": "gbts", "must": "*" },
    { "name": "后轮胎压力", "type": "text", "inputName": "reaTireP", "must": "*" },
    { "name": "燃油规则", "type": "text", "inputName": "fuelType", "must": "*" },
    { "name": "制作日期", "type": "today-date", "inputName": "makeTime", "must": "*" },
    { "name": "备注", "type": "text", "inputName": "remark", "must": "" }
];
// 用户注册
var userInfo = [
    { "name": "姓名", "type": "text", "inputName": "nickname", "must": "*" },
    { "name": "员工卡号", "type": "text", "inputName": "employeeCard", "must": "*" },
    { "name": "NET ID", "type": "text", "inputName": "netid", "must": "*" },
    { "name": "手机", "type": "text", "inputName": "telephone", "must": "*" },
    {
        "name": "所在Team",
        "type": "select",
        "inputName": "team",
        "must": "*",
        "option": [{ "name": "请选择" }]
    }
];
// 授权模态框
var approveInfo = [{
        "name": "是否授权",
        "type": "radio",
        "inputName": "isallow",
        "must": "",
        "option": [{ "name": "是" }, { "name": "否" }]
    }, {
        "name": "授权分组",
        "type": "checkbox",
        "inputName": "gid",
        "must": "",
        "option": [{ "name": "请先在驾驶员分组中添加分组", "val": "" }]
    },
    { "name": "授权起始日", "type": "today-date", "inputName": "startTime", "must": "*" },
    { "name": "授权终止日", "type": "endyear-date", "inputName": "endTime", "must": "*" },
];
// 分组列表
function creategroupTable(boxname, toolbarid, res,
    row1, row2, ifpage, row1name, row2name,
    ifoperate, userOperateEventsDel, userOperateFormatterDel, pagetype, tit) {
    $(boxname).bootstrapTable({
        data: res,
        toggle: "table",
        toolbar: toolbarid,
        pagination: ifpage, //是否显示分页（*）
        sortable: false, //是否启用排序
        sortOrder: "asc", //排序方式
        sidePagination: pagetype, //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1, //初始化加载第一页，默认第一页
        pageSize: 15, //每页的记录行数（*）
        pageList: [15, 30, 50, 100], //可供选择的每页的行数（*）
        paginationShowPageGo: true,
        search: true, //是否搜索查询
        showColumns: true, //是否显示所有的列
        showRefresh: false, //是否显示刷新按钮
        minimumCountColumns: 2, //最少允许的列数
        clickToSelect: true, //是否启用点击选中行
        searchOnEnterKey: true, //设置为 true时，按回车触发搜索方法
        strictSearch: false, //设置为 true启用全匹配搜索， 否则为模糊搜索
        showToggle: true, //是否显示切换视图（table/card）按钮
        searchAlign: "right",
        columns: [
            [{
                "title": tit,
                "halign": "center",
                "align": "center",
                "colspan": 9
            }],
            [{ field: "checkbox", title: "全选", checkbox: true, align: 'center', sortable: true },
                { field: "index", title: "序号", align: 'center', sortable: true, formatter: function(value, row, index) { return index + 1; } },
                { field: row1, title: row1name, align: 'center', sortable: true },
                { field: row2, title: row2name, align: 'center', sortable: true },
                { field: 'operate', title: '操作', align: 'center', events: userOperateEventsDel, formatter: userOperateFormatterDel }
            ]
        ]
    });
    // 隐藏表格中的某一列
    if (!ifoperate) {
        $(boxname).bootstrapTable('hideColumn', 'operate');
    }
}
// 车辆分组列表
function loadCarGroup() {
    var url = allurl + "/car-management/group/getGroup.action";
    $.ajax({
        "url": url,
        "type": "get",
        "success": function(res) {
            if (res.length <= 0) {
                toastr.warning('车辆分组为空，请先前添加车辆分组', '提示', messageOpts);
                return;
            }
            $('#cargroupTable').bootstrapTable('destroy');
            creategroupTable("#cargroupTable", "#cargroup_toolbar", res,
                "name", "remark", true, "分组名称", "分组备注",
                true, carGroupOperateEvents, carGroupOperateFormatter, "client", "车辆分组列表");
            addcarInfo[8].option = [];
            userInfo[4].option = [];
            for (var i = 0; i < res.length; i++) {
                addcarInfo[8].option.push({ id: res[i].id, name: res[i].name, remark: res[i].remark })
                userInfo[4].option.push({ id: res[i].id, name: res[i].name, remark: res[i].remark })
            }
            creatForm(addcarInfo, "#carTypeIn .cartypein_apply", "sub_cartypein");
        },
        "error": function(res) {
            console.log(res);
        }
    });
}

// 驾驶员分组列表
function loadDriverGroup() {
    var url = allurl + "/car-management/driver/group/getGroup.action";
    $.ajax({
        "url": url,
        "type": "get",
        contentType: 'application/json;charset=UTF-8', //contentType很重要 
        crossDomain: true,
        "success": function(res) {
            if (res.length <= 0) {
                toastr.warning('驾驶员分组为空，请先前添加驾驶员分组', '提示', messageOpts);
                return;
            }
            $('#drivergroupTable').bootstrapTable('destroy');
            creategroupTable("#drivergroupTable", "#drivergroupTable_toolbar", res,
                "name", "remark", true, "分组名称", "分组备注",
                true, driverGroupOperateEvents, driverGroupOperateFormatter, "client", "驾驶员分组列表");
            // addDrverInfo[4].option = [];
            approveInfo[1].option = [];
            for (var i = 0; i < res.length; i++) {
                approveInfo[1].option.push({ id: res[i].id, name: res[i].name, val: res[i].id }) // addDrverInfo[4].option.push({ id: res[i].id, name: res[i].name, remark: res[i].remark })
            }
        },
        "error": function(res) {
            console.log(res);
        }
    });
}

function driverGroupOperateFormatter(value, row, index) {
    return [
        '<button type="button" id="del_drivergroup" class="btn btn-default btn-sm" style="margin-right:15px;">删除</button>',
        '<button type="button" id="update_drivergroup" class="btn btn-default btn-sm">修改</button>'
    ].join('');
}
window.driverGroupOperateEvents = {
    'click #del_drivergroup': function(e, value, row, index) {
        var delrow = [];
        delrow.push(row);
        deletAll(delrow, "drivergroupdel");
    },
    'click #update_drivergroup': function(e, value, row, index) {
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("驾驶员分组修改");
        creatForm(addGroupInfo, "#add_model .modal-body form", "editDrivergroup_btn");
        showData("#add_model .modal-body form", row); // 编辑时数据回显
        $(".editDrivergroup_btn").unbind('click').bind('click', function() {
            var sub_data = $("#add_model .modal-body form").serializeObject();
            sub_data.id = row.id;
            sub_data = JSON.stringify(sub_data);
            var sub_url = allurl + "/car-management/driver/group/updateGroup.action";
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "post", "editDrivergroup_btn");
        })
    }
};

function carGroupOperateFormatter(value, row, index) {
    return [
        '<button type="button" id="del_cargroup" class="btn btn-default  btn-sm" style="margin-right:15px;">删除</button>',
        '<button type="button" id="update_cargroup" class=" btn btn-default  btn-sm">修改</button>'
    ].join('');
}
window.carGroupOperateEvents = {
    'click #del_cargroup': function(e, value, row, index) {
        var delrow = [];
        delrow.push(row);
        deletAll(delrow, "cargroupdel");
    },
    'click #update_cargroup': function(e, value, row, index) {
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("车辆分组修改");
        creatForm(addGroupInfo, "#add_model .modal-body form", "editcarGroup_btn");
        showData("#add_model .modal-body form", row); // 编辑时数据回显
        $(".editcarGroup_btn").unbind('click').bind('click', function() {
            var sub_data = $("#add_model .modal-body form").serializeObject();
            sub_data.id = row.id;
            sub_data = JSON.stringify(sub_data);
            var sub_url = allurl + "/car-management/group/update.action";
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "post", "editcarGroup_btn");
        })
    }
};
// 新增车辆分组
var addGroupInfo = [
    { "name": "分组名称", "type": "text", "inputName": "name", "must": "*" },
    { "name": "备注", "type": "text", "inputName": "remark", "must": "" }
];
var addemployeeInfo = [
    { "name": "操作员", "type": "text", "inputName": "name", "must": "*" },
    { "name": "电话", "type": "text", "inputName": "tel", "must": "*" },
    { "name": "备注", "type": "text", "inputName": "remark", "must": "" }
];
// 新增项目
var addprojectInfo = [
    { "name": "项目名称", "type": "text", "inputName": "projectName", "must": "*" },
    { "name": "项目编号", "type": "text", "inputName": "project_sn", "must": "*" },
    {
        "name": "项目状态",
        "type": "select",
        "inputName": "status",
        "must": "*",
        "option": [{ "name": "Active", "val": "Active" }, { "name": "Closed", "val": "Closed" }, { "name": "pending", "val": "pending" },
            { "name": "Cancelled", "val": "Cancelled" }, { "name": "To do", "val": "To do" },
            { "name": "Lost", "val": "Lost" }, { "name": "ADP", "val": "ADP" },
            { "name": "C-cal", "val": "C-cal" }, { "name": "BN-cal", "val": "BN-cal" },
        ]
    },
    { "name": "状态说明", "type": "text", "inputName": "remark", "must": "*" },
];

$("#add_cargroup_btn").unbind('click').bind('click', function() {
    $("#add_model").modal();
    $("#add_model #myModalLabel").html("添加车辆分组");
    creatForm(addGroupInfo, "#add_model .modal-body form", "sub_add_cargroup");
    $(".sub_add_cargroup").unbind('click').bind('click', function() {
        var sub_data = $("#add_model .modal-body form").serializeObject();
        sub_data = JSON.stringify(sub_data);
        var sub_url = allurl + "/car-management/group/add.action";
        $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
        subData(sub_url, sub_data, "post", "addcargroup");
    })
})
$("#add_drivergroup_btn").unbind('click').bind('click', function() {
    $("#add_model").modal();
    $("#add_model #myModalLabel").html("添加驾驶员分组");
    creatForm(addGroupInfo, "#add_model .modal-body form", "sub_add_drivergroup");
    $(".sub_add_drivergroup").unbind('click').bind('click', function() {
        var sub_data = $("#add_model .modal-body form").serialize();
        // sub_data = JSON.stringify(sub_data);
        var sub_url = allurl + "/car-management/driver/group/add.action";
        subData(sub_url, sub_data, "get", "adddrivergroup");
        $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
    })
})

// 项目管理
$("#add_project_btn").unbind('click').bind('click', function() {
    $("#add_model").modal();
    $("#add_model #myModalLabel").html("新增项目");
    creatForm(addprojectInfo, "#add_model .modal-body form", "sub_add_project");
    $(".sub_add_project").unbind('click').bind('click', function() {
        var sub_data = $("#add_model .modal-body form").serializeObject();
        sub_data.project_status = $("#add_model .status option:selected").attr("value");
        sub_data = JSON.stringify(sub_data);
        var sub_url = allurl + "/car-management/project/addProject.action";
        subData(sub_url, sub_data, "post", "addproject");
        $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
    })
});

function findProject(pageInfo) { //项目列表
    if (pageInfo == undefined) {
        var pageInfo = { pageNumber: 1, pageSize: 13 };
    }
    $("#projectTable").bootstrapTable('destroy').bootstrapTable({
        url: allurl + "/car-management/project/pageQuery.action",
        dataType: 'json',
        striped: true, //是否显示行间隔色
        toggle: "table",
        toolbar: "projectTable_toolbar",
        pagination: "true", //是否显示分页（*）
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: pageInfo.pageNumber, //初始化加载第一页，默认第一页
        pageSize: pageInfo.pageSize, //每页的记录行数（*）
        pageList: [10, 20, 30, 40, 50], //可供选择的每页的行数（*）
        paginationShowPageGo: true,
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
        exportDataType: "basic",
        exportOptions: {
            ignoreColumn: [0, 8], //忽略某一列的索引  
            fileName: '测试车辆-项目管理列表', //文件名称设置  
            worksheetName: 'sheet1', //表格工作区名称  
            tableName: '测试车辆-项目管理列表',
            excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
                // onMsoNumberFormat: DoOnMsoNumberFormat
        },
        exportDataType: "selected",
        uniqueId: "id", // 每一行的唯一标识 
        //得到查询的参数
        queryParams: function(params) {
            console.log(params);
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                size: params.limit, //页面大小
                page: (params.offset / params.limit) + 1, //页码
                sort: params.sort, //排序列名  
                sortOrder: params.order, //排位命令（desc，asc）
                sn: $("#projectTable_toolbar .project_sn").val()
            };
            console.log(temp);
            return temp;
        },
        onLoadSuccess: function(res) {
            console.log(res);
            projectStatus[0].option = [];
            for (var i = 0; i < res.rows.length; i++) {
                projectStatus[0].option.push({ id: res.rows[i].id, name: res.rows[i].project_sn, status: res.rows[i].project_status })
            }
        },
        //单击行时
        onClickRow: function(row, $element) {
            index = $element.data('index');
        },
        //点击每列前的checkbox时
        onCheck: function(row, $element) {
            index = $element.data('index');
        },
        onLoadError: function() {
            console.log("数据加载失败！");
        },
        onPageChange: function(page, size) {
            var pageInfo = { pageNumber: page, pageSize: size };
            window.sessionStorage.pageInfo = JSON.stringify(pageInfo);
        },
        columns: [
            [{
                "title": "测试车辆-项目管理列表",
                "halign": "center",
                "align": "center",
                "colspan": 7
            }],
            [{ field: "checkbox", title: "全选", checkbox: true, align: 'center', valign: "middle" },
                {
                    field: 'index',
                    title: "序号",
                    valign: "middle",
                    align: "center",
                    width: "5%",
                    formatter: function(value, row, index) {
                        var pageSize = $('#projectTable').bootstrapTable('getOptions').pageSize; //通过表的#id 可以得到每页多少条
                        var pageNumber = $('#projectTable').bootstrapTable('getOptions').pageNumber; //通过表的#id 可以得到当前第几页
                        return pageSize * (pageNumber - 1) + index + 1; //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号 } } }
                    }
                },
                { field: "project_sn", title: "项目编号", align: 'center', valign: "middle" },
                { field: "projectName", title: "项目名称", align: 'center', valign: "middle" },
                { field: "project_status", title: "项目状态", align: 'center', valign: "middle" },
                { field: "remark", title: "状态说明", align: 'center', valign: "middle" },
                { field: 'operate', title: '操作', align: 'center', valign: "middle", events: projectOperateEvents, formatter: projectOperateFormatter }
            ]
        ]
    });
}


function projectOperateFormatter(value, row, index) {
    return [
        '<button type="button" id="del_project" class="btn btn-default btn-sm" style="margin-right:15px;">删除</button>',
        '<button type="button" id="update_project" class="btn btn-default btn-sm">修改</button>'
    ].join('');
}
window.projectOperateEvents = {
    'click #del_project': function(e, value, row, index) {
        var delrow = [];
        delrow.push(row);
        deletAll(delrow, "del_project");
    },
    'click #update_project': function(e, value, row, index) {
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("项目修改");
        creatForm(addprojectInfo, "#add_model .modal-body form", "update_project");
        showData("#add_model .modal-body form", row); // 编辑时数据回显
        $(".update_project").unbind('click').bind('click', function() {
            console.log(index);
            var sub_data = $("#add_model .modal-body form").serializeObject();
            sub_data.project_status = $("#add_model .status option:selected").attr("value");
            sub_data.id = row.id;
            sub_data = JSON.stringify(sub_data);
            var sub_url = allurl + "/car-management/project/updateProject.action";
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "post", "update_project");
        })
    }
};

// 新增iccard
var addiccardInfo = [
    { "name": "iccard编号", "type": "text", "inputName": "iccard", "must": "*" },
    {
        "name": "iccard类别",
        "type": "radio",
        "inputName": "cardType",
        "must": "",
        "option": [{ "name": "车辆标签卡", "val": "0" }, { "name": "驾驶员卡", "val": "1" },
            { "name": "车辆尾卡", "val": "2" }, { "name": "超级卡", "val": "3" }
        ]
    }
];
// iccard管理
function findIccard(pageInfo) { //项目列表
    if (pageInfo == undefined) {
        var pageInfo = { pageNumber: 1, pageSize: 13 };
    }
    $("#iccardTable").bootstrapTable('destroy').bootstrapTable({
        url: allurl + "/car-management/iccard/findAll.action",
        dataType: 'json',
        striped: true, //是否显示行间隔色
        toggle: "table",
        toolbar: "iccardTable_toolbar",
        pagination: "true", //是否显示分页（*）
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: pageInfo.pageNumber, //初始化加载第一页，默认第一页
        pageSize: pageInfo.pageSize, //每页的记录行数（*）
        pageList: [10, 20, 30, 40, 50], //可供选择的每页的行数（*）
        paginationShowPageGo: true,
        search: false, //是否搜索查询
        showColumns: true, //是否显示所有的列
        showRefresh: false, //是否显示刷新按钮
        sortable: true, //是否启用排序
        minimumCountColumns: 2, //最少允许的列数
        clickToSelect: true, //是否启用点击选中行
        searchOnEnterKey: true, //设置为 true时，按回车触发搜索方法
        strictSearch: false, //设置为 true启用全匹配搜索， 否则为模糊搜索
        onPageChange: function(page, size) {
            console.log('切换页事件 当前页数：第' + page + "页，每页显示数量" + size + "条");
            var pageInfo = { pageNumber: page, pageSize: size };
            window.sessionStorage.pageInfo = JSON.stringify(pageInfo);
        },
        showToggle: true, //是否显示切换视图（table/card）按钮
        searchAlign: "right",
        showExport: true,
        exportDataType: "basic",
        exportOptions: {
            ignoreColumn: [0, 5], //忽略某一列的索引  
            fileName: '测试车辆-iccard管理列表', //文件名称设置  
            worksheetName: 'sheet1', //表格工作区名称  
            tableName: '测试车辆-iccard管理列表',
            excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
                // onMsoNumberFormat: DoOnMsoNumberFormat
        },
        exportDataType: "selected",
        uniqueId: "id", // 每一行的唯一标识  
        //得到查询的参数
        queryParams: function(params) {
            console.log(params);
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                size: params.limit, //页面大小
                page: (params.offset / params.limit) + 1, //页码
                sort: params.sort, //排序列名  
                sortOrder: params.order //排位命令（desc，asc） 
            };
            console.log(temp);
            return temp;
        },
        onLoadSuccess: function(res) {
            console.log(res);
            $('#iccardTable').bootstrapTable('hideColumn', 'operate');
            addcarInfo[18].option = []; //车辆电子标签
            addcarInfo[20].option = []; //车辆电子标签
            for (var i = 0; i < res.rows.length; i++) {
                addcarInfo[18].option.push({ id: res.rows[i].id, name: res.rows[i].iccard, projectName: res.rows[i].cardType })
                addcarInfo[20].option.push({ id: res.rows[i].id, name: res.rows[i].iccard, projectName: res.rows[i].cardType })
            }
        },
        //单击行时
        onClickRow: function(row, $element) {
            index = $element.data('index');
        },
        //点击每列前的checkbox时
        onCheck: function(row, $element) {
            index = $element.data('index');
        },
        onLoadError: function() {
            console.log("数据加载失败！");
        },
        onPageChange: function(page, size) {
            var pageInfo = { pageNumber: page, pageSize: size };
            window.sessionStorage.pageInfo = JSON.stringify(pageInfo);
        },
        columns: [
            [{
                "title": "测试车辆-iccard管理列表",
                "halign": "center",
                "align": "center",
                "colspan": 5
            }],
            [{ field: "checkbox", title: "全选", checkbox: true, align: 'center', valign: "middle" },
                {
                    field: 'index',
                    title: "序号",
                    valign: "middle",
                    align: "center",
                    width: "5%",
                    formatter: function(value, row, index) {
                        var pageSize = $('#iccardTable').bootstrapTable('getOptions').pageSize; //通过表的#id 可以得到每页多少条
                        var pageNumber = $('#iccardTable').bootstrapTable('getOptions').pageNumber; //通过表的#id 可以得到当前第几页
                        return pageSize * (pageNumber - 1) + index + 1; //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号 } } }
                    }
                },
                { field: "iccard", title: "iccard编号", align: 'center', valign: "middle" },
                {
                    field: "cardType",
                    title: "iccard类别",
                    align: 'center',
                    valign: "middle",
                    formatter: function(value, row, index) {
                        var a = "";
                        if (value == 0) {
                            a = '<span style="color:black">' + "车辆标签卡" + '</span>';
                        } else if (value == 1) {
                            a = '<span style="color:blue">' + "驾驶员卡" + '</span>';
                        } else if (value == 2) {
                            a = '<span style="color:green">' + "车辆尾卡" + '</span>';
                        } else if (value == 3) {
                            a = '<span style="color:red">' + "超级卡" + '</span>';
                        } else {
                            a = '';
                        }
                        return a;
                    }
                },
                { field: 'operate', title: '操作', align: 'center', valign: "middle", events: iccardOperateEvents, formatter: iccardOperateFormatter }
            ]
        ]
    });
}

function iccardOperateFormatter(value, row, index) {
    return [
        '<button type="button" id="del_iccard" class="btn btn-default btn-sm" style="margin-right:15px;">删除</button>',
        '<button type="button" id="update_iccard" class="btn btn-default btn-sm">修改</button>'
    ].join('');
}
window.iccardOperateEvents = {
    'click #del_iccard': function(e, value, row, index) {
        var delrow = [];
        delrow.push(row);
        deletAll(delrow, "del_iccard");
    },
    'click #update_iccard': function(e, value, row, index) {
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("iccard修改");
        creatForm(addiccardInfo, "#add_model .modal-body form", "update_iccard");
        showData("#add_model .modal-body form", row); // 编辑时数据回显
        $(".update_iccard").unbind('click').bind('click', function() {
            console.log(index);
            var sub_data = $("#add_model .modal-body form").serializeObject();
            sub_data.id = row.id;
            sub_data = JSON.stringify(sub_data);
            var sub_url = allurl + "/car-management/iccard/updateiccard.action";
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "post", "update_iccard");
        })
    }
};

$("#add_iccard_btn").unbind('click').bind('click', function() {
    $("#add_model").modal();
    $("#add_model #myModalLabel").html("新增iccard");
    creatForm(addiccardInfo, "#add_model .modal-body form", "sub_add_iccard");
    $(".sub_add_iccard").unbind('click').bind('click', function() {
        var sub_data = $("#add_model .modal-body form").serialize();
        var sub_url = allurl + "/car-management/iccard/saveiccard.action";
        subData(sub_url, sub_data, "get", "addiccard");
        $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
    })
});
// 查询车辆标签卡/iccard/findcarid.action
// 查询车辆尾卡/iccard/findBackcarid.action   查询车辆尾卡
// 查询超级卡/iccard/findSuppercarid.action   查询超级卡
// 查询驾驶员卡/iccard/findDrivercarid.action

// 客户管理--------------------------------------------------------------------------------------------------------------------------
function findCustomer(pageInfo) { //项目列表
    if (pageInfo == undefined) {
        var pageInfo = { pageNumber: 1, pageSize: 13 };
    }
    $("#customerTable").bootstrapTable('destroy').bootstrapTable({
        url: "http://localhost/car-def/webapp/json/driverList.json?size=13&page=1&sortOrder=asc",
        // url: allurl + "/car-management/customer/pageQuery.action",
        dataType: 'json',
        striped: true, //是否显示行间隔色
        toggle: "table",
        toolbar: "customerTable_toolbar",
        pagination: "true", //是否显示分页（*）
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: pageInfo.pageNumber, //初始化加载第一页，默认第一页
        pageSize: pageInfo.pageSize, //每页的记录行数（*）
        pageList: [10, 20, 30, 40, 50, 100, 200, 300], //可供选择的每页的行数（*）
        paginationShowPageGo: true,
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
        exportDataType: "basic",
        exportOptions: {
            ignoreColumn: [0, 4], //忽略某一列的索引  
            fileName: '测试车辆-客户管理列表', //文件名称设置  
            worksheetName: 'sheet1', //表格工作区名称  
            tableName: '测试车辆-客户管理列表',
            excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
                // onMsoNumberFormat: DoOnMsoNumberFormat
        },
        exportDataType: "selected",
        uniqueId: "id", // 每一行的唯一标识  
        //得到查询的参数
        queryParams: function(params) {
            console.log(params);
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                size: params.limit, //页面大小
                page: (params.offset / params.limit) + 1, //页码
                sort: params.sort, //排序列名  
                sortOrder: params.order //排位命令（desc，asc） 
            };
            console.log(temp);
            return temp;
        },
        onLoadSuccess: function(res) {
            console.log(res);
            projectStatus[0].option = [];
            for (var i = 0; i < res.rows.length; i++) {
                projectStatus[0].option.push({ id: res.rows[i].id, name: res.rows[i].project_sn, status: res.rows[i].project_status })
            }
        },
        //单击行时
        onClickRow: function(row, $element) {
            index = $element.data('index');
        },
        //点击每列前的checkbox时
        onCheck: function(row, $element) {
            index = $element.data('index');
        },
        onLoadError: function() {
            console.log("数据加载失败！");
        },
        onPageChange: function(page, size) {
            var pageInfo = { pageNumber: page, pageSize: size };
            window.sessionStorage.pageInfo = JSON.stringify(pageInfo);
        },
        columns: [
            [{
                "title": "测试车辆-客户管理列表",
                "halign": "center",
                "align": "center",
                "colspan": 5
            }],
            [{ field: "checkbox", title: "全选", checkbox: true, align: 'center', valign: "middle" },
                {
                    field: 'index',
                    title: "序号",
                    valign: "middle",
                    align: "center",
                    width: "5%",
                    formatter: function(value, row, index) {
                        var pageSize = $('#customerTable').bootstrapTable('getOptions').pageSize; //通过表的#id 可以得到每页多少条
                        var pageNumber = $('#customerTable').bootstrapTable('getOptions').pageNumber; //通过表的#id 可以得到当前第几页
                        return pageSize * (pageNumber - 1) + index + 1; //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号 } } }
                    }
                },
                { field: "name", title: "客户名称", align: 'center', valign: "middle" },
                { field: "remark", title: "客户备注", align: 'center', valign: "middle" },
                { field: 'operate', title: '操作', align: 'center', valign: "middle", events: customerOperateEvents, formatter: customerOperateFormatter }
            ]
        ]
    });
}
// 新增客户
var addcustomerInfo = [
    { "name": "客户名称", "type": "text", "inputName": "customer", "must": "*" },
    { "name": "备注", "type": "text", "inputName": "remark", "must": "" }
];

function customerOperateFormatter(value, row, index) {
    return [
        '<button type="button" id="del_customer" class="btn btn-default btn-sm" style="margin-right:15px;">删除</button>',
        '<button type="button" id="update_customer" class="btn btn-default btn-sm">修改</button>'
    ].join('');
}
window.customerOperateEvents = {
    'click #del_customer': function(e, value, row, index) {
        var delrow = [];
        delrow.push(row);
        deletAll(delrow, "del_customer");
    },
    'click #update_customer': function(e, value, row, index) {
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("客户修改");
        creatForm(addcustomerInfo, "#add_model .modal-body form", "update_customer");
        showData("#add_model .modal-body form", row); // 编辑时数据回显
        $(".update_customer").unbind('click').bind('click', function() {
            console.log(index);
            var sub_data = $("#add_model .modal-body form").serializeObject();
            sub_data.customer_status = $("#add_model .status option:selected").attr("value");
            sub_data.id = row.id;
            sub_data = JSON.stringify(sub_data);
            var sub_url = allurl + "/car-management/customer/updatecustomer.action";
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "post", "update_customer");
        })
    }
};

$("#project_search").unbind('click').bind('click', function() {
    findProject();
})