<%--
  Created by IntelliJ IDEA.
  User: G.Seinfeld
  Date: 2017/4/20
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <title>Flat UI Free 101 Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Loading Bootstrap -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI -->
    <link href="dist/css/flat-ui.min.css" rel="stylesheet">

    <link rel="shortcut icon" href="dist/img/favicon.ico">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="dist/js/vendor/html5shiv.js"></script>
    <script src="dist/js/vendor/respond.min.js"></script>

    <![endif]-->
</head>
<body>
<div class="container">
    <%--<h1>Hello, world!</h1>--%>
    <div class="input-group col-lg-5">
        <input type="text" class="form-control" placeholder="请输入用户名" id="search-query-3" />
        <span class="input-group-btn">
            <button type="submit" class="btn"><span class="fui-search"></span></button>
        </span>
    </div>
    <br/>
    <button class="btn btn-embossed btn-success">
        增加用户
    </button>
    <form id="viewform" method="post" action="UserManager.do">
        <input id="rowsPerPage" name="rowsPerPage" type="hidden" value="10"/>
        <input id="orderField" name="orderField" type="hidden" value="${orderField}"/>
        <input id="pageIndex" name="pageIndex" type="hidden" value="${currentPage}"/>
        <table class="table" id="listview">
            <tr>
                <th>用户名</th>
                <th>密码</th>
                <th>手机号码</th>
                <th>
                    <span class="orderable" orderColumn="point" orderType="">积分<span class="orderSign"></span></span>
                </th>
                <th><span class="orderable" orderColumn="register_time" orderType="">注册时间<span class="orderSign"></span></span></th>
                <th>操作</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.userAccount}</td>
                    <td>${user.password}</td>
                    <td>${user.mobileNumber}</td>
                    <td>${user.point}</td>
                    <td>${user.registerDate}</td>
                    <td>修改 删除</td>
                </tr>
            </c:forEach>
        </table>
        <div>
            <ul class="pagination">
                <li class="previous"><a href="#fakelink" class="fui-arrow-left"></a></li>
                <c:forEach begin="1" end="${pageNum}" step="1" var="i">
                    <li class="${currentPage==i?'active':''}"><a href="#fakelink">${i}</a></li>
                </c:forEach>
                <li class="next"><a href="#fakelink" class="fui-arrow-right"></a></li>
            </ul>
        </div>
    </form>

</div>
<!-- /.container -->


<!-- jQuery (necessary for Flat UI's JavaScript plugins) -->
<script src="dist/js/vendor/jquery.min.js"></script>
<script src="dist/js/vendor/jquery.form.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="dist/js/vendor/video.js"></script>
<script src="dist/js/flat-ui.min.js"></script>
<script src="gsein/js/sort-and-paginate.js"></script>
</body>
</html>
