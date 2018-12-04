function createLogTable(tablename, toolbarname, url, OperateEvent, OperateFormatter, pageInfo) {
    if (pageInfo == undefined) {
        var pageInfo = { pageNumber: 1, pageSize: 13 };
    }
    $(tablename).bootstrapTable('destroy').bootstrapTable({
        url: url,
        dataType: 'json',
        striped: true, //是否显示行间隔色
        toggle: "table",
        toolbar: toolbarname,
        pagination: "true", //是否显示分页（*）
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: pageInfo.pageNumber, //初始化加载第一页，默认第一页
        pageSize: pageInfo.pageSize, //每页的记录行数（*）
        paginationShowPageGo: true,
        pageList: [10, 20, 30, 40, 50, 100], //可供选择的每页的行数（*）
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
            fileName: '测试车辆-进出记录', //文件名称设置  
            worksheetName: 'sheet1', //表格工作区名称  
            type: 'excel',
            tableName: '测试车辆-进出记录',
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
                "title": "测试车辆-进出记录",
                "halign": "center",
                "align": "center",
                "colspan": 11
            }],
            [{
                    field: "checkbox",
                    title: "全选",
                    checkbox: true,
                    align: 'center',
                    valign: "middle"
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
                { field: "carSn", title: "车辆编号", align: 'center', valign: "middle" },
                { field: "driverName", title: "驾驶员", align: 'center', valign: "middle", width: "10%" },
                { field: "licenseNo", title: "车牌号", align: 'center', valign: "middle" },
                // { field: "licenseEndTime", title: "车牌有效期", align: 'center', valign: "middle" },
                { field: "updateTime", title: "进出时间", align: 'center', valign: "middle" },
                { field: "error", title: "是否允许通过", align: 'center', valign: "middle" },
                // { field: "errorString", title: "错误信息", align: 'center', valign: "middle", width: "20%" },
                { 
                    field: "io", 
                    title: "进出(in/out)", 
                    align: 'center', 
                    valign: "middle", 
                    width: "10%",
                    formatter: function(value, row, index) {
                        var io = ''
                        if(value == 'i') {
                            io = '进'
                        } else if(value == 'o') {
                            io = '出'
                        } else {
                            io = '-'
                        }
                        return io
                    }
                }
            ]
        ]
    });
}

var inouturl = allurl + "/car-management/inAndOut/all.action";
createLogTable("#inAndOutTable", "toolbar_inAndOutTable", inouturl, "", "", "");