jQuery.noConflict();
jQuery(document).ready(function($){

    /**
     * 到查看app信息和版本的审核页面
     */
    $("#tableInfo").on("click","#checkApp",function(){
        var obj=$(this);
        if(obj.attr("versionName")=="暂无"){
            alert("此APP暂无最新版本，无法进行审核，请先上传最新版本！！");
        }else{
            location.href="/sysA/appCheck/toAppCheck/"+ $(this).attr("aid");
            return;
        }
    });

    /**
     * 分页的方法
     */
    function page(pageNo) {
        $("#sF").ajaxSubmit({
            type: 'post',
            url: "/sysA/appCheck/appListPage",
            data:{pageIndex:pageNo},
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (data) {
                var appList = data.newPage;  //获得页的集合
                $("#tableInfo").html("");
                $(".page").remove();
                $("#tableInfo").append("<tr class=\"firstTr\" style='background-color: #00aeef'>\n" +
                    "<th width=\"18%\">软件名称</th>\n" +
                    "<th width=\"15%\">APK名称</th>\n" +
                    "<th width=\"5%\">软件大小(单位:M)</th>\n" +
                    "<th width=\"5%\">所属平台</th>\n" +
                    "<th width=\"20%\">所属分类(一级，二级，三级)</th>\n" +
                    "<th width=\"8%\">状态</th>\n" +
                    "<th width=\"6%\">下载次数</th>\n" +
                    "<th width=\"5%\">最新版本</th>\n" +
                    "<th width=\"5%\">操作</th>\n" +
                    "</tr>");
                //循环遍历集合
                for (var i = 0; i < appList.length; i++) {
                    var app = appList[i];
                    var versionName = app.versionNo == null ? "暂无" : app.versionNo;
                    $("#tableInfo").append("<tr><td><span>" + app.softwareName + "</span></td><td><span>" + app.aPKName + "</span></td> <td><span>" + app.softwareSize + "</span></td><td><span>" + app.flatformName + "</span></td>" +
                        "<td><span>" + app.categoryLevel1Name + "--" + app.categoryLevel2Name + "--" + app.categoryLevel3Name + "</span></td><td><span>" + app.statusName + "</span></td><td><span>" + app.downloads + "</span></td>" +
                        "<td><span style='color: red'>" + versionName + "</span></td><td><button type='button' id='checkApp' aid='" + app.id + "' versionName='" + versionName + "' class='btn btn-round btn-danger'>审核</button></td></tr>");
                }
                var $div = $("<div class='page'></div>").appendTo($(".table-responsive"));
                var $operArea = $("<p align='center'>共" + data.totalCount + "条记录&nbsp;&nbsp;&nbsp;当前页数:[" + data.currPageNo + "/" + data.totalPageCount + "]&nbsp;</p>").appendTo($div);
                if (data.currPageNo > 1) {
                    var $first = $("<a href=\"javascript:;\" id='1' class=\"first\" >首页</a>");
                    var $perv = $("<a href=\"javascript:;\" class='pre' id='" + (data.currPageNo - 1) + "'>上一页</a>");
                    $div.append($first).append("&nbsp;").append($perv);   //添加到元素里面
                }
                //如果当前页数小于总页数
                if (data.currPageNo < data.totalPageCount) {
                    var $thred = $("<a href=\"javascript:;\" class='next'  id='" + (data.currPageNo + 1) + "'>下一页</a>");
                    var $last = $("<a href=\"javascript:;\" class='last'  id='" + data.totalPageCount + "'>末页</a>");
                    $div.append($thred).append("&nbsp;").append($last);   //添加到元素里面
                }
                var $go = $("<span style='float: right'><label>跳转至</label>\n" +
                    "\t<input type=\"text\" name=\"inputPage\" totalPage='" + data.totalPageCount + "' id=\"inputPage\" value='' class=\"page-key\" />页\n" +
                    "\t<button type=\"button\" class=\"page-btn\">GO</button>\n" +
                    "\t\t</span>");
                $div.append($go);
            }
        });
    }

    page(1);  //初始化页面的用户

    /**
     * 点击上下页来显示列表
     */
    $(".x_content").on("click",".last,.first,.pre,.next",function(){
        var pageNo=this.id;
        page(pageNo);
    })

    /**
     * 搜索的方法
     */
    $("#searchApp").click(function(){
        page(1);
    })


    //点击go去的页面
    $(".x_content").on("click",".page-btn",function(){
        var inputPage=$("#inputPage").val();
        var tatalPage= $("#inputPage").attr("totalPage");
        jump_to(inputPage,tatalPage);
    });

    //验证输入的是否合法
    function jump_to(num,totalPage){
        //alert(num);
        //验证用户的输入
        var regexp=/^[1-9]\d*$/;
        if(!regexp.test(num)){
            alert("请输入大于0的正整数！");
            return false;
        }else if((num-totalPage) > 0){
            alert("请输入小于总页数的页码");
            return false;
        }else{
            page(num);
        }
    }

});