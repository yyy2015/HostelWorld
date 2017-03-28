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
    <link rel="icon" href="/img/icon.png">

    <title>plan</title>

    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" >

    <link rel="stylesheet" href="/plugin/datePicker/css/bootstrap-combined.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="/plugin/datePicker/css/bootstrap-datetimepicker.min.css">

    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/hostelReleasePlan.css">
    <link rel="stylesheet" type="text/css" href="/css/hostelDetail.css">


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
            <img class="my-logo" src="/img/h-logo.png">
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/jsp/home.jsp">首页</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="float-right"><a href="/user/userInfo">${username}</a></li>
                <li class="float-right"><a href="/user/logout">退出登录</a></li>
            </ul>
        </div>
    </div>
</nav>



<div class="container main-part">
    <h3>客栈名称</h3>
    <hr>
    <div class="col-sm-12">
        <div class="plan-title">
            <div class="col-sm-1">编号</div>
            <div class="col-sm-2">开始日期</div>
            <div class="col-sm-2">结束日期</div>
            <div class="col-sm-1">类型</div>
            <div class="col-sm-1">剩余</div>
            <div class="col-sm-2">地址</div>
            <div class="col-sm-2">价格</div>
            <div class="col-sm-1">预订</div>
        </div>
        <div class="plan-body" id="room-list">
            <div class="plan-body-item">
                <div class="col-sm-1 no">1</div>
                <div class="col-sm-2 start">2017.10.20</div>
                <div class="col-sm-2 end">2017.11.20</div>
                <div class="col-sm-1 type">单人房</div>
                <div class="col-sm-1 num">10</div>
                <div class="col-sm-2 address">鼓楼，南京</div>
                <div class="col-sm-2 "><span class="price">100</span>/每晚</div>
                <div class="col-sm-1">
                    <button class="btn btn-default my-btn reserve" data-toggle="modal" data-target="#reserve-room" >
                        预订</button>
                </div>
            </div>
            <div class="plan-body-item">
                <div class="col-sm-1 no">1</div>
                <div class="col-sm-2 start">2017.10.20</div>
                <div class="col-sm-2 end">2017.11.20</div>
                <div class="col-sm-1 type">单人房</div>
                <div class="col-sm-1 num">10</div>
                <div class="col-sm-2 address">鼓楼，南京</div>
                <div class="col-sm-2 "><span class="price">100</span>/每晚</div>
                <div class="col-sm-1"><a class="btn btn-default my-btn reserve">预订</a></div>
            </div>
            <div class="plan-body-item">
                <div class="col-sm-1 no">1</div>
                <div class="col-sm-2 start">2017.10.20</div>
                <div class="col-sm-2 end">2017.11.20</div>
                <div class="col-sm-1 type">单人房</div>
                <div class="col-sm-1 num">10</div>
                <div class="col-sm-2 address">鼓楼，南京</div>
                <div class="col-sm-2 "><span class="price">100</span>/每晚</div>
                <div class="col-sm-1"><a class="btn btn-default my-btn reserve">预订</a></div>
            </div>
        </div>
    </div>


</div>

<!--预订客房模态框-->
<div class="modal fade" id="reserve-room" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title grey-color" >预订房间</h4>
            </div>
            <form action="/user/reserve/${userId}" method="post">
                <div class="modal-body">
                    <div>
                        <span class="modal-param">入住日期：</span>
                        <div class="input-append date my-date-picker">
                            <input type="text" name="startDate" id="startDate" />
                            <span class="add-on">
                                <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                            </span>
                        </div>
                    </div><br>
                    <div >
                        <span class="modal-param">退房日期：</span>
                        <div class="input-append date my-date-picker">
                            <input type="text" name="endDate" id="endDate" />
                            <span class="add-on">
                                <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                            </span>
                        </div>
                    </div><br>
                    <div >
                        <span class="modal-param" >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp数量：</span>
                        <input type="text" id="roomNum" name="num">
                    </div><br>

                    <div >
                        <span class="modal-param">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp支付：<span id="toPay"></span></span>
                    </div><br>

                    <div >
                        <span class="modal-param hint">确认支付后将从您的账户中扣除相应金额，如取消预约只能退回一半钱款</span>
                    </div><br>

                    <div class="hidden">
                        <input type="text" name="roomId" id="roomId">
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-cancel" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary btn-confirm">预订并支付</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="/plugin/jquery/jquery-3.1.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/plugin/datePicker/js/bootstrap-datetimepicker.min.js"></script>
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

<script type="text/javascript">
    var RoomList = {
        init:function(){
            this.gridsFather = $("#room-list");
            this.lastGrid = $(".plan-body-item").eq(0);
        },
        updateData:function(roomList){
            this.gridsFather.empty();
            var _this = this;
            $.each(roomList,function(i,room){
                sessionStorage.setItem("room"+i,room);
                var tempGrid = _this.lastGrid.clone(true);
                tempGrid.find(".no").eq(0).text(room.id);
                tempGrid.find(".start").eq(0).text(room.startDate);
                tempGrid.find(".end").eq(0).text(room.endDate);
                tempGrid.find(".type").eq(0).text(room.type);
                tempGrid.find(".num").eq(0).text(room.num);
                tempGrid.find(".address").eq(0).text(room.address);
                tempGrid.find(".price").eq(0).text(room.price);

                var reserve = tempGrid.find(".reserve").eq(0);
                reserve.click(function(){
                    $("#roomId").attr("value",room.id);
                    console.log(room.id);
                })

                $("#roomNum").blur(function(){
                    var startDate = $("#startDate").val();
                    var endDate = $("#endDate").val();
                    var roomNum = $("#roomNum").val();
                    $.get({
                        url:"/user/pay/"+${userId},
                        data:{
                            roomId:room.id,
                            roomNum:roomNum,
                            startDate:startDate,
                            endDate:endDate
                        },
                        success:function(payValue){
                            $("#toPay").text(payValue);
                        },
                        error:function(){
                            console.log("get pay wrong!");
                        }
                    })
                })

                _this.gridsFather.append(tempGrid);
            })
        }
    }



    var url = window.location.href;
    var arr = url.split("/");
    var id = arr[arr.length-1];
    $(document).ready(
            function(){
                RoomList.init();
                $.get({
                    url:"/hostel/roomList/"+id,
                    success:function(newList){
                        RoomList.updateData(newList);
                    },
                    error:function(){
                        console.log("user get detail hostel room List wrong!");
                    }
                })
            }
    )
</script>


</body>
</html>
