function isFF() {
    return navigator.userAgent.indexOf("Firefox") != -1;
}

function isChrome() {
    return navigator.userAgent.indexOf("Chrome") > -1;
}

var body = document.getElementsByTagName("body")[0];

function detectZoom() {
    body.style.zoom = "0";
    var secreenWidth = window.screen.width;
    if (secreenWidth > 1024 && secreenWidth <= 1366) {
        body.style.zoom = "0.9";
    } else if (secreenWidth <= 1024) {
        body.style.zoom = "0.8";
    }
    // var ratio = 0,
    //     screen = window.screen,
    //     ua = navigator.userAgent.toLowerCase();

    // if (window.devicePixelRatio !== undefined) {
    //     ratio = window.devicePixelRatio;
    // } else if (~ua.indexOf('msie')) {
    //     if (screen.deviceXDPI && screen.logicalXDPI) {
    //         ratio = screen.deviceXDPI / screen.logicalXDPI;
    //     }
    // } else if (window.outerWidth !== undefined && window.innerWidth !== undefined) {
    //     ratio = window.outerWidth / window.innerWidth;
    // }
    // if (ratio) {
    //     ratio = Math.round(ratio * 100);
    // }
    // //  detectZoom 函数的返回值如果是 100 就是默认缩放级别，大于 100 则是放大了，小于 100 则是缩小了。
    // // alert("ratio=" + ratio);
    // if (isChrome()) {
    //     // if (ratio < 125 && ratio >= 113) {
    //     //     body.style.zoom = "0.7";
    //     // } else 
    //     if (ratio < 113 && ratio >= 94) {
    //         body.style.zoom = "1";
    //     } else if (ratio < 94 && ratio >= 83) {
    //         body.style.zoom = "1.35";
    //     } else if (ratio < 83 && ratio >= 63) {
    //         body.style.zoom = "1.5";
    //     } else if (ratio < 63 && ratio >= 42) {
    //         body.style.zoom = "2.5";
    //     } else if (ratio == 31) {
    //         body.style.zoom = "3.6";
    //     } else {
    //         body.style.zoom = "0";
    //     }
    // }
};
detectZoom();
window.onresize = detectZoom;