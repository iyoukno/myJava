<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="http://localhost:8080/fcgl/">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <script type="text/javascript" src="static/Scripts/jquery-1.7.2.js"> </script>
    <script type="text/javascript">
        $(function () {
            $("#return").click(function () {
                location.href="pages/user/houselist.jsp"
            })
        })
    </script>
</head>
<style>
    #return{
        color: red;
        position: fixed;
        right: 10px;
        bottom: 10px;
    }
</style>

<body>
<div style="height: 700px;width: 100%; background-color: snow;">
    <img src="${requestScope.img_path=="hp_path"?"static/sorry.png":requestScope.img_path}" style="height: 600px;width: 100%; margin-bottom: 20px">
    <p style="margin:15px 5px 20px 15px"><i class="layui-icon layui-icon-friends" > &nbsp;</i>${requestScope.salesname}：</p>
    <p style="margin:15px 5px 20px 15px"><i class="layui-icon layui-icon-chat">&nbsp;${requestScope.salestel}</i></p>
    <i class="layui-icon layui-icon-face-smile" style="margin-left: 15px;color: orange">&nbsp;</i><br>
    <div style="padding-left: 1em">您可以联系上面的销售小哥(小姐姐)，进一步的了解房屋情况哦</div>
</div>
<i class="layui-icon layui-icon-return" id="return">返回</i>

</body>
</html>