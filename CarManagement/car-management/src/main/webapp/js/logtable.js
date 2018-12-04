function createLogTable(tablename, toolbarname, url, OperateEvent, OperateFormatter, pageInfo) {
    if (pageInfo == undefined) {
        var pageInfo = { pageNumber: 1, pageSize: 13 };
    }
    $(tablename).bootstrapTable('destroy').bootstrapTable({
        // url: allurl + "/car-management/log/findCarLog.action",
        url: url,
        dataType: 'json',
        striped: true, //是否显示行间隔色
        toggle: "table",
        toolbar: toolbarname,
        // toolbar: "toolbar_carLogTable",/**/
        pagination: "true", //是否显示分页（*）
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: pageInfo.pageNumber, //初始化加载第一页，默认第一页
        pageSize: pageInfo.pageSize, //每页的记录行数（*）
        paginationShowPageGo: true,
        pageList: [10, 20, 30, 40, 50], //可供选择的每页的行数（*）
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
        Icons: 'glyphicon-export',
        exportOptions: {
            ignoreColumn: [0, 11], //忽略某一列的索引  
            fileName: '测试车辆-日志列表', //文件名称设置  
            worksheetName: 'sheet1', //表格工作区名称  
            type: 'excel',
            tableName: '测试车辆-日志列表',
            excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
        },
        uniqueId: "id", // 每一行的唯一标识  
        queryParams: function(params) { //得到查询的参数
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                size: params.limit, //页面大小
                page: (params.offset / params.limit) + 1, //页码
                sort: "name", //排序列名  
                sortOrder: params.order //排位命令（desc，asc） 
            };
            return temp;
        },
        onLoadSuccess: function(res) {
            console.log(res);
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
                "title": "测试车辆-日志列表",
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
                        var pageSize = $(tablename).bootstrapTable('getOptions').pageSize; //通过表的#id 可以得到每页多少条
                        var pageNumber = $(tablename).bootstrapTable('getOptions').pageNumber; //通过表的#id 可以得到当前第几页
                        return pageSize * (pageNumber - 1) + index + 1; //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
                    }
                },
                { field: "module", title: "模块名称", align: 'center', valign: "middle" },
                { field: "method", title: "执行操作", align: 'center', valign: "middle" },
                { field: "methodType", title: "操作类型", align: 'center', valign: "middle" },
                { field: "operate_ip", title: "请求IP", align: 'center', valign: "middle" },
                { field: "description", title: "请求结果", align: 'center', valign: "middle" },
                { field: "requestMethod", title: "请求方式", align: 'center', valign: "middle" },
                { field: "createTime", title: "创建日期", align: 'center', valign: "middle" },
                { field: "operator", title: "操作人", align: 'center', valign: "middle" }, {
                    field: 'operate',
                    title: '操作',
                    align: 'center',
                    valign: "middle",
                    events: OperateEvent,
                    formatter: OperateFormatter
                }
            ]
        ]
    });
}


function carlogOperateFormatter(value, row, index) {
    return [
        '<button type="button" id="delcarLog_row" class="btn btn-default btn-sm">删除</button>'
    ].join('');
}
window.carlogOperateEvents = {
    'click #delcarLog_row': function(e, value, row, index) {
        $(this).parent().parent().remove();
        deletecarLog(row.id);
    }
};

function maintainlogOperateFormatter(value, row, index) {
    return [
        '<button type="button" id="delmaintainLog_row" class="RoleOfA btn btn-default btn-sm">删除</button>'
    ].join('');
}
window.maintainlogOperateEvents = {
    'click #delmaintainLog_row': function(e, value, row, index) {
        $(this).parent().parent().remove();
        deletemaintainLog(row.id);
    }
};

function syslogOperateFormatter(value, row, index) {
    return [
        '<button type="button" id="delsysLog_row" class="RoleOfA btn btn-default btn-sm">删除</button>'
    ].join('');
}
window.syslogOperateEvents = {
    'click #delsysLog_row': function(e, value, row, index) {
        $(this).parent().parent().remove();
        deletesysLog(row.id);
    }
};

function driverlogOperateFormatter(value, row, index) {
    return [
        '<button type="button" id="delmaintainLog_row" class="RoleOfA btn btn-default btn-sm">删除</button>'
    ].join('');
}
window.driverlogOperateEvents = {
    'click #delmaintainLog_row': function(e, value, row, index) {
        $(this).parent().parent().remove();
        deletedriverLog(row.id);
    }
};

function deletecarLog(idsArr) {
    $.ajax({
        url: allurl + "/car-management/log/delete.action",
        type: "get",
        data: {
            ids: idsArr
        },
        success: function(res) {
            console.log(res);
            if (res.ret == true) {
                toastr.success('日志删除成功', '车辆管理日志列表', messageOpts);
                var pageInfo = window.sessionStorage.getItem("pageInfo");
                pageInfo = JSON.parse(pageInfo);
                createLogTable("#carLogTable", "toolbar_carLogTable", allurl + "/car-management/log/findCarLog.action", carlogOperateEvents, carlogOperateFormatter, pageInfo);
                // createLogTable("#maintainLogTable", "toolbar_carLogTable", allurl + "/car-management/log/findCarMaintainLog.action", maintainlogOperateEvents, maintainlogOperateFormatter, pageInfo);
            } else {
                toastr.warning('日志删除失败', '日志列表', messageOpts);
            }
        },
        "error": function(res) {
            toastr.error('程序内部错误', '日志列表', messageOpts);
        }
    })
}

function deletesysLog(idsArr) {
    $.ajax({
        url: allurl + "/car-management/log/delete.action",
        type: "get",
        data: {
            ids: idsArr
        },
        success: function(res) {
            console.log(res);
            if (res.ret == true) {
                toastr.success('日志删除成功', '系统管理日志列表', messageOpts);
                var pageInfo = window.sessionStorage.getItem("pageInfo");
                pageInfo = JSON.parse(pageInfo);
                createLogTable("#sysLogTable", "toolbar_sysLogTable", allurl + "/car-management/log/findCarSystemLog.action", syslogOperateEvents, syslogOperateFormatter, pageInfo);
            } else {
                toastr.warning('日志删除失败', '日志列表', messageOpts);
            }
        },
        "error": function(res) {
            toastr.error('程序内部错误', '日志列表', messageOpts);
        }
    })
}

function deletedriverLog(idsArr) {
    $.ajax({
        url: allurl + "/car-management/log/delete.action",
        type: "get",
        data: {
            ids: idsArr
        },
        success: function(res) {
            console.log(res);
            if (res.ret == true) {
                toastr.success('日志删除成功', '驾驶员管理日志列表', messageOpts);
                var pageInfo = window.sessionStorage.getItem("pageInfo");
                pageInfo = JSON.parse(pageInfo);
                createLogTable("#driverLogTable", "toolbar_carLogTable", allurl + "/car-management/log/findCarDriverLog.action", driverlogOperateEvents, driverlogOperateFormatter, pageInfo);
            } else {
                toastr.warning('日志删除失败', '日志列表', messageOpts);
            }
        },
        "error": function(res) {
            toastr.error('程序内部错误', '日志列表', messageOpts);
        }
    })
}

function deletemaintainLog(idsArr) {
    $.ajax({
        url: allurl + "/car-management/log/delete.action",
        type: "get",
        data: {
            ids: idsArr
        },
        success: function(res) {
            console.log(res);
            if (res.ret == true) {
                toastr.success('日志删除成功', '维修管理日志列表', messageOpts);
                var pageInfo = window.sessionStorage.getItem("pageInfo");
                pageInfo = JSON.parse(pageInfo);
                createLogTable("#maintainLogTable", "toolbar_carLogTable", allurl + "/car-management/log/findCarMaintainLog.action", maintainlogOperateEvents, maintainlogOperateFormatter, pageInfo);
            } else {
                toastr.warning('日志删除失败', '日志列表', messageOpts);
            }
        },
        "error": function(res) {
            toastr.error('程序内部错误', '日志列表', messageOpts);
        }
    })
}


// 删除所有车辆管理日志
$("#delcarlog_all").unbind('click').bind('click', function() {
    var a = $("#carLogTable").bootstrapTable('getSelections');
    deletAllLog(a, "car");
});
// 删除所有系统管理日志
$("#delsyslog_all").unbind('click').bind('click', function() {
    var b = $("#sysLogTable").bootstrapTable('getSelections');
    deletAllLog(b, "sys");
});
// 删除所有维修管理日志
$("#delmaintainlog_all").unbind('click').bind('click', function() {
    var c = $("#maintainLogTable").bootstrapTable('getSelections');
    deletAllLog(c, "maintain");
});
// 删除所有驾驶员管理日志
$("#deldriverlog_all").unbind('click').bind('click', function() {
    var d = $("#driverLogTable").bootstrapTable('getSelections');
    deletAllLog(d, "driver");
});
// createLogTable("#carLogTable", "toolbar_carLogTable", allurl + "/car-management/log/findCarLog.action", carlogOperateEvents, carlogOperateFormatter);
// createLogTable("#driverLogTable", "toolbar_driverLogTable", allurl + "/car-management/log/findCarDriverLog.action", driverlogOperateEvents, driverlogOperateFormatter);
// createLogTable("#sysLogTable", "toolbar_sysLogTable", allurl + "/car-management/log/findCarSystemLog.action", syslogOperateEvents, syslogOperateFormatter);
// createLogTable("#maintainLogTable", "toolbar_carLogTable", allurl + "/car-management/log/findCarMaintainLog.action", maintainlogOperateEvents, maintainlogOperateFormatter);
// 删除所有接口
function deletAllLog(a, name) {
    // var a = $("#carLogTable").bootstrapTable('getSelections');
    var delcarlogArr = [];
    var delcarlogString = "";
    if (a.length >= 1) {
        for (var i = 0; i < a.length; i++) {
            delcarlogArr.push(a[i].id)
        }
        delcarlogString = delcarlogArr.join(",");
        console.log(name);
        if (name == "car") {
            deletecarLog(delcarlogString);
        } else if (name == "driver") {
            deletedriverLog(delcarlogString);
        } else if (name == "sys") {
            deletesysLog(delcarlogString);
        } else if (name == "maintain") {
            deletemaintainLog(delcarlogString);
        } else if (name == "tempcarlist") {
            delCarList(allurl+"/car-management/tempcar/delete.action", delcarlogString, "get", "tempcarlist",
                "临时车辆列表", "删除失败", "删除成功");
        } else if (name == "auditlistdel") {
            delCarList(allurl+"/car-management/car/deleteReview.action", delcarlogString, "get", "auditlistdel", "待审核列表", "车辆删除失败", "车辆删除成功");
        } else if (name == "failauditdel") {
            delCarList(allurl+"/car-management/car/deleteReview.action", delcarlogString, "get", "failauditdel", "审核失败列表", "车辆删除失败", "车辆删除成功");
        } else if (name == "finauditdel") {
            delCarList(allurl+"/car-management/car/deleteReview.action", delcarlogString, "get", "finauditdel", "审核成功列表", "车辆删除失败", "车辆删除成功");
        } else if (name == "sumCarListTable") {
            delCarList(allurl+"/car-management/car/delete.action", delcarlogString, "get", "sumCarList",
                "车辆总表", "删除失败", "删除成功");
        }
    } else {
        toastr.warning('最少选中一行', '删除', messageOpts);
    }
}

function delCarList(url, dat, type, name, tit, filToa, sucToa) {
    $.ajax({
        url: url,
        type: type,
        data: {
            "ids": dat
        },
        "dataType": "jsonp", //数据类型为jsonp  
        "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数
        success: function(res) {
            console.log(res);
            if (res.ret == true) {
                toastr.success(sucToa, tit, messageOpts);
                if (name == "failauditdel") {
                    loadFailAudit();
                } else if (name == "finauditdel") {
                    loadsucAudit();
                } else if (name == "auditlistdel") {
                    loadAuditList();
                } else if (name == "tempcarlist") {
                    loadCarList(JSON.stringify({
                        "vSn": null
                    }));
                } else if (name == "sumCarList") {
                    loadsumCarList("");
                }
            } else {
                toastr.warning(filToa, tit, messageOpts);
            }
        },
        "error": function(res) {
            toastr.error('程序内部错误', tit, messageOpts);
        }
    })
}