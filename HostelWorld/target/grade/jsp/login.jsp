<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
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
                <div class="hint"><% if(request.getAttribute("nameOrpwd_wrong")!=null) out.print("用户名或密码错误"); %></div>
                <form action="/login" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input type="text" name="username" class="form-control" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password"  name="password" class="form-control" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group text-center">
                        <button type="submit" class="btn btn-common btn-info">登录</button>
                        <div class="reg">还没有账号？<a href="/jsp/register.jsp">去注册!</a></div>
                    </div>
                </form>
            </div>

        </div>

    </div>
</div>


</body>
</html>