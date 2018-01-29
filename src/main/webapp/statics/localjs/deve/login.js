jQuery.noConflict();
jQuery(document).ready(function ($) {
    var userCode = $("#devCode");
    var userPwd = $("#devPwd");

//获得焦点验证的方法
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

    $("#login").click(function () {
        if (userCode.attr("validateStatus") != "true") {
            userCode.focus();
        } else if (userPwd.attr("validateStatus") != "true") {
            userPwd.focus();
        } else {
            $("#devForm").ajaxSubmit({
                type: 'post',
                url: "/doLogin.html",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success: function (data) {
                    if (data == 1) {
                        location.href = "/sys/main.html";
                    } else {
                        validateTip(null, {"color": "red"}, imgNo + "用户名或者密码错误", false);
                        // $(".form-control").prev().html("用户名或者密码错误！");
                    }
                }
            });
        }
    })
})
