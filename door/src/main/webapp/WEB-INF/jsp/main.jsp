<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String basePath = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>主页</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/static/jquery/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/static/layui/layui.all.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">XY</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${user.name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">登出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree">
                <c:forEach items="${permissions1}" var="obj1">
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;">${obj1.name}</a>
                        <dl class="layui-nav-child">
                            <c:forEach items="${permissions2}" var="obj2">
                                <c:if test="${obj1.id == obj2.parentId}">
                                    <dd><a href="${obj2.url}">${obj2.name}</a></dd>
                                </c:if>
                            </c:forEach>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;"></div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        千江有水千江月，万里无云万里天
    </div>
</div>
<script src="/static/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });

    $.ajax({
        type: "post",
        url: '',
        data: {loginName:$("#loginName").val(), password:$("#password").val()},
        dataType: "json",
        success: function(data){
            if(data != null && typeof (data) != 'undefined' && data != ''){
                var user = data;
            }
        }
    });

</script>
</body>
</html>