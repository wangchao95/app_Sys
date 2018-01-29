<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>401</title>
    <!-- Bootstrap -->
    <link href="/statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/statics/css/nprogress.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="/statics/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <!-- page content -->
        <div class="col-md-12">
          <div class="col-middle">
            <div class="text-center text-center">
              <h1 class="error-number">401</h1>
              <h2>访问失败</h2>
              <p>对不起，你没有访问权限,请先</p>
              <a href="/toDevLogin"><h3>登录开发者页面</h3></a>
              <a href="/toBackLogin"><h3>登录管理员页面</h3></a>

              <div class="mid_center">
                <h3>Search</h3>
                <form>
                  <div class="col-xs-12 form-group pull-right top_search">
                    <div class="input-group">
                      <input type="text" class="form-control" placeholder="Search for...">
                      <span class="input-group-btn">
                              <button class="btn btn-default" type="button">Go!</button>
                          </span>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
      </div>
    </div>
    <!-- jQuery -->
    <script src="/statics/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="/statics/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="/statics/js/fastclick.js"></script>
    <!-- NProgress -->
    <script src="/statics/js/nprogress.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="/statics/js/custom.min.js"></script>
  </body>
</html>