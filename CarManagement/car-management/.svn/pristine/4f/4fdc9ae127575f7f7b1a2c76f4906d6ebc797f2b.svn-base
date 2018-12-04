 $(".guijibox").hide();
 $(".controlbox").show();
 $(".uparrow").unbind('click').bind('click', function() {
     $(".uparrow").addClass("trans");
     if ($(".uparrow").hasClass("trans")) {
         $(".uparrow").removeClass("trans");
     }
     $(".control_box").slideToggle("slow");
 });

 $(".curr_btn").unbind('click').bind('click', function() {
     $(".controlbox").show();
     $(".guijibox").hide();
     $(".pointerTabLeft").removeClass("pointerTabRight");
 });
 $(".guiji_btn").unbind('click').bind('click', function() {
     console.log("guiji");
     $(".guijibox").show();
     $(".controlbox").hide();
     $(".pointerTabLeft").addClass("pointerTabRight");
 });
 //时间选择器
 var myDate = new Date();
 var date2 = new Date(myDate);
 date2.setDate(myDate.getDate() - 30);

 laydate.render({
     elem: '#startDate',
     type: 'datetime',
     value: date2,
     theme: '#041473' //自定义颜色主题
 });
 laydate.render({
     elem: '#endDate',
     type: 'datetime',
     value: myDate,
     theme: '#041473' //自定义颜色主题

 });
 $("#cmapcontainer").show();
 $("#amapcontainer").hide();

 // 清楚地图覆盖物
 function Clear(inputid) { //清除
     //  map.clearOverlays(); //清除图层覆盖物
     map.clearMap(); //清除图层覆盖物
 }
 //  $("#currenttrack_btn").unbind('click').bind('click', function() {
 //      console.log("实时轨迹按钮");
 //      $("#cmapcontainer").show();
 //      $("#amapcontainer").hide();
 //      console.log("隐藏#amap");
 //      Clear("current_input");
 //      searchCurrentcar();
 //  });
 //回车提交事件
 $("body").keydown(function() {
     if (event.keyCode == "13") { //keyCode=13是回车键
     }
 });