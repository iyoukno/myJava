<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@include file="/pages/common/head.jsp"%>>
</head>
<style>

    .layui-laypage-default{
        margin-left: 50%!important;
        transform: translateX(-50%);
    }

</style>

<body>
<!--导航栏-->
<%@include file="/pages/common/navigation_bar.jsp"%>
<table class="layui-table"  lay-filter="demo" id="test"></table>
<script src="layui/layui.js" charset="utf-8"></script>

<script>


    layui.use(['table','element'], function(){
        var table = layui.table;
        element=layui.element;
        element.init()


        table.render({
            elem: '#test'
            ,url:'ApplyShow_SL?action=getAllApplyShow'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,id:'idTest'
            ,parseData:function (res) {
                console.log(res);
                return{
                    "code":0
                    ,"msg":"暂无数据，请提交申请后再试噢"
                    ,"count":res.count
                    ,"data":res.data
                }
            }
            ,cols: [[
                ,{field:'id', width:86, title: '申请编号'}
                ,{field:'userId', width:120, title: '用户名称', sort: true}
                ,{field:'houseId', width:150, title: '房屋名称'}
                ,{field:'date', title: '创建时间', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'status', width:137, title: '申请状态', sort: true}
            ]]
            ,page:false
        })


    });

</script>
</body>

</html>