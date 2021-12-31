<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    用户登录
</head>
<body>
这是图片<img src="/file/getImage" alt="测试图片">
<br>
<form action="/userAuth/login" method="post">
    用户名：<input type="text" name="userName"><br>
    密码：<input type="password" name="password"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>