<%--
  Created by IntelliJ IDEA.
  User: lilong
  Date: 2019/4/2
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File Request Page</title>
</head>
<body>
    <form method="POST" action="uploadFile.do" enctype="multipart/form-data">
        File to upload: <input type="file" name="file">
        <input type="submit" value="Upload"> Press here to upload the file!
    </form>
</body>
</html>
