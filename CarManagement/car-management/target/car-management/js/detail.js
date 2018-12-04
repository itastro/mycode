// 接车点检
creatForm(carCheckInfo, "#carCheckForm form", "carCheck_btn");

// 安全
var carInfo = window.sessionStorage.getItem("carInfo");
carInfo = JSON.parse(carInfo);
$("#toolForm .tool_btn").attr("disabled", true);
// 车辆编号、 保单号、 厂牌型号、 起始日、 终止日、 保险备注、 申请人、 申请日期
var insArr = [{ "name": "数据编号", class: "vSn" }, { "name": "车辆编号", class: "vSn" }, { "name": "保单号", class: "licenseNo" },
    { "name": "起始日", class: "licenseStartTime" }, { "name": "终止日", class: "licenseEndTime" },
    { "name": "保险备注", class: "remark" },
    { "name": "申请人", class: "applyperson" }, { "name": "申请日期", class: "applytime" }
];

function findinsuranceByvSn(boxname, vSn) {
    $.ajax({
        url: allurl + "/car-management/insurance/findByvSn/" + vSn + ".action",
        success: function(res) {
            // console.log(res);
            if (res.length <= 0) {
                $(boxname).html("未搜索到相关记录数据");
                return;
            } else {
                var audit_tit = "<div class='audit_title clearfix'><span class='audit_span' style='width:12.5%'>车辆编号</span>" +
                    "<span class='audit_span' style='width:12.5%'>保单号</span>" +
                    "<span class='audit_span' style='width:12.5%'>起始日</span>" +
                    "<span class='audit_span' style='width:12.5%'>终止日</span>" +
                    "<span class='audit_span' style='width:12.5%'>厂牌型号</span>" +
                    "<span class='audit_span' style='width:12.5%'>保险备注</span>" +
                    "<span class='audit_span' style='width:12.5%'>申请人</span>" +
                    "<span class='audit_span' style='width:12.5%'>申请日期</span>" +
                    "</div>";
                var auditboxs = "";
                var audit_con = "";
                for (var i = 0; i < res.length; i++) {
                    audit_con = "<div class='audit_row clearfix'><span class='audit_span' style='width:12.5%'>" + res[i].vSn + "</span>" +
                        "<span class='audit_span' style='width:12.5%'>" + res[i].insNo + "</span>" +
                        "<span class='audit_span' style='width:12.5%'>" + res[i].startTime + "</span>" +
                        "<span class='audit_span' style='width:12.5%'>" + res[i].endTime + "</span>" +
                        "<span class='audit_span' style='width:12.5%'>" + res[i].brandModeltwo + "</span>" +
                        "<span class='audit_span' style='width:12.5%'>" + res[i].remark + "</span>" +
                        "<span class='audit_span' style='width:12.5%'>" + res[i].applyPerson + "</span>" +
                        "<span class='audit_span' style='width:12.5%'>" + res[i].applyTime + "</span>" +
                        "</div>";
                    var auditFot = "<div class='audit_fot'><span class='operator'>录入人：" + res[i].addPerson + "</span><span class='date'>录入日期：" + res[i].makeTime + "</span></div>";
                    auditboxs += audit_tit + audit_con + auditFot;
                    // console.log(auditboxs);
                }
                $(boxname).html(auditboxs);
            }
        }
    })
}
// 还车点检
creatForm(returnCarInfo, "#returncarForm form", "returncardetail_btn");
// 查看保养记录
function findUpkeep(name, vSn) {
    $.ajax({
        "url": allurl + "/car-management/car/maintenance/getMaintenance.action",
        "type": "get",
        "data": {
            "vSn": vSn
        },
        contentType: 'application/json;charset=UTF-8', //contentType很重要 
        crossDomain: true,
        "success": function(res) {
            console.log(res);
            if (res == null || res.length == 0) {
                toastr.warning('此车尚未进行保养，记录为空', '保养记录', messageOpts);
                return;
            }
            var upkeepInfo = "";
            for (var i = 0; i < res.length; i++) {
                var itemInfo = "";
                for (var j = 0; j < res[i].maintenanceItem.length; j++) {
                    itemInfo += '  <div class="col-sm-12"><span>' +
                        '<input type="checkbox" name="upkeepItem" value="' + res[i].maintenanceItem[j].itemName + '">"' + res[i].maintenanceItem[j].itemName + '"&nbsp;&nbsp;' +
                        '</span>' +
                        '<span class="form-group_text">' +
                        '<label for="">品牌及标号：</label>' +
                        '<input type="text" class="brand_input" value="' + res[i].maintenanceItem[j].brandAndlabel + '">' +
                        '</span>' +
                        '</div>';
                }
                console.log(itemInfo);
                upkeepInfo += '<form class="form-horizontal even_style upkeepFormInfo">' +
                    '<div class="form-group"><label for="inputEmail3" class="col-sm-4 control-label">' + "车辆编号：" + '</label>' +
                    '<div class="col-sm-6"><input type="text" class="form-control col-sm-7 vSn" value="' + res[i].vSn + '" placeholder="试验车号">' +
                    '</div></div>' +
                    ' <div class="form-group"><label for="inputEmail3" class="col-sm-4 control-label">保养日期：</label>' +
                    '<div class="col-sm-6 car_tools_check">' +
                    '<input class="form-control col-sm-7 layer-date mydata_input upkeepTime" value="' + res[i].maintenanceTime + '">' +
                    '</div></div>' +
                    '<div class="form-group"><label for="inputEmail3" class="col-sm-4 control-label">保养里程：</label>' +
                    '<div class="col-sm-6 car_tools_check">' +
                    '<input class="form-control col-sm-7 layer-date mydata_input upkeepTime" value="' + res[i].maintenanceMileage + '">' +
                    '</div></div>' +
                    ' <div class="form-group"><label for="inputEmail3" class="col-sm-4 control-label">下次保养：</label>' +
                    '<div class="col-sm-6 car_tools_check">' +
                    '<input class="form-control col-sm-7 layer-date mydata_input upkeepTime" value="' + res[i].nextMaintenanceTime + '">' +
                    '</div></div>' +
                    ' <div class="upitem_group"><label for="inputEmail3" class="col-sm-2 control-label">保养项目：</label>' +
                    '<div class="col-sm-9 car_tools_check">' + itemInfo +
                    '</div></div>' +
                    '<div class="upkeep_footer" style="text-align:right;margin-right:180px;"><span class="operator">操作人：' + res[i].maintenanceOperator +
                    '</span></div>' +
                    '</form>';
                // <span class="date">操作日期：' + res[i].maintenanceTime + '</span>
            }
            $(name).html(upkeepInfo);
            $(name + " input").attr("readOnly", true);
        },
        "error": function(res) {
            console.log(res);
        }
    });
}
var plateArr = [{ "name": "车辆编号" }, { "name": "验车申请日" }, { "name": "车牌号" },
    { "name": "车牌终止日" },
    { "name": "录入日期" }, { "name": "车牌备注" }
];

function historyLicenseByvSn(boxname, vSn) {
    $.ajax({
        url: allurl + "/car-management/license/historyLicenseByvSn.action?vSn=" + vSn,
        success: function(res) {
            console.log(res);
            if (res.length <= 0) {
                $(boxname).html("未搜索到相关记录数据");
                return;
            } else {
                var audit_tit = "<div class='audit_title clearfix'><span class='audit_span' style='width:14.28%'>车辆编号</span>" +
                    "<span class='audit_span' style='width:14.28%'>车牌号</span>" +
                    "<span class='audit_span' style='width:14.28%'>车牌终止日</span>" +
                    "<span class='audit_span' style='width:14.28%'>验车申请日</span>" +
                    "<span class='audit_span' style='width:14.28%'>车牌备注</span>" +
                    "<span class='audit_span' style='width:14.28%'>录入人</span>" +
                    "<span class='audit_span' style='width:14.28%'>录入日期</span>" +
                    "</div>";
                var auditboxs = "";
                var audit_con = "";
                for (var i = 0; i < res.length; i++) {
                    audit_con = "<div class='audit_row clearfix'><span class='audit_span' style='width:14.28%'>" + res[i].vSn + "</span>" +
                        "<span class='audit_span' style='width:14.28%'>" + res[i].licenseNo + "</span>" +
                        "<span class='audit_span' style='width:14.28%'>" + res[i].licenseEndTime + "</span>" +
                        "<span class='audit_span' style='width:14.28%'>" + res[i].applytime + "</span>" +
                        "<span class='audit_span' style='width:14.28%'>" + res[i].remark + "</span>" +
                        "<span class='audit_span' style='width:14.28%'>" + res[i].addPerson + "</span>" +
                        "<span class='audit_span' style='width:14.28%'>" + res[i].maketime + "</span>" +
                        "</div>";
                    auditboxs += audit_tit + audit_con;
                    console.log(auditboxs);
                }
                $(boxname).html(auditboxs);
                // console.log(auditboxs);
            }
        }
    })
}


function loadprojectName(boxname) { //查询所有的项目号
    $.ajax({
        url: allurl + "/car-management/project/loadprojectName.action",
        success: function(res) {
            console.log(res);
            projectStatus[0].option = [];
            var options = "";
            for (var i = 0; i < res.length; i++) {
                projectStatus[0].option.push({ "name": res[i], "val": res[i] });
                options += '<option value="' + res[i] + '" name="' + res[i] + '">' + res[i] + '</option>';
            }
            $(boxname).html(options);
            console.log(options);
        }
    })
}