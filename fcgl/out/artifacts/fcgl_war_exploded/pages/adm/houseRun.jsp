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
            <!--这里填内容 -->
            <table class="layui-table"  lay-filter="demo" id="test"></table>

            <script type="text/html" id="barDemo">
                <%-- <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail" id="chak">查看</a>--%>
                <a class="layui-btn layui-btn-xs" lay-event="edit">upPh</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
            </script>
            <i class="layui-icon layui-icon-addition" style="color:red;"></i>
        </div>


    </div>


</div>
<script src="layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element','table'], function(){
        var element = layui.element;
        var table=layui.table;
        table.render({
            elem: '#test'
            ,url:'Adm_SL?action=HouseRun'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,id:'idTest'
            ,parseData:function (res) {
                console.log(res);
                return{
                    "code":0
                    ,"msg":""
                    ,"count":res.count
                    ,"data":res.data
                }
            }
            ,cols: [[
                // {type:'checkbox'}
                ,{field:'id', width:80, title: '编号', sort: true}
                ,{field:'title', width:86, title: '房产名'}
                ,{field:'type', width:120, title: '户型', sort: true}
                ,{field:'price', width:80, title: '价格'}
                ,{field:'address', title: '地址', minWidth: 200} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'hp_path', title: '图片', sort: true}
                ,{field:'regionId', title: '区域编号', sort: true}
                ,{field:'salespersonId', title: '销售人员'}
                ,{field:'orientation', width:137, title: '朝向', sort: true}
                ,{field:'time', width:137, title: '创建时间', sort: true}
                ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}
            ]]
            ,page:false
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data=obj.data;
            if (obj.event=='del'){
                location.href='Adm_SL?action=delHouseById&id='+data.id;
            }
        });

    });
</script>
</body>
</html>
