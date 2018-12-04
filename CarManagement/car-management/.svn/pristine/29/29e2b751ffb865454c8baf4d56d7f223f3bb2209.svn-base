var user_role_check_val = [];

// 确认添加用户
$(".adduser_btn").unbind('click').bind('click', function() {
    if ($(".username_tips").text() != "用户名正确") {
        $(".user_tips").text($(".username_tips").text());
        return;
    }
    // 用户名、用户密码、用户昵称、邮箱、电话号码不能为空
    if ($("input[name='user_name']").val() == "" || $("input[name='user_pass']").val() == "" || $("input[name='user_phone']").val() == "" ||
        $("input[name='user_email']").val() == "" || $("input[name='user_nickname']").val() == "") {
        $(".user_tips").text("用户名、用户密码、用户昵称、邮箱、电话号码不能为空");
        return;
    }
    var username = $("input[name='user_name']").val();
    var adduserFormData = "";
    // 向数据库添加用户
    //添加用户角色表单， 数据库加载角色列表
    $.ajax({
        "url": allurl + "/car-management/user/addUser.action",
        "type": "get",
        "data": {
            "username": $("input[name='user_name']").val(),
            "password": $("input[name='user_pass']").val(),
            "telephone": $("input[name='user_phone']").val(),
            "email": $("input[name='user_email']").val(),
            "nickname": $("input[name='user_nickname']").val(),
            "remark": $(".user_remark").val(),
            "sex": $("input[name='sex']:checked").val(),
            "rids[]": user_role_check_val
        },
        "dataType": "jsonp", //数据类型为jsonp  
        "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数
        "success": function(res) {
            console.log(res);
            if (res.ret) {
                $(".user_tips").html("添加成功，您可以返回用户列表进行查看");
            } else {
                $(".user_tips").html("添加失败，请联系管理员");
            }
        },
        "error": function(res) {
            console.log(res);
            $(".user_tips").html("添加失败，请联系管理员");
        }
    })
});
// 取消添加用戶表單
$(".my_remove_btn").unbind('click').bind('click', function() {
    $("#user .form-horizontal").hide();
    $("#user_rightbox").show();
    loadUserList();
});
// 重置按鈕
$(".my_reset_btn").unbind('click').bind('click', function() {
    console.log("重置按钮");
    formReset();
});
var $tableUserList = $('#userList');
$(function() {
    $('#toolbar2').find('select').change(function() {
        $tableUserList.bootstrapTable('destroy').bootstrapTable({
            exportDataType: $(this).val()
        });
    });
})




// 用户名重复及格式正误检测
$("input[name='user_name']").bind('input porpertychange', function() {
    var pw1Num = $("input[name='user_name']").val();
    // var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z\d]{6,16}$/g; //密码必须有大小写字母和数字且6-20位
    var re = /^[0-9a-zA-Z_]{5,16}$/g; //密码由大小写字母或数字组成且为6-20位
    var rez = re.test(pw1Num);
    console.log(pw1Num);
    if (rez == true) {
        // tips.style.display = 'block';
        $(".username_tips").html("格式正确");
        $.ajax({
            "url": allurl + "/car-management/user/check/" + $("input[name='user_name']").val() + "/1.action",
            "type": "get",
            "dataType": "jsonp", //数据类型为jsonp  
            "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数
            "success": function(res) {
                console.log(res);
                if (res.ret) {
                    $(".username_tips").text("用户名正确");
                } else {
                    $(".username_tips").text("用户名已被占用");
                }
            },
            "error": function(res) {
                console.log(res);
                $(".username_tips").text("系统错误，请联系管理员");
            }
        })
    } else if (pw1Num == '') {
        $(".username_tips").text('用户名不能为空');
    } else {
        $(".username_tips").text('用户名格式不正确');
        // tips.style.display = 'block';
    }
});
// ------------------------------------------------------

function userOperateFormatterDel(value, row, index) {
    return [
        '<button type="button" id="user_btn_mydel" class="RoleOfA btn btn-default optionBth  btn-sm" style="margin-right:15px;">删除</button>'
    ].join('');
}
var userdelarr = [];
window.userOperateEventsDel = {
    'click #user_btn_mydel': function(e, value, row, index) {
        console.log(row);
        userdelarr.length = 0;
        userdelarr.push(row.uid);
        console.log($(this).parent().parent());
        $(this).parent().parent().remove();
        // 删除用户操作
        $.ajax({
            "url": allurl + "/car-management/car-management/user/delete.action",
            "type": "get",
            "data": {
                "ids[]": userdelarr
            },
            "dataType": "jsonp", //数据类型为jsonp  
            "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数
            "success": function(res) {
                console.log(res);
                if (res.ret) {
                    loadUserList();
                    // alert("删除成功");
                }
            },
            "error": function(res) {
                console.log(res);
            }
        })
    }
};