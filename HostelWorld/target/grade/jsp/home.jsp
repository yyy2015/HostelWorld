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
    <link rel="stylesheet" type="text/css" href="../css/hostelList.css">
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
                <li><a href="/jsp/home.jsp">首页</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="float-right"><a href="/user/userInfo">${sessionScope.username}</a></li>
                <li class="float-right"><a href="/user/logout">退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container main-part">
    <div class="col-sm-12" id="hostel-list">
        <div class="col-sm-3 hostel-list-item">
            <h3 class="hostelName">客栈名称</h3>
            <span class="tag">地址：<span class="value address">汉口路22号，鼓楼区，南京</span></span>
            <p class="description">&nbsp&nbsp&nbsp&nbsp这是一段描述这是一段描述这是一段描述这是一段描述这是一段描述</p>
            <span class="tag">掌柜：<span class="value host">阿袁</span></span>
            <a class="btn btn-default my-btn detail">查看详情</a>
        </div>
    </div>

</div>
<script src="../plugin/jquery/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/home.js"></script>


</body>
</html>
