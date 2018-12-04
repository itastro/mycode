var childmenuArr = [];
//加载 菜单列表
function loadMenuList() {
    $.ajax({
        "url": allurl + "/car-management/menu/menuList.action",
        "type": "get",
        "dataType": "jsonp", //数据类型为jsonp  
        "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数
        beforeSend: function() {
            // toastr.warning('loading......', '正在加载中，请等待', messageOpts);
        },
        "success": function(res) {
            console.log(res);
            createTable("#menuList", "toolbar_menuList", res,
                "mid", "name", "keyWord", "remark", "operator", "createTime", true, true,
                "菜单编号", "名称", "关键字", "备注", "创建人", "创建日期",
                false, menuOperateEventsDel, menuOperateFormatterDel, "client");

            for (var i = 0; i < res.length; i++) {
                if (res[i].childrenMenus.length != 0) {
                    for (var j = 0; j < res[i].childrenMenus.length; j++) {
                        childmenuArr.push(res[i].childrenMenus[j]);
                    }
                }
            }
            console.log(childmenuArr);
            createTable("#childmenuList", "childmenulist_toolbar", childmenuArr,
                "mid", "name", "pId", "remark", "operator", "createTime", true, true,
                "子菜单编号", "名称", "父级菜单编号", "备注", "创建人", "创建日期",
                false, menuOperateEventsDel, menuOperateFormatterDel, "client");
        },
        "error": function(res) {
            console.log(res);
        }
    });
}

var $tableUserList = $('#menuList');

function menuOperateFormatterDel(value, row, index) {
    return [
        '<button type="button" id="menu_btn_mydel" class="menuOfA btn btn-default optionBth  btn-sm" style="margin-right:15px;">删除</button>'
    ].join('');
}
var menudelarr = [];
window.menuOperateEventsDel = {
    'click #menu_btn_mydel': function(e, value, row, index) {
        console.log(row);
        menudelarr.push(row.pid);
        // 删除权限操作
        $.ajax({
            "url": allurl + "/car-management/menu/deletemenu.action",
            "type": "get",
            "data": {
                "mids[]": menudelarr
            },
            "dataType": "jsonp", //数据类型为jsonp  
            "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数
            "success": function(res) {
                console.log(res);
            },
            "error": function(res) {
                console.log(res);
            }
        })
    }
};