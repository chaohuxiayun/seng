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
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>常规使用：普通图片上传</legend>
</fieldset>

<div class="layui-upload">
    <div class="layui-upload">
        <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
        <button type="button" class="layui-btn" id="test9">开始上传</button>
    </div>
</div>
<script type="text/javascript">

    layui.use('upload', function() {
        var $ = layui.jquery, upload = layui.upload;

        //选完文件后不自动上传
        upload.render({
            elem: '#test8'
            ,url: '<%=basePath%>doorImage/uploadAndDistingdush'
            ,auto: false
            ,accept: 'file'
            // ,multiple: true
            ,bindAction: '#test9'
            ,done: function(res){
                console.log(res)
            }
        });
    });


</script>
</body>
</html>
