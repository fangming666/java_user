<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/4/28
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>展示所有的用户</title>
</head>
<body>
<h1>${xiaoxi}</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>城市</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <c:forEach var="U" items="${userAll}">
        <form action="UpdateServlet" method="post">
            <tr>
                <td><input type="text" value="${U.id}" name="id"></td>
                <td><input type="text" value="${U.name}" name="name"></td>
                <td><input type="text" value="${U.pwd}" name="pwd"></td>
                <td><input type="text" value="${U.sex}" name="sex"></td>
                <td><input type="text" value="${U.home}" name></td>
                <td><input type="text" value="${U.info}" name="info"></td>
                <td><a class="changeEvent" href="DeleteServlet?id=${U.id}">删除</a>
                    <input class="changeEvent" type="submit" value="更新"></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
<script>
    let H1 = document.getElementsByTagName("h1")[0];
    let changeEvent = document.getElementsByClassName("changeEvent");
    setTimeout(() => {
        H1.innerHTML = ""
    }, 1000)
</script>
</html>
