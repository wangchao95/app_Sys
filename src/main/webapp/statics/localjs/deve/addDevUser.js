jQuery.noConflict();
jQuery(document).ready(function($) {
    var devCode=$("#devCode");
    var devName=$("#devName");
    var devPassword=$("#devPassword");
    var reldevPassword=$("#reldevPassword");
    var devEmail=$("#devEmail");
    var devInfo=$("#devInfo");

    devCode.bind("blur", function () {
        $.post("/sys/devUser/existUserCode","code="+devCode.val(),function(data){
            if(data.count==1){
                validateTip(devCode,{"color":"red"},imgNo+" 此编码已经存在",false);
            }else if(data.count==-1){
                validateTip(devCode,{"color":"red"},imgNo+" 此编码不能为空",false);
            }else{
                validateTip(devCode,{"color":"green"},imgYes+" 此编码合法",true);
            }
        })
    });

    devName.bind("blur", function () {
        verityfy(null,devName,"用户名",null);
    });

    //失去焦点验证的方法
    devPassword.bind("blur", function () {
        var patrn = /^\w{6,15}$/;
        verityfy(patrn,devPassword,"密码","密码必须是6-15位数字或者字母");
    });

    reldevPassword.on("blur",function(){
        if(reldevPassword.val() == null || reldevPassword.val() == ""){
            validateTip(reldevPassword,{"color":"red"},imgNo+" 再次输入密码不能为空",false);
        }else if(reldevPassword.val()!=devPassword.val()){
            validateTip(reldevPassword,{"color":"red"},imgNo+" 两次输入的密码不一致",false);
        }else{
            validateTip(reldevPassword,{"color":"green"},imgYes+"再次密码正确",true);
        }
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
    $("#sendAddUser").click(function(){
        if( devName.attr("validateStatus")!="true"){
            devName.blur();
        }else if(devCode.attr("validateStatus")!="true") {
            devCode.blur();
        }else if(devPassword.attr("validateStatus")!="true") {
            devPassword.blur();
        }else if(reldevPassword.attr("validateStatus")!="true") {
            reldevPassword.blur();
        }else if(devEmail.attr("validateStatus")!="true") {
            devEmail.blur();
        }else if(devInfo.attr("validateStatus")!="true"){
            devInfo.blur();
        }else{
            $("#addUserForm").ajaxSubmit({
                type: 'post',
                url: "/sys/devUser/addDevUser",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success:function(data){
                    if(data==0){
                        alert("添加用户失败啦");
                        return;
                    }else if(data==-1){
                        alert("添加失败输入的数据不合法");
                    }else{
                        alert("添加用户成功啦");
                        location.href="/sys/appInfo/appJsp";
                    }
                }
            });
        }
    })

})