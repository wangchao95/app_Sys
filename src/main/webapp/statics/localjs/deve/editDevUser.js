jQuery.noConflict();
jQuery(document).ready(function($) {
    var devName=$("#devName");
    var devPassword=$("#devPassword");
    var devEmail=$("#devEmail");
    var devInfo=$("#devInfo");

    devName.bind("blur", function () {
        verityfy(null,devName,"用户名",null);
    });

    //失去焦点验证的方法
    devPassword.bind("blur", function () {
        var patrn = /^\w{6,15}$/;
        verityfy(patrn,devPassword,"密码","密码必须是6-15位数字或者字母");
    });

    //失去焦点验证的方法
    devEmail.bind("blur", function () {
        var patrn=/^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
        verityfy(patrn,devEmail,"邮箱","你输入的邮箱格式不对");
    });
    devInfo.bind("blur", function () {
        verityfy(null,devInfo,"用户信息",null);
    });

    /**
     * 修改app的最新版本
     */
    $("#sendEditUser").click(function(){
        devName.blur();
        devPassword.blur();
        devEmail.blur();
        devInfo.blur();
        if( devName.attr("validateStatus")!="true"){
            devName.blur();
        }else if(devPassword.attr("validateStatus")!="true") {
            devPassword.blur();
        }else if(devEmail.attr("validateStatus")!="true") {
            devEmail.blur();
        }else if(devInfo.attr("validateStatus")!="true"){
            devInfo.blur();
        }else{
            $("#editUserForm").ajaxSubmit({
                type: 'post',
                url: "/sys/devUser/editUser",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success:function(data){
                    if(data==0){
                        alert("修改用户失败啦");
                        return;
                    }else if(data==-1){
                        alert("修改失败输入的数据不合法");
                    }else{
                        alert("修改用户成功啦");
                        location.href="/loginOut.html";
                    }
                }
            });
        }
    })

})