<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<body>
<h2>Hello World!</h2>

<form action="file/upload?urlParam=urlParamValue" method="post" enctype="multipart/form-data">
    <h3>文件上传</h3>
    <input type="file" name="file" multiple>
    <input type="text" name="formParam">
    <input type="submit" value="upload">
</form>
<br>
这是图片<img src="file/getImage" alt="测试图片">

</body>
</html>
