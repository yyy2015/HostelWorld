<%--
  Created by IntelliJ IDEA.
  User: yyy
  Date: 2017/3/29
  Time: 6:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/icon.png">

    <title>UserInfo</title>

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/userInfo.css">
    <link rel="stylesheet" type="text/css" href="../css/statistic.css">


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
                <li><a href="#">首页</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="float-right"><a href="#">${sessionScope.username}</a></li>
                <li class="float-right"><a href="/user/logout">退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>



<div class="container main-part">
    <!--侧边栏-->
    <div class="col-sm-3 col-md-2 sidebar my-sidebar float-left">
        <ul class="nav nav-sidebar">
            <li><a href="#">待审批</a></li>
            <li><a href="#">支付结算</a></li>
            <li><a href="#">信息统计</a></li>
        </ul>
    </div>

    <div class="col-sm-9 col-md-10 main-content float-right ">
        <div class="sub-title">
            <h3>数据统计</h3>
            <hr>
            <div class="col-sm-12">
                <div id="hostel-money" class="my-chart"></div>
            </div>

            <div class="col-sm-12">
                <div id="hostel-money-bar" class="my-chart"></div>
            </div>

            <div class="col-sm-12">
                <div id="hostel-money-res" class="my-chart"></div>
            </div>

        </div>

    </div>

</div>


<script src="../plugin/jquery/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../plugin/highchart/highcharts.js"></script>
<script src="../plugin/highchart/exporting.js"></script>
<script src="../js/statistic.js"></script>


</body>
</html>
