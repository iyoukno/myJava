<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2020/12/2
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    pageContext.setAttribute("address",basePath);
%>
<base href="<%=basePath%>">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="text/javascript" src="static/Scripts/jquery-1.7.2.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
