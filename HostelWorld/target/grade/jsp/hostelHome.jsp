<%--
  Created by IntelliJ IDEA.
  User: yyy
  Date: 2017/3/14
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="icon" href="../img/icon.png">

    <title>Hostel world</title>

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<!--导航栏-->
<nav class="navbar navbar-inverse navbar-fixed-top my-nav">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img class="my-logo" src="../img/h-logo.png">
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="home.jsp">首页</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="float-right"><a href="#">${sessionScope.hostelSeq}</a></li>
                <li class="float-right"><a href="/user/logout">退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>


</body>
</html>
