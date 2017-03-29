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
                <div class="hint">
                    <% if(session.getAttribute("stopped") != null) out.print("用户已永久停用"); %>
                    <% if(session.getAttribute("nameOrpwd_wrong")!=null) out.print("用户名或密码错误"); %>
                </div>
                <form action="/user/login" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input type="text" name="username" class="form-control" placeholder="用户名或客栈序列号">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password"  name="password" class="form-control" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <select class="form-control" name="identity">
                                <option>member</option>
                                <option>hostel</option>
                                <option>manager</option>
                            </select>
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