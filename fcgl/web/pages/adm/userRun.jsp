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
    <%@include file="/pages/common/head.jsp"%>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%@include file="/pages/adm/common/topbar.jsp"%>>

    <%@include file="/pages/adm/common/leftbar.jsp"%>>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <table class="layui-table"  lay-filter="demo" id="test"></table>

            <script type="text/html" id="barDemo">
<%--                <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail" id="chak">查看</a>--%>
<%--                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>--%>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
        </div>
    </div>


</div>
<script src="layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element','table'], function(){
        var element = layui.element;
        var table=layui.table
        table.render({
            elem:'#test'
            ,url:'Adm_SL?action=userRun'
            ,cellMinWidth:80
            ,id:'idTest'
            ,parseData:function (res) {
                return{
                    "code":0
                    ,"msg":""
                    ,"count":res.count
                    ,"data":res.data
                }
            }
            ,cols: [[
                // {type:'checkbox'}
                ,{field:'id', width:160, title: 'id', sort: true}
                ,{field:'username', width:86, title: 'name'}
                ,{field:'age', width:120, title: 'age', sort: true}
                ,{field:'gender', width:80, title: 'sex'}
                ,{field:'phone', title: 'tel', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}
            ]]
            ,page:false
        })

        // 工具条监听


        //工具条监听
    });
</script>
</body>
</html>
