<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2020/11/23
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="UTF-8">
  <title>扬州房产</title>
  <base href="http://localhost:8080/fcgl/">
  <link rel="stylesheet" href="static/css/style.css"/>
  <script type="text/javascript" src="static/Scripts/jquery-1.7.2.js"></script>
  <script type="text/javascript">
    $(function () {

      $("#Rusername").blur(function () {
        var name=this.value;
        $.getJSON("http://localhost:8080/fcgl/User_SL","action=ajaxExistsUser&username="+name,function (data) {
          console.log(data)
          if (data.existUsername){
            $("span.errorMsg").text("用户已存在！");
          }else {
            $("span.errorMsg").text("用户名可用！");
          }
        })

      })

        $("#registerBtn").click(function () {
          var usernameText=$("#Rusername").val();
          var usernamePatt = /^\w{3,12}$/;
          //3 使用test方法验证
          if (!usernamePatt.test(usernameText)) {
            //4 提示用户结果
            $("span.errorMsg").text("用户名不合法！");

            return false;
          }

          // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
          //1 获取用户名输入框里的内容
          var passwordText = $("#Rpassword").val();
          //2 创建正则表达式对象
          var passwordPatt = /^\w{5,12}$/;
          //3 使用test方法验证
          if (!passwordPatt.test(passwordText)) {
            //4 提示用户结果
            $("span.errorMsg").text("密码不合法！");

            return false;
          }

          // 验证确认密码：和密码相同
          //1 获取确认密码内容
          var repwdText = $("#repwd").val();
          //2 和密码相比较
          if (repwdText != passwordText) {
            //3 提示用户
            $("span.errorMsg").text("确认密码和密码不一致！");

            return false;
          }

        })

        $("#loginBtn").click(function () {
          var name = $("#logname").val();
          if (name==""){
            $("span.errorMsg1").text("请输入用户名！")
            return false;
          }

        })
    })

  </script>
</head>

<body>
<!--背景-->
<div class="wel" id="background-3"></div>
<!--左右两边云-->
<div class="wel" id="box">
  <div class="box-1 lefp"></div>
  <div class="box-1">
    <div class="righp"></div>
  </div>
</div>
<!--荧光点点-->
<div class="wel" id="git"></div>
<!--登录注册表-->
<div class="wel" id="from">
  <div class="box-2 le-1">
    <form action="User_SL?action=ulogin" method="post">
      <div class="flrg">
        <h3>登录</h3>
        <span class="errorMsg1" style="color:red;"></span>
        <div class="a">
          <!--<label>账号：</label>-->
          <input type="text" class="in-1" id="logname" name="username" placeholder="请输入用户名">
        </div>
        <div class="a">
          <!--<label>密码：</label>-->
          <input type="password" class="in-1" id="logpw" name="password" placeholder="请输入密码">
        </div>
        <div class="a">
          <button type="submit" id="loginBtn">登录</button>
        </div>
        <div class="a">
          <div class="hr"></div>
        </div>
        <div class="a">
          <a href="#">忘记密码？</a>
        </div>
      </div>
    </form>
  </div>
  <div class="box-2 le-2">
    <form action="User_SL?action=register" method="post">
      <div class="flrg-1">
        <h3>注册</h3>
        <span class="errorMsg" style="color:red;">${requestScope.msg}</span>
        <div class="a">
          <input type="text" class="in-1" id="Rusername" name="username" placeholder="您的用户名">
        </div>
        <div class="a">
          <input type="password" class="in-1" id="Rpassword" name="password" placeholder="输入密码">
        </div>
        <div class="a">
          <input type="password" class="in-1" id="repwd" name="repwd" placeholder="再次确认密码">
        </div>
        <div class="a">
          <input type="text" class="in-1" id="phoneNum" name="phone" placeholder="输入手机号码">
        </div>
        <div class="a">
          <input type="radio"  id="nv" name="gender" value="女" checked>女
          <input type="radio"  id="na" name="gender" value="男">男
        </div>
<%--        <div class="a">--%>
<%--          <input type="email" class="in-1" placeholder="输入邮箱地址">--%>
<%--        </div>--%>
        <div class="a">
          <button type="submit" id="registerBtn">注册</button>
        </div>
      </div>
    </form>
  </div>

</body>

</html>