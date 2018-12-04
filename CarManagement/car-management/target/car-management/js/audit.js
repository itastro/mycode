// 还车点检

// 点击修改，出现相应的提交按钮
var edit_btn = $('#main .form_subject .pull-right');
var form_btngroups = $('#main .form_btngroup');
var form_btngroup_cancel = $('#main .form_btngroup .pull-right');
for (var m = 0; m < edit_btn.length; m++) {
    edit_btn[m].index = m;
    edit_btn[m].onclick = function() {
        $('#main .form_btngroup').eq(this.index).show() // $('.form_btngroup').hide();
    };
}
$('#main .form_btngroup .pull-right').unbind('click').bind('click', function() {
    $(this).parent().hide();
})