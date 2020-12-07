<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2020/12/3
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;">管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="pages/adm/userRun.jsp">用户管理</a></dd>
                    <dd><a href="pages/adm/houseRun.jsp">房产管理</a></dd>
                    <%--                        <dd><a href="javascript:;">区域管理</a></dd>--%>
                    <dd><a href="pages/adm/applyRun.jsp">看房申请管理</a></dd>

                </dl>
            </li>


        </ul>
    </div>
</div>