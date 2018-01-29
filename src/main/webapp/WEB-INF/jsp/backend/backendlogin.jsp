<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>后台管理系统</title>

    <!-- Bootstrap -->
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/statics/css/nprogress.css" rel="stylesheet">
        <!-- Custom Theme Style -->
    <link href="/statics/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="" method="post" id="backForm">
              <h1>后台管理系统</h1>
              <div>
                <font style="color: red" id="message"></font>
                <input type="text" id="userCode" class="form-control" name="userCode" placeholder="请输入用户名" required="required" />
              </div>
              <div>
                <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="请输入密码" required="required" />
              </div>
              <span>${error }</span>
              <div>
                <input type="button" id="backSubmit" class="btn btn-success" value="登  录"/>
                <input type="reset" class="btn btn-default" value="重  填"/>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <div>
                  <p>&copy;2018 All Rights Reserved.</br>
                    Author Lanhaifeng in shenzhen xinshi School!
                  </p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/jquery-form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/localjs/backend/backLogin.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/common.js"></script>