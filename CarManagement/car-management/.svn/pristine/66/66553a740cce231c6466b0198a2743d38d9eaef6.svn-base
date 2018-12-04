var allurl = "";
function getList() {
    $.ajax({
        "url": allurl + "/car-management/carmaintain/screen.action",
        "type": "get",
        "success": function(res) {
            if (res.count == 0) {
                alert("未检索到维修车辆");
                return;
            }
            console.log(res);
            $(".maintain_countCar").html(res.count);
            $(".maintain_completeCar").html(res.complete);
            $(".maintain_currentCar").html(res.current);
            $(".maintain_queueCar").html(res.queue);
            // ----------------------------------------------------------------------------------------------------------------------------------
            if (isFF() || isChrome()) {
                $("head").append("<script type='text/javascript' src='../assets/js/circleChart.js'>" + '<' + "/script>");
                $(".circleChart#0").circleChart({
                    size: 70,
                    color: "#0000ff",
                    backgroundColor: "#8D8D8D",
                    value: res.queuepercentage,
                    text: 0,
                    onDraw: function(el, circle) {
                        circle.text(Math.round(circle.value) + "%");
                    }
                });
                $(".circleChart#1").circleChart({
                    size: 70,
                    color: "red",
                    backgroundColor: "#8D8D8D",
                    value: res.currentpercentage,
                    text: 0,
                    top: 50,
                    onDraw: function(el, circle) {
                        circle.text(Math.round(circle.value) + "%");
                    }
                });
                $(".circleChart#2").circleChart({
                    size: 70,
                    color: "#1FAC41",
                    backgroundColor: "#8D8D8D",
                    value: res.completepercentage,
                    text: 0,
                    onDraw: function(el, circle) {
                        circle.text(Math.round(circle.value) + "%");
                    }
                });
            }
            var screenHtml = "";
            var lunbo = "";
            var classname = "";
            // var obj = res.data;
            if (res.pageBean.rows) {
                var obj = res.pageBean.rows;
            } else {
                return;
            }
            if (obj == null) {
                return;
            }
            console.log(obj);
            var linum = "";
            for (var i = 0; i < obj.length; i++) {
                for (var key in obj[i]) {
                    if (obj[i][key] == null) {
                        obj[i][key] = "------";
                    }
                }
                var a = "";
                if (obj[i].status == null) {
                    a = '';
                } else if (obj[i].status == "排队中") {
                    a = '<span style="color:#0000ff;width:100%;weight:bold;">排队中</span>';
                } else if (obj[i].status == "维修中") {
                    a = '<span style="color:red;width:100%;weight:bold;">维修中</span>';
                } else if (obj[i].status == "已完成") {
                    a = '<span style="color:#1FAC41;width:100%;weight:bold;">已完成</span>';
                } else {
                    a = '<span>已完成</span>';
                }
                if (obj[i].operator == null) {
                    obj[i].operator = "--";
                }
                if (obj[i].park == null) {
                    obj[i].park = "--";
                }
                if (i == 0) {
                    activename = "active";
                } else {
                    activename = "";
                }
                var index = i + 1;
                screenHtml +=
                    '<li style="margin-top:0px;"><span class="list0">' + index +
                    '</span><span class="list1">' + obj[i].vSn +
                    '</span><span class="list2 ' + classname + '">' + obj[i].applyPeople + '</span>' +
                    '<span class="list3">' + obj[i].workContent +
                    '</span><span class="list4">' + obj[i].forecastTime +
                    '</span><span class="list5">' + obj[i].operator +
                    '</span><span class="list6">' + a + '</span>' +
                    '</span><span class="list7">' + obj[i].fin_park + '</span></li>';
            }
            $("#scrollDiv ul").html(screenHtml);

            var list3 = $("#scrollDiv ul li .list3");
            for (var i = 0; i < list3.length; i++) {
                if (isEllipsis(list3[i])) {
                    list3[i].innerHTML = '<marquee style="width:80%;align:middle;">' + list3[i].innerText + '</marquee>'
                }
            }

        },
        "error": function(res) {
            console.log(res);
        }
    })
}

function Scroll(opt, callback) {
    //参数初始化
    if (!opt) var opt = {};
    var _this = $("#scrollDiv ul:first");
    var lineH = _this.find("li:first").height(), //获取行高
        line = opt.line ? parseInt(opt.line, 10) : parseInt(_this.height() / lineH, 10), //每次滚动的行数，默认为一屏，即父容器高度
        speed = opt.speed ? parseInt(opt.speed, 10) : 1000, //卷动速度，数值越大，速度越慢（毫秒）
        timer = opt.timer ? parseInt(opt.timer, 10) : 3000; //滚动的时间间隔（毫秒）
    if (line == 0) line = 1;
    var upHeight = 0 - line * lineH;
    window.timerID = timerID = "";
    console.log("speed=" + speed, "timer=" + timer, "line=" + line);

    //  clearInterval(timerID);
    _this.animate({
        marginTop: upHeight
    }, speed, function() {
        for (i = 1; i <= line; i++) {
            _this.find("li:first").appendTo(_this);
        }
        _this.css({ marginTop: 0 });
    });
    //   timerID = setInterval("scrollUp()", timer);
    timerID = setInterval(function() {
        _this.animate({
            marginTop: upHeight
        }, speed, function() {
            for (i = 1; i <= line; i++) {
                _this.find("li:first").appendTo(_this);
            }
            _this.css({ marginTop: 0 });
        });
    }, timer)
}