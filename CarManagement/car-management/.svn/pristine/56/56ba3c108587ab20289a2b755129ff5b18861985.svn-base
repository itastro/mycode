  // 百度地图API功能	
  map = new BMap.Map("allmap");
  // map.centerAndZoom(new BMap.Point(116.417854, 39.921988), 15);
  map.centerAndZoom(new BMap.Point(104.114129, 37.550339), 5);
  map.addControl(new BMap.NavigationControl()); // 添加平移缩放控件
  map.enableScrollWheelZoom(); //启用滚轮放大缩小，默认禁用

  var data_info = [
      [116.417854, 39.921988, "地址：北京市东城区王府井大街88号乐天银泰百货八层"],
      [116.406605, 39.921585, "地址：北京市东城区东华门大街"],
      [108.95, 34.27, "地址：西安"],
      [110.18, 36.87, "地址：延安"],
      [108.43, 34.5, "地址：礼泉"],
      [116.443, 39.92, "地址：北京朝阳"],
      [121.481387, 31.238281, "地址：上海市"],
      [115.859929, 28.778893, "地址：江西农业大学"],
      [123.464557, 41.801445, "地址：沈阳市"],
      [120.481387, 39.238281, "地址：上海市"]
  ];
  var sContent =
      "<div class='point_content'><h4 style='margin:0 0 5px 0;padding:0.2em 0'>驾驶员：王大伟</h4>" +
      "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>当前状态：行驶</h4>" +
      "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>车辆编号：02020</h4>" +
      "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>车牌号：陕A098ux</h4>" +
      "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>日期：2019年1月12日</h4>" +
      "</div>";
  var infoWindow = new BMap.InfoWindow(sContent); // 创建信息窗口对象
  var opts = {
      width: 250, // 信息窗口宽度
      height: 80, // 信息窗口高度
      title: "信息窗口", // 信息窗口标题
      background: "#3E3E3E",
      enableMessage: true //设置允许信息窗发送短息
  };
  var markers = [];
  for (var i = 0; i < data_info.length; i++) {
      var marker = new BMap.Marker(new BMap.Point(data_info[i][0], data_info[i][1])); // 创建标注
      // markers.push(marker);
      markers.push(marker);
      var content = data_info[i][2];
      // map.addOverlay(marker); // 将标注添加到地图中

      addClickHandler(content, marker);

      // var myIcon = new BMap.Icon("./img/redcar.png", new BMap.Size(30, 57));
      // var marker2 = new BMap.Marker(marker, {
      //     icon: myIcon
      // }); // 创建标注
      // // marker2.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
      // map.addOverlay(marker2);
  }
  //最简单的用法，生成一个marker数组，然后调用markerClusterer类即可。
  var markerClusterer = new BMapLib.MarkerClusterer(map, {
      markers: markers
  });

  function addClickHandler(content, marker) {
      marker.addEventListener("click", function(e) {
          // openInfo(content, e);
          this.openInfoWindow(infoWindow);
      });
  }

  function openInfo(content, e) {
      var p = e.target;
      var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
      var infoWindow = new BMap.InfoWindow(content, opts); // 创建信息窗口对象 
      map.openInfoWindow(infoWindow, point); //开启信息窗口
  }

  // 个性化地图
  var styleJson = [
      // 
      {
          'featureType': 'water',
          'elementType': 'all',
          'stylers': {
              'color': '#d1d1d1'
          }
      }, {
          'featureType': 'land',
          'elementType': 'all',
          'stylers': {
              'color': '#f3f3f3'
          }
      }, {
          'featureType': 'railway',
          'elementType': 'all',
          'stylers': {
              'visibility': 'off'
          }
      }, {
          'featureType': 'highway',
          'elementType': 'all',
          'stylers': {
              'color': '#fdfdfd'
          }
      }, {
          'featureType': 'highway',
          'elementType': 'labels',
          'stylers': {
              'visibility': 'off'
          }
      }, {
          'featureType': 'arterial',
          'elementType': 'geometry',
          'stylers': {
              'color': '#fefefe'
          }
      }, {
          'featureType': 'arterial',
          'elementType': 'geometry.fill',
          'stylers': {
              'color': '#fefefe'
          }
      }, {
          'featureType': 'poi',
          'elementType': 'all',
          'stylers': {
              'visibility': 'off'
          }
      }, {
          'featureType': 'green',
          'elementType': 'all',
          'stylers': {
              'visibility': 'off'
          }
      }, {
          'featureType': 'subway',
          'elementType': 'all',
          'stylers': {
              'visibility': 'off'
          }
      }, {
          'featureType': 'manmade',
          'elementType': 'all',
          'stylers': {
              'color': '#d1d1d1'
          }
      }, {
          'featureType': 'local',
          'elementType': 'all',
          'stylers': {
              'color': '#d1d1d1'
          }
      }, {
          'featureType': 'arterial',
          'elementType': 'labels',
          'stylers': {
              'visibility': 'off'
          }
      }, {
          'featureType': 'boundary',
          'elementType': 'all',
          'stylers': {
              'color': '#fefefe'
          }
      }, {
          'featureType': 'building',
          'elementType': 'all',
          'stylers': {
              'color': '#d1d1d1'
          }
      }, {
          'featureType': 'label',
          'elementType': 'labels.text.fill',
          'stylers': {
              'color': '#999999'
          }
      }
  ]
  map.setMapStyle({
      styleJson: styleJson
  });