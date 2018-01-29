jQuery.noConflict();
jQuery(document).ready(function($) {
	var versionNo=$("#versionNo");
    var versionSize=$("#versionSize");
    var versionInfo=$("#versionInfo");


    //失去焦点验证的方法
    versionNo.bind("blur", function () {
        var patrn = /^[A-Z][1-9].\w{2,}$/;
        verityfy(patrn,versionNo,"版本号","版本号必须是字母和数字开头带“.”号的字符");
    });

    //失去焦点验证的方法
    versionSize.bind("blur", function () {
        var patrn = /^[1-9]{1,6}$/;
        verityfy(patrn,versionSize,"版本大小","版本大小必须是大于1的1到6位数");
    });

    versionInfo.bind("blur", function () {
        verityfy(null,versionInfo,"版本简介",null);
    });



    /**
         * 添加版本对象
         */
        $("#send").click(function () {
        	var aid=$("#appId").val();
            if(versionNo.attr("validateStatus")!="true") {
                versionNo.blur();
            }else if( versionSize.attr("validateStatus")!="true"){
                versionSize.blur();
			}else if(versionInfo.attr("validateStatus")!="true"){
                versionInfo.blur();
			}else{
                $(".form-label-left").ajaxSubmit({
                    type: 'post',
                    url: "/sys/appVersion/addVersion",
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    success:function(data){
                        if(data.count=="1"){
                            alert("添加成功啦");
                            location.href=" /sys/appInfo/toAddVersion/"+aid;

                        }else{
                            alert("添加失败啦");
                            $(".form-control").next().html(data.message);
                            return;
                        }
                    }
                })
			}
        })
});
      
      
      