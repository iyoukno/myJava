<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">
    <title>Title</title>
    <%@include file="/pages/common/head.jsp"%>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>

<style>
    img{
        width: 100%;
        height: 500px;
    }
    .layui-laypage-default{
        margin-left: 50%!important;
        transform: translateX(-50%);
    }
    #layerDiv{
        display: none;
    }
</style>

<body>
<!--导航栏-->
<%@include file="/pages/common/navigation_bar.jsp"%>
<!--导航栏-->

<!--图片-->
<img src="static/houseimg/se.jpg">


<div style="margin-bottom: 5px; text-align: center" >

    <!-- 示例-970 -->
    <ins class="adsbygoogle" style=" line-height: 60px; display:inline-block;width:100%;height:70px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620">
        <i class="layui-icon layui-icon-down" style="color: orange;font-size: 20px;"></i>

    </ins>

</div>

<%--<div class="layui-btn-group demoTable">--%>
<%--    <button class="layui-btn" data-type="getCheckData">获取选中行数据</button>--%>
<%--    <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>--%>
<%--    <button class="layui-btn" data-type="isAll">验证是否全选</button>--%>
<%--</div>--%>

&nbsp;&nbsp;&nbsp;户型：<input style="width: 80px" type="text" id="type"><i class="layui-icon layui-icon-search" id="serTy"></i>
&nbsp;&nbsp;&nbsp;最大价格：<input style="width: 80px" type="text" id="price"><i class="layui-icon layui-icon-search" id="serPr"></i>

&nbsp;&nbsp;&nbsp;区域选择：
<select id="regionSelect">
    <option selected value="全部">全部</option>
    <option value="江都">江都区</option>
    <option value="广陵">广陵区</option>
    <option value="高邮">高邮县</option>
    <option value="开发">开发区</option>
    <option value="宝应">宝应县</option>
    <option value="邗江">邗江区</option>
</select>


<table class="layui-table"  lay-filter="demo" id="test"></table>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail" id="chak">查看</a>
<!--    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>-->
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">申请</a>
</script>


<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>


    layui.use(['table','element'], function(){
        var table = layui.table;
        element=layui.element;
        element.init()
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            var salesID=data.salespersonId
            var houseId=data.id
            var img_path=data.hp_path;
            // layer.msg('销售人员id:'+ salesID+ ":"+ houseId+":"+img_path +' 的查看操作');

            if(obj.event === 'detail'){

                location.href="HL_SL?action=HouseDetail&salesId="+salesID+"&houseId="+houseId+"&img_path="+img_path
                //这里点击查看，弹出一个房屋的具体信息图层
                // $("#rrr").attr("src",img_path)
                // layer.open({
                //     type:1
                //     ,content:''
                //     ,area:['300px','500px']
                //     ,anim:4
                // })
            } else if(obj.event === 'del'){
                //这里弹出一个申请表单
                if ($("#islogin").html()=="no"){
                    alert('请先登录，再申请看房');
                    return;
                }
                else if($("#islogin").html()!="no"){
                    location.href="Apply_SL?action=addApply&houseId="+data.id;
                }


                // layer.confirm('真的删除行么', function(index){
                //     obj.del();
                //     layer.close(index);
                // });
            }
            // else if(obj.event === 'edit'){
            //     layer.alert('编辑行：<br>'+ JSON.stringify(data))
            // }
        });

        // var $ = layui.$, active = {
        //     getCheckData: function(){ //获取选中数据
        //         var checkStatus = table.checkStatus('idTest')
        //             ,data = checkStatus.data;
        //         layer.alert(JSON.stringify(data));
        //     }
        //     ,getCheckLength: function(){ //获取选中数目
        //         var checkStatus = table.checkStatus('idTest')
        //             ,data = checkStatus.data;
        //         layer.msg('选中了：'+ data.length + ' 个');
        //     }
        //     ,isAll: function(){ //验证是否全选
        //         var checkStatus = table.checkStatus('idTest');
        //         layer.msg(checkStatus.isAll ? '全选': '未全选')
        //     }
        // };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });



        table.render({
            elem: '#test'
            ,url:'House_SL?action=queryByPage'
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
                // ,{field:'id', width:80, title: '编号', sort: true}
                ,{field:'title', width:86, title: '房产名'}
                ,{field:'type', width:120, title: '户型', sort: true}
                ,{field:'price', width:80, title: '价格'}
                ,{field:'address', title: '地址', minWidth: 200} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                // ,{field:'hp_path', title: '图片', sort: true}
                // ,{field:'regionId', title: '区域编号', sort: true}
                // ,{field:'salespersonId', title: '销售人员'}
                ,{field:'orientation', width:137, title: '朝向', sort: true}
                ,{field:'time', width:137, title: '创建时间', sort: true}
                ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'}
            ]]
            ,page:{
                limit:5
                ,curr:1
                ,groups:3
                ,limits:[5,10,20]
            }



        })


    });
</script>

<script type="text/javascript">
    $(function () {
        $("#serTy").click(function () {
            var type=$("#type").val();
            layui.use(['table','layer'],function () {
                var layer=layui.layer
                var table=layui.table;
                // layer.open({
                //     title: '提示消息'
                //     ,content: '查询条件不能为空！'
                // });
                table.reload('idTest',{
                    url: 'House_SL'
                    ,where:{
                        action:'queryByType'
                        ,queryStr:type
                    }
                })

            })

            alert("按户型搜索:"+type);
        })

        $("#serPr").click(function () {
            var price=$("#price").val();
            layui.use(['table'],function () {
                var table=layui.table;
                table.reload('idTest',{
                    url: 'House_SL'
                    ,where:{
                        action:'queryByPrice'
                        ,queryStr:price
                    }
                })

            })
            alert("按价格搜索")

        })

        $("#regionSelect").change(function () {
            var region=$(this).val()
            layui.use(['table','layer'],function () {

                var layer=layui.layer
                var table=layui.table;
                // layer.open({
                //     title: '提示消息'
                //     ,content: '查询条件不能为空！'
                // });
                table.reload('idTest',{
                    url: 'House_SL'
                    ,where:{
                        action:'queryByRegion'
                        ,queryStr:region
                    }
                })

            })

            // alert("按照区域搜索："+region)
        })
        // alert($("#issuc").val())
        if ($("#issuc").html()=="yes"){
            alert("申请成功，请等待审核")
        }
        // alert($("#isapplied").html())
        if ($("#isapplied").html()=="hello"){
            alert("已申请，请勿重复申请")
        }
        // alert($("#islogin").html())
        // if ($("#islogin").html()=="no"){
        //     alert("请登录再申请看房")
        // }

    })

</script>

</body>
<span style="display: none" id="issuc">${requestScope.issuc}</span>
<span style="display: none" id="islogin">${empty sessionScope.userId?"no":sessionScope.userId}</span>
<span style="display: none" id="isapplied">${requestScope.isapplied}</span>
</html>