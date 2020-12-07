<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2020/11/23
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <base href="http://localhost:8080/fcgl/">
    <link rel="stylesheet" type="text/css" href="static/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="static/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" href="static/css/component.css">
    <!--[if IE]>
    <script src="static/js/html5.js"></script>
    <![endif]-->
    <script type="text/javascript" src="static/Scripts/jquery-1.7.2.js"></script>

    <script type="text/javascript">
        $(function () {

        })
    </script>


</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎你,管理员</h3>
                <form action="Adm_SL?action=login"  method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="admname" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
                    </div>
<%--                    <div class="mb2"><a class="act-but submit" style="color: #FFFFFF" ><button>登录</button></a></div>--%>
                    <button class="act-but submit" style="width: 330px">登录</button>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="static/js/TweenLite.min.js"></script>
<script src="static/js/EasePack.min.js"></script>
<script src="static/js/rAF.js"></script>
<script src="static/js/demo-1.js"></script>
<div style="text-align:center;">

</div>
</body>
</html>
