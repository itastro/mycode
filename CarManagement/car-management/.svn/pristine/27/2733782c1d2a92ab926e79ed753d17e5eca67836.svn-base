function loadoilList(pageInfo) {
    if (pageInfo == undefined) {
        var pageInfo = { pageNumber: 1, pageSize: 10 };
    }
    $("#oilTable").bootstrapTable('destroy').bootstrapTable({
        url: allurl + '/car-management/oil/query.action',
        dataType: 'json',
        striped: true, //是否显示行间隔色
        toggle: "table",
        toolbar: "toolbar_OilTable",
        pagination: "true", //是否显示分页（*）
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: pageInfo.pageNumber, //初始化加载第一页，默认第一页
        pageSize: pageInfo.pageSize, //每页的记录行数（*）
        paginationShowPageGo: true,
        pageList: [10, 50, 100, 150, 200, 300, 400, 500], //可供选择的每页的行数（*）
        search: false, //是否搜索查询
        showColumns: true, //是否显示所有的列
        showRefresh: false, //是否显示刷新按钮
        sortable: true, //是否启用排序
        minimumCountColumns: 2, //最少允许的列数
        clickToSelect: true, //是否启用点击选中行
        searchOnEnterKey: true, //设置为 true时，按回车触发搜索方法
        strictSearch: false, //设置为 true启用全匹配搜索， 否则为模糊搜索
        showToggle: true, //是否显示切换视图（table/card）按钮
        exportDataType: "selected",
        showExport: true, //是否显示导出按钮  
        buttonsAlign: "right", //按钮位置  
        exportTypes: ['excel'], //导出文件类型  
        //单击行时
        onClickRow: function(row, $element) {
            index = $element.data('index');
        },
        //点击每列前的checkbox时
        onCheck: function(row, $element) {
            index = $element.data('index');
        },
        exportOptions: {
            ignoreColumn: [0, 15], //忽略某一列的索引  
            fileName: '测试车辆-油卡列表', //文件名称设置  
            worksheetName: 'sheet1', //表格工作区名称  
            type: 'excel',
            tableName: '测试车辆-油卡列表',
            excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
                // onMsoNumberFormat: DoOnMsoNumberFormat
        },
        exportDataType: "selected",
        uniqueId: "id", // 每一行的唯一标识  
        //得到查询的参数
        queryParams: function(params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                size: params.limit, //页面大小
                page: (params.offset / params.limit) + 1, //页码
                sort: "vSn", //排序列名  
                sortOrder: "desc", //排位命令（desc，asc） 
                importTime: $(".oil_importdata").val(),
                operator: $(".oil_operator").val()
            };
            return temp;
        },
        onLoadSuccess: function(res) {
            console.log(res);
            var data = $('#oilTable').bootstrapTable('getData', true);
            // 合并单元格  
            var fieldList = ["operator", "expense"];
            mergeCells(data, "operator", 1, $('#oilTable'), fieldList);
            // oil_file
        },
        onLoadError: function() {
            console.log("数据加载失败！");
        },
        columns: [
            [{
                "title": "测试车辆-油卡列表",
                "halign": "center",
                "align": "center",
                "colspan": 16
            }],
            [{ field: "checkbox", title: "全选", checkbox: true, align: 'center' },
                {
                    field: 'index',
                    title: "序号",
                    valign: "middle",
                    align: "center",
                    width: "5%",
                    formatter: function(value, row, index) {
                        var pageSize = $('#oilTable').bootstrapTable('getOptions').pageSize; //通过表的#id 可以得到每页多少条
                        var pageNumber = $('#oilTable').bootstrapTable('getOptions').pageNumber; //通过表的#id 可以得到当前第几页
                        return pageSize * (pageNumber - 1) + index + 1; //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号 }
                    }
                },
                { field: "time", title: "日期", align: 'center', valign: "middle" },
                { field: "gas", title: "加油站", align: 'center', valign: "middle" },
                { field: "l", title: "数量（L）", align: 'center', valign: "middle" },
                { field: "type", title: "型号", align: 'center', valign: "middle" },
                { field: "price", title: "总价", align: 'center', valign: "middle" },
                { field: "projectSn", title: "项目号", align: 'center', valign: "middle" },
                { field: "vSn", title: "车号", align: 'center', valign: "middle" },
                { field: "mm", title: "里程表", align: 'center', valign: "middle" },
                {
                    field: 'operate',
                    valign: "middle",
                    title: '操作',
                    align: 'center',
                    events: oiloperateEvents,
                    formatter: oiloperateFormatter
                },
                { field: "oilCardNum", title: "加油卡号", align: 'center', valign: "middle" },
                {
                    field: "operator",
                    title: "加油人",
                    align: 'center',
                    valign: "middle",
                    cellStyle: function(value, row, index) {
                        console.log(row);
                        if (index % 2 == 0) {
                            return { css: { "background-color": "#F2F2F2" } }
                        } else {
                            return { css: { "background-color": "#E3F3FC" } }
                        }
                    }
                },
                { field: "remark", title: "说明", align: 'center', valign: "middle" },
                { field: "expense", title: "消费金额", align: 'center', valign: "middle" },

                { field: "importTime", title: "导入日期", align: 'center', valign: "middle" },
            ]
        ]
    });
}

function oiloperateFormatter(value, row, index) {
    return [
        '<button type="button" id="btn_oilup" class="my_btn btn btn-default  btn-sm">填写</button>'
    ].join('');
}

window.oiloperateEvents = {
    'click #btn_oilup': function(e, value, row, index) { //修改
        console.log(row);
        window.sessionStorage.oilrow = JSON.stringify(row);
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("油卡录入");
        creatForm(oilInfo, "#add_model .modal-body form", "editOil_btn");
        showData("#add_model .modal-body form", row); // 编辑时数据回显
        $("#add_model .modal-body  input.time").attr("readonly", true);
        $(".editOil_btn").unbind('click').bind('click', function() {
            var oilrow = sessionStorage.getItem("oilrow");
            oilrow = JSON.parse(oilrow);
            console.log(oilrow);
            var sub_data = $("#add_model .modal-body form").serializeObject();
            sub_data.id = oilrow.id;
            var sub_url = allurl + "/car-management/oil/save.action";
            sub_data = JSON.stringify(sub_data);
            console.log(sub_data);
            // var c = $.extend(oilrow, sub_data);
            window.sessionStorage.oilrow = JSON.stringify(sub_data);
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "post", "btn_oilup");
        })
    }
};
var oilInfo = [
    { "name": "日期", "type": "text", "inputName": "time", "must": "*" },
    { "name": "项目号", "type": "text", "inputName": "projectSn", "must": "*" },
    { "name": "车号", "type": "text", "inputName": "vSn", "must": "*" },
    { "name": "里程表", "type": "text", "inputName": "mm", "must": "*" },
];
// 查询
$("#oil_search").unbind('click').bind('click', function() {
    loadoilList();
});
// 合并单元格
/** 
 * 合并单元格 
 *  
 * @param data 
 *            原始数据（在服务端完成排序） 
 * @param fieldName 
 *            合并参照的属性名称 
 * @param colspan 
 *            合并开始列 
 * @param target 
 *            目标表格对象      
 * @param fieldList 
 *            要合并的字段集合 
 */
function mergeCells(data, fieldName, colspan, target, fieldList) {
    // 声明一个map计算相同属性值在data对象出现的次数和  
    var sortMap = {};
    for (var i = 0; i < data.length; i++) {
        for (var prop in data[i]) {
            //例如people.unit.name  
            var fieldArr = fieldName.split(".");
            getCount(data[i], prop, fieldArr, 0, sortMap);
        }
    }
    var index = 0;
    for (var prop in sortMap) {
        var count = sortMap[prop];
        for (var i = 0; i < fieldList.length; i++) {
            $(target).bootstrapTable('mergeCells', { index: index, field: fieldList[i], colspan: colspan, rowspan: count });
            console.log(count);
            console.log("index=" + index);
            // $(target).bootstrapTable("rowStyle", { index: index, })
        }
        index += count;
    }
}

/** 
 * 递归到最后一层 统计数据重复次数 
 * 比如例如people.unit.name 就一直取到name 
 * 类似于data["people"]["unit"]["name"] 
 */
function getCount(data, prop, fieldArr, index, sortMap) {
    if (index == fieldArr.length - 1) {
        if (prop == fieldArr[index]) {
            var key = data[prop];
            if (sortMap.hasOwnProperty(key)) {
                sortMap[key] = sortMap[key] + 1;
            } else {
                sortMap[key] = 1;
            }
        }
        return;
    }
    if (prop == fieldArr[index]) {
        var sdata = data[prop];
        index = index + 1;

        getCount(sdata, fieldArr[index], fieldArr, index, sortMap);
    }
}