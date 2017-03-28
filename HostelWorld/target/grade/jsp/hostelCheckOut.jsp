<%--
  Created by IntelliJ IDEA.
  User: yyy
  Date: 2017/3/29
  Time: 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN">
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/icon.png">

    <title>plan</title>

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >

    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/hostelReleasePlan.css">
    <!--<link rel="stylesheet" type="text/css" href="../css/noMemberCheckIn.css">-->


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
                <li class="float-right"><a href="#">${hostelSeq}</a></li>
                <li class="float-right"><a href="/user/logout">退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>



<div class="container main-part">
    <!--侧边栏-->
    <div class="col-sm-3 col-md-2 sidebar my-sidebar float-left">
        <ul class="nav nav-sidebar">
            <li><a href="/hostel/info/${hostelId}">客栈信息</a></li>
            <li><a href="#">发布计划</a></li>
            <li><a href="#">入店登记</a></li>
            <li><a href="#">离店登记</a></li>
            <li><a href="#">客栈统计</a></li>
        </ul>
    </div>

    <div class="col-sm-9 col-md-10 main-content float-right ">
        <div class="sub-title">
            <h3>退房登记</h3>
            <hr>
            <div class="col-sm-12 plan-list">
                <div class="plan-title">
                    <div class="col-sm-2">住客</div>
                    <div class="col-sm-2">入住日期</div>
                    <div class="col-sm-2">退房日期</div>
                    <div class="col-sm-2">房间类型</div>
                    <div class="col-sm-1">间数</div>
                    <div class="col-sm-2">地址</div>
                    <div class="col-sm-1">登记</div>
                </div>
                <div class="plan-body" id="plan-body-list">
                    <div class="plan-body-item">
                        <div class="col-sm-2 liverName">1</div>
                        <div class="col-sm-2 start">2017.10.20</div>
                        <div class="col-sm-2 end">2017.11.20</div>
                        <div class="col-sm-2 type">单人房</div>
                        <div class="col-sm-1 roomNum">间数</div>
                        <div class="col-sm-2 address">鼓楼，南京</div>
                        <div class="col-sm-1 ">
                            <button class="btn btn-default my-btn btn-checkOut">退房</button>
                        </div>

                    </div>

                </div>
            </div>
        </div>

    </div>

</div>

<script src="../plugin/jquery/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/hostelCheckOut.js"></script>
<script type="text/javascript">
    $(document).ready(
            function(){
                LiveList.init();
                $.get({
                    url:"/hostel/checkOutList/"+${hostelId},
                    success:function(newList){
                        LiveList.updateData(newList);
                    },
                    error:function(){
                        console.log("get check out list wrong!");
                    }

                })
            }
    )
</script>



</body>
</html>

