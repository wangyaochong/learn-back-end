<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    用户登录
</head>
<body>
<form action="/userAuth/login" method="post">
    用户名：<input type="text" name="userName"><br>
    密码：<input type="password" name="password"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>