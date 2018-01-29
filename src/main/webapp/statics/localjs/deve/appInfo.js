jQuery.noConflict();
jQuery(document).ready(function($){
    /**
     * 到添加版本的页面
     */
    $("#tableInfo").on("click",".addVerison",function(){
        var obj = $(this);
        location.href="/sys/appInfo/toAddVersion/"+ obj.attr("aid");
    })

    /**
     * 到新增APP页面
     */
    $(".btn-lg").click(function(){
        location.href="/sys/appInfo/toAddApp";
    })

    /**
     * 到修改App的页面
     */
    $("#tableInfo").on("click",".editApp",function(){
            var obj = $(this);
            var status = obj.attr("status");
            if (status == "1" || status == "3") {//待审核、审核未通过状态下才可以进行修改操作
                location.href="/sys/appInfo/toEditApp/"+ obj.attr("aid");
            } else {
                alert("该APP应用的状态为：【" + obj.attr("statusName") + "】,不能修改！");
            }
    });


    /**
     * 到修改App最新版本页面
     */
    $("#tableInfo").on("click",".editVerison",function(){
        var versionId=$(this).attr("versionId");
        var statusName=$(this).attr("sta");
        if(versionId==null||versionId==""||versionId=="0"){
            alert("此APP软件站务版本，请先增加版本！");
            return;
        }
        if(statusName=="审核通过"||statusName=="已上架"
        ||statusName=="已下架"){
            alert("此APP软件的状态为"+statusName+"占时不能修改");
            return;
        }
        var obj = $(this);
        location.href="/sys/appInfo/toEditVersion/"+ obj.attr("aid");
    })

    /**
     * 到查看app信息和版本的页面
     */
    $("#tableInfo").on("click",".appView",function(){
        location.href="/sys/appInfo/toAppView/"+ $(this).attr("aid");

    });


    /**
     * 上下架操作
     */
    $(document).on("click", ".openApp,.downApp", function () {
        var obj = $(this);
        var appinfoid = obj.attr("aid");
        var saleSwitch = obj.attr("saleSwitch");
        if ("open" === saleSwitch) {
            if(obj.attr("statusName")==="已下架"||obj.attr("statusName")==="审核通过"){
                saleSwitchAjax(appinfoid, obj);
            }else{
                alert("你的应用程序【" + obj.attr("name") + "】不是下架状态或者审核通过状态，不能上架");
            }

        }else if ("close" === saleSwitch) {
            if(obj.attr("statusName")==="已上架"){
                if (confirm("你确定要下架您的APP应用【" + obj.attr("name") + "】吗？")) {
                    saleSwitchAjax(appinfoid, obj);
                }
            }else{
                alert("你的应用程序【" + obj.attr("name") + "】不是上架状态，不能下架");
            }
        }
    });

    var saleSwitchAjax = function (appId,obj) {
        $.ajax({
            type: "post",
            url: "/sys/appInfo/openOrCloseApp",
            data:{option:obj.attr("saleSwitch"),aid:appId},//请求参数
            dataType: "json",
            success: function (data) {
                if (data ===1) {
                    if ("open" === obj.attr("saleSwitch")) {
                        alert("上架成功啦");
                        page(obj.attr("pageIndex"));
                    }else if ("close" === obj.attr("saleSwitch")) {
                        alert("下架成功啦");
                        page(obj.attr("pageIndex"));
                    }
                }else{
                    if ("open" === obj.attr("saleSwitch")) {
                        alert("上架失败啦");
                    }else if ("close" === obj.attr("saleSwitch")) {
                        alert("下架失败啦");
                    }
                }
            }
        });
    };





    /**
     * 到查看app信息和版本的页面
     */
    $("#tableInfo").on("click",".delAppInfo",function(){
        var name=$(this).attr("name");
        var index=$(this).attr("pageIndex");
        if(confirm("确定要删除"+name+"及其所有的版本吗？"))
            var data="id="+$(this).attr("aid");
        $.post("/sys/appInfo/delAppInfo",data,function(data){
            if (data ==1) {//删除成功：移除删除行
                alert("删除成功");
                page(index);
            } else if (data==-1) {//删除失败
                alert("对不起，删除AAP应用【" + name + "】失败");
            } else if (data==0) {
                alert("对不起，APP应用【" + name + "】不存在");
            }
        });
    });


    /**
     * 分页的方法
     */
    function page(pageNo) {
        $("#searchForm").ajaxSubmit({
            type: 'post',
            url: "/sys/appInfo/appListPage",
            data:{pageIndex:pageNo},
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (data) {
                var appList=data.newPage;  //获得页的集合
                $("#tableInfo").html("");
                $(".page").remove();
                $("#tableInfo").append("<tr class=\"firstTr\" style='background-color: #00aeef'>\n" +
                    "<th width=\"10%\">软件名称</th>\n" +
                    "<th width=\"15%\">APK名称</th>\n" +
                    "<th width=\"5%\">软件大小(单位:M)</th>\n" +
                    "<th width=\"5%\">所属平台</th>\n" +
                    "<th width=\"15%\">所属分类(一级，二级，三级)</th>\n" +
                    "<th width=\"8%\">状态</th>\n" +
                    "<th width=\"6%\">下载次数</th>\n" +
                    "<th width=\"8%\">最新版本</th>\n" +
                    "<th width=\"15%\">操作</th>\n" +
                    "</tr>");
                //循环遍历集合
                for(var i=0;i<appList.length;i++){
                    var app=appList[i];
                    var statusName=app.statusName;
                    $("#tableInfo").append("<tr><td><span>"+app.softwareName+"</span></td><td><span>"+app.aPKName+"</span></td> <td><span>"+app.softwareSize+"</span></td><td><span>"+app.flatformName+"</span></td>" +
                        "<td><span>"+app.categoryLevel1Name+"--"+app.categoryLevel2Name+"--"+app.categoryLevel3Name+"</span></td><td><span>"+statusName+"</span></td><td><span>"+app.downloads+"</span></td><td><span>"+app.versionNo+"</span></td>"+
                        "<td><div class=\"btn-group\">\n" +
                        "            <button type=\"button\" class=\"btn btn-danger\">点击操作</button>\n" +
                        "            <button type=\"button\" class=\"btn btn-danger dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n" +
                        "              <span class=\"caret\"></span>\n" +
                        "              <span class=\"sr-only\">Toggle Dropdown</span>\n" +
                        "            </button>\n" +
                        "            <ul class=\"dropdown-menu\" role=\"menu\">\n" +
                        "              <li><a href=\"javascript:;\" class='downApp' pageIndex='"+pageNo+"' name='"+app.softwareName+"' statusName='"+app.statusName+"' saleSwitch='close' aid='"+app.id+"'>下架</a>\n" +
                        "              </li>\n" +
                        "              <li><a href=\"javascript:;\" class='addVerison' aid='"+app.id+"'>新增版本</a>\n" +
                        "              <li><a href=\"javascript:;\" sta='"+statusName+"' versionId='"+app.versionId+"' class='editVerison' aid='"+app.id+"'>修改最新版本</a>\n" +
                        "              </li>\n" +
                        "              <li><a href=\"javascript:;\" class='openApp' pageIndex='"+pageNo+"' name='"+app.softwareName+"' statusName='"+app.statusName+"' saleSwitch='open' aid='"+app.id+"'>上架</a>\n" +
                        "              </li>\n" +
                        "              </li>\n" +
                        "              <li><a href=\"javascript:;\" class='editApp' statusName='"+app.statusName+"' status='"+app.status+"' aid='"+app.id+"'>修改</a>\n" +
                        "              </li>\n" +
                        "              </li>\n" +
                        "              <li><a href=\"javascript:;\" class='appView' aid='"+app.id+"'>查看</a>\n" +
                        "              </li>\n" +
                        "              <li class=\"divider\"></li>\n" +
                        "              <li><a href=\"javascript:;\" class='delAppInfo' aid='"+app.id+"' name='"+app.softwareName+"' pageIndex='"+pageNo+"'>删除</a>\n" +
                        "              </li>\n" +
                        "            </ul>\n" +
                        "          </div></td></tr>");
                }
                var $div=$("<div class='page'></div>").appendTo($(".table-responsive"));
                var $operArea=$("<p align='center'>共"+data.totalCount+"条记录&nbsp;&nbsp;&nbsp;当前页数:["+data.currPageNo+"/"+data.totalPageCount+"]&nbsp;</p>").appendTo($div);
                if(data.currPageNo>1){
                    var $first=$("<a href=\"javascript:;\" id='1' class=\"first\" >首页</a>");
                    var $perv=$("<a href=\"javascript:;\" class='pre' id='"+(data.currPageNo-1)+"'>上一页</a>");
                    $div.append($first).append("&nbsp;").append($perv);   //添加到元素里面
                }
                //如果当前页数小于总页数
                if(data.currPageNo<data.totalPageCount){
                    var $thred=$("<a href=\"javascript:;\" class='next'  id='"+(data.currPageNo+1)+"'>下一页</a>");
                    var $last=$("<a href=\"javascript:;\" class='last'  id='"+data.totalPageCount+"'>末页</a>");
                    $div.append($thred).append("&nbsp;").append($last);   //添加到元素里面
                }
                var $go=$("<span style='float: right'><label>跳转至</label>\n" +
                    "\t<input type=\"text\" name=\"inputPage\" totalPage='"+data.totalPageCount+"' id=\"inputPage\" value='' class=\"page-key\" />页\n" +
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
    $(".right_col").on("click",".last,.first,.pre,.next",function(){
        var pageNo=this.id;
        page(pageNo);
    })

    /**
     * 搜索的方法
     */
    $(".btn-sm").click(function(){
        page(1);
    })


    //点击go去的页面
    $(".right_col").on("click",".page-btn",function(){
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