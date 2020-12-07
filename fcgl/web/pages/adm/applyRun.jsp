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
                <a class="layui-btn layui-btn-xs" lay-event="yes">同意</a>
                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="no">拒绝</a>
            </script>
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
            elem:'#test'
            ,url:'Adm_SL?action=ApplyRun'
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
                ,{field:'id', width:80, title: 'id', sort: true}
                ,{field:'userId', width:80, title: 'userid'}
                ,{field:'houseId', width:80, title: 'houseid', sort: true}
                ,{field:'date', width:120, title: 'date'}
                ,{field:'status', width:80,title: 'status' } //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}
            ]]
            ,page:false
        })


        //监听工具条
        table.on('tool(demo)', function(obj){
            var data=obj.data
            if (obj.event=='yes'){
                location.href='Adm_SL?action=handleApply&id='+data.id+"&status=1"
            }
            if (obj.event=='no'){
                location.href='Adm_SL?action=handleApply&id='+data.id+"&status=2"
            }
        });

    });
</script>
</body>
</html>
