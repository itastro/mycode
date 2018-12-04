    $(document).ready(function() {
        var mp = new BMap.Map("amapcontainer", {
            enableMapClick: false
        });

        mp.centerAndZoom(new BMap.Point(50.633088, 34.745758), 5);
        //根据点信息实时更新地图显示范围，让轨迹完整显示。设置新的中心点和显示级别
        // function setZoom(bPoints) {
        //     var view = map.getViewport(eval(bPoints));
        //     var mapZoom = view.zoom;
        //     var centerPoint = view.center;
        //     mp.centerAndZoom(centerPoint, mapZoom);
        // }
        mp.enableScrollWheelZoom();
        var points = [];
        var ago_total = 0; //总记录数
        var ago_groupCount = 0; //每次转十条
        function loadAgotrack() {
            console.log($("#startDate").val());
            console.log($("#endDate").val());
            console.log($("#ago_input").val());
            if ($("#startDate").val() == null || $("#endDate").val() == "" || $("#ago_input").val() == "") {
                alert("不能为空");
                return;
            } else {
                $.ajax({
                    "url": "../json/omap.json",
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
                        for (var n = 0; n < res.length; n++) {
                            for (var nn = 0; nn < res[n].legth; nn++) {}
                            points.push(new BMap.Point(res[n][2], res[n][1]));
                        }
                        if (points.length % 10 > 0) {
                            ago_groupCount = (points.length / 10) + 1;
                        } else {
                            ago_groupCount = (points.length / 10);
                        }
                        for (var i = 0; i < ago_groupCount; i++) { //外层循环，有多少组十条
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
                                        currentLocation(data.points[0], res);
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

        $("#track_playback_btn").unbind('click').bind('click', function() {
            $("#cmapcontainer").hide();
            $("#amapcontainer").show();
            mp.clearOverlays();
            loadAgotrack();
        });
        //标注当前车辆坐标位置
        function currentLocation(curPosArr, carArr) {
            mp.clearOverlays();
            var curPt = new BMap.Point(curPosArr[2], curPosArr[1]); //当前位置
            var curIcon = new BMap.Icon("../img/map/30redcar.png", new BMap.Size(35, 40));
            var curMarker = new BMap.Marker(curPt, {
                icon: curIcon
            });
            mp.addOverlay(curMarker);
            // setZoom(curPt);
            mp.centerAndZoom(curPt, 9);
            var isDraw = false; //是否已经绘制过路线
            curMarker.onclick = function() {
                drawPath(carArr, isDraw);
                isDraw = true;
            }
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
            ComplexCustomOverlay.prototype = new BMap.Overlay();
            ComplexCustomOverlay.prototype.initialize = function(map) {
                this._map = map;
                var div = this._div = document.createElement("div");
                $(div).addClass('state-wrap');
                var str = '<div class="logistics-wrap">';
                str += '<div class="logistics-state">' + this.state + '</div>';
                str += '<div class="logistics-time">' + this.time + '</div>';
                str += '</div>';
                div.innerHTML = str;
                mp.getPanes().labelPane.appendChild(div);
                var he = div.offsetHeight;
                this._he = he; //当前div的高度
                return div;
            };
            ComplexCustomOverlay.prototype.draw = function() {
                var map = this._map;
                var pixel = map.pointToOverlayPixel(this._point);
                this._div.style.left = pixel.x - 24 + "px";
                this._div.style.top = pixel.y - this._he + 5 + "px";
            };
            /*自定义复杂覆盖物结束*/
            for (var i = 0, len = carArr.length; i < len; i++) {
                var point = new BMap.Point(carArr[i].lng, carArr[i].lat);
                pointArr[i] = point;
                var myIcon = new BMap.Icon("../img/map/50greencar.png", new BMap.Size(9, 9));
                var marker = new BMap.Marker(point, {
                    icon: myIcon
                }); // 创建标注
                mp.addOverlay(marker); // 将标注添加到地图中    
                //此处解决在for循环中添加事件总是执行最后一个的情况，传入参数并且立即执行
                (function(point, state, time) {
                    var myComOverlay = new ComplexCustomOverlay(point, state, time);
                    mp.addOverlay(myComOverlay);
                    marker.onclick = function() { //给各个点添加点击事件，显示、隐藏自定义复杂物
                        if (myComOverlay.isVisible()) {
                            myComOverlay.hide();
                        } else {
                            myComOverlay.show();
                        }
                    }
                })(point, carArr[i].lng, changeDateFormat(carArr[i][0]));
            };
            var len = pointArr.length - 1;
            initRoute(ptNum);

            function initRoute(num) {
                driving.search(pointArr[num], pointArr[num + 1]);
                driving.setSearchCompleteCallback(function() {
                    var plan = driving.getResults().getPlan(0);
                    var pts = plan.getRoute(0).getPath();
                    var lineCor = ptNum == (len - 1) ? 'red' : "#1aea0a";
                    var lineSty = ptNum == (len - 1) ? 'dashed' : "solid";
                    var polyline = new BMap.Polyline(pts, {
                        strokeColor: lineCor,
                        strokeWeight: 3,
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