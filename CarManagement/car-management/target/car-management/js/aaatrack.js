$(document).ready(function() {
    $("#track_playback_btn").unbind('click').bind('click', function() {
        $("#cmapcontainer").hide();
        $("#amapcontainer").show();
        mp.clearOverlays();
        // points.length = 0;
        // myarr.length = 0;
        // ago_total = 0;
        // ago_groupCount = 0;
        loadAgotrack();
    });
    // var car1 = [
    //     ["113.208619", "23.170208", "广州", "装车", "2016-12-05 19:47:03"],
    //     ["112.622218", "26.979794", "", "装车", "2016-12-05 19:47:03"],
    //     ["113.006332", "28.263503", "长沙", "当前位置", "2016-12-05 19:47:03"],
    //     ["111.731111", "40.842", , "呼和浩特", "暂未到达目的地"]
    // ];
    // console.log(car1);
    var mp = new BMap.Map("amapcontainer", {
        enableMapClick: false
    });
    mp.enableScrollWheelZoom();

    // mp.centerAndZoom(new BMap.Point(50.633088, 34.745758), 5);


    var points = [];
    var ago_total = 0; //总记录数
    var ago_groupCount = 0; //每次转十条
    var myarr = [];
    // -------------------------------------------------------------------------------------------------
    function loadAgotrack() {
        // console.log($("#startDate").val());
        // console.log($("#endDate").val());
        // console.log($("#ago_input").val());
        if ($("#startDate").val() == null || $("#endDate").val() == "" || $("#ago_input").val() == "") {
            alert("不能为空");
            return;
        } else {
            $.ajax({
                "url": "http://localhost/car/CarMangae0/json/omap.json",
                // "url": "http://192.168.0.222:8080/car-management/car/carTrack.action",
                "type": "get",
                // "dataType": "jsonp", //数据类型为jsonp  
                // "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数  
                "data": {
                    "startDate": $("#startDate").val(),
                    "endDate": $("#endDate").val(),
                    "vSn": $("#ago_input").val()
                },
                "success": function(res) {
                    console.log(res);
                    if (res.length <= 1) {
                        alert("未检索到此车的历史数据");
                        return;
                    }
                    points.length = 0;
                    ago_total = 0;
                    ago_groupCount = 0;
                    for (var n = 0; n < res.length; n = n + 2) {
                        points.push(new BMap.Point(res[n][0], res[n][1]));
                    }
                    // 处理最后一个经纬度坐标点
                    console.log(res[res.length - 1][0]);
                    points.push(new BMap.Point(res[res.length - 1][0], res[res.length - 1][1]));
                    console.log(points);
                    if (points.length % 10 > 0) {
                        ago_groupCount = (points.length / 10) + 1;
                    } else {
                        ago_groupCount = (points.length / 10);
                    }
                    for (var i = 0; i < ago_groupCount - 1; i++) { //外层循环，有多少组十条
                        var pos = new Array();
                        for (var j = 0; j < 10; j++) { //内层循环，每组十条
                            if (ago_total < points.length) { //不超过总记录数结束
                                console.log(points);
                                console.log(points[(i * 10) + j].lng);
                                console.log(points[(i * 10) + j].lat);
                                var point = new BMap.Point(points[(i * 10) + j].lng, points[(i * 10) + j].lat);
                                pos.push(point);
                                console.log(pos);
                            }
                            ago_total++;
                        }
                        var convertor = new BMap.Convertor();
                        convertor.translate(pos, 1, 5, function(data) {
                            console.log(data);
                            if (data.status === 0) {
                                for (var m = 0; m < data.points.length; m++) {
                                    console.log(data.points);
                                    console.log(data.points[m].lng, data.points[m].lat);
                                    myarr[m] = new Array();
                                    for (var mm = 0; mm < 3; mm++) {
                                        myarr[m][0] = data.points[m].lng;
                                        myarr[m][1] = data.points[m].lat;
                                        myarr[m][2] = data.points[m].lat;
                                    }
                                    console.log(myarr);
                                    currentLocation([data.points[0].lng, data.points[0].lat], myarr);
                                }
                            }
                        });
                    }
                },
                "error": function(res) {
                    console.log(res);
                }
            });
        }
    }
    // -------------------------------------------------------------------------------------------------

    // currentLocation(["113.006332", "28.263503"], car1);
    //标注当前车辆坐标位置
    function currentLocation(curPosArr, carArr) {
        console.log(curPosArr);
        var curPt = new BMap.Point(curPosArr[0], curPosArr[1]); //当前位置
        var curIcon = new BMap.Icon("../img/map/30redcar.png", new BMap.Size(38, 20));
        var curMarker = new BMap.Marker(curPt, {
            icon: curIcon
        });

        mp.addOverlay(curMarker);
        var isDraw = false; //是否已经绘制过路线
        setTimeout(function() {
            drawPath(carArr, isDraw);
            isDraw = true;
        }, 500)

        // curMarker.onclick = function() {
        //     drawPath(carArr, isDraw);
        //     isDraw = true;
        // }
    };
    //绘制路线
    function drawPath(carArr, isDraw) {
        if (isDraw) { //若绘制过路线  返回 false
            return false;
        };
        var pointArr = [];
        var ptNum = 0;
        var driving = new BMap.DrivingRoute(mp); //创建驾车实例
        // 复杂的自定义覆盖物
        function ComplexCustomOverlay(point, state, time) {
            this._point = point;
            this.state = state;
            this.time = time;
        };
        // ComplexCustomOverlay.prototype = new BMap.Overlay();
        // ComplexCustomOverlay.prototype.initialize = function(map) {
        //     this._map = map;
        //     var div = this._div = document.createElement("div");
        //     $(div).addClass('state-wrap');
        //     var str = '<div class="logistics-wrap">';
        //     str += '<div class="logistics-state">' + this.state + '</div>';
        //     str += '<div class="logistics-time">' + this.time + '</div>';
        //     str += '</div>';
        //     // div.innerHTML = str;
        //     mp.getPanes().labelPane.appendChild(div);
        //     var he = div.offsetHeight;
        //     this._he = he; //当前div的高度
        //     return div;
        // };
        // ComplexCustomOverlay.prototype.draw = function() {
        //     var map = this._map;
        //     var pixel = map.pointToOverlayPixel(this._point);
        //     this._div.style.left = pixel.x - 24 + "px";
        //     this._div.style.top = pixel.y - this._he + 5 + "px";
        // };
        /*自定义复杂覆盖物结束*/
        console.log(carArr);
        for (var i = 0, len = carArr.length; i < len; i++) {
            console.log(carArr);
            var point = new BMap.Point(carArr[i][0], carArr[i][1]);
            console.log(point);
            pointArr[i] = point;
            console.log(pointArr);
            // var myIcon = new BMap.Icon("../img/map/30greencar.png", new BMap.Size(9, 9));
            if (i == len - 1) {
                var myIcon = new BMap.Icon("../img/map/30redcar.png", new BMap.Size(38, 20));
                var marker = new BMap.Marker(point, {
                    icon: myIcon
                }); // 创建标注
                mp.addOverlay(marker); // 将标注添加到地图中    
                // marker.onclick = function() { //给各个点添加点击事件，显示、隐藏自定义复杂物
                //     if (myComOverlay.isVisible()) {
                //         myComOverlay.hide();
                //     } else {
                //         myComOverlay.show();
                //     }
                // }
            }
            //此处解决在for循环中添加事件总是执行最后一个的情况，传入参数并且立即执行
            // (function(point, state, time) {
            //     var myComOverlay = new ComplexCustomOverlay(point, state, time);
            //     mp.addOverlay(myComOverlay);

            // })(point, carArr[i][0], carArr[i][1]);
        };
        var len = pointArr.length - 1;
        initRoute(ptNum);

        function initRoute(num) {
            console.log(pointArr); //报错null
            driving.search(pointArr[num], pointArr[num + 1]);
            driving.setSearchCompleteCallback(function() {
                console.log(driving.getResults()); //undefined
                var plan = driving.getResults().getPlan(0);
                var pts = plan.getRoute(0).getPath();
                var lineCor = ptNum == (len - 1) ? '#0073DB' : "#0073DB";
                var lineSty = ptNum == (len - 1) ? 'solid' : "solid";
                var polyline = new BMap.Polyline(pts, {
                    strokeColor: lineCor,
                    strokeWeight: 4,
                    strokeOpacity: 0.8,
                    strokeStyle: lineSty
                });
                mp.addOverlay(polyline);
                //查找下两个点
                ptNum++;
                if (ptNum < len) {
                    initRoute(ptNum);
                }
            });
        };
        mp.setViewport(pointArr); //自动调整视野
    };
})