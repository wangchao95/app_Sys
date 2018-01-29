jQuery.noConflict();
jQuery(document).ready(function($) {
    // 此处为审核操作
        $(".btn-success").on("click", function () {
            data = "aid=" + $("#aid").val() + "&status=" + $(this).val();
            $.post("/sysA/appCheck/checkSave", data, function (data) {
                if (data == 1) {
                    alert("审核后通过啦");
                    location.href = "/sysA/appCheck/appList";
                } else {
                    alert("审核失败，请重新审核吧");
                }
            });
        });

});

