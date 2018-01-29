jQuery.noConflict();
jQuery(document).ready(function($) {
    var appTerrace=$("#appTerrace");
    var firstCate=$("#queryCategoryLevel1");

    function loadInfo(tcode,varible){
        //动态加载App状态列表
        $.ajax({
            type:"GET",//请求类型
            url:"/sysA/dcitory/datadictionarylist",//请求的url
            data:{tcode:varible},//请求参数
            dataType:"json",//ajax接口（请求url）返回的数据类型
            success:function(data){//data：返回数据（json对象）
                tcode.html("");
                var options = "<option value=\"0\">--请选择--</option>";
                for(var i = 0; i < data.length; i++){
                    options += "<option value=\""+data[i].valueId+"\">"+data[i].valueName+"</option>";
                }
                tcode.html(options);
            },
            error:function(data){//当访问时候，404，500 等非200的错误状态码
                alert("加载APP状态列表失败！");
            }
        });
    }

    loadInfo(appTerrace,"APP_FLATFORM");   //加载平台下拉框

    //动态加载App一级菜单列表
    $.ajax({
        type:"GET",//请求类型
        url:"/sysA/appCate/firstCate",//请求的url
        data:{parentId:0},//请求参数
        dataType:"json",//ajax接口（请求url）返回的数据类型
        success:function(data){//data：返回数据（json对象）
            firstCate.html("");
            var options = "<option value=\"0\">--请选择--</option>";
            for(var i = 0; i < data.length; i++){
                options += "<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
            }
            firstCate.html(options);
        },
        error:function(data){//当访问时候，404，500 等非200的错误状态码
            alert("加载APP一级列表失败！");
        }
    });

    $("#queryCategoryLevel1").change(function () {
        var queryCategoryLevel1 = $("#queryCategoryLevel1").val();
        if (queryCategoryLevel1 != '' && queryCategoryLevel1 != null) {
            $.ajax({
                type: "GET",//请求类型categorylevellist2
                url: "/sysA/appCate/categorylevellist2",//请求的url
                data: {pid: queryCategoryLevel1},//请求参数
                dataType: "json",//ajax接口（请求url）返回的数据类型
                success: function (data) {//data：返回数据（json对象）
                    $("#queryCategoryLevel2").html("");
                    var options = "<option value=\"0\">--请选择--</option>";
                    for (var i = 0; i < data.length; i++) {
                        options += "<option value=\"" + data[i].id + "\">" + data[i].categoryName + "</option>";
                    }
                    $("#queryCategoryLevel2").html(options);
                },
                error: function (data) {//当访问时候，404，500 等非200的错误状态码
                    alert("加载二级分类失败！");
                }
            });
        } else {
            $("#queryCategoryLevel2").html("");
            var options = "<option value=\"0\">--请选择--</option>";
            $("#queryCategoryLevel2").html(options);
        }
        $("#queryCategoryLevel3").html("");
        var options = "<option value=\"0\">--请选择--</option>";
        $("#queryCategoryLevel3").html(options);
    });

    $("#queryCategoryLevel2").change(function () {
        var queryCategoryLevel2 = $("#queryCategoryLevel2").val();
        if (queryCategoryLevel2 != '' && queryCategoryLevel2 != null) {
            $.ajax({
                type: "GET",//请求类型
                url: "/sysA/appCate/categorylevellist2",//请求的url
                data: {pid: queryCategoryLevel2},//请求参数
                dataType: "json",//ajax接口（请求url）返回的数据类型
                success: function (data) {//data：返回数据（json对象）
                    $("#queryCategoryLevel3").html("");
                    var options = "<option value=\"0\">--请选择--</option>";
                    for (var i = 0; i < data.length; i++) {
                        //alert(data[i].id);
                        //alert(data[i].categoryName);
                        options += "<option value=\"" + data[i].id + "\">" + data[i].categoryName + "</option>";
                    }
                    $("#queryCategoryLevel3").html(options);
                },
                error: function (data) {//当访问时候，404，500 等非200的错误状态码
                    alert("加载三级分类失败！");
                }
            });
        } else {
            $("#queryCategoryLevel3").html("");
            var options = "<option value=\"0\">--请选择--</option>";
            $("#queryCategoryLevel3").html(options);
        }
    });

});



	
