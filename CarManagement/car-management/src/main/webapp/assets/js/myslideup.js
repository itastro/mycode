(function($) {
    $.fn.extend({
        Scroll: function(opt, callback) {
            //参数初始化
            if (!opt) var opt = {};
            var _this = this.eq(0).find("ul:first");
            var lineH = _this.find("li:first").height(), //获取行高
                line = opt.line ? parseInt(opt.line, 10) : parseInt(this.height() / lineH, 10), //每次滚动的行数，默认为一屏，即父容器高度
                speed = opt.speed ? parseInt(opt.speed, 10) : 1000, //卷动速度，数值越大，速度越慢（毫秒）
                timer = opt.timer ? parseInt(opt.timer, 10) : 3000; //滚动的时间间隔（毫秒）
            if (line == 0) line = 1;
            var upHeight = 0 - line * lineH;
            var timerID = "";
            console.log("speed=" + speed, "timer=" + timer, "line=" + line);
            clearInterval(timerID);
            //滚动函数
            scrollUp = "";
            scrollUp = function() {
                // timerID = "";
                clearInterval(timerID);
                _this.animate({
                    marginTop: upHeight
                }, speed, function() {
                    for (i = 1; i <= line; i++) {
                        _this.find("li:first").appendTo(_this);
                    }
                    _this.css({ marginTop: 0 });
                });
            };
            //鼠标事件绑定
            _this.hover(function() {
                clearInterval(timerID);
            }, function() {
                clearInterval(timerID);
                timerID = setInterval("scrollUp()", timer);
            }).mouseout();
        }
    })
})(jQuery);

// $(document).ready(function() {
//     $("#scrollDiv").Scroll({
//         line: 5,
//         speed: 1000,
//         timer: 3000
//     });
// });