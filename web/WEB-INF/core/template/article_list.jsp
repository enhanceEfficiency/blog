<%--
  Created by IntelliJ IDEA.
  User: G.Seinfeld
  Date: 2017/5/19
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title>文章列表页</title>
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
    <script src="gsein/js/sort-and-paginate.js"></script>
</head>
<body>
<!--导航条-->
<c:import url="navbar.jsp"/>
<div class="container">
    <div class="article_list col-xs-9 col-xs-offset-3">
        <div class="article_item">
            <div class="article_title">
                <h3>
                    <a>从 0 到 1 走进 Kaggle</a>
                </h3>
            </div>
            <div class="article_description small-font">
                <p>

                    本文结构：
                    - kaggle 是什么
                    - 如何参赛
                    - 解决问题一般步骤
                    - 进一步：
                    - 如何探索数据
                    - 如何构造特征
                    - 提交结果kaggle 是什么？Kaggle 是一个数据科学竞赛的平台，很多公司会发布一些接近真实业务的问题，吸引爱好数据科学的人来一起解决。
                    https://www.kaggle.com/点击导航栏的 competitions 可以看到有很多...
                </p>
            </div>
            <div class="article_manage ">
                <span class="link_postdate">2017-05-13 23:41</span>
                <span class="link_view" title="阅读次数"><a href="/aliceyangxi1987/article/details/71911003" title="阅读次数">阅读</a>(823)</span>
                <span class="link_comments" title="评论次数"><a href="/aliceyangxi1987/article/details/71911003#comments" title="评论次数">评论</a>(4)</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
