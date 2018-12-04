function loadVinList(pageInfo) {
  if (pageInfo == undefined) {
    pageInfo = {
      pageNumber: 1,
      pageSize: 10
    };
  }
  var tableOptions = {
    url: allurl + '/car-management/gpscar/pageQuery.action',
    dataType: 'json',
    striped: true, // 是否显示行间隔色
    toggle: "table",
    toolbar: "VinTable_toolbar",
    pagination: "true", // 是否显示分页（*）
    sortOrder: "asc", // 排序方式
    sidePagination: "server", // 分页方式：client客户端分页，server服务端分页（*）
    pageNumber: pageInfo.pageNumber, // 初始化加载第一页，默认第一页
    pageSize: pageInfo.pageSize, // 每页的记录行数（*）
    paginationShowPageGo: true,
    pageList: [10, 30, 50, 100, 150, 200, 300, 400, 500], // 可供选择的每页的行数（*）
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
      ignoreColumn: [0, 29], // 忽略某一列的索引
      fileName: '测试车辆-保险列表', // 文件名称设置
      worksheetName: 'sheet1', // 表格工作区名称
      tableName: '测试车辆-保险列表',
      excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
      // onMsoNumberFormat: DoOnMsoNumberFormat
    },
    exportDataType: "selected",
    uniqueId: "vSn", // 每一行的唯一标识
    onPageChange: function (page, size) {
      console.log('切换页事件 当前页数：第' + page + "页，每页显示数量" + size + "条");
      var pageInfo = {
        pageNumber: page,
        pageSize: size
      };
      window.sessionStorage.pageInfo = JSON.stringify(pageInfo);
    },
    // 得到查询的参数
    queryParams: function (params) {
      console.log(params);
      // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
      var temp = {
        size: params.limit, // 页面大小
        page: (params.offset / params.limit) + 1, // 页码
        sort: params.sort, // 排序列名
        sortOrder: params.order, // 排位命令（desc，asc）
        gpsSn: $("#VinTable_toolbar .vinbind_vin").val(), // gps编号
        vSn: $("#VinTable_toolbar .vinbind_vSn").val(), // 车辆编号
      };
      return temp;
    },
    onLoadSuccess: function (res) {
      if (window.islogin == undefined || window.islogin == null) {
        $('#InsTable').bootstrapTable('hideColumn', 'operate');
      } else if (window.islogin.data.roles.length > 0) {
        var userrole = [];
        for (var i = 0; i < window.islogin.data.roles.length; i++) {
          userrole.push(window.islogin.data.roles[i].name);
        }
        var userroleString = userrole.toString();
        if (userroleString.indexOf("超级管理员") != -1 || userroleString.indexOf("保险管理员") != -1 || userroleString.indexOf("实习生") != -1) {
          $('#vinTable').bootstrapTable('showColumn', 'operate');
        } else {
          $('#vinTable').bootstrapTable('hideColumn', 'operate');
        }
      }
    },
    onLoadError: function () {
      console.log("数据加载失败！");
    },
    columns: [
      [{
        "title": "测试车辆-终端管理",
        "halign": "center",
        "align": "center",
        "colspan": 30
      }],
      [{
          field: "vSn",
          title: "车辆编号",
          align: 'center',
          valign: "middle",
          events: carVsnoperateEvents,
          formatter: carVsnoperateFormatter
        },
        {
          field: "gpsSn",
          title: "GPS编号",
          align: 'center',
          valign: "middle"
        },
        // {
        //   field: 'operate',
        //   title: '操作',
        //   align: 'center',
        //   valign: "middle",
        //   events: vinoperateEvents,
        //   formatter: vinFormatter
        // }
      ]
    ]
  }

  $("#vinTable").bootstrapTable('destroy').bootstrapTable(tableOptions)
}

function vinFormatter(value, row, index) {
  if (window.islogin == undefined || window.islogin == null) {
    return '';
  } else {
    var userrole = [];
    for (var i = 0; i < window.islogin.data.roles.length; i++) {
      userrole.push(window.islogin.data.roles[i].name);
    }
    var userroleString = userrole.toString();
    if (userroleString.indexOf("超级管理员") != -1 || userroleString.indexOf("保险管理员") != -1 || userroleString.indexOf("实习生") != -1) {
      if (row.lave > 40) {
        isallow = "disabled";
      } else {
        isallow = "";
      }
      return [
        '<button type="button" id="btn_vinbind" class="my_btn btn btn-default btn-sm">绑定</button>'
      ].join('');
    } else {
      return '';
    }
  }
}

window.vinoperateEvents = {
  'click #btn_vinbind': function (e, value, row, index) { //修改

  }
};

$("#vin_search").unbind('click').bind('click', function () {
  loadVinList();
})
var vinInfo = []

$("#btn_vinbind").unbind('click').bind('click', function () {
  vinInfo = [{
    "name": "车辆编号",
    "type": "text",
    "inputName": "vSn",
    "must": "*"
  },
  {
    "name": "GPS编号",
    "type": "text",
    "inputName": "gpsSn",
    "must": "*"
  },
];
  // console.log(row);
  // window.sessionStorage.oilrow = JSON.stringify(row);
  $("#add_model").modal();
  $("#add_model #myModalLabel").html("绑定终端");
  creatForm(vinInfo, "#add_model .modal-body form", "editVin_btn");
  $("#add_model .modal-body  input.time").attr("readonly", true);
  $(".editVin_btn").unbind('click').bind('click', function () {
    var sub_data = $("#add_model .modal-body form").serializeObject();
    var sub_url = allurl + "/car-management/gpscar/check.action";
    // sub_data = JSON.stringify(sub_data);
    window.sessionStorage.vinrow = JSON.stringify(sub_data);
    
    $.ajax({
      type: 'get',
      url: sub_url,
      data: sub_data,
      contentType: 'application/json;charset=UTF-8', // contentType很重要
      crossDomain: true,
      success: function (res) {
        console.log(res)
        // if (res.ret) {
          vinInfo = []
          $("#add_model").modal();
          $("#add_model #myModalLabel").html("绑定确认");
          creatForm(vinInfo, "#add_model .modal-body form", "ok");
          $("#add_model .modal-body form").prepend('<p>'+res.msg+'</p>');
          $(".ok").unbind('click').bind('click', function () {
            sub_url = allurl + "/car-management/gpscar/bindCarGps.action";
            subData(sub_url, sub_data, "get", "bindCarGps");
            $(this).attr({
              "data-dismiss": "modal",
              "aria-label": "Close"
            });
          })
          
        // } else {
        //   toastr.error(res.msg, "提示", errormessageOpts);
        // }
      },
      error: function (err) {
        toastr.error('程序内部错误', "提示", errormessageOpts);
      }
    })
  })
})