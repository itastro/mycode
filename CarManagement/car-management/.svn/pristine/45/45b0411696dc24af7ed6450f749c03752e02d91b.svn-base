var statusobj = [{
    value: "",
    name: "全部"
}, {
    value: 0,
    name: "已录入"
}, {
    value: 1,
    name: "已点检"
}, {
    value: 2,
    name: "已安全检查"
}, {
    value: 3,
    name: "已线束检查"
}, {
    value: 4,
    name: "已bom检查"
}, {
    value: 5,
    name: "已审核"
}, {
    value: 6,
    name: "已还车"
}];

$
    .ajax({
        // url: "http://localhost/car-def/webapp/json/menu.json", //用户相关
        url: allurl + "/car-management/menu/showMenu.action", // 用户相关
        "success": function(res) {
            console.log(res);
            var menuli = "";
            for (var i = 0; i < res.length; i++) {
                if (res[i].childrenMenus.length > 0) {
                    menuli = '<li class="sidebar-dropdown">' +
                        '<a class="sidebar_dropdown_hover two_a" href="#">' +
                        '<i class="iconfont icon-' + res[i].url +
                        '"></i>' + '<span>' + res[i].name +
                        '</span><span class="badge">' +
                        res[i].childrenMenus.length + '</span></a>' +
                        '<div class="sidebar-submenu">' +
                        '<ul class="menuli_ulli' + i + '">' + '</ul>' +
                        '</div>' + '</li>';
                    $("#myTab").append(menuli);
                    var menuli_ulli = "";
                    for (var k = 0; k < res[i].childrenMenus.length; k++) {
                        var menuli_ulli_menu3li = "";
                        if (res[i].childrenMenus[k].childrenMenus.length > 0) {
                            for (var j = 0; j < res[i].childrenMenus[k].childrenMenus.length; j++) {
                                menuli_ulli_menu3li += '<li class="' +
                                    res[i].childrenMenus[k].childrenMenus[j].url +
                                    '"><a href="#' +
                                    res[i].childrenMenus[k].childrenMenus[j].url +
                                    '" data-toggle="tab">' +
                                    res[i].childrenMenus[k].childrenMenus[j].name +
                                    '</a> </li>';
                            }
                            menuli_ulli += '<li class="sidebar-dropdown threeMenu">' +
                                '<a class="sidebar_dropdown_hover three_a" href="#"><span>' +
                                res[i].childrenMenus[k].name +
                                '</span><span class="badge">' +
                                res[i].childrenMenus[k].childrenMenus.length +
                                '</span></a>' +
                                '<div class="sidebar-submenu">' +
                                '<ul class="menuli_ulli_menu3li' +
                                i +
                                '">' +
                                menuli_ulli_menu3li +
                                '</ul>' +
                                '</div>' + '</li>';
                        } else {
                            if (res[i].childrenMenus[k].url == "maintainScreen") {
                                menuli_ulli += '<li class="' +
                                    res[i].childrenMenus[k].url +
                                    '"><a href="/car-management/html/screen.html" title="维修大屏" target="_blank">' +
                                    res[i].childrenMenus[k].name +
                                    '</a> </li>';
                            } else if (res[i].childrenMenus[k].url == "sentry") {
                                menuli_ulli += '<li class="' +
                                    res[i].childrenMenus[k].url +
                                    '"><a href="/car-management/html/sentry.html" title="车辆出入管理" target="_blank">' +
                                    res[i].childrenMenus[k].name +
                                    '</a> </li>';
                            } else {
                                menuli_ulli += '<li class="' +
                                    res[i].childrenMenus[k].url +
                                    '"><a href="#' +
                                    res[i].childrenMenus[k].url +
                                    '" data-toggle="tab">' +
                                    res[i].childrenMenus[k].name +
                                    '</a> </li>';
                            }
                        }
                        $(".menuli_ulli" + i).html(menuli_ulli);
                    }
                }
            }
            $(".sidebar-dropdown > a.two_a").unbind('click')
                .bind(
                    'click',
                    function() {
                        $(".sidebar-submenu").slideUp(250);
                        if ($(this).parent().hasClass("active")) {
                            $(".sidebar-dropdown").removeClass(
                                "active");
                            $(this).parent().removeClass("active");
                        } else {
                            $(".sidebar-dropdown").removeClass(
                                "active");
                            $(this).next(".sidebar-submenu")
                                .slideDown(250);
                            $(this).parent().addClass("active");
                        }
                    });
            $("#toggle-sidebar").unbind('click').bind('click', function() {
                $(".page-wrapper").toggleClass("toggled");
            });
            $(".carCheck").unbind('click').bind('click', function() {
                $("#carCheck input").val("");
                myformReset("#carCheck");
                getVsn("#carCheck form .vSn"); // 数据库生成车辆编号
            });
            // 点击选中切换页面并改变面包屑导航路径
            $(".sidebar-submenu ul li")
                .unbind('click')
                .bind(
                    'click',
                    function() {
                        if ($(this).parent().parent().parent()
                            .hasClass("threeMenu")) {
                            var ss = '<li>' +
                                $(this).parent().parent()
                                .siblings().children()[0].innerText +
                                "/" + '</li><li>' +
                                this.innerText + '</li>';
                            changBread(
                                this.parentNode.parentNode.parentNode.children[0].innerText,
                                ss);
                        } else if ($(this).hasClass("threeMenu")) {
                            changBread(
                                this.parentNode.parentNode.parentNode.children[0].children[1].innerText,
                                "车辆录入");
                        } else {
                            changBread(
                                this.parentNode.parentNode.parentNode.children[0].children[1].innerText,
                                this.innerText);
                        }
                        var sib = $(this).parent().parent()
                            .parent().siblings();
                        for (var i = 0; i < sib.length; i++) {
                            $(sib[i]).removeClass("active");
                            if (sib[i].children[1]) {
                                var li2 = sib[i].children[1].children[0];
                                for (var j = 0; j < li2.children.length; j++) {
                                    $(li2.children[j]).removeClass(
                                        "active");
                                }
                            }
                        }
                    });
            var Menuhash = document.querySelectorAll(".sidebar-submenu li");
            for (var i = 0; i < Menuhash.length; i++) {
                Menuhash[i].onclick = function() {
                    window.location.hash = $(this).attr("class");
                }
            }
            changeTabs(); // 监听hash变化
        },
        "error": function(data) {
            // window.location.href =
            // "../../../car/CarMangae0/html/login.html";
        }
    })

// 解决tabs标签在当前页面点击后，再次点击，失效问题。
function removecss(box) {
    $(".sidebar-submenu a").removeClass("active");
}