// 研发工具记录申请
var toolnameArr = [{ "toolname": "12V电源" },
    { "toolname": "CAN1开发接头" },
    { "toolname": "前催化器载体温度" },
    { "toolname": "空气比传感器座" },
    { "toolname": "排方前采样管" },
    { "toolname": "CAN0开发接头" },
    { "toolname": "排气管改造" },
    { "toolname": "安装前拖车钩" },
    { "toolname": "拆下ECU" },
    { "toolname": "" },
    { "toolname": "" },
    { "toolname": "" },
    { "toolname": "" },
    { "toolname": "" },
    { "toolname": "" },
    { "toolname": "" },
    { "toolname": "" },
    { "toolname": "" }
];

function ToolRecordApply(name, vSn, btnname) {
    var checkitems = '';
    $.ajax({
        url: allurl + "/car-management/car/findDevelop.action?vSn=" + vSn,
        success: function(res) {
            if (res.length > 0) {
                for (var i = 0; i < res.length; i++) {
                    checkitems += '<div class="checkitem" uuid="' + res[i].id + '"><span><input type="text" class="toolname" value="' + res[i].toolName + '">' + '</span></div>';
                }
                for (var s = 0; s < 9; s++) {
                    checkitems += '<div class="checkitem"><span><input type="text" class="toolname" value=""></span></div>';
                }
                checkitems += "<div class='audit_fot check_user'><span class='operator'>申请人：" + res[0].applicant +
                    "</span><span class='date'>申请日期：" + res[0].applyTime + "</span></div>";
                $(name).html(checkitems);
                $(name + " input").attr("readOnly", true);
                $(name + " input").addClass("readonly");
            } else {
                for (var i = 0; i < toolnameArr.length; i++) {
                    checkitems += '<div class="checkitem" id="' + i + '"><span><input type="text" class="toolname" value="' + toolnameArr[i].toolname + '">' + '</span></div>';
                }
                $(name).html(checkitems);
                $(name + " input").attr("readOnly", false);
                $(name + " input").removeClass("readonly");

            }
        }
    })
}
// bom检查申请
var bomapplyArr = [
    { "id": 56, "pname": "ECM发动机电子控制模块-MT92.1", "carCheckRequest": null, "components": { "id": 1, "name": "" }, "carCheckItems": [] },
    { "id": 6, "pname": "高压燃油油轨总成", "carCheckRequest": null, "components": { "id": 11, "name": "" }, "carCheckItems": [] },
    { "id": 06, "pname": "高压油泵总成", "carCheckRequest": null, "components": { "id": 11, "name": "" }, "carCheckItems": [] },
    { "id": 57, "pname": "MAP/MAT sensor进气压力温度传感器", "carCheckRequest": null, "components": { "id": 2, "name": "" }, "carCheckItems": [] },
    { "id": 58, "pname": "Fron Oxygen Sensor前氧传感器", "carCheckRequest": null, "components": { "id": 3, "name": "" }, "carCheckItems": [] },
    { "id": 59, "pname": "Rear Oxygen Sensor后氧传感器", "carCheckRequest": null, "components": { "id": 4, "name": "" }, "carCheckItems": [] },
    { "id": 60, "pname": "Fuel Rail Assembly燃油导轨总成", "carCheckRequest": null, "components": { "id": 5, "name": "" }, "carCheckItems": [] },
    { "id": 61, "pname": "Knock Sensor 爆震传感器", "carCheckRequest": null, "components": { "id": 6, "name": "" }, "carCheckItems": [] },
    { "id": 62, "pname": "Crank Position sensor曲轴位置传感器", "carCheckRequest": null, "components": { "id": 7, "name": "" }, "carCheckItems": [] },
    { "id": 63, "pname": "Purge Solenoid-ECP炭罐电磁阀", "carCheckRequest": null, "components": { "id": 8, "name": "" }, "carCheckItems": [] },
    { "id": 64, "pname": "ETC电子节气阀体总成", "carCheckRequest": null, "components": { "id": 9, "name": "" }, "carCheckItems": [] },
    { "id": 65, "pname": "coolant Sensor 冷却液温度传感器", "carCheckRequest": null, "components": { "id": 10, "name": "" }, "carCheckItems": [] },
    { "id": 66, "pname": "Boot P/T sensor增压压力温度传感器", "carCheckRequest": null, "components": { "id": 11, "name": "" }, "carCheckItems": [] },
    { "id": 67, "pname": "", "carCheckRequest": null, "components": { "id": "", "name": "" }, "carCheckItems": [] },
    { "id": 68, "pname": "", "carCheckRequest": null, "components": { "id": "", "name": "" }, "carCheckItems": [] },
    { "id": 69, "pname": "", "carCheckRequest": null, "components": { "id": "", "name": "" }, "carCheckItems": [] },
    { "id": 70, "pname": "", "carCheckRequest": null, "components": { "id": "", "name": "" }, "carCheckItems": [] },
    { "id": 71, "pname": "", "carCheckRequest": null, "components": { "id": "", "name": "" }, "carCheckItems": [] }
]

function bomApply(name, vSn, btnname) {
    var checkboxs = '<div class="checktitle"><span>零部件名称</span><span>零部件号</span></div>';
    $.ajax({
        url: allurl + "/car-management/car/findEmsAndBomCheckByvSn/" + vSn + ".action",
        success: function(res) {
            if (res.checkResults.length <= 0) { //尚未申请
                for (var n = 0; n < bomapplyArr.length; n++) {
                    checkboxs += '<div class="checkitem" uuid=""><span><input type="text" class="bom_name" value="' + bomapplyArr[n].pname + '">' +
                        '</span><span><input type="text" class="bom_num" value="' + bomapplyArr[n].components.name + '">' +
                        '</span></div>';
                }
                $(name).html(checkboxs);
                $(name + " input").attr("readOnly", false);
                $(name + " input").removeClass("readonly");
            } else {
                var obj = res.checkResults;
                for (var i = 0; i < obj.length; i++) {
                    checkboxs += '<div class="checkitem" uuid="' + obj[i].uuid + '"><span><input type="text" class="bom_name" value="' + obj[i].bomName + '">' +
                        '</span><span><input type="text" class="bom_num" value="' + obj[i].bomNum + '">' +
                        '</span></div>';
                }
                for (var s = 0; s < 5; s++) {
                    checkboxs += '<div class="checkitem"><span><input type="text" class="bom_name" value="">' +
                        '</span><span><input type="text" class="bom_num" value="">' +
                        '</span></div>';
                }
                checkboxs += "<div class='audit_fot check_user'><span class='operator'>申请人：" + res.check.applyPerson +
                    "</span><span class='date'>申请日期：" + res.check.applyTime + "</span></div>";

                $(name).html(checkboxs);
                $(name + " input").attr("readOnly", true);
                $(name + " input").addClass("readonly");
            }

        }
    })
}
var carInfo = window.sessionStorage.getItem("carInfo");
carInfo = JSON.parse(carInfo);
if (carInfo == null || carInfo == undefined) {
    carInfo = {}
    carInfo.vSn = "";
}