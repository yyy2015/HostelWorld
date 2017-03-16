<%--
  Created by IntelliJ IDEA.
  User: yyy
  Date: 2017/3/15
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
                <li class="float-right"><a href="#">sylvia</a></li>
                <li class="float-right"><a href="#">退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>



<div class="container main-part">
    <!--侧边栏-->
    <div class="col-sm-3 col-md-2 sidebar my-sidebar float-left">
        <ul class="nav nav-sidebar">
            <li><a href="#">基本信息</a></li>
            <li><a href="#">我的预约</a></li>
            <li><a href="#">信息统计</a></li>
        </ul>
    </div>

    <div class="col-sm-9 col-md-10 main-content float-right ">
        <div class="sub-title">
            <h3>基本信息</h3>
            <hr>
            <div class="basic-info col-sm-6 float-left">
                <ul class="info-list">
                    <li><span class="display-inline username">sylvia</span><span class="levelTag">普通</span></li>
                    <li> <span class="tag">状态:&nbsp&nbsp&nbsp</span><span class="value">未激活<span class="hint">(会员激活请首次充值1000元以上)</span></span></li>
                    <li> <span class="tag">账户余额:&nbsp&nbsp&nbsp</span><span class="value">0
                        <button class="btn btn-default my-btn" data-toggle="modal" data-target="#top-up">充值</button></span>
                    </li>
                    <li> <span class="tag">积分:&nbsp&nbsp&nbsp</span><span class="value">0
                        <button class="btn btn-default my-btn" data-toggle="modal" data-target="#change">兑换</button></span>
                    </li>
                    <li> <span class="tag">会员卡号:&nbsp&nbsp&nbsp</span><span class="value">1234567</span> </li>
                    <li> <span class="tag">银行账户:&nbsp&nbsp&nbsp</span><span class="value">1234567</span> </li>
                </ul>
            </div>
            <div class="operation col-sm-3 float-right">
                <button class="btn btn-default my-btn my-btn-large display-block" data-toggle="modal" data-target="#modify">修改密码</button><br>
                <button class="btn btn-default my-btn my-btn-large display-block" data-toggle="modal" data-target="#stop-member">停用会员</button>

            </div>

        </div>

        <div class="clearfix"></div>
        <div class="sub-title">
            <h3>消费记录</h3>
            <hr>
            <div class="record-part">
                <div class="record-title">
                    <div class="col-sm-3">日期</div>
                    <div class="col-sm-6">明细</div>
                    <div class="col-sm-3">金额</div>
                </div>
                <div class="record-list">
                    <div class="record-list-item ">
                        <div class="col-sm-3">2017-3-15</div>
                        <div class="col-sm-6">预订两间酒店大床非常棒预订两间酒店大床非常棒预订两间酒店大床非常棒</div>
                        <div class="col-sm-3">-1500</div>
                    </div>
                    <div class="record-list-item ">
                        <div class="col-sm-3">2017-3-15</div>
                        <div class="col-sm-6">预订两间酒店大床非常棒预订两间酒店大床非常棒预订两间酒店大床非常棒</div>
                        <div class="col-sm-3">-1500</div>
                    </div>
                </div>

            </div>


        </div>

    </div>

</div>

<!--充值模态框-->
<div class="modal fade" id="top-up" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title grey-color" >充值</h4>
            </div>
            <div class="modal-body">
                <div >
                    <span class="modal-param">充值金额：</span>
                    <input type="text" class="param-text">
                    <span class="common">元</span>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-cancel" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary btn-confirm" data-dismiss="modal">充值</button>
            </div>
        </div>
    </div>
</div>
<!--兑换模态框-->
<div class="modal fade" id="change" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title grey-color">积分兑换</h4>
            </div>
            <div class="modal-body">
                <div >
                    <span class="modal-param">积分：</span>
                    <input type="text" class="param-text">
                    <span class="hint">(每10分可兑换一元)</span>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-cancel" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary btn-confirm" data-dismiss="modal">兑换</button>
            </div>
        </div>
    </div>
</div>
<!--修改密码模态框-->
<div class="modal fade" id="modify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title grey-color">修改密码</h4>
            </div>
            <div class="modal-body">
                <div >
                    <span class="modal-param">请输入新密码：</span>
                    <input type="text" class="param-text">
                </div>
                <div >
                    <span class="modal-param">请确认新密码：</span>
                    <input type="text" class="param-text">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-cancel" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary btn-confirm" data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>
<!--停用会员模态框-->
<div class="modal fade" id="stop-member" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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