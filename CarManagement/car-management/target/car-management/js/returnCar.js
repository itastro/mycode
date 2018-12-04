// 新车点检信息
var returnCarInfo = [{
    "name": "车辆编号",
    "type": "text",
    "inputName": "vSn",
    "must": ""
}, {
    "name": "研发工具是否回收",
    "type": "radio",
    "inputName": "toolisrecycled",
    "must": "",
    "option": [{
        "name": "是"
    }, {
        "name": "否"
    }]
}, {
    "name": "运输车号",
    "type": "text",
    "inputName": "trans_sn",
    "must": ""
}, {
    "name": "随车工具",
    "type": "text",
    "inputName": "tools",
    "must": "套"
}, {
    "name": "还车申请人",
    "type": "text",
    "inputName": "proposer",
    "must": "*"
}, {
    "name": "停车警示牌",
    "type": "text",
    "inputName": "warningboard",
    "must": "只"
}, {
    "name": "交车人",
    "type": "text",
    "inputName": "forpeople",
    "must": ""
}, {
    "name": "备用轮胎",
    "type": "text",
    "inputName": "sparetyre",
    "must": "只"
}, {
    "name": "接车人",
    "type": "text",
    "inputName": "pickone",
    "must": "*"
}, {
    "name": "里程表",
    "type": "text",
    "inputName": "odometer",
    "must": "km"
}, {
    "name": "接车人电话",
    "type": "text",
    "inputName": "pick_tel",
    "must": ""
}, {
    "name": "千斤顶",
    "type": "text",
    "inputName": "jack",
    "must": "只"
}, {
    "name": "接车人身份证",
    "type": "text",
    "inputName": "pick_card",
    "must": ""
}, {
    "name": "车用灭火器",
    "type": "text",
    "inputName": "fire",
    "must": "只"
}, {
    "name": "实际还车日期",
    "type": "today-date",
    "inputName": "time",
    "must": ""
}, {
    "name": "钥匙数量",
    "type": "text",
    "inputName": "keyy",
    "must": "把"
}, {
    "name": "备注",
    "type": "text",
    "inputName": "remark",
    "must": ""
}, ];
creatForm(returnCarInfo, "#returncarCheck form", "returncarCheck_btn");
$(".returncarCheck_btn").unbind('click').bind('click', function() {
    var mustobj = $("#returncarCheck .required");
    var sub_url = allurl + "/car-management/car/backCheck.action"; // 还车
    var sub_data = $("#returncarCheck form").serializeObject();
    sub_data.id = $("#returncarCheck form").attr("id");

    if (sub_data.proposer == '') {
        console.log('请填写还车声请人')
        toastr.warning('请填写还车申请人', '提示', errormessageOpts);
        return;
    }
    if (sub_data.pickone == '') {
        toastr.warning('请填写接车人', '提示', errormessageOpts);
        return;
    }

    sub_data = JSON.stringify(sub_data);
    subData(sub_url, sub_data, "post", "returncarCheck_btn");
})
var mustobj = $("#returncarCheck .required");
for (var i = 0; i < mustobj.length; i++) {
    if (mustobj[i].value != "" && mustobj[i].value != null) {
        $(".returncarCheck_btn").text("还车");
    }
}

function findBackcheck(boxname, vSn) {
    $.ajax({
        url: allurl + "/car-management/car/findBackcheck/" + vSn + ".action",
        success: function(res) {
            console.log(res);
            if (res != null) {
                $(boxname).attr("id", res.id);
                showData(boxname, res);
            } else {
                $("#returncarForm form .vSn").val(vSn);
            }
        }
    });
}
$("#returncarCheck button.pull-right").click(function() {
    window.location.hash = "carList";
})