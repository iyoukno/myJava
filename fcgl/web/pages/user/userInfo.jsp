<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="http://localhost:8080/fcgl/">
    <title>Title</title>
</head>
<body>
<form action="User_SL?action=upLoadPhoto" method="post", enctype="multipart/form-data">
    请上传你的头像:<br>
    <input type="file" name="photo"><br/>
    <input type="submit" value="上传"><br/>
</form>
</body>
</html>