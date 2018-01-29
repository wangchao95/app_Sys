<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2>修改最新版本信息</h2>
            <ul class="nav navbar-right panel_toolbox">
              <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
              </li>
            </ul>
          <div class="clearfix"></div>
        </div>
        <div class="x_content" style="display: block;">
         <br>
            <%--提示信息--%>
            <font style="color: red;" id="message"></font>
        <form class="form-horizontal form-label-left" id="editUserForm" action="" method="post" enctype="multipart/form-data">
           <input type="hidden" name="id" id="id" value="${devUser.id}">
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">编码 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input class="form-control col-md-7 col-xs-12" value="${dUser.devCode }"
              type="text" id="devCode" name="devCode" readonly="readonly">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">用户名<span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" id="devName" name="devName" value="${dUser.devName }"  required="required"
               class="form-control col-md-7 col-xs-12">
            </div>
          </div>
       
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="devPassword">密码 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="password" name="devPassword" id="devPassword" value="${dUser.devPassword}" class="form-control col-md-7 col-xs-12"/>
            </div>
          </div>

            <div class="item form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="devEmail">邮箱 <span class="required">*</span></label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="email" name="devEmail" id="devEmail" value="${dUser.devEmail}" class="form-control col-md-7 col-xs-12"/>
                </div>
            </div>
            <div class="item form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12"  for="devInfo">开发者信息 <span class="required">*</span></label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" name="devInfo" id="devInfo" value="${dUser.devInfo}" class="form-control col-md-7 col-xs-12"/>
                </div>
            </div>
			<div id="apkFile"></div>
			${fileUploadError }
            </div>
          </div>
          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="sendEditUser" type="button" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" onclick="javascript:history.back()" id="back">返回</button>
            </div>
          </div>
          <div class="clearfix"></div>
          <br/><br/>
        </form>
        </div>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/deve/editDevUser.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/jquery-form.js"></script>