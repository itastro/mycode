//选择文件完成时
function fileSelected() {
    var file = document.getElementById('fileToUpload').files[0];
    if (file) {
        var fileSize = 0;
        if (file.size > 1024 * 1024)
            fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
        else
            fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';

        //alert(fileSize);

        var t = file.name.split('.');
        var filetype = t[t.length - 1];
        //alert(filetype);
        $("#filename").val(file.name);
        $("#filetype").val(filetype);
        $("#filesize").val(fileSize);

    }
}

//上传按钮执行
function uploadFile() {

    $("#div-bar").show();

    var file = document.getElementById('fileToUpload').files[0];

    var fd = new FormData();
    fd.append("fileToUpload", document.getElementById('fileToUpload').files[0]);
    fd.append("filename", file.name);
    fd.append("filetype", $("#filetype").val());
    fd.append("filesize", $("#filesize").val());
    var xhr = new XMLHttpRequest();
    xhr.upload.addEventListener("progress", uploadProgress, false);
    xhr.addEventListener("load", uploadComplete, false);
    xhr.addEventListener("error", uploadFailed, false);
    xhr.addEventListener("abort", uploadCanceled, false);
    xhr.open("POST", "/testfileupload");
    xhr.send(fd);
}

//上传过程
function uploadProgress(evt) {
    if (evt.lengthComputable) {
        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
        //document.getElementById('progressNumber').innerHTML = percentComplete.toString() + '%';
        var width = percentComplete.toString() + "%";

        //$("#uploadbar").get(0).style.width = width;
        $("#uploadbar").css("width", width)
    } else {
        //document.getElementById('progressNumber').innerHTML = 'unable to compute';
    }
}

//上传完成
function uploadComplete(evt) {
    /* This event is raised when the server send back a response */
    var number = evt.target.responseText.trim();
    var str = "<li><span class='fa fa-paperclip fa-flip-horizontal'></span>" + $("#filename").val() + "<a onclick='delfile(this," + evt.target.responseText + ")'>删除</a></li>"

    var keyfields = "";
    if ($("#keyfields").val() == "") {
        keyfields = number + ";";
    } else {
        keyfields = $("#keyfields").val() + number + ";";
    }

    $("#keyfields").val(keyfields);
    $("#filelist").append(str);
    $("#fileToUpload").val("");

    //$("#uploadbar").css("width","0%");
    $("#div-bar").hide();
}

//上传失败
function uploadFailed(evt) {
    //alert("There was an error attempting to upload the file.");
    $("#div-bar").hide();
}

//上传取消
function uploadCanceled(evt) {
    //alert("The upload has been canceled by the user or the browser dropped the connection.");
    $("#div-bar").hide();
}

function delfile(obj, keyfield) {
    //$("#filelist li").remove($(obj).parent());
    $(obj).parent().remove();

    var keyfields = $("#keyfields").val();
    slice = keyfields.split(";");
    var tkeyfields = "";
    for (var i = 0; i < slice.length; i++) {
        if (slice[i] != keyfield && slice[i] != "") {
            tkeyfields += slice[i] + ";";
        }
    }
    $("#keyfields").val(tkeyfields);
}