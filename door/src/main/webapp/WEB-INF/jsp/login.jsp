<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String basePath = request.getContextPath()+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>图片</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width,minimum-scale=1,user-scalable=no,maximum-scale=1,initial-scale=1" />
    <link rel="stylesheet" href="/static/layui/css/layui.css"  media="all">
    <script type="text/javascript" src="/static/jquery/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/static/layui/layui.all.js"></script>
    <style type="text/css">
        .login-panel{
            margin: auto auto;
            border-radius: 8px;
        }

    </style>
</head>
<body>
<div class="login-panel">
    <table>
        <tr>
            <td colspan="2"><div class="layui-form-item">
                    <label class="layui-form-label">登录名：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="loginName" lay-verify="required" placeholder="登录名" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </td>
        </tr>
        <tr>
            <td><div class="layui-form-item">
                <label class="layui-form-label">密码：</label>
                <div class="layui-input-inline">
                    <input type="password" name="password" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <div class="layui-form-item">
                <label class="layui-form-label">密码：</label>
                <div class="layui-input-inline">
                    <input type="password" name="password" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                </div>
            </div>
            </td>
        </tr>
        <tr>
            <td>
                <button type="button" class="layui-btn layui-btn-radius" onclick="login()">默认按钮</button>
            </td>
            <td>
                <button type="button" class="layui-btn layui-btn-normal layui-btn-radius" onclick="reset()">百搭按钮</button>
            </td>
        </tr>
    </table>
</div>


<script type="text/javascript">
    function login() {

        $.ajax({
            type: "post",
            url: '<%=basePath%>doorController/login',
            data: {loginName:$("#loginName").val(), password:$("#password").val()},
            dataType: "json",
            success: function(data){
                if(data != null && typeof (data) != 'undefined' && data != ''){
                    var user = data;


                }
            }
        });
    }
</script>
</body>
</html>
