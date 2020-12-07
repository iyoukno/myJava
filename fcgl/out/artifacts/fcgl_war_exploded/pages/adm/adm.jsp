<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2020/11/24
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台管理平台 - Layui</title>
    <base href="http://localhost:8080/fcgl/">
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%@include file="/pages/adm/common/topbar.jsp"%>>

    <%@include file="/pages/adm/common/leftbar.jsp"%>>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <!--这里填统计信息 -->

        </div>
    </div>


</div>
<script src="layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;


    });
</script>
</body>
</html>
