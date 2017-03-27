<%@ page import="edu.nju.hostelworld.model.Hostel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/icon.png">

    <title>UserInfo</title>

    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/userInfo.css">


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
            <li><a href="#">客栈信息</a></li>
            <li><a href="#">发布计划</a></li>
            <li><a href="#">入店登记</a></li>
            <li><a href="#">离店登记</a></li>
            <li><a href="#">客栈统计</a></li>
        </ul>
    </div>

    <div class="col-sm-9 col-md-10 main-content float-right ">
        <div class="sub-title">
            <h3>客栈信息</h3>
            <hr>
            <div class="basic-info col-sm-6 float-left">
                <ul class="info-list">
                    <li><span class="display-inline username">${hostel.hostelName}</span></li>
                    <li> <span class="tag">状态:&nbsp&nbsp&nbsp</span>
                        <%switch(((Hostel)request.getAttribute("hostel")).getStatus()){
                            case 0: out.print("<span class='value my-yellow'>申请审批中</span>");break;
                            case 1: out.print("<span class='value my-blue'>申请已通过</span>");break;
                            case 2: out.print("<span class='value my-red'>申请已拒绝</span>");break;
                        }%></li>
                    <li> <span class="tag">账户余额:&nbsp&nbsp&nbsp</span><span class="value">${hostel.balance}</span></li>
                    <li> <span class="tag">客栈主人:&nbsp&nbsp&nbsp</span><span class="value">${hostel.host}</span></li>
                    <li> <span class="tag">客栈序列号:&nbsp&nbsp&nbsp</span><span class="value">${hostel.hostelSeq}</span> </li>
                    <li> <span class="tag">银行账户:&nbsp&nbsp&nbsp</span><span class="value">${hostel.bankAccount}</span></li>
                    <li> <span class="tag">客栈描述:&nbsp&nbsp&nbsp</span><span class="value">${hostel.description}</span></li>
                </ul>
            </div>
            <div class="operation col-sm-3 float-right">
                <button class="btn btn-default my-btn my-btn-large display-block" data-toggle="modal" data-target="#modify">修改信息</button><br>
            </div>

        </div>

        <div class="clearfix"></div>

    </div>

</div>

<!--修改信息模态框-->
<div class="modal fade" id="modify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title grey-color">修改客栈信息</h4>
            </div>
            <form action="/hostel/modifyInfo" method="post">
                <div class="modal-body">
                    <div >
                        <span class="modal-param">客栈主人：</span>
                        <input type="text" class="param-text" name="host" value="${hostel.host}" >
                    </div><br>
                    <div >
                        <span class="modal-param">客栈名称：</span>
                        <input type="text" class="param-text" name="hostelName" value="${hostel.hostelName}" >
                    </div><br>
                    <div >
                        <span class="modal-param">银行账户：</span>
                        <input type="text" class="param-text" name="bankAccount" value="${hostel.bankAccount}">
                    </div><br>
                    <div >
                        <span class="modal-param">客栈描述：</span>
                        <textarea type="text" style="width:400px;height:100px;"  name="description" >${hostel.description}</textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-cancel" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary btn-confirm" >提交修改</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--关闭客栈模态框-->
<div class="modal fade" id="stop-hostel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title grey-color">停用会员</h4>
            </div>
            <div class="modal-body">
                <div >
                    <span class="modal-param">停用会员将清空您的所有信息，确认停用吗？</span>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-cancel" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary btn-confirm" data-dismiss="modal">确认</button>
            </div>
        </div>
    </div>
</div>

<script src="../plugin/jquery/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>


</body>
</html>