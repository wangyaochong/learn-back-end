<%--
  Created by IntelliJ IDEA.
  User: wangy
  Date: 2021/7/13
  Time: 8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户登录</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    <label>用户名:<input type="text" name="username"/></label>
    <label>密码：<input type="password" name="password"></label>
    <input type="submit" value="登录">
</form>

<a href="./register.jsp">注册</a>
</body>
</html>
