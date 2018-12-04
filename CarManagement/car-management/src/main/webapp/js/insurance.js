function loadInsuranceList(pageInfo) {
  if (pageInfo == undefined) {
    var pageInfo = {
      pageNumber: 1,
      pageSize: 10
    };
  }
  $("#InsTable").bootstrapTable('destroy').bootstrapTable({
    url: allurl + '/car-management/insurance/pageQuery.action',
    dataType: 'json',
    striped: true, // 是否显示行间隔色
    toggle: "table",
    toolbar: "InsTable_toolbar",
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
        updateTime: $(".insuranceTypeIn_top .ins_updata").val(), // 更新日期
        insNo: $(".insuranceTypeIn_top .insNo").val(), // 保单号
        vin: $(".insuranceTypeIn_top .vin").val(), // 车架号
        engineNumber: $(".insuranceTypeIn_top .engineNumber").val(), // 发动机号
        iendTime: $(".insuranceTypeIn_top .ins_enddata").val(), // 終止日
        vSn: $(".insuranceTypeIn_top .ins_vSn").val(), // 车辆编号
        // project_status: $(".insuranceTypeIn_top .project_status").val(), // 项目状态
        istatus: $(".insuranceTypeIn_top .ins_state").val(), // 保险状态
        vehicleInspection: $(".insuranceTypeIn_top .vehicleInspection").val(), // 验车状态
        applyTime: $(".insuranceTypeIn_top .ins_applyTime").val() // 保险申请日
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
          $('#InsTable').bootstrapTable('showColumn', 'operate');
        } else {
          $('#InsTable').bootstrapTable('hideColumn', 'operate');
        }
      }
    },
    onLoadError: function () {
      console.log("数据加载失败！");
    },
    columns: [
      [{
        "title": "测试车辆-保险列表",
        "halign": "center",
        "align": "center",
        "colspan": 30
      }],
      [{
          field: "checkbox",
          title: "全选",
          checkbox: true,
          align: 'center',
          valign: "middle"
        },
        {
          field: 'index',
          title: "序号",
          valign: "middle",
          align: "center",
          width: "3%",
          formatter: function (value, row, index) {
            var pageSize = $('#InsTable').bootstrapTable('getOptions').pageSize; // 通过表的#id
            // 可以得到每页多少条
            var pageNumber = $('#InsTable').bootstrapTable('getOptions').pageNumber; // 通过表的#id
            // 可以得到当前第几页
            return pageSize * (pageNumber - 1) + index + 1; // 返回每条的序号：
          }
        },
        {
          field: "vSn",
          title: "车辆编号",
          align: 'center',
          valign: "middle",
          events: carVsnoperateEvents,
          formatter: carVsnoperateFormatter
        },
        {
          field: "project",
          title: "项目编号",
          align: 'center',
          valign: "middle",
          formatter: function (value, row, index) {
            return value.project_sn;
          }
        },
        {
          field: "carName",
          title: "车辆名称",
          align: 'center',
          valign: "middle"
        },
        {
          field: "numtime",
          title: "保险期限",
          align: 'center',
          valign: "middle",
          formatter: function (value, row, index) {
            return value + "年";
          }
        },
        {
          field: "engineNumber",
          title: "发动机号",
          align: 'center',
          valign: "middle",
          formatter: function (value, row, index) {
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
          formatter: function (value, row, index) {
            if (value == null) {
              return '';
            } else {
              return '<span style="width:50px;word-break:break-all; word-wrap:break-all;">' + value + '</span>';
            }
          }
        },
        {
          field: "vCarType",
          title: "车辆类型",
          align: 'center',
          valign: "middle"
        },
        {
          field: "seats",
          title: "座纳",
          align: 'center',
          valign: "middle"
        },
        {
          field: "price",
          title: "价值",
          align: 'center',
          valign: "middle"
        },
        {
          field: "engineCapacity",
          title: "排量",
          align: 'center',
          valign: "middle"
        },
        {
          field: "vehicleQuality",
          title: "吨位",
          align: 'center',
          valign: "middle"
        },
        {
          field: "projectEngineer",
          title: "负责工程师",
          align: 'center',
          valign: "middle"
        },
        {
          field: "customer",
          title: "客户",
          align: 'center',
          valign: "middle",
          formatter: function (value, row, index) {
            if (value == null) {
              return '';
            } else {
              return '<span style="width:85px;">' + value + '</span>';
            }
          }
        },
        {
          field: "project",
          title: "项目状态",
          align: 'center',
          valign: "middle",
          formatter: function (value, row, index) {
            if (value != null) {
              return value.project_status
            }
          }
        },
        {
          field: "applyPerson",
          title: "申请人",
          align: 'center',
          valign: "middle"
        },
        {
          field: "applyTime",
          title: "申请日期",
          align: 'center',
          valign: "middle"
        },
        {
          field: "insNo",
          title: "保单号",
          align: 'center',
          valign: "middle",
          formatter: function (value, row, index) {
            if (value == null) {
              return '';
            } else {
              return '<span style="width:57px;word-break:break-all; word-wrap:break-all;">' + value + '</span>';
            }
          }
        },
        {
          field: "brandModelone",
          title: "车辆型号",
          align: 'center',
          valign: "middle"
        },
        {
          field: "brandModeltwo",
          title: "厂牌型号(保)",
          align: 'center',
          valign: "middle"
        },
        {
          field: "startTime",
          title: "起始日",
          align: 'center',
          valign: "middle"
        },
        {
          field: "endTime",
          title: "终止日",
          align: 'center',
          valign: "middle",
          formatter: function (value, row, index) {
            if (value == null || value == "1970-10-01") {
              return "";
            } else {
              return '<span style="color:red">' + value + '</span>';
            }
          }
        },
        {
          field: "remark",
          title: "保险备注",
          align: 'center',
          valign: "middle"
        },
        // {
        // field: "lave",
        // title: "剩余日期",
        // align: 'center',
        // valign: "middle",
        // formatter: function(value, row, index) {
        // var a = "";
        // if (value <= 0 && value != null) {
        // a = '<span style="color:red">过期' + value + '天</span>';
        // } else if (value > 0 && value <= 90) {
        // a = '<span style="color:blue">剩余' + value + '天</span>';
        // } else if (value != null) {
        // a = '<span style="color:green">剩余' + value + '天</span>';
        // } else if (value == null) {
        // a = "";
        // }
        // return a;
        // }
        // },

        // vehicleInspection
        {
          field: "makeTime",
          title: "更新日期",
          align: 'center',
          valign: "middle"
        },
        {
          field: "istatus",
          title: "保险状态",
          align: 'center',
          valign: "middle",
          formatter: function (value, row, index) {
            var a = "";
            if (value == null) {
              var a = '';
            } else if (value == "未申请") {
              var a = '<span style="color:red">未申请</span>';
            } else if (value == "已申请") {
              var a = '<span style="color:green">已申请</span>';
            } else if (value == "未续保") {
              var a = '<span style="color:red">未续保</span>';
            } else if (value == "已续保") {
              var a = '<span style="color:green">已续保</span>';
            } else {
              var a = value;
            }
            return a;
          }
        }, {
          field: "vehicleInspection",
          title: "验车状态",
          align: 'center',
          valign: "middle",
          formatter: function (value, row, index) {
            var a = "";
            if (value == null) {
              var a = '';
            } else if (value == "未申请") {
              var a = '<span style="color:red">未申请</span>';
            } else if (value == "已申请") {
              var a = '<span style="color:green">已申请</span>';
            } else {
              var a = value;
            }
            return a;
          }
        },
        {
          field: "licenseEndTime",
          title: "车牌到期日",
          align: 'center',
          valign: "middle",
          formatter: function (value, row, index) {
            if (value == null || value == "1970-10-01") {
              return "";
            } else {
              return '<span style="color:blue">' + value + '</span>';
            }
          }
        },
        {
          field: "licremark",
          title: "车牌备注",
          align: 'center',
          valign: "middle"
        },
        {
          field: 'operate',
          title: '操作',
          align: 'center',
          valign: "middle",
          events: InsoperateEvents,
          formatter: InsoperateFormatter
        }
      ]
    ]
  });
}

function InsoperateFormatter(value, row, index) {
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
        '<button type="button" id="Insurance_typein" class="my_btn btn btn-default btn-sm" style="margin-right:15px;">录入</button>',
        '<button type="button" id="Insurance_update" class="my_btn btn btn-default btn-sm" style="margin-right:15px;">修改</button>',
        '<button type="button" id="Renewal_btn" ' + isallow + ' class="my_btn btn btn-default btn-sm" style="margin-right:15px;">续保</button>'
      ].join('');
    } else {
      return '';
    }
  }
}
window.InsoperateEvents = {
  'click #Insurance_typein': function (e, value, row, index) { // 录入保险
    $("#add_model").modal();
    $("#add_model #myModalLabel").html("保险录入");
    creatForm(InsuranceInfo, "#add_model .modal-body form", "Insurance_typein_btn");
    showData("#add_model .modal-body form", row);
    $(".Insurance_typein_btn").unbind('click').bind('click', function () {
      var sub_data = $("#add_model .modal-body form").serializeObject();
      var sub_url = allurl + "/car-management/insurance/addInsurance.action";
      console.log(sub_data);
      sub_data = JSON.stringify(sub_data);
      $(this).attr({
        "data-dismiss": "modal",
        "aria-label": "Close"
      });
      subData(sub_url, sub_data, "post", "addInsurance");
    });
  },
  'click #Insurance_update': function (e, value, row, index) { // 保险修改
    $("#add_model").modal();
    $("#add_model #myModalLabel").html("保险修改");
    creatForm(InsuranceInfo, "#add_model .modal-body form", "Insurance_typein_btn");
    showData("#add_model .modal-body form", row);
    $(".Insurance_typein_btn").unbind('click').bind('click', function () {
      var sub_data = $("#add_model .modal-body form").serializeObject();
      var sub_url = allurl + "/car-management/insurance/updateInsurance.action";
      sub_data = JSON.stringify(sub_data);
      $(this).attr({
        "data-dismiss": "modal",
        "aria-label": "Close"
      });
      subData(sub_url, sub_data, "post", "updateInsurance");
    });
  },
  'click #Renewal_btn': function (e, value, row, index) { // 续保
    var Ins_Arr = [];
    Ins_Arr.push(row);
    deletAll(Ins_Arr, "Ins_applyAgain");
  }
};

// 保险录入
var InsuranceInfo = [{
    "name": "车辆编号",
    "type": "text",
    "inputName": "vSn",
    "must": "*"
  },
  {
    "name": "保单号",
    "type": "text",
    "inputName": "insNo",
    "must": ""
  },
  {
    "name": "保险起始日",
    "type": "today-date",
    "inputName": "startTime",
    "must": "*"
  },
  {
    "name": "厂牌型号（保）",
    "type": "text",
    "inputName": "brandModeltwo",
    "must": ""
  },
  {
    "name": "保险终止日",
    "type": "end-date",
    "inputName": "endTime",
    "must": ""
  },
  {
    "name": "保险备注",
    "type": "text",
    "inputName": "remark",
    "must": ""
  },
];
var yancheInfo = [{
    "name": "距离保险到期",
    "type": "text",
    "inputName": "vSn",
    "must": "天"
  },
  {
    "name": "保险过期是否验车",
    "type": "radio",
    "inputName": "pateend",
    "must": "*",
    "option": [{
      "name": "是"
    }, {
      "name": "否"
    }]
  }
];

$("#yanche_filter").unbind('click').bind('click', function () {
  var yanche_Arr = $("#InsTable").bootstrapTable('getSelections');
  deletAll(yanche_Arr, "yanche_apply");
})
$("#ins_search").unbind('click').bind('click', function () {
  loadInsuranceList();
})