<%--
  Created by IntelliJ IDEA.
  User: yyy
  Date: 2017/3/29
  Time: 4:45
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
    <link rel="stylesheet" type="text/css" href="../css/settle.css">


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
                <%--<li><a href="#">首页</a></li>--%>
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
            <li><a href="/jsp/managerHome.jsp">待审批</a></li>
            <li><a href="#">支付结算</a></li>
            <li><a href="/jsp/managerStatistic.jsp">信息统计</a></li>
        </ul>
    </div>

    <div class="col-sm-9 col-md-10 main-content float-right ">
        <div class="sub-title">
            <h3>客栈结算</h3>
            <hr>
            <div class="col-sm-12">
                <div class="settle-title">
                    <div class="col-sm-2">编号</div>
                    <div class="col-sm-2">客栈编号</div>
                    <div class="col-sm-2">客栈名称</div>
                    <div class="col-sm-2">待处理金额</div>
                    <div class="col-sm-2">应结算</div>
                    <div class="col-sm-2">结算</div>
                </div>
                <div class="plan-body" id="settle-body-list">
                    <div class="settle-body-item">
                        <div class="col-sm-2 id">1</div>
                        <div class="col-sm-2 hostelSel">12345</div>
                        <div class="col-sm-2 hostelName">客栈名称</div>
                        <div class="col-sm-2 total">1000</div>
                        <div class="col-sm-2 toSettle">800</div>
                        <div class="col-sm-2">
                            <button class="btn btn-default my-btn btn-settle">结算</button>
                        </div>
                    </div>

                </div>

            </div>

            <div class="clearfix"></div>
            <h3>HostelWorld</h3>
            <hr>
            <div>
                <span class="settle-title" style="position:relative;left:20px;">账户余额：&nbsp&nbsp&nbsp&nbsp&nbsp</span>
                <span id="hostelAccount">1000</span>
            </div>

        </div>

    </div>

</div>


<script src="../plugin/jquery/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/managerSettle.js"></script>


</body>
</html>