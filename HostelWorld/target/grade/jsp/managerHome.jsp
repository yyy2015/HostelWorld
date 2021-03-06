<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/icon.png">

    <title>UserInfo</title>

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/userInfo.css">
    <link rel="stylesheet" type="text/css" href="../css/manager.css">


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
            <li><a href="#">待审批</a></li>
            <li><a href="/jsp/managerSettle.jsp">支付结算</a></li>
            <li><a href="/jsp/managerStatistic.jsp">信息统计</a></li>
        </ul>
    </div>

    <div class="col-sm-9 col-md-10 main-content float-right ">
        <div class="sub-title">
            <h3>待审批申请</h3>
            <hr>
            <div class="col-sm-12" id="application-list">
                <div class="application-list-item">
                    <div class="info-part float-left col-sm-10">
                        <h4 class="hostelName">客栈名称</h4>
                        <span class="tag">序列号：<span class="value seq">1234567</span></span>
                        <span class="tag">银行账户：<span class="value bankAccount">1234567</span></span>
                        <span class="tag">客栈地址：<span class="value address">南京大学鼓楼校区</span></span>
                        <p class="description">&nbsp&nbsp&nbsp&nbsp这是一段客栈描述这是一段客栈描述这是一段客栈描述这是一段客栈描述这是一段客栈描述这是一段客栈描述
                            这是一段客栈描述这是一段客栈描述这是一段客栈描述</p>
                        <span class="tag">申请人：<span class="value host">yyy</span></span>
                    </div>
                    <div class="operation-part float-right col-sm-2">
                        <button class="btn btn-default my-btn approve">同意</button>
                        <button class="btn btn-default my-btn refuse">拒绝</button>
                    </div>
                </div>

            </div>

        </div>

        <div class="clearfix"></div>

    </div>

</div>


<script src="../plugin/jquery/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/manageApplication.js"></script>


</body>
</html>