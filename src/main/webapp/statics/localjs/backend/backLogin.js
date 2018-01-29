jQuery.noConflict();
jQuery(document).ready(function($){
    var userCode=$("#userCode");
    var userPwd=$("#userPassword");

    userCode.bind("blur", function () {
        if (userCode.val() == null || userCode.val() == "") {
            validateTip(userCode, {"color": "red"}, imgNo + " 登录的账户不能为空", false);
        } else {
            validateTip(userCode, {"color": "green"}, imgYes+"账户输入合格", true);
        }
    });

    //失去焦点验证的方法
    userPwd.bind("blur", function () {
        var patrn = /^\w{6,}$/;
        if (userPwd.val() == null || userPwd.val() == "") {
            validateTip(userPwd, {"color": "red"}, imgNo + "密码不能为空", false);
        } else if (!userPwd.val().match(patrn)) {
            validateTip(userPwd, {"color": "red"}, imgNo + "密码必须是6位以上的字母或数字", false);
        } else {
            validateTip(userPwd, {"color": "green"}, imgYes+"密码输入合格", true);
        }
    });

        $("#backSubmit").click(function(){
            if(userCode.attr("validateStatus")!="true"){
                userCode.focus();
            }else if(userPwd.attr("validateStatus")!="true"){
                userPwd.focus();
            }else{
                $("#backForm").ajaxSubmit({
                    type:'post',
                    url:"/doBackLogin.html",
                    contentType:"application/x-www-form-urlencoded;charset=utf-8",
                    // 成功执行的函数
                    success:function(data){
                        if(data==1){
                            location.href="/sysA/backmain.html";
                        }else{
                            validateTip(null, {"color": "red"}, imgNo + "账号或者密码输入错误，请重新输入", false);
                        }
                    }
                });
            }
        })
});