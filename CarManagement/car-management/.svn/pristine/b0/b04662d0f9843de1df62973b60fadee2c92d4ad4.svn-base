// 加载权限列表
var checkmenu_val = [];
var role_check_val = [];
Array.prototype.remove = function(val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};
// 加载菜单列表role_menuList
function loadmenuChoice(boxname) {
    $(boxname).html("");
    $.ajax({
        "url": allurl + "/car-management/menu/menuList.action",
        "type": "get",
        "dataType": "jsonp", //数据类型为jsonp  
        "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数  
        "success": function(res) {
            console.log(res);
            var MenuList = "";
            for (var i = 0; i < res.length; i++) {
                if (res[i].childrenMenus.length > 0) {
                    MenuList = '<div mid=' + res[i].mid + ' class="MenuList' + i + ' menulist_height">' +
                        '<label for="">' + res[i].name + ':</label>&nbsp;&nbsp' +
                        '</div>';
                    $(boxname).append(MenuList);
                    var MenuList_checkbox = "";
                    for (var k = 0; k < res[i].childrenMenus.length; k++) {
                        MenuList_checkbox += '&nbsp;&nbsp&nbsp;&nbsp;<input name="mid" mid="' + res[i].childrenMenus[k].mid + '" type="checkbox" value="' + res[i].childrenMenus[k].name + '">' + res[i].childrenMenus[k].name;
                    }
                    $(".MenuList" + i).append(MenuList_checkbox);
                }
            }
            // 判断选择菜单 多选选项
            var menuobj = document.getElementsByName("mid");
            for (k in menuobj) {
                menuobj[k].onclick = function() {
                    console.log(this.checked);
                    if (this.checked) {
                        console.log(this.parentNode.getAttribute("mid"));
                        checkmenu_val.push(this.getAttribute("mid"));
                    } else {
                        if ($.inArray(this.getAttribute("mid"), checkmenu_val) != -1) {
                            checkmenu_val.remove(this.getAttribute("mid"));
                        }
                    }
                    // 判断是否添加父级菜单id
                    // 当点击this,for循环判断当前this和他的兄弟节点的checked ，如果有一个为true，则添加父级mid到数组中
                    // 如果当前this和他的兄弟节点的checked,没有一个为true,则将父级mid从数组删除。  将这个条件作为if条件判断相对简单，上面可作为else语句
                    // var thisSiblings;
                    // console.log($(this).parent().children("input"));
                    var menus_inputs = $(this).parent().children("input");
                    var flagfalse = menus_inputs.length;
                    for (var n = 0; n < menus_inputs.length; n++) {
                        // 判断是否选择
                        if (menus_inputs[n].checked == false) {
                            // 如果没有找到，返回-1
                            if ($.inArray(this.parentNode.getAttribute("mid"), checkmenu_val) == -1) {
                                checkmenu_val.push(this.parentNode.getAttribute("mid"));
                            }
                        } else {
                            flagfalse = flagfalse - 1;
                        }
                    }
                    if (flagfalse == menus_inputs.length) {
                        checkmenu_val.remove(this.parentNode.getAttribute("mid"));
                    }
                }
            };

        },
        "error": function(res) {
            console.log(res);
        }
    });
}

function loadRoleList() {
    //加载 角色列表
    $.ajax({
        "url": allurl + "/car-management/role/roleList.action",
        "type": "get",
        "data": {
            "page": 1,
            "size": 15
        },
        "dataType": "jsonp", //数据类型为jsonp  
        "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数  
        "success": function(res) {
            console.log(res);
            $('#roleList').bootstrapTable('destroy');
            createTable("#roleList", "toolbar_roleList", res.rows,
                "rid", "name", "keyWord", "remark", "operator", "createTime", true, true,
                "角色编号", "名称", "关键字", "备注", "创建人", "创建日期",
                true, roleOperateEventsDel, roleOperateFormatterDel, "server");
            user_roleInfo[0].option = [];
            for (var i = 0; i < res.rows.length; i++) {
                user_roleInfo[0].option.push({ val: res.rows[i].rid, name: res.rows[i].name, remark: res.rows[i].keyWord })
            }
            var addrolebtn = document.getElementById("btn_add_role");
            loadrightsList(".role_check_box");
            addrolebtn.onclick = function() {
                $("#role_list").hide();
                $("#role .form-horizontal").show();
                var role_checkobj = document.getElementsByName("rolepid");
                for (k in role_checkobj) {
                    role_checkobj[k].onclick = function() {
                        if (this.checked) {
                            role_check_val.push(this.getAttribute("pid"));
                        } else {
                            if ($.inArray(this.getAttribute("pid"), role_check_val) != -1) {
                                role_check_val.remove(this.getAttribute("pid"));
                            }
                        }
                    }
                };
                // 确认添加角色
                $(".role_commit_btn").unbind('click').bind('click', function() {
                    $.ajax({
                        "url": allurl + "/car-management/role/addRole.action",
                        "type": "get",
                        "data": {
                            "name": $("input[name='role_name']").val(),
                            "keyWord": $("input[name='role_keywords']").val(),
                            "remark": $("input[name='role_remark']").val(),
                            "pids[]": role_check_val,
                            "mids": checkmenu_val.toString()
                        },
                        "dataType": "jsonp", //数据类型为jsonp  
                        "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数
                        "success": function(res) {
                            console.log(res);
                            if (res.ret) {
                                $(".role_tips").html("添加成功，您可以返回角色列表进行查看");
                                toastr.success('添加成功，您可以返回角色列表进行查看', '提示', messageOpts);
                            } else {
                                $(".role_tips").html("添加失败，请联系管理员");
                                toastr.warning(res.msg, '提示', messageOpts);
                            }
                        },
                        "error": function(res) {
                            console.log(res);
                            $(".role_tips").html("添加失败，请联系管理员");
                        }
                    })
                });
                // 返回角色列表
                $(".removerole_btn").unbind('click').bind('click', function() {
                    $("#role .form-horizontal").hide();
                    $("#role_list").show();
                    loadRoleList();
                });
                // 重置按鈕
                $(".resetrole_btn").unbind('click').bind('click', function() {
                    console.log("重置按钮");
                    formReset();
                });
            };
        },
        "error": function(res) {
            console.log(res);
        }
    });
}

var $tableUserList = $('#roleList');

function roleOperateFormatterDel(value, row, index) {
    return [
        '<button type="button" id="role_btn_mydel" class="btn btn-default optionBth  btn-sm" style="margin-right:15px;">删除</button>',
        '<button type="button" id="role_relate_rights" class="btn btn-default optionBth  btn-sm" style="margin-right:15px;">权限</button>',
        '<button type="button" id="role_relate_menu" class="btn btn-default optionBth  btn-sm" style="margin-right:15px;">菜单</button>',
        '<button type="button" id="role_relate_removemenu" class="btn btn-default optionBth  btn-sm" style="margin-right:15px;">解绑菜单</button>',
        '<button type="button" id="role_relate_removerights" class="btn btn-default optionBth  btn-sm">解绑权限</button>',
    ].join('');
}
var roledelarr = [];
window.roleOperateEventsDel = {
    'click #role_btn_mydel': function(e, value, row, index) {
        console.log(row);
        roledelarr.push(row.rid);
        console.log(roledelarr);
        // 删除权限操作
        $.ajax({
            "url": allurl + "/car-management/role/deleteRole.action",
            "type": "get",
            "data": {
                "rids[]": roledelarr
            },
            "dataType": "jsonp", //数据类型为jsonp  
            "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数
            "success": function(res) {
                loadRoleList();
                toastr.success(res.msg, "提示", messageOpts);
            },
            "error": function(res) {
                toastr.error(res.msg, "提示", messageOpts);
            }
        })
    },
    'click #role_relate_rights': function(e, value, row, index) {
        $("#apply_model").modal();
        $("#apply_model #myModalLabel").html("角色关联权限");
        creatForm(roleRelateRightsInfo, "#apply_model .modal-body form", "role_rights");
        loadrightsList("#apply_model .checkbox_group");

        $(".role_rights").unbind('click').bind('click', function() {
            var sub_url = allurl + "/car-management/role/bacthRoleRelatedPermission.action?rid=" + row.rid + "&pids=" + window.role_checks.join(",");
            subData(sub_url, "", "get", "role_rights");
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
        })
    },
    'click #role_relate_menu': function(e, value, row, index) {
        $("#apply_model").modal();
        $("#apply_model #myModalLabel").html("角色关联菜单");
        creatForm(roleRelateMenuInfo, "#apply_model .modal-body form", "role_menu");
        loadmenuChoice("#apply_model .col-sm-6");
        $(".role_menu").unbind('click').bind('click', function() {
            var sub_url = allurl + "/car-management/role/bacthRoleRelatedMenu.action?rid=" + row.rid + "&mids=" + checkmenu_val.toString();
            subData(sub_url, "", "get", "role_menus");
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
        })
    },
    'click #role_relate_removerights': function(e, value, row, index) { //解绑权限
        $("#apply_model").modal();
        $("#apply_model #myModalLabel").html("角色解绑已关联权限");
        creatForm(roleRelateRightsInfo, "#apply_model .modal-body form", "role_rights_cancel");
        findPerByRole(row.rid, row.name, "#apply_model .modal-body form .col-sm-6");
        $(".role_rights_cancel").unbind('click').bind('click', function() {
            var sub_url = allurl + "/car-management/role/roleCanclePer.action?rid=" + row.rid + "&pid=" + window.role_checks.join(",");
            subData(sub_url, "", "get", "role_rights");
            $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
        })
    },
    'click #role_relate_removemenu': function(e, value, row, index) { //解绑菜单
        $("#apply_model").modal();
        $("#apply_model #myModalLabel").html("角色解绑已关联菜单");
        findMenuByRole(row.rid, row.name)
    }
};


var roleRelateRightsInfo = [
    { "name": "权限选择", "type": "checkbox", "inputName": "pids[]", "must": "", "option": [] }
];
var roleRelateMenuInfo = [
    { "name": "菜单选择", "type": "type", "inputName": "mid", "must": "", "option": [] }
];
var roleRemoveRelateRightsInfo = [
    { "name": "角色解绑权限", "type": "checkbox", "inputName": "pids[]", "must": "", "option": [] }
];
var roleRemoveRelateMenuInfo = [
    { "name": "角色解绑菜单", "type": "type", "inputName": "mid", "must": "", "option": [] }
];
// 查看角色关联菜单/role/findMenuByRole.action
function findMenuByRole(uid, nickname) {
    $.ajax({
        url: allurl + "/car-management/role/findMenuByRole.action?rid=" + uid,
        success: function(res) {
            console.log(res);
            roleRemoveRelateMenuInfo[0].option = [];
            for (var i = 0; i < res.length; i++) {
                roleRemoveRelateMenuInfo[0].option.push({ val: res[i].rid, name: res[i].name, remark: res[i].keyWord })
            }
            creatForm(roleRemoveRelateMenuInfo, "#apply_model .modal-body form", "roleCancleMenu");

            var confirmInfo =
                '<div class="confirm_group">' +
                '<span class="confirm_name">请确认您解除菜单的角色是：</span><span class="confirm_val" style="color:green;weight:bolder;">' + nickname + '</span>' +
                '</div>';
            console.log($("#apply_model .modal-body form").html());
            $("#apply_model .modal-body form").html(confirmInfo + $("#apply_model .modal-body form").html());

            var MenuList = "";
            for (var i = 0; i < res.length; i++) {
                if (res[i].childrenMenus.length > 0) {
                    MenuList = '<div mid=' + res[i].mid + ' class="MenuList' + i + ' menulist_height">' +
                        '<label for="">' + res[i].name + ':</label>&nbsp;&nbsp' +
                        '</div>';
                    $("#apply_model .modal-body form .col-sm-6").append(MenuList);
                    var MenuList_checkbox = "";
                    for (var k = 0; k < res[i].childrenMenus.length; k++) {
                        MenuList_checkbox += '&nbsp;&nbsp&nbsp;&nbsp;<input name="mid" mid="' + res[i].childrenMenus[k].mid + '" type="checkbox" value="' + res[i].childrenMenus[k].name + '">' + res[i].childrenMenus[k].name;
                    }
                    $(".MenuList" + i).append(MenuList_checkbox);
                }
            }
            // 判断选择菜单 多选选项
            var menuobj = document.getElementsByName("mid");
            for (k in menuobj) {
                menuobj[k].onclick = function() {
                    console.log(this.checked);
                    if (this.checked) {
                        console.log(this.parentNode.getAttribute("mid"));
                        checkmenu_val.push(this.getAttribute("mid"));
                    } else {
                        if ($.inArray(this.getAttribute("mid"), checkmenu_val) != -1) {
                            checkmenu_val.remove(this.getAttribute("mid"));
                        }
                    }
                    var menus_inputs = $(this).parent().children("input");
                    var flagfalse = menus_inputs.length;
                    for (var n = 0; n < menus_inputs.length; n++) {
                        if (menus_inputs[n].checked == false) {
                            if ($.inArray(this.parentNode.getAttribute("mid"), checkmenu_val) == -1) {
                                checkmenu_val.push(this.parentNode.getAttribute("mid"));
                            }
                        } else {
                            flagfalse = flagfalse - 1;
                        }
                    }
                    if (flagfalse == menus_inputs.length) {
                        checkmenu_val.remove(this.parentNode.getAttribute("mid"));
                    }
                }
            };

            $(".roleCancleMenu").unbind('click').bind('click', function() { //点击确认
                var sub_data = {
                    rid: uid,
                    mid: checkmenu_val.toString()
                };
                var sub_url = allurl + "/car-management/role/roleCancleMenu.action";
                subData(sub_url, sub_data, "get", "roleCancleMenu");
                $(this).attr({ "data-dismiss": "modal", "aria-label": "Close" });
            })
        }
    })
}
// 查看角色关联权限/role/findPerByRole.action
function findPerByRole(uid, nickname, paramsid) {
    $.ajax({
        url: allurl + "/car-management/role/findPerByRole.action?rid=" + uid,
        "success": function(res) {
            console.log(res);
            var checkboxHtml = "";
            var obj = res;
            if (res.length <= 0) {
                checkboxHtml = "此角色未关联权限,不用解绑";
            } else {
                for (var i = 0; i < res.length; i++) {
                    checkboxHtml += '<input name="" type="checkbox" value="' + obj[i].name + '" pid="' + obj[i].pid + '"><label>' + obj[i].name + '</label>&nbsp;&nbsp;&nbsp;';
                }
            }
            $(paramsid).html(checkboxHtml);
            var role_checkobjs = $("#apply_model .checkbox_group input");
            console.log(role_checkobjs);
            for (var k = 0; k < role_checkobjs.length; k++) {
                role_checkobjs[k].onclick = function() {
                    if (this.checked) {
                        console.log(this.getAttribute("pid"));
                        window.role_checks.push(this.getAttribute("pid"));
                    } else {
                        if ($.inArray(this.getAttribute("pid"), role_checks) != -1) {
                            window.role_checks.remove(this.getAttribute("pid"));
                        }
                    }
                    console.log(window.role_checks);
                }
            }
        },
    })
}