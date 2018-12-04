$(".showFileName").hide();
$("#uploadBtn").hide();
$("#canceluploadBtn").hide();
$("#upload").on("change", "input[type='file']", function() {
    var filePath = $(this).val();
    var arr = filePath.split("\\");
    var fileName = arr[arr.length - 1];
    if (filePath.indexOf("xlsx") != -1 || filePath.indexOf("xls") != -1) {
        $(".showFileName").show();
        $("#uploadBtn").show();
        $("#canceluploadBtn").show();
        $(".showFileName").html(fileName);
        $("#upload").hide();
    } else {
        $(".showFileName").html("文件类型有误！").show();
    }
});
// 油卡
$(".showoilFileName").hide();
$("#upload_oilBtn").hide();
$("#cancelupload_oilBtn").hide();
$("#upload_oil").on("change", "input[type='file']", function() {
    var filePath_oil = $(this).val(); //如果仅上传图片  if(filePath.indexOf("jpg") != -1 || filePath.indexOf("png") != -1) {
    var oilarr = filePath_oil.split("\\");
    var fileName_oil = oilarr[oilarr.length - 1];
    if (filePath_oil.indexOf("xlsx") != -1 || filePath_oil.indexOf("xls") != -1) {
        $(".showoilFileName").show();
        $("#upload_oilBtn").show();
        $("#cancelupload_oilBtn").show();
        $(".showoilFileName").html(fileName_oil);
        $("#upload_oil").hide();
    } else {
        $(".showoilFileName").html("文件类型有误！").show();
    }
});
// 用户
$(".showuserFileName").hide();
$("#uploaduserBtn").hide();
$("#cancelupload_userBtn").hide();
$("#uploadUser").on("change", "input[type='file']", function() {
    var filePath_user = $(this).val(); //如果仅上传图片  if(filePath.indexOf("jpg") != -1 || filePath.indexOf("png") != -1) {
    var userarr = filePath_user.split('\\');
    var fileName_user = userarr[userarr.length - 1];
    if (filePath_user.indexOf("xlsx") != -1 || filePath_user.indexOf("xls") != -1) {
        $('.showuserFileName').show();
        $('#uploaduserBtn').show();
        $('#cancelupload_userBtn').show();
        $(".showuserFileName").html(fileName_user);
        $('#uploadUser').hide();
    } else {
        $(".showuserFileName").html("文件类型有误！").show();
    }
});

$("#cancelupload_userBtn").unbind('click').bind('click', function() {
    cancel_userupload();
});
// 取消驾驶员文件上传事件
function cancelupload() {
    $("#excel_file").val("");
    $("#upload").show();
    $(".showFileName").hide();
    $("#uploadBtn").hide();
    $("#canceluploadBtn").hide();
}
$('#uploadBtn').unbind('click').bind('click', function() { //驾驶员批量导入，确认上传
    $.ajax({
        url: allurl + "/car-management/driver/driver_batchImport.action",
        type: "post",
        data: new FormData($('#uploaddriverForm')[0]),
        processData: false,
        contentType: false,
        success: function(res) {
            toastr.success(res.msg, '提示', messageOpts);
            if (res.ret == true) {
                loadoilList();
                cancelupload();
            }
        },
        error: function name() {
            toastr.error(res.msg, '提示', messageOpts);
        }
    })
});
// 油卡导入
function canceluploadoil() {
    $("#oil_file").val("");
    $("#upload_oil").show();
    $(".showoilFileName").hide();
    $("#upload_oilBtn").hide();
    $("#cancelupload_oilBtn").hide();
}
$('#upload_oilBtn').click(function() {
    $.ajax({
        url: allurl + "/car-management/oil/batchimport.action",
        type: "post",
        data: new FormData($('#uploadOil')[0]),
        processData: false,
        contentType: false,
        success: function(res) {
            toastr.success(res.msg, '提示', messageOpts);
            if (res.ret == true) {
                loadoilList();
                canceluploadoil();
            }
        },
        error: function name() {
            toastr.error(res.msg, '提示', messageOpts);
        }
    })
});
// 用户导入
function cancel_userupload() {
    $("#excel_userfile").val("");
    $("#uploadUser").show();
    $(".showuserFileName").hide();
    $("#uploaduserBtn").hide();
    $("#cancelupload_userBtn").hide();
};
$('#uploaduserBtn').unbind('click').bind('click', function() { //用户批量导入，确认上传
    $.ajax({
        url: allurl + "/car-management/user/user_batchImport.action",
        type: "post",
        data: new FormData($('#uploadduser')[0]),
        processData: false,
        contentType: false,
        success: function(res) {
            toastr.success(res.msg, '提示', messageOpts);
            if (res.ret == true) {
                cancel_userupload();
                loadUserList();
            }
        },
        error: function name() {
            toastr.error(res.msg, '提示', messageOpts);
        }
    })
});
//新车车辆图片上传、移动
$(".shownewCarFileName").hide();
$("#uploadnewCarpicBtn").hide();
$(".shownewcircuitryName").hide();
$("#uploadnewcircuitryBtn").hide();
$("#newcarpicture_file").on("change", function() {
    var fileM = document.getElementById("newcarpicture_file");
    var fileObj = fileM.files[0];
    $(".shownewCarFileName").show();
    $(".shownewCarFileName").html(fileObj.name);
});
$("#newcircuitry_file").on("change", function() {
    var fileM = document.getElementById("newcircuitry_file");
    $(".shownewcircuitryName").show();
    $(".shownewcircuitryName").html(fileM.files[0].name);
});



// crd文件上传
$("#uploadnewcrdBtn").hide();
$(".shownewcrdName").hide();
$("#newcrd_file").on("change", function() {
        var fileM = document.getElementById("newcrd_file");
        $(".shownewcrdName").show();
        $(".shownewcrdName").html(fileM.files[0].name);
    })
    //  更新
    //车辆图片上传、移动
$(".showCarFileName").hide();
$("#uploadCarpicBtn").hide();
$("#cancelcarpicture_btn").hide();
$(".showcircuitryName").hide();
$("#uploadcircuitryBtn").hide();
$("#cancelcircuitry_btn").hide();
$("#carpicture_file").on("change", function() {
    var fileM = document.getElementById("carpicture_file");
    var fileObj = fileM.files[0];
    $(".showCarFileName").show();
    $(".showCarFileName").html(fileObj.name);
})

$("#circuitry_file").on("change", function() {
    var fileM = document.getElementById("circuitry_file");
    $(".showcircuitryName").show();
    $(".showcircuitryName").html(fileM.files[0].name);
});
$("#uploadcrdBtn").hide();
$(".showcrdName").hide();
$("#crd_file").on("change", function() {
    var fileM = document.getElementById("crd_file");
    $(".showcrdName").show();
    $(".showcrdName").html(fileM.files[0].name);
})

//bom文件上传
//var bomformData;
// $("#uploadnewBomBtn").hide();
// $(".shownewBomName").hide();
// $("#newbom_file").on("change", function() {
//     var fileM = document.getElementById("newbom_file");
//     bomformData = new FormData();
//     bomformData.append('uploadFile', fileM.files[0].name);
//     $(".shownewBomName").show();
//     $(".shownewBomName").html(fileM.files[0].name);

// });