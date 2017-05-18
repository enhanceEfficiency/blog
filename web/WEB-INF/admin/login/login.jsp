<%--
  Created by IntelliJ IDEA.
  User: G.Seinfeld
  Date: 2017/5/17
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>博客后台登录</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="dist/css/flat-ui.min.css" rel="stylesheet">

    <link href="gsein/css/common.css" rel="stylesheet">

    <link rel="shortcut icon" href="dist/img/favicon.ico">



    <!-- HTML5 shim, for IE6-8 support of HTML5 elements.  -->
    <!--[if lt IE 9]>
    <script src="dist/js/vendor/html5shiv.js"></script>
    <script src="dist/js/vendor/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
    <script src="dist/js/vendor/jquery.min.js"></script>
    <script src="dist/js/vendor/jquery.form.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="dist/js/vendor/video.js"></script>
    <script src="dist/js/flat-ui.min.js"></script>

    <script src="gsein/js/check_login.js"></script>
</head>
<body>
<div class="container">
    <div class="login-heading text-center">
        <div id="messageBox" class="alert alert-danger hide"><button data-dismiss="alert" class="close">×</button>
            <label id="loginError" class="has-error"></label>
        </div>

    </div>
    <h3 class="blue text-center">博客后台登录</h3>
    <div class="panel panel-default login-panel">
        <div class="panel-body">
            <div class="form">
                <form role="form">
                    <div class="form-group"><input class="form-control" type="text" name="userAccount" placeholder="登录名"></div>
                    <div class="form-group"><input class="form-control" type="text" name="password" placeholder="密码"></div>
                    <div class="form-group">
                        <button class="btn btn-primary horizontal" type="submit">登录</button>
                        <span class="small-font horizontal"><input type="checkbox"><label  class="horizontal">记住我（公共场所慎用）</label></span>
                    </div>
                </form>

            </div>

        </div>
    </div>
</div>


</body>
</html>
