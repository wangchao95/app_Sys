jQuery.noConflict();
jQuery(document).ready(function($) {
    var versionSize=$("#versionSize");
    var versionInfo=$("#versionInfo");

    function delfile(id) {
        $.ajax({
            type: "GET",//请求类型
            url: "delfile.json",//请求的url
            data: {id: id, flag: 'apk'},//请求参数
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                if (data.result == "success") {
                    alert("删除成功！");
                    $("#uploadfile").show();
                    $("#apkFile").html('');
                } else if (data.result == "failed") {
                    alert("删除失败！");
                }
            },
            error: function (data) {//当访问时候，404，500 等非200的错误状态码
                alert("请求错误！");
            }
        });
    }

    //失去焦点验证的方法
    versionSize.bind("blur", function () {
        var patrn = /^[1-9]{1,6}(.00|[1-9])$/;
        verityfy(patrn,versionSize,"版本大小","版本大小必须是大于1的1到6位数");
    });

    versionInfo.bind("blur", function () {
        verityfy(null,versionInfo,"版本简介",null);
    });



    $(function () {
        //上传APK文件---------------------
        var downloadLink = $("#downloadLink").val();
        var id = $("#id").val();
        var apkFileName = $("#apkFileName").val();
        if (downloadLink == null || downloadLink == "") {
            $("#uploadfile").show();
        } else {
            $("#apkFile").append("<p>" + apkFileName +
                "&nbsp;&nbsp;<a href=\"" + downloadLink + "?m=" + Math.random() + "\" >下载</a> &nbsp;&nbsp;" +
                "<a href=\"javascript:;\" onclick=\"delfile('" + id + "');\">删除</a></p>");
        }
    });

    /**
	 * 修改app的最新版本
     */
    $("#sendEditVersion").click(function(){
        versionSize.blur();
        versionInfo.blur();
        if( versionSize.attr("validateStatus")!="true"){
            versionSize.blur();
        }else if(versionInfo.attr("validateStatus")!="true"){
            versionInfo.blur();
        }else{
            $("#editVersionForm").ajaxSubmit({
                type: 'post',
                url: "/sys/appVersion/editVersion",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                success:function(data){
                    if(data==0){
                        alert("修改版本失败啦");
                        return;
                    }else if(data==-1){
                        alert("修改失败输入的数据不合法");
                    }else{
                        alert("修改版本成功啦");
                        location.href="/sys/appInfo/toEditVersion/"+ data.appId;
                    }
                }
            });
        }
	})
});
      
      
      