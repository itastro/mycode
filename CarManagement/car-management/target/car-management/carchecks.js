// 新车点检信息
var carCheckInfo = [
    { "name": "车辆编号", "type": "text", "inputName": "vSn", "must": "*" },
    { "name": "随车物品", "type": "text", "inputName": "item", "must": "" },
    { "name": "车辆型号", "type": "text", "inputName": "brandModelone", "must": "*" },
    { "name": "随车工具", "type": "text", "inputName": "tools", "must": "套" },
    { "name": "车架号", "type": "text", "inputName": "vin", "must": "*" },
    { "name": "停车警示牌", "type": "text", "inputName": "warningboard", "must": "只" },
    { "name": "发动机号", "type": "text", "inputName": "engineNumber", "must": "*" },
    { "name": "备用轮胎", "type": "text", "inputName": "sparetyre", "must": "只" },
    {
        "name": "车辆外观",
        "type": "checkbox",
        "inputName": "facade",
        "must": "",
        "option": [{ "name": "正常", "val": "1" }, { "name": "见外观说明", "val": "2" }]
    },
    { "name": "千斤顶", "type": "text", "inputName": "jack", "must": "只" },
    { "name": "外观说明", "type": "text", "inputName": "explanation", "must": "" },
    { "name": "车用灭火器", "type": "text", "inputName": "fire", "must": "只" },
    { "name": "送车人", "type": "text", "inputName": "send_p", "must": "*" },
    { "name": "钥匙数量", "type": "text", "inputName": "keyy", "must": "把" },
    { "name": "送车人电话", "type": "text", "inputName": "telephone", "must": "*" },
    { "name": "里程表", "type": "text", "inputName": "odometer", "must": "km*" },
    { "name": "接车人", "type": "text", "inputName": "pickone", "must": "*" },
    { "name": "接车日期", "type": "today-date", "inputName": "time", "must": "" },
];
$(".add_bom").click(function() {
    var box = '<div class="checkitem"><span><input type="text" class="bom_name" value="">' +
        '</span><span><input type="text" class="bom_num" value="">' +
        '</span></div>';
    $("#newcarTypeIn form.bom_apply").append(box);
});
$(".add_rd").click(function() {
    var box = '<div class="checkitem"><span><input type="text" class="toolname" value=""></span></div>';
    $("#newcarTypeIn form.rd_apply").append(box);
});

function getVsn(boxname) {
    $.ajax({
        "url": allurl + "/car-management/car/getvSn.action",
        async: false,
        success: function(res) {
            console.log(res);
            $(boxname).val(res);
            $("#carCheck .checkform .vSn").val(res);
            $("#newcarTypeIn .cartypein_apply .vSn").val(res);
            $("#newcarTypeIn .cartypein_apply .vSn").attr("readonly", true);
            ToolRecordApply("#newcarTypeIn .rd_apply", res, "");
            bomApply("#newcarTypeIn .bom_apply", res, "");
        }
    })
}
// 接车点检
creatForm(carCheckInfo, "#carCheck .checkform", "carCheck_btn");

$("#newcarTypeIn .cartypein_apply input").val("2");
$("#carCheck form .vSn").attr("readOnly", true);

$(".carCheck").unbind('click').bind('click', function() {
    $("#carCheck input").val("");
    myformReset("#carCheck");
    getVsn("#carCheck .checkform .vSn"); //数据库生成车辆编号
});
$("#carCheck button.btn.btn-default.pull-left.btn-primary.carCheck_btn").hide();
$("#newcarTypeIn .cartypein_apply .form_btngroup").hide();
$("#newcarTypeIn .cartypein_apply .form_btngroup").hide();


// 车辆信息提交------------------------------------------------------------------------------------------------------
$("#newcarTypeIn .sub_cartypein").unbind('click').bind('click', function() {
    // 接车点检信息
    var mustobj = $("#carCheck .required");
    for (var i = 0; i < mustobj.length; i++) {
        if (mustobj[i].value == "" || mustobj[i].value == null) {
            toastr.warning('有必填项未填写', '提示', messageOpts);
            mustobj[i].focus();
            return;
        }
    }
    var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (reg.test($("#carCheck .telephone").val()) == false) {
        toastr.warning('电话格式不正确', '提示', messageOpts);
        return;
    }
    $.ajax({
        url: "/car-management/car/findUpcheck/" + $("#newcarTypeIn .cartypein_apply .vSn").val() + ".action",
        async: false,
        success: function(res) {
            console.log(res);
            if (res != null) { //如果车辆编号已经存在，则重新生成一个编号。
                $.ajax({
                    "url": allurl + "/car-management/car/getvSn.action",
                    async: false,
                    success: function(res) {
                        // console.log(res);
                        toastr.warning('车辆编号已存在，系统已自动调整为:' + res, '提示', messageOpts);
                        $("#carCheck .checkform .vSn").val(res);
                        $("#newcarTypeIn .cartypein_apply .vSn").val(res);
                        $("#newcarTypeIn .cartypein_apply .vSn").attr("readonly", true);
                        ToolRecordApply("#newcarTypeIn .rd_apply", res, "");
                        bomApply("#newcarTypeIn .bom_apply", res, "");
                    }
                })
            }
        }
    });
    setTimeout(function() {
        console.log($("#carCheck .checkform .vSn").val());
        var sub_data = $("#carCheck .checkform").serializeObject();
        var sub_url = allurl + "/car-management/car/upcheck.action";
        sub_data = JSON.stringify(sub_data);
        // console.log(sub_data);
        // 车辆录入信息
        var typein_url = allurl + "/car-management/car/save.action";
        var typein_data = $("#newcarTypeIn .cartypein_apply").serializeObject();
        var groupval = $("#newcarTypeIn .cartypein_apply .groupName option:selected").attr("value");
        var project_sn = $("#newcarTypeIn .cartypein_apply .project_sn").val();
        typein_data.groupName = groupval;
        typein_data.project_sn = project_sn;
        // bom数据
        var bomuuid = $("#newcarTypeIn .bom_apply .checkitem");
        var bomNameArr = $("#newcarTypeIn .bom_apply .bom_name");
        var bomnumArr = $("#newcarTypeIn .bom_apply .bom_num");
        var bomArr = [];
        for (var i = 0; i < bomNameArr.length; i++) {
            if (bomNameArr[i].value != "" && bomnumArr[i].value != "") {
                bomArr.push({
                    "uuid": bomuuid[i].getAttribute("uuid"),
                    "bomName": bomNameArr[i].value,
                    "bomNum": bomnumArr[i].value,
                    "vSn": $("#newcarTypeIn .cartypein_apply .vSn").val()
                });
            }
        }
        if (bomArr.length == 0) {
            toastr.warning('请填写相关bom零部件', '提示', messageOpts);
            return;
        }
        var bomurl = allurl + "/car-management/car/applybom.action";
        var bomData = JSON.stringify(bomArr);
        // 研发
        var toolNameArr = $(".rd_apply .toolname");
        var toolArr = [];
        for (var i = 0; i < toolNameArr.length; i++) {
            if (toolNameArr[i].value != "") {
                toolArr.push({
                    "toolName": toolNameArr[i].value,
                    "vSn": $("#newcarTypeIn .cartypein_apply .vSn").val()
                });
            }
        }
        if (toolArr.length == 0) {
            toastr.warning('请填写要安装的工具或设备名称', '提示', messageOpts);
            return;
        }
        var toolurl = allurl + "/car-management/car/applytools.action";
        var toolData = JSON.stringify(toolArr);

        // subData(sub_url, sub_data, "post", "carCheck_btn");//点检
        $.ajax({
            url: sub_url,
            data: sub_data,
            type: "post",
            contentType: 'application/json;charset=UTF-8', // contentType很重要
            crossDomain: true,
            async: false,
            success: function(res) {
                toastr.success(res.msg, "提示", messageOpts);
                if (res.ret == true) {
                    subData(typein_url, typein_data, "get", "newcar_typein_sub", ".cartypein_apply"); //车辆录入提交
                    subData(bomurl, bomData, "post", "bomapply"); //bom申请提交
                    subData(toolurl, toolData, "post", "toolapply"); //tool申请提交
                } else {
                    return;
                }
            }
        });
        // 车辆图片
        setTimeout(function() {
            if ($(".shownewCarFileName").html() != "" && $(".shownewCarFileName").html() != null) {
                $.ajax({ //上传图片
                    url: allurl + "/car-management/car/carPicUpload.action?vSn=" + $("#newcarTypeIn .cartypein_apply .vSn").val(),
                    type: "post",
                    async: false,
                    data: new FormData($('#uploadnewCarPictureForm')[0]),
                    processData: false,
                    contentType: false,
                    success: function(res) {
                        toastr.success(res.msg, '提示', messageOpts);
                    },
                    error: function name() {
                        toastr.error(res.msg, '提示', messageOpts);
                    }
                });
            }
            if ($(".shownewcircuitryName").html() != "" && $(".shownewcircuitryName").html() != null) {
                $.ajax({ //上传电路图
                    url: allurl + "/car-management/file/circuitPicUpload.action?vSn=" + $("#newcarTypeIn .cartypein_apply .vSn").val(),
                    type: "post",
                    data: new FormData($('#uploadnewcircuitryForm')[0]),
                    processData: false,
                    contentType: false,
                    async: false,
                    success: function(res) {
                        console.log(res);
                        toastr.success(res.msg, '提示', messageOpts);
                    },
                    error: function name() {
                        toastr.error(res.msg, '提示', messageOpts);
                    }
                });
            }
            if ($(".shownewcrdName").html() != "" && $(".shownewcrdName").html() != null) {
                $.ajax({ //上传crd
                    url: allurl + "/car-management/file/wordUpload.action?vSn=" + $("#newcarTypeIn .cartypein_apply .vSn").val(),
                    type: "post",
                    data: new FormData($('#uploadnewcrdForm')[0]),
                    processData: false,
                    contentType: false,
                    success: function(res) {
                        toastr.success(res.msg, '提示', messageOpts);
                        if (res.ret == true) {
                            $(".carCheck").removeClass("active");
                            $(".carList").addClass("active");
                            window.location.hash = "carList";
                        }
                    },
                    error: function name() {
                        toastr.error(res.msg, '提示', messageOpts);
                    }
                });
            } else {
                $(".carCheck").removeClass("active");
                $(".carList").addClass("active");
                window.location.hash = "carList";
            }
        }, 300)
    }, 100);
});

// 车辆信息修改------------------------------------------------------------------------------------------------------
$("#carCheck button.pull-right").hide(); //隐藏函数生成的接车点检按钮
//接车点检修改
creatForm(carCheckInfo, "#carupCheck .checkform", "carCheck_btn");

// 更新
$("#carupCheck .checkform .form_btngroup").hide(); //隐藏函数生成的接车点检按钮
$("#carupCheck .cartypein_btn_group").hide(); //初始化隐藏车辆录入修改界面的提交按钮，点击修改，show()
$("#carupCheck .form_subject .pull-right").unbind('click').bind('click', function() {
    $("#carupCheck .cartypein_btn_group").show();
    $(".return_btn").hide();
    $("#carupCheck input").not(".vSn").attr("readOnly", false);
    $("#carupCheck input").not(".vSn").removeClass("readonly");
});

// 取消编辑/修改
$("#carTypeIn .cancel_cartypein").unbind('click').bind('click', function() {
    $("#carupCheck .cartypein_btn_group").hide();
    $(".return_btn").show();
    $("#carupCheck input").attr("readOnly", true);
    $("#carTypeIn input").addClass("readonly");
});
$(".return_btn").unbind('click').bind('click', function() {
    window.location.hash = "carList";
});

// 车辆录入更新
$("#carTypeIn .sub_cartypein").unbind('click').bind('click', function() {
    var mustobj = $("#carupCheck .required");
    for (var i = 0; i < mustobj.length; i++) {
        if (mustobj[i].value == "" || mustobj[i].value == null) {
            toastr.warning('有必填项未填写', '提示', messageOpts);
            mustobj[i].focus();
            return;
        }
    }
    var check_url = allurl + "/car-management/car/findUpcheck/" + $("#carupCheck .checkform .vSn").val() + ".action";
    var typein_data = $("#carTypeIn .cartypein_apply").serializeObject();
    typein_data.id = $("#carTypeIn .cartypein_apply .vSn").attr("id");
    typein_data.circuiturl = $("#carTypeIn .cartypein_apply .vSn").attr("circuiturl");
    typein_data.circuitName = $("#carTypeIn .cartypein_apply .vSn").attr("circuitName");
    typein_data.wordurl = $("#carTypeIn .cartypein_apply .vSn").attr("wordurl");
    typein_data.wordName = $("#carTypeIn .cartypein_apply .vSn").attr("wordName");
    typein_data.picurl = $("#carTypeIn .cartypein_apply .vSn").attr("picurl");
    var typein_url = allurl + "/car-management/car/update.action";
    if (typein_data.id == "" || typein_data.id == null) {
        typein_url = allurl + "/car-management/car/save.action";
    }
    var groupval = $("#carTypeIn .cartypein_apply .groupName option:selected").attr("value");
    var project_sn = $("#carTypeIn .cartypein_apply .project_sn").val();
    typein_data.groupName = groupval;
    typein_data.project_sn = project_sn;
    // bom数据
    var bomuuid = $("#carTypeIn .bom_apply .checkitem");
    var bomNameArr = $("#carTypeIn .bom_apply .bom_name");
    var bomnumArr = $("#carTypeIn .bom_apply .bom_num");
    var bomArr = [];
    for (var i = 0; i < bomNameArr.length; i++) {
        if (bomNameArr[i].value != "" && bomnumArr[i].value != "") {
            bomArr.push({ "uuid": bomuuid[i].getAttribute("uuid"), "bomName": bomNameArr[i].value, "bomNum": bomnumArr[i].value, "vSn": $("#carTypeIn .cartypein_apply .vSn").val() });
        }
    }
    var bomurl = allurl + "/car-management/car/applybom.action";
    var bomData = JSON.stringify(bomArr);
    // 研发
    var toolNameArr = $("#carTypeIn .rd_apply .toolname");
    var toolArr = [];
    for (var i = 0; i < toolNameArr.length; i++) {
        if (toolNameArr[i].value != "") {
            toolArr.push({ "toolName": toolNameArr[i].value, "vSn": $("#carTypeIn .cartypein_apply .vSn").val() });
        }
    }
    var toolurl = allurl + "/car-management/car/applytools.action";
    var toolData = JSON.stringify(toolArr);
    $.ajax({
        url: check_url,
        success: function(res) {
            console.log(res);
            var sub_data = $("#carupCheck .checkform").serializeObject();
            sub_data.id = res.id;
            sub_data = JSON.stringify(sub_data);
            var sub_url = allurl + "/car-management/car/updateUpcheck.action";
            subData(sub_url, sub_data, "post", "carupCheck_btn");
        }
    });
    // 分三次提交
    subData(typein_url, typein_data, "get", "typein_sub"); //车辆录入提交
    subData(bomurl, bomData, "post", "bomapply"); //bom申请提交
    subData(toolurl, toolData, "post", "toolapply"); //tool申请提交
    setTimeout(function() {
        if ($(".showCarFileName").html() != "" && $(".showCarFileName").html() != null) {
            $.ajax({ //上传图片
                url: allurl + "/car-management/car/carPicUpload.action?vSn=" + $("#carTypeIn .cartypein_apply .vSn").val(),
                type: "post",
                data: new FormData($('#uploadCarPictureForm')[0]),
                processData: false,
                contentType: false,
                success: function(res) {
                    toastr.success(res.msg, '提示', messageOpts);
                },
                error: function name() {
                    toastr.error(res.msg, '提示', messageOpts);
                }
            });
        }
        if ($(".showcircuitryName").html() != "" && $(".showcircuitryName").html() != null) {
            $.ajax({ //上传电路图
                url: allurl + "/car-management/file/circuitPicUpload.action?vSn=" + $("#carTypeIn .cartypein_apply .vSn").val(),
                type: "post",
                data: new FormData($('#uploadcircuitryForm')[0]),
                processData: false,
                contentType: false,
                success: function(res) {
                    console.log(res);
                    toastr.success(res.msg, '提示', messageOpts);
                },
                error: function name() {
                    toastr.error(res.msg, '提示', messageOpts);
                }
            });
        }
        if ($(".showcrdName").html() != "" && $(".showcrdName").html() != null) {
            $.ajax({ //上传crd
                url: allurl + "/car-management/file/wordUpload.action?vSn=" + $("#carTypeIn .cartypein_apply .vSn").val(),
                type: "post",
                data: new FormData($('#uploadcrdForm')[0]),
                processData: false,
                contentType: false,
                success: function(res) {
                    toastr.success(res.msg, '提示', messageOpts);
                },
                error: function name() {
                    toastr.error(res.msg, '提示', messageOpts);
                }
            });
        }
    }, 300)
});