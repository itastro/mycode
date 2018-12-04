  // 获取随机数
  function getRandom(n) {
      return Math.floor(Math.random() * n + 1)
  }
  // 搜索某一条车辆
  function searchCar() {
      console.log($("#current_input").val());
      if ($("#current_input").val() == null || $("#current_input").val() == "") {
          alert("车辆编号不能为空");
      } else {
          $.ajax({
              "url": "/car-management/car/carData.action",
              "type": "get",
              "dataType": "jsonp", //数据类型为jsonp  
              "jsonp": "jsonpCallback", //服务端用于接收callback调用的function名的参数  
              "data": {
                  "vSn": $("#current_input").val()
              },
              "success": function(newres) {
                  console.log(newres);
                  for (var j = 0; j < newres.length; j++) {
                      if (newres[0] == null) {
                          alert("车辆数据未搜素到");
                          return;
                      }
                      if (newres[j].longitude != "" && newres[j].latitude != "") {
                          dynamicLine(newres[j].longitude, newres[j].latitude);
                      } else {
                          alert("车辆数据未搜素到");
                      }
                  }
              },
              "error": function(data) {
                  console.log(data);
                  alert("发生错误");
              }
          })
      }
  }
  //在轨迹点上创建图标，并添加点击事件，显示轨迹点信息。points,数组。
  function addMarker(points) {
      var pointsLen = points.length;
      if (pointsLen == 0) {
          return;
      }
      var myIcon = new BMap.Icon("../img/index/30redcar.png", new BMap.Size(39, 20), {
          offset: new BMap.Size(10, 5)
      });

      // 创建标注对象并添加到地图   
      for (var i = 0; i < pointsLen; i++) {
          var point = new BMap.Point(points[i].lng, points[i].lat);
          var marker = new BMap.Marker(point, {
              icon: myIcon
          });
          map.addOverlay(marker);
      }
  }

  //添加线
  function addLine(points) {
      var linePoints = [],
          pointsLen = points.length,
          i, polyline;
      if (pointsLen == 0) {
          return;
      }
      // 创建标注对象并添加到地图   
      for (i = 0; i < pointsLen; i++) {
          linePoints.push(new BMap.Point(points[i].lng, points[i].lat));
      }

      polyline = new BMap.Polyline(linePoints, {
          strokeColor: "red",
          strokeWeight: 1,
          strokeOpacity: 0.5
      }); //创建折线
      map.addOverlay(polyline); //增加折线
  }

  //随机生成新的点，加入到轨迹中。
  function dynamicLine(lng, lat) {
      var lng = lng;
      var lat = lat;
      var point = {
          "lng": lng,
          "lat": lat,
          "status": 1
      }
      var makerPoints = [];
      var newLinePoints = [];
      var len;

      makerPoints.push(point);
      addMarker(makerPoints); //增加对应该的轨迹点
      points.push(point);
      bPoints.push(new BMap.Point(lng, lat));
      len = points.length;
      newLinePoints = points.slice(len - 2, len); //最后两个点用来画线。

      addLine(newLinePoints); //增加轨迹线
      setZoom(bPoints);
      setTimeout(dynamicLine, 5000);
  }

  //根据点信息实时更新地图显示范围，让轨迹完整显示。设置新的中心点和显示级别
  function setZoom(bPoints) {
      var view = map.getViewport(eval(bPoints));
      var mapZoom = view.zoom;
      var centerPoint = view.center;
      map.centerAndZoom(centerPoint, mapZoom);
  }

  //数据准备,
  var points = []; //原始点信息数组
  var bPoints = []; //百度化坐标数组。用于更新显示范围。

  //地图操作开始
  var map = new BMap.Map("cmapcontainer");

  map.centerAndZoom(new BMap.Point(103.388611, 35.563611), 5); //初始显示中国。

  map.enableScrollWheelZoom(); //滚轮放大缩小

  //   setTimeout(dynamicLine, 1000); //动态生成新的点。
  //   setTimeout(searchCar, 1000); //动态生成新的点。