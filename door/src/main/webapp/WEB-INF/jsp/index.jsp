<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String basePath = request.getContextPath()+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>用户登录</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="ecm">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Windows-Target" contect="_top"/>
    <meta name="viewport" content="width=device-width,minimum-scale=1,user-scalable=no,maximum-scale=1,initial-scale=1" />
    <link rel="stylesheet" href="/static/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="/static/css/common.css"  media="all">
    <link rel="stylesheet" href="/static/css/nstyle.css"  media="all">
    <script type="text/javascript" src="/static/jquery/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/static/layui/layui.all.js"></script>
    <style>
        body{
            background-image: url("/static/image/bg/bg1.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            font-size: 14px;
            color: #333;
            text-rendering: geometricPrecision;
            -webkit-font-smoothing: antialiased;
            _background-attachment: fixed;
            font-family:Microsoft YaHei,PingFangSC-Light,PingFang SC,Helvetica,Tahoma,Arial,Hiragino Sans GB,WenQuanYi Micro Hei,sans-serif;
        }
        .container{
            height:100%;
        }
        .cbp-bislideshow {
            list-style: none;
            width: 100%;
            height: 100%;
            position: fixed;
            top: 0;
            left: 0;
            z-index: -1;
            padding: 0;
            margin: 0;
        }
        .cbp-bislideshow li {
            position: absolute;
            width: 101%;
            height: 101%;
            top: -0.5%;
            left: -0.5%;
            opacity: 0;
            -webkit-transition: opacity 1s;
            -moz-transition: opacity 1s;
            transition: opacity 1s;
        }
        .backgroundsize .cbp-bislideshow li {
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
            background-position: center center;
        }
        .backgroundsize .cbp-bislideshow li img {
            display: none;
        }

        .cbp-bislideshow li img {
            display: block;
            width: 100%;
        }
        .no-js.no-backgroundsize .cbp-bislideshow li:first-child {
            opacity: 1;
        }
        .no-js.backgroundsize .cbp-bislideshow li:first-child img {
            display: block;
        }
        .g_logo{
            padding:20px;
        }
        .g_content{
            position: absolute;
            top: 12%;
            left: 0;
            right: 0;
        }
        .sysname{
            text-align:center;
            font-size:56px;
            color:#fff;
            letter-spacing:8px;
            height: 0;
            opacity: 0;
        }
        .loginnow{
            padding-top:12%;
            text-align:center;
        }
        .logbtn{
            padding: 12px 62px;
            background: #fff;
            border: 0;
            border-radius: 2px;
            color: #436aeb;
            cursor: pointer;
            transition: all 1.0s ease;
            box-shadow: 0 13px 42px 11px rgba(0, 0, 0, 0.05);
            letter-spacing: 2px;
            font-size: 18px;
        }
        .logbtn:hover{
            background:#436aeb;
            color:#fff;
        }
        .loginbox{
            background: #fff;
            padding: 30px 40px;
            width: 318px;
            margin:40px auto;
            height: 220px;
        }
        .loginform{
            border-bottom:1px solid #ddd;
            padding:5px 0;
            margin: 20px 0;
        }
        .loginform input{
            border: 0;
            background: none;
            padding:0 5px;
            height:23px;
            font-size:16px;
            vertical-align: middle;
            box-sizing: border-box;
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
        }
        .login_btn {
            background: #436aea;
            width: 45%;
            height:35px;
            color: #fff;
            font-size: 16px;
            border-radius: 2px;
            border:none;
            cursor:pointer;
            float:left;
            transition: all 0.36s ease;
        }
        .login_btn:hover{
            background: #3c60d5;
        }
        .reset_btn {
            background: #aaa;
            width: 45%;
            height: 35px;
            color: #fff;
            font-size: 16px;
            border-radius: 2px;
            border:none;
            cursor:pointer;
            float:right;
            transition: all 0.36s ease;
        }
        .reset_btn:hover {
            background: #999;
        }
        .footer {
            bottom: 0;
            padding: 5px 0;
            text-align: center;
            width: 100%;
            color: #fff;
            font-size: 10px;
            Position: fixed;
            opacity:0.7;
        }
        .yzm{
            margin-top: -1px;
            *margin-top:0;
            position:absolute;
            right:0;
            width: 62px;
            height:30px;
        }
        .txt2 {
            width:211px;
            color:#ccc;
            display: inline-block;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="g_content"><p class="sysname">保险影像内容管理系统</p>
        <div class="loginbox"  >
            <ul>
                <li style="text-align:center;font-size:26px;color:#436aeb;padding-bottom:10px;letter-spacing: 1px;">欢迎登录/User Login</li>
                <li class="loginform">
                    <img style="vertical-align: middle;" src="/static/image/tub_01.png">
                    <span><input  id="userCode"   type="text" autocomplete="off"  placeholder="请输入登录名" style="color:#ddd;width:240px;" /></span>
                </li>
                <li class="loginform">
                    <img style="vertical-align: middle;" src="/static/image/tub_02.png">
                    <span><input id="userPassword"  type="password" autocomplete="new-password" value="" placeholder="请输入密码" style="color:#ddd;width:240px;"/></span>
                </li>
                <li style="padding-top:10px;height:36px;"><button class="login_btn" onclick="userLogin()" type="button">登录</button>
                    <button class="reset_btn" onclick="resetInput()" type="button">重置</button></li>
            </ul>
        </div>
    </div>
    <div class="footer">yellow three--xiayun&nbsp;&nbsp;<span id="versionInfo"></span></div>
</div>

<!-- <script type="text/javascript" src="ecm-nview/public/jquery/jquery-1.4.4.js"></script> -->
<script type="text/javascript">
    var basePath="<%=basePath%>";
</script>

<script type="text/javascript">
    function userLogin() {
        var userCode=$("#userCode").val();
        var password=$("#userPassword").val();
        var securityCode=$("#securityCode").val();
        if(""==userCode||""==password){
            layer.alert('用户名和密码必能为空!')
        } else{
            var index = layer.load(0, {shade: false});
            $.ajax({
                url: '<%=basePath%>door/login',
                data: {loginName:userCode,password:password},
                type: 'POST',
                timeout: 10000,
                success: function(data){
                    layer.close(index);
                    if (data.code == '200') {
                        // 登录成功。。
                        layer.msg('登录成功，累计登录次数：' + data.loginCount);
                        window.location.href = "/door/main";
                    } else {
                        layer.msg(data.message);
                    }
                },
                error: function(){
                    layer.close(index);
                    layer.alert('登录失败，请稍后重试!')
                }
            });

        }
    };

    //按下重置按钮清空页面上的用户名密码
    function resetInput(){
        $("#userCode").val("");
        $("#userPassword").val("");
        $("#securityCode").val("");
        refresh();
    }

    //按下回车键登陆
    function keyLogin(e){
        e = e || event;
        var currKey = e.keyCode || e.which;
        if (currKey == 13)   //回车键的键值为13
            userLogin();
    }

    /*
    ascii码说明：
    8：退格键
    46：delete
    37-40： 方向键
    48-57：小键盘区的数字
    9： Tab
    */
    function vaildNumber(e){
        e=e||event;
        var keyCode = e.keyCode || e.which;
        //是数字，并且除了：退格键 delete 方向键
        if(( keyCode < 37 || (keyCode > 40 && keyCode < 48) || keyCode > 57 ) && keyCode != 8 && keyCode != 46 && keyCode != 9 ){
            if (("IE").indexOf(getBrowserVerInfo().browser) >= 0){//IE
                e.returnValue = false;
            }else{
                e.preventDefault();
            }
        }
    }

</script>
</body>
</html>
