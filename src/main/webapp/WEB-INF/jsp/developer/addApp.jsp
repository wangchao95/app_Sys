<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<link href="/statics/css/dropzone.min.css" rel="stylesheet">
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>新增APP基础信息 <i class="fa fa-user"></i><small>${devUser.devName}</small></h2>
             <div class="clearfix"></div>
      </div>
      <div class="x_content">
           <div class="clearfix"></div>
        <%--提示消息--%>
        <font style="color: red;" id="message"></font>
        <form class="form-horizontal form-label-left" id="addAppInfo" action="" name="addAppInfo" enctype="multipart/form-data" method="post">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="appName">软件名称<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="appName" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="softwareName" placeholder="请输入软件名称" required="required" type="text">
            </div>
            <%--<font style="color: red">r3wre3</font>--%>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="apkName">APK名称<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="apkName" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="APKName" placeholder="请输入APK名称" required="required" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="rom">支持ROM<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="rom" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="supportROM" placeholder="请输入支持的ROM" required="required" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="viewLanguage">界面语言<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="viewLanguage" class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" name="interfaceLanguage" placeholder="请输入支持的界面语言" required="required" type="text">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="appSize">软件大小 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="appSize" name="softwareSize" onkeyup="value=value.replace(/[^\d]/g,'')" required="required" data-validate-minmax="10,500" aria-placeholder="请输入软件大小" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="loadCount">下载次数 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="number" id="loadCount" name="downloads" required="required" data-validate-minmax="10,10000000" aria-placeholder="请输入软件下载次数" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="item form-group">
            <label for="flatformId" class="control-label col-md-3 col-sm-3 col-xs-12">所属平台</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select id="flatformId" name="flatformId" class="form-control" required="required">

              </select>
            </div>
          </div>
          <div class="item form-group">
            <label for="categoryLevel1" class="control-label col-md-3 col-sm-3 col-xs-12">一级分类</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select id="categoryLevel1" name="categoryLevel1" class="form-control"  required="required">

              </select>
            </div>
          </div>
          <div class="item form-group">
            <label for="categoryLevel2" class="control-label col-md-3 col-sm-3 col-xs-12">二级分类</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select id="categoryLevel2" name="categoryLevel2" class="form-control" required="required">
                <option value="0">--请选择--</option>
              </select>
            </div>
          </div>
          <div class="item form-group">
            <label for="categoryLevel3" class="control-label col-md-3 col-sm-3 col-xs-12">三级分类</label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select id="categoryLevel3" name="categoryLevel3" class="form-control" required="required">
                <option value="0">--请选择--</option>
              </select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="status">APP状态 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="status" readonly="readonly">
                <option value="1">待审核</option>
              </select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">应用简介<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <textarea id="appInfo" required="required" placeholder="请输入本软件的相关信息" name="appInfo" class="form-control col-md-7 col-xs-12"></textarea>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="file">LOGO图片<span class="required">*</span>

            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="file" id="logoPic" name="logoPic"  required="required"  class="form-control col-md-7 col-xs-12">
              <font style="color: red"></font>
            </div>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button type="button" class="btn btn-primary" id="addApp">保存</button>
              <button id="send" type="button" class="btn btn-success" onclick="javascript:history.back()">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/deve/appinfoadd.js"></script>
