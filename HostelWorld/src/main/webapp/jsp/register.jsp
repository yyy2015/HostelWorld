<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
<div class="box">
    <div class="login-box">
        <div class="logo-part text-center">
            <img src="../img/logo-white.png"  />
        </div>
        <div class="login-content">
            <div class="form">
                <div class="hint"><% if(session.getAttribute("name_repeat") != null) out.write("用户名已存在"); %></div>
                <form id="reg-form" action="/user/register" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input type="text" name="username" class="form-control" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password" id="password" name="password" class="form-control" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password" id="passwordConfirm" name="passwordConfirm" class="form-control" placeholder="确认密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-book"></span></span>
                            <input type="text" id="bankAccount" name="bankAccount" class="form-control" placeholder="银行账户">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <select class="form-control" name="identity">
                                <option>member</option>
                                <option>hostel</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group text-center">
                        <button type="button" id="sub" class="btn btn-common btn-info" onclick="confirmPwd()">注册</button>
                        <span class="reg">已有账号？<a href="/jsp/login.jsp">去登录!</a></span>
                    </div>
                </form>
            </div>

        </div>

    </div>
</div>


<script src="/js/confirm.js"></script>

</body>
</html>