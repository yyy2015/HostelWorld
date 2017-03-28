<%--
  Created by IntelliJ IDEA.
  User: yyy
  Date: 2017/3/28
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="../img/icon.png">
    <title>userReserve</title>


    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/userInfo.css">

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
            <li><a href="/user/userInfo">基本信息</a></li>
            <li><a href="/jsp/userReserve.jsp">我的预约</a></li>
        </ul>
    </div>

    <div class="col-sm-9 col-md-10 main-content float-right ">
        <div class="sub-title">
            <h3>已预约</h3>
            <hr>
            <div class="col-sm-12">
                <div class="reserve-title">
                    <div class="col-sm-1">客栈名称</div>
                    <div class="col-sm-2">入住日期</div>
                    <div class="col-sm-2">退房日期</div>
                    <div class="col-sm-2">类型</div>
                    <div class="col-sm-1">房间数量</div>
                    <div class="col-sm-2">地址</div>
                    <div class="col-sm-1">支付</div>
                    <div class="col-sm-1">取消预订</div>
                </div>
                <div class="reserve-list" id="reserve-list">
                    <div class="reserve-item">
                        <div class="col-sm-1 hostelName">1</div>
                        <div class="col-sm-2 start">2017.10.20</div>
                        <div class="col-sm-2 end">2017.11.20</div>
                        <div class="col-sm-2 type">单人房</div>
                        <div class="col-sm-1 num">10</div>
                        <div class="col-sm-2 address">鼓楼，南京</div>
                        <div class="col-sm-1 payMoney">150</div>
                        <div class="col-sm-1">
                            <button class="btn btn-default my-btn reserve-cancel" data-toggle="modal" data-target="#cancelReserve" >
                                取消预订</button>
                        </div>
                    </div>
                    <div class="reserve-item">
                        <div class="col-sm-1 hostelName">1</div>
                        <div class="col-sm-2 start">2017.10.20</div>
                        <div class="col-sm-2 end">2017.11.20</div>
                        <div class="col-sm-2 type">单人房</div>
                        <div class="col-sm-1 num">10</div>
                        <div class="col-sm-2 address">鼓楼，南京</div>
                        <div class="col-sm-1 payMoney">150</div>
                        <div class="col-sm-1">
                            <button class="btn btn-default my-btn reserve-cancel" >
                                取消预订</button>
                        </div>
                    </div>
                    <div class="reserve-item">
                        <div class="col-sm-1 hostelName">1</div>
                        <div class="col-sm-2 start">2017.10.20</div>
                        <div class="col-sm-2 end">2017.11.20</div>
                        <div class="col-sm-2 type">单人房</div>
                        <div class="col-sm-1 num">10</div>
                        <div class="col-sm-2 address">鼓楼，南京</div>
                        <div class="col-sm-1 payMoney">150</div>
                        <div class="col-sm-1">
                            <button class="btn btn-default my-btn reserve-cancel" >
                                取消预订</button>
                        </div>
                    </div>

                </div>
            </div>

            <div class="clearfix"></div>
            <h3>已完成预约</h3>
            <hr>
            <div class="col-sm-12">
                <div class="reserve-title">
                    <div class="col-sm-1">客栈名称</div>
                    <div class="col-sm-2">入住日期</div>
                    <div class="col-sm-2">退房日期</div>
                    <div class="col-sm-2">类型</div>
                    <div class="col-sm-1">房间数量</div>
                    <div class="col-sm-2">地址</div>
                    <div class="col-sm-1">支付</div>
                    <div class="col-sm-1">取消预订</div>
                </div>
                <div class="reserve-list" id="finished-reserve-list">
                    <div class="finish-reserve-item">
                        <div class="col-sm-1 hostelName">1</div>
                        <div class="col-sm-2 start">2017.10.20</div>
                        <div class="col-sm-2 end">2017.11.20</div>
                        <div class="col-sm-2 type">单人房</div>
                        <div class="col-sm-1 num">10</div>
                        <div class="col-sm-2 address">鼓楼，南京</div>
                        <div class="col-sm-1 payMoney">150</div>
                        <div class="col-sm-1">
                            <button class="btn btn-default my-btn reserve-cancel"  >
                                已完成</button>
                        </div>
                    </div>

                </div>
            </div>


        </div>
    </div>
</div>

<!--取消预约模态框-->
<div class="modal fade" id="cancelReserve" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title grey-color">取消预订</h4>
            </div>
            <div class="modal-body">
                <div >
                    <span class="modal-param">取消预订后只能退还您一半的钱款，确认取消吗？</span>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn-cancel" data-dismiss="modal">不取消</button>
                <button type="button" class="btn btn-primary btn-confirm" id="confirmCancel" data-dismiss="modal" >确认取消</button>
            </div>
        </div>
    </div>
</div>



<script src="../plugin/jquery/jquery-3.1.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">

    var ReserveList = {
        init:function(){
            this.gridsFather = $("#reserve-list");
            this.lastGrid = $(".reserve-item").eq(0);
        },
        updateDate:function(reserveList){
            this.gridsFather.empty();
            var _this = this;
            $.each(reserveList,function(i,reserve){
                var tempGrid = _this.lastGrid.clone(true);
                tempGrid.find(".hostelName").eq(0).text(reserve.hostelName);
                tempGrid.find(".start").eq(0).text(reserve.startDate);
                tempGrid.find(".end").eq(0).text(reserve.endDate);
                tempGrid.find(".type").eq(0).text(reserve.room.type);
                tempGrid.find(".num").eq(0).text(reserve.num);
                tempGrid.find(".address").eq(0).text(reserve.room.address);
                tempGrid.find(".payMoney").eq(0).text(reserve.payMoney);

                $("#confirmCancel").click(function(){
                    $.get({
                        url:"/user/cancelReserve/"+reserve.id,
                        data:{
                            userId:${userId}
                        },
                        success:function(newList){
                            ReserveList.updateDate(newList);
                        },
                        error:function(){
                            console.log("cancel reserve failed!");
                        }
                    })
                })

                _this.gridsFather.append(tempGrid);

            })
        }
    }

    var FinishList = {
        init:function(){
            this.gridsFather = $("#finished-reserve-list");
            this.lastGrid = $(".finish-reserve-item").eq(0);
        },
        
    }

    $(document).ready(
            function(){
                ReserveList.init();
                $.get({
                    url:"/user/getReserve/"+${userId},
                    success:function(newList){
                        ReserveList.updateDate(newList);
                    },
                    error:function(){
                        console.log("get reserve list wrong!");
                    }
                })
            }
    )


</script>

</body>
</html>
