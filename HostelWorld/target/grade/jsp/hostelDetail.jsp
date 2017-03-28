<%--
  Created by IntelliJ IDEA.
  User: yyy
  Date: 2017/3/27
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/icon.png">

    <title>plan</title>

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >

    <link rel="stylesheet" href="../plugin/datePicker/css/bootstrap-combined.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="../plugin/datePicker/css/bootstrap-datetimepicker.min.css">

    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/hostelReleasePlan.css">


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


</div>

<!--发布计划模态框-->
<div class="modal fade" id="release-plan" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title grey-color" >添加房间计划</h4>
            </div>
            <form action="/hostel/releasePlan/${hostelId}" method="post">
                <div class="modal-body">
                    <div>
                        <span class="modal-param">开始日期：</span>
                        <div class="input-append date my-date-picker">
                            <input type="text" name="startDate" />
                            <span class="add-on">
                                <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                            </span>
                        </div>
                    </div><br>
                    <div >
                        <span class="modal-param">结束日期：</span>
                        <div class="input-append date my-date-picker">
                            <input type="text" name="endDate" />
                            <span class="add-on">
                                <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                            </span>
                        </div>
                    </div><br>
                    <div >
                        <span class="modal-param">房间类型：</span>
                        <select  name="type">
                            <option>单人间</option>
                            <option>大床房</option>
                            <option>标准间</option>
                        </select>
                    </div><br>
                    <div >
                        <span class="modal-param">房间数量：</span>
                        <input type="text"  name="num">
                    </div><br>
                    <div >
                        <span class="modal-param">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp地址：</span>
                        <input type="text"  name="address">
                    </div><br>
                    <div >
                        <span class="modal-param">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp价格：</span>
                        <input type="text"  name="price">
                    </div><br>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-cancel" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary btn-confirm" data-dismiss="modal">添加</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="../plugin/jquery/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../plugin/datePicker/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">
    $('.my-date-picker').datetimepicker({
        format: 'yyyy-MM-dd hh:mm:ss',
        language: 'en',
        pickDate: true,
        pickTime: true,
        hourStep: 1,
        minuteStep: 15,
        secondStep: 30,
        inputMask: true
    })
</script>


</body>
</html>
