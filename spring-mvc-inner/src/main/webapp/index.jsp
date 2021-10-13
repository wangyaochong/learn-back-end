<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<body>
<h2>Hello World!</h2>

<form action="/file/upload" method="post" enctype="multipart/form-data">
    <h3>文件上传</h3>
    <input type="file" name="file">
    <input type="submit" value="upload">
</form>
</body>
</html>
