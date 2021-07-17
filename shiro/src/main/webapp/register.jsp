<%--
  Created by IntelliJ IDEA.
  User: wangy
  Date: 2021/7/13
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>用户注册</h1>

<form action="${pageContext.request.contextPath}/user/register">
    <label>用户名:<input type="text" name="username"/></label>
    <label>密码：<input type="password" name="password"></label>
    <input type="submit" value="注册">
</form>

</body>
</html>
