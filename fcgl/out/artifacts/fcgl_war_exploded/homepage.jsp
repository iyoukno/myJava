<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <%@include file="/pages/common/head.jsp"%>
</head>

<style>
    .bak{

        text-align: center;
        line-height: 400px;
        font-size: 50px;
        color: snow;
    }
    #bak1{
        background-image: url("static/houseimg/first.jpg");
    }
    #bak2{
        background-image: url("static/houseimg/se.jpg");
    }
    #bak3{
        background-image: url("static/houseimg/thr.jpg");
    }
    /*#bak4{*/
    /*    background-image: url("../../static/houseimg/fourth.jpg");*/
    /*}*/
    /*#bak5{*/
    /*    background-image: url("../../static/houseimg/five.jpg");*/
    /*}*/

    #companyimg{
        width: 400px;
        height: 400px;
        position: relative;
       left: 700px;
        top: -480px;
    }
    #newhouse{

    }

</style>

<script type="text/javascript">
    $(function () {
        $("#photo").click(function () {
            layui.use()
        })
    })
</script>


<body>
<%--导航栏--%>
<%@include file="/pages/common/navigation_bar.jsp"%>

<div class="layui-carousel" id="test1">

    <div carousel-item id="carouselimg">
        <div class="bak" id="bak1">
            力争国产第一房地产
        </div>
        <div class="bak" id="bak2">我们一直在努力</div>
        <div class="bak" id="bak3">成就卓越，砥砺前行</div>
    </div>
</div>


<hr>

<div style="text-align: center;margin-top: 80px">
    <span style="font-size: 40px">企业发展</span>
</div>


<div style="text-align: center">
    <span style="font-size: 8px">二十年来，不忘初心，一直前行</span>
</div>

<div style="width: 100%;height: 550px">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>公司历程</legend>
    </fieldset>
    <ul class="layui-timeline">
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <h3 class="layui-timeline-title">1999年</h3>
                <p>
                    <span style="font-size: 20px">公司初建，从零开始。</span>
                </p>
                <ul>
                    <li>不积跬步，无以至千里，不积小流，无以成江海。</li>
                    <li>无论它能走多远，抑或如何支撑？至少我们曾倾注全心，无怨无悔 <i class="layui-icon " style="color: orange"></i></li>
                </ul>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <h3 class="layui-timeline-title">2009年</h3>
                <p><span style="font-size: 20px">蓬勃发展，不断向前！</span></p>
                <ul>
                    <li>顾客之后还有顾客，服务的开始才是销售的开始</li>
                    <li>我们致力于为顾客提供最优质的服务！<i class="layui-icon layui-icon-heart-fill" style="color: red"></i></li>
                </ul>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <h3 class="layui-timeline-title">2019年</h3>
                <p>
                    <span style="font-size: 20px">公司上市，再度出发！</span>
                </p>
                <ul>
                    <li>行动是成功的阶梯，</li>
                    <li>让我们携手，一起勇攀高峰！<i class="layui-icon layui-icon-fire" style="color: red"></i></li>
                </ul>
            </div>
        </li>
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
                <div class="layui-timeline-title">将来</div>
                <p>
                    <span style="font-size: 20px">加入我们吧！少年！让我们去开创美好新世界，</span>
                </p>
            </div>
        </li>
    </ul>


    <img id="companyimg" src="static/houseimg/comp.jpg" >
</div>

<div style="text-align: center;margin-top: 80px">
    <span style="font-size: 40px">最新房源</span>
</div>
<hr class="layui-bg-gray">

<div id="newhouse" style="display: flex;justify-content: space-between">
    <div style="height: 300px;width: 300px; background-color: snow;float: right;">
        <img src="static/houseimg/1.jpg" style="height: 200px;width: 300px; margin-bottom: 20px">
        <p style="margin:15px 5px 20px 15px"><i class="layui-icon layui-icon-location" > &nbsp;</i>森和阳光：</p>
        <p style="margin:15px 5px 20px 15px"><i class="layui-icon layui-icon-date">&nbsp;2020年11月20日</i></p>
        <i class="layui-icon layui-icon-read" style="margin-left: 15px">&nbsp;</i><br>
        <div style="padding-left: 1em">小区充满了欧式风格，绿化面积大，采光效果也很好，给人一种风景宜人的感觉</div>
    </div>

    <div style="height: 300px;width: 300px; background-color: snow;float: right;">
        <img src="static/houseimg/2.jpg" style="height: 200px;width: 300px; margin-bottom: 20px">
        <p style="margin:15px 5px 20px 15px"><i class="layui-icon layui-icon-location" > &nbsp;</i>西湖风光：</p>
        <p style="margin:15px 5px 20px 15px"><i class="layui-icon layui-icon-date">&nbsp;2020年11月20日</i></p>
        <i class="layui-icon layui-icon-read" style="margin-left: 15px">&nbsp;</i><br>
        <div style="padding-left: 1em">坐落在扬州市著名的廋西湖景区，城市中的一片绿林</div>
    </div>

    <div style="height: 300px;width: 300px; background-color: snow">
        <img src="static/houseimg/3.jpg" style="height: 200px;width: 300px; margin-bottom: 20px">
        <p style="margin:15px 5px 20px 15px"><i class="layui-icon layui-icon-location" > &nbsp;</i>洛克小镇：</p>
        <p style="margin:15px 5px 20px 15px"><i class="layui-icon layui-icon-date">&nbsp;2020年11月20日</i></p>
        <i class="layui-icon layui-icon-read" style="margin-left: 15px">&nbsp;</i><br>
        <div style="padding-left: 1em">民风淳朴的洛克小镇，在这里，你可以远离城市的喧嚣</div>
    </div>

</div>






<!-- 你的HTML代码 -->

<script src="layui/layui.js"></script>
<script>
    //一般直接写在一个js文件中
    layui.use(['layer', 'form','element','carousel'], function(){
        var layer = layui.layer
            ,form = layui.form
            ,element=layui.element
            ,carousel=layui.carousel;

        carousel.render({
            elem:'#test1',
            width:'100%',
            height:'500px',
            arrow:'always',
            anim:'default'
        });

        // layer.msg('Hello World');
        element.init();

    });
</script>
</body>
</html>