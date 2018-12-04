var user_role_check_val = [];

//用户管理模块： 用户列表
function loadUserList(pageInfo) {
    if (pageInfo == undefined) {
        var pageInfo = { pageNumber: 1, pageSize: 15 };
    }
    $("#userList").bootstrapTable('destroy').bootstrapTable({
        url: allurl + "/car-management/user/searchUser.action",
        dataType: 'json',
        striped: true, //是否显示行间隔色
        toggle: "table",
        toolbar: "toolbar_userList",
        pagination: "true", //是否显示分页（*）
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: pageInfo.pageNumber, //初始化加载第一页，默认第一页
        pageSize: pageInfo.pageSize, //每页的记录行数（*）
        paginationShowPageGo: true,
        pageList: [15, 20, 30, 40, 50, 100], //可供选择的每页的行数（*）
        search: false, //是否搜索查询
        showColumns: true, //是否显示所有的列
        showRefresh: false, //是否显示刷新按钮
        sortable: true, //是否启用排序
        minimumCountColumns: 2, //最少允许的列数
        clickToSelect: true, //是否启用点击选中行
        searchOnEnterKey: true, //设置为 true时，按回车触发搜索方法
        strictSearch: false, //设置为 true启用全匹配搜索， 否则为模糊搜索
        showToggle: true, //是否显示切换视图（table/card）按钮
        searchAlign: "right",
        showExport: true,
        exportDataType: "selected",
        showExport: true, //是否显示导出按钮  
        buttonsAlign: "right", //按钮位置  
        exportTypes: ['excel'], //导出文件类型  
        Icons: 'glyphicon-export',
        exportOptions: {
            ignoreColumn: [0, 11], //忽略某一列的索引  
            fileName: '测试车辆-用户列表', //文件名称设置  
            worksheetName: 'sheet1', //表格工作区名称  
            type: 'excel',
            tableName: '测试车辆-用户列表',
            excelstyles: ['background-color', 'color', 'font-size', 'font-weight']
        },
        exportDataType: "selected",
        uniqueId: "id", // 每一行的唯一标识  
        //得到查询的参数
        queryParams: function(params) {
            //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            var temp = {
                size: params.limit, //页面大小
                page: (params.offset / params.limit) + 1, //页码
                sort: "name", //排序列名  
                sortOrder: params.order, //排位命令（desc，asc） 
                name: $("#userlist_toolbar .nickname").val(),
                netid: $("#userlist_toolbar .netid").val(),
                roleName: $("#userlist_toolbar #user_role option:selected").val()
            };
            return temp;
        },
        onLoadSuccess: function(res) {
            console.log(res);
        },
        onLoadError: function() {
            console.log("数据加载失败！");
        },
        onPageChange: function(page, size) {
            var pageInfo = { pageNumber: page, pageSize: size };
            window.sessionStorage.pageInfo = JSON.stringify(pageInfo);
        },
        columns: [
            [{
                "title": "测试车辆-用户列表",
                "halign": "center",
                "align": "center",
                "colspan": 11
            }],
            [{
                    field: "checkbox",
                    title: "全选",
                    checkbox: true,
                    align: 'center'
                }, {
                    field: 'index',
                    title: "序号",
                    valign: "middle",
                    align: "center",
                    width: "5%",
                    formatter: function(value, row, index) {
                        var pageSize = $('#userList').bootstrapTable('getOptions').pageSize; //通过表的#id 可以得到每页多少条
                        var pageNumber = $('#userList').bootstrapTable('getOptions').pageNumber; //通过表的#id 可以得到当前第几页
                        return pageSize * (pageNumber - 1) + index + 1; //返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
                    }
                },
                { field: "nickname", title: "姓名", align: 'center', valign: "middle" },
                { field: "telephone", title: "电话", align: 'center', valign: "middle" },
                { field: "employeeCard", title: "员工卡号", align: 'center', valign: "middle" },
                { field: "netid", title: "NET ID", align: 'center', valign: "middle" },
                { field: "team", title: "所在Team", align: 'center', valign: "middle" }, {
                    field: "roles",
                    title: "角色",
                    align: 'center',
                    formatter: function(value, row, index) {
                        var a = "";
                        if (value == null) {
                            a = '--';
                        } else {
                            for (var i = 0; i < value.length; i++) {
                                if (i == value.length - 1) {
                                    a += '<span>' + value[i].name + '</span>';
                                } else {
                                    a += '<span>' + value[i].name + '</span>,';
                                }
                            }

                        }
                        return a;
                    }
                }, {
                    field: 'operate',
                    title: '操作',
                    align: 'center',
                    events: userOperateEventsDel,
                    formatter: userOperateFormatterDel
                }
            ]
        ]
    });
}


// 用户名重复及格式正误检测
$("input[name='user_name']").bind('input porpertychange', function() {
    var pw1Num = $("input[name='user_name']").val();
    var re = /^[0-9a-zA-Z_]{5,16}$/g; //密码由大小写字母或数字组成且为6-20位
    var rez = re.test(pw1Num);
    console.log(pw1Num);
    if (rez == true) {
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
    }
});
// ------------------------------------------------------

function userOperateFormatterDel(value, row, index) {
    return [
        '<button type="button" id="user_btn_mydel" class="btn btn-default btn-sm" style="margin-right:10px;">删除</button>',
        '<button type="button" id="user_update" class="btn btn-default btn-sm" style="margin-right:10px;">修改</button>',
        '<button type="button" id="user_role" class="btn btn-default btn-sm" style="margin-right:10px;">角色</button>',
        '<button type="button" id="removerelate_role" class="btn btn-default btn-sm">解绑</button>'
    ].join('');
}
var userdelarr = [];
window.userOperateEventsDel = {
    'click #user_btn_mydel': function(e, value, row, index) {
        $("#del_model").modal();
        $("#del_model .text-center").html("确定删除此用户？");
        $(".modal_del").unbind('click').bind('click', function() {
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            userdelarr.length = 0;
            userdelarr.push(row.uid);
            var sub_url = allurl + "/car-management/user/delete.action";
            var sub_data = {
                "ids[]": userdelarr
            };
            subData(sub_url, sub_data, "get", "userdel");
        })
    },
    'click #user_update': function(e, value, row, index) {
        $("#add_model").modal();
        $("#add_model #myModalLabel").html("用户修改");
        creatForm(userInfo, "#add_model .modal-body form", "edituser_btn");
        showData("#add_model .modal-body form", row); // 编辑时数据回显
        $(".edituser_btn").unbind('click').bind('click', function() {
            var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
            if (reg.test($("#add_model .telephone").val()) == false) {
                toastr.warning('电话格式不正确', '提示', messageOpts);
                return;
            }
            var sub_url = allurl + "/car-management/user/updateUser.action";
            var sub_data = $("#add_model .modal-body form").serialize();
            sub_data = sub_data + "&team=" + $("#add_model .modal-body .team option:selected").attr("value") + "&uid=" + row.uid;
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "get", "edituser_btn");
        })
    },
    'click #user_role': function(e, value, row, index) {
        $("#apply_model").modal();
        $("#apply_model #myModalLabel").html("用户分配角色");
        creatForm(user_roleInfo, "#apply_model .modal-body form", "user_role_btn");
        var confirmInfo =
            '<div class="confirm_group">' +
            '<span class="confirm_name">请确认您分配角色的用户是：</span><span class="confirm_val" style="color:green;weight:bolder;">' + row.nickname + '</span>' +
            '</div>';
        $("#apply_model .modal-body form").html(confirmInfo + $("#apply_model .modal-body").html());
        $(".user_role_btn").unbind('click').bind('click', function() {
            // 用户关联角色
            var sub_data = $("#apply_model .modal-body form").serializeObject();
            sub_data.uid = row.uid;
            var sub_url = allurl + "/car-management/user/userRelatedRole.action";
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            subData(sub_url, sub_data, "get", "userRelatedRole");
        })
    },
    'click #removerelate_role': function(e, value, row, index) {
        $("#apply_model").modal();
        $("#apply_model #myModalLabel").html("用户解除关联的角色");
        userRole(row.uid, row.nickname); //查询用户关联的角色
    }
};

var user_roleInfo = [{
    "name": "角色",
    "type": "checkbox",
    "inputName": "rid",
    "must": "*",
    "option": [{ "name": "工程师" }, { "name": "车辆查验人员" }, { "name": "维修技师" }, { "name": "维修管理员" }, { "name": "试验车牌办理人员" }, { "name": "超级管理员" }]
}];
var user_removeroleInfo = [{
    "name": "解除关联角色",
    "type": "checkbox",
    "inputName": "rid",
    "must": "*",
    "option": [{ "name": "维修技师" }, { "name": "维修管理员" }, { "name": "助理" }, { "name": "超级管理员" }]
}];

function userRole(uid, nickname) { //查看当前用户关联的角色
    $.ajax({
        url: allurl + "/car-management/user/findRoleByUser.action?uid=" + uid,
        success: function(res) {
            console.log(res);
            user_removeroleInfo[0].option = [];
            for (var i = 0; i < res.length; i++) {
                user_removeroleInfo[0].option.push({ val: res[i].rid, name: res[i].name, remark: res[i].keyWord })
            }
            creatForm(user_removeroleInfo, "#apply_model .modal-body form", "UserReoveRelateRole");
            var confirmInfo =
                '<div class="confirm_group">' +
                '<span class="confirm_name">请确认您解除角色的用户是：</span><span class="confirm_val" style="color:green;weight:bolder;">' + nickname + '</span>' +
                '</div>';
            console.log($("#apply_model .modal-body form").html());
            $("#apply_model .modal-body form").html(confirmInfo + $("#apply_model .modal-body form").html());
            console.log($("#apply_model .modal-body form").html());

            $(".UserReoveRelateRole").unbind('click').bind('click', function() { //点击确认
                var sub_data = $("#apply_model .modal-body form").serialize();
                sub_data = sub_data + "&uid=" + uid;
                var sub_url = allurl + "/car-management/user/userCancleRole.action";
                subData(sub_url, sub_data, "get", "UserReoveRelateRole");
                $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            })
        }
    })
}

$("#addUser").unbind('click').bind('click', function() {
    $("#add_model").modal();
    $("#add_model #myModalLabel").html("新增用户");
    creatForm(userInfo, "#add_model .modal-body form", "adduser");
    $(".adduser").unbind('click').bind('click', function() {
        var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
        if (reg.test($("#add_model .telephone").val()) == false) {
            toastr.warning('电话格式不正确', '提示', messageOpts);
            return;
        }
        var sub_data = $("#add_model .modal-body form").serialize();
        sub_data = sub_data + "&team=" + $("#add_model .modal-body .team option:selected").attr("value");
        var sub_url = allurl + "/car-management/user/addUser.action";
        $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
        subData(sub_url, sub_data, "get", "adduser");
    })
})
$("#deluser_all").unbind('click').bind('click', function() { //批量删除用户
    var userArr = $("#userList").bootstrapTable('getSelections');
    deletAll(userArr, "userdel");
});
// 批量关联角色
$("#relate_role_all").unbind('click').bind('click', function() {
    var userRelateArr = $("#userList").bootstrapTable('getSelections');
    deletAll(userRelateArr, "mushUserRelateRole");
});
// 当前用户自己修改个人信息//个人中心
$(".userinfo").unbind('click').bind('click', function() {
    $("#add_model").modal();
    $("#add_model #myModalLabel").html("个人信息查看/修改");
    creatForm(userInfo, "#add_model .modal-body form", "edituser_btn");
    var islogin = localStorage.getItem("successUser");
    islogin = JSON.parse(islogin);
    showData("#add_model .modal-body form", islogin.data); // 编辑时数据回显
    $("#add_model").find("option[value = '" + islogin.data.team + "']").attr("selected", "selected");
    $(".edituser_btn").unbind('click').bind('click', function() {
        var reg = /^[1][3,4,5,7,8][0-9]{9}$/;
        if (reg.test($("#add_model .telephone").val()) == false) {
            toastr.warning('电话格式不正确', '提示', messageOpts);
            return;
        }
        var sub_url = allurl + "/car-management/user/updateUser.action";
        var sub_data = $("#add_model .modal-body form").serialize();
        sub_data = sub_data + "&team=" + $("#add_model .modal-body .team option:selected").attr("value") + "&uid=" + islogin.data.uid;

        $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
        subData(sub_url, sub_data, "get", "edituser_btn");
    })
});

// 根据用户名搜索用户
$('#user_search').bind('keypress', function(event) {
    if (event.keyCode == "13") {
        alert('你输入的内容为：' + $('#user_search').val());
        loadUserList();
    }
});
$('#user_search').unbind('click').bind('click', function() {
    loadUserList();
});
$("#userlist_toolbar .nickname").bind('input porpertychange', function() {
    inputchangload();
})
$("#userlist_toolbar .netid").bind('input porpertychange', function() {
    inputchangload();
})
$("#userlist_toolbar select#user_role").change(function() {
    inputchangload();
});

function inputchangload() {
    if ($("#userlist_toolbar .nickname").val() == "" && $("#userlist_toolbar .netid").val() == "" &&
        $("#userlist_toolbar #user_role option:selected").val() == "") {
        console.log("null");
        loadUserList();
    }
}