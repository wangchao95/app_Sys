// 在jQuery(document).ready(function ($) {或者$(document).ready(function(){})外面申明的变量不带$符号的每个js文件都可以使用，如果要使用$，只有在里面
var imgYes = "<img width='15px' src='/statics/images/y.png' />";
var imgNo = "<img width='15px' src='/statics/images/n.png' />";
var message =null;
jQuery.noConflict();
jQuery(document).ready(function ($) {
	message= $("#message");
});

/**
 * 提示信息显示
 * element:显示提示信息的元素（font）
 * css：提示样式
 * tipString:提示信息
 * status：true/false --验证是否通过
 */
// 此处就在jQuery(document).ready(function ($)或者$(document).ready(function(){})外面申明的，每个js文件都可以访问（前提是此代码块如果在$..外面申明就不能使用带$的任意代码）
function validateTip(element, css, tipString, status) {
    message.css(css);
    message.html(tipString);
    element.attr("validateStatus", status);
}

//输入验证的方法
function verityfy(pattern,element,name,message){
    if (element.val() == null || element.val() == ""||element.val()==0||element.val()=="0") {
        validateTip(element, {"color": "red"}, imgNo + name+"不能为空", false);
    }else if(pattern!=null && pattern!=""){
    	if(!element.val().match(pattern)){
            validateTip(element, {"color": "red"}, imgNo +name+message, false);
		}else{
            validateTip(element, {"color": "green"}, imgYes+name+"输入合格", true);
        }
    }else{
        validateTip(element, {"color": "green"}, imgYes+name+"输入合格", true);
    }
}

