<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/4/28
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<p>${xiaoxi}</p>
<a href="Searchall">查看所有的用户</a>
</body>
</html>
