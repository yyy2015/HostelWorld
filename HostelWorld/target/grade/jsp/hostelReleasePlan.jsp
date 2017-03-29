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
                <%--<li><a href="#">首页</a></li>--%>
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
            <li><a href="/jsp/hostelReleasePlan.jsp">发布计划</a></li>
            <li><a href="/jsp/hostelCheckIn.jsp">入店登记</a></li>
            <li><a href="/jsp/hostelCheckOut.jsp">离店登记</a></li>
        </ul>
    </div>

    <div class="col-sm-9 col-md-10 main-content float-right ">
        <div class="sub-title">
            <h3>房间计划</h3>
            <hr>
            <div class="col-sm-12 plan-list">
                <div class="plan-title">
                    <div class="col-sm-1">编号</div>
                    <div class="col-sm-2">开始日期</div>
                    <div class="col-sm-2">结束日期</div>
                    <div class="col-sm-2">房间类型</div>
                    <div class="col-sm-1">剩余</div>
                    <div class="col-sm-2">地址</div>
                    <div class="col-sm-2">价格</div>
                </div>
                <div class="plan-body" id="plan-body-list">
                    <div class="plan-body-item">
                        <div class="col-sm-1 no">1</div>
                        <div class="col-sm-2 start">2017.10.20</div>
                        <div class="col-sm-2 end">2017.11.20</div>
                        <div class="col-sm-2 type">单人房</div>
                        <div class="col-sm-1 num">10</div>
                        <div class="col-sm-2 address">鼓楼，南京</div>
                        <div class="col-sm-2 "><span class="price">100</span>/每晚</div>
                    </div>
                    <div class="plan-body-item">
                        <div class="col-sm-1">1</div>
                        <div class="col-sm-2">2017.10.20</div>
                        <div class="col-sm-2">2017.11.20</div>
                        <div class="col-sm-2">单人房</div>
                        <div class="col-sm-1">10</div>
                        <div class="col-sm-2">鼓楼，南京</div>
                        <div class="col-sm-2"><span>100</span>/每晚</div>
                    </div>
                    <div class="plan-body-item">
                        <div class="col-sm-1">1</div>
                        <div class="col-sm-2">2017.10.20</div>
                        <div class="col-sm-2">2017.11.20</div>
                        <div class="col-sm-2">单人房</div>
                        <div class="col-sm-1">10</div>
                        <div class="col-sm-2">鼓楼，南京</div>
                        <div class="col-sm-2"><span>100</span>/每晚</div>
                    </div>
                </div>
            </div>
            <button class="btn btn-default my-btn addPlan float-right" data-toggle="modal" data-target="#release-plan">
                添加计划</button>

        </div>

        <div class="clearfix"></div>

    </div>

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
                    <button type="submit" class="btn btn-primary btn-confirm">添加</button>
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

<script src="/js/hostelReleasePlan.js"></script>

<script type="text/javascript">
    var id = ${hostelId};
    $(document).ready(
            function(){
                PlanList.init();
                $.get({
                    url:"/hostel/roomList/"+id,
                    success:function(newList){
                        PlanList.updateDate(newList);
                    },
                    error:function(){
                        console.log("get plan list wrong!");
                    }

                })
            }
    )
</script>


</body>
</html>
