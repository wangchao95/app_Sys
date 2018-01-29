<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<!-- page content -->
<p style="font-size: 18px;">APP信息管理维护,
            <img src="/statics/images/user.png" width="20" height="20" />
            <span style="font-size: 14px;">${devUser.devName}-您可以通过搜索或其他筛选选项对APP进行修改、删除操作。^_^</span>
          </p>
          <hr/>
          <form class="form-horizontal form-label-left input_mask" method="post" enctype="multipart/form-data" id="searchForm">
            <label class="control-label col-md-2">软件名称</label>
            <div class="col-xs-3 col-xs-3 col-xs-2 form-group has-feedback">
              <input type="text" class="form-control has-feedback-left" id="appName" name="softwareName">
            </div>
            <label class="control-label col-md-2">AAP状态</label>
            <div class="col-xs-3 col-xs-3 col-xs-2 form-group has-feedback">
              <select class="select2_single form-control" tabindex="-1" id="appStatus" name="status">

              </select>
            </div>
            <label class="control-label col-md-2">所属平台</label>
            <div class="col-xs-3 col-xs-3 col-xs-2 form-group has-feedback">
              <select class="select2_single form-control" tabindex="-1" id="appTerrace" name="flatformId">

              </select>
            </div>
            <label class="control-label col-md-2">一级分类</label>
            <div class="col-xs-3 col-xs-3 col-xs-2 form-group has-feedback">
              <select class="select2_single form-control" tabindex="-1" id="firstCate" name="categoryLevel1">

              </select>
            </div>
            <label class="control-label col-md-2">二级分类</label>
            <div class="col-xs-3 col-xs-3 col-xs-2 form-group has-feedback">
              <select class="select2_single form-control" tabindex="-1" id="secondCate" name="categoryLevel2">
                  <option value="0">--请选择--</option>
              </select>
            </div>
            <label class="control-label col-md-2">三级分类</label>
            <div class="col-xs-3 col-xs-3 col-xs-2 form-group has-feedback">
              <select class="select2_single form-control" tabindex="-1" id="threeCate" name="categoryLevel3">
                  <option value="0">--请选择--</option>
              </select>
            </div>
            <div class="ln_solid"></div>
            <div class="form-group">
              <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-1">
                <button type="button" class="btn btn-success btn-sm">查询</button>
              </div>
            </div>
          </form>
        </div>


      <%--table开始--%>
      <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
          <div class="x_title">
            <button type="button" class="btn btn-info btn-lg">新增APP基础信息</button>
          </div>

          <div class="x_content">
              <%--动态加载的table--%>
              <div class="table-responsive">
                <table class="table table-striped jambo_table bulk_action" id="tableInfo">

                </table>
              </div>
          </div>
        </div>
      </div>
      <%--table结束--%>


<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/deve/appinfolist.js"></script>
<script src="/statics/localjs/deve/appInfo.js"></script>