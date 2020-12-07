<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2020/12/2
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--导航栏-->
<ul class="layui-nav">
    <li class="layui-nav-item">
        <a href="#"><i class="layui-icon layui-icon-home"></i></a>
    </li>
    <li class="layui-nav-item">
        <a href="pages/user/houselist.jsp">房源<span class="layui-badge-dot"></span></a>
    </li>
    <li class="layui-nav-item">
        <a href=""><img src="${empty sessionScope.photo?"static/bilibili.png":sessionScope.photo}" class="layui-nav-img"><i class="layui-icon layui-icon-username"></i></a>
        <dl class="layui-nav-child">
            <dd><a href="${empty sessionScope.userId?"pages/user/index.jsp":"pages/user/userInfo.jsp"}">上传头像</a></dd>
            <dd><a href="${empty sessionScope.userId?"pages/user/index.jsp":"pages/user/applypage.jsp"}" >我的申请</a></dd>
            <dd><a href="pages/user/index.jsp">切换账户</a></dd>
        </dl>
    </li>
</ul>
<!--导航栏-->
