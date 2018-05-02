<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/4/28
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        .text-danger {
            font-size: 12px;
            color: red;
        }
    </style>
</head>
<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/";
%>
<form action="ZhuceServlet" method="post">
    <p>输入用户名：<input type="text" name="name" class="clearText" value="${userName}"></p>
    <p class="text-danger">${xiaoxi}</p>
    <p>输入密码：<input type="text" name="pwd" class="clearText" value="${userPwd}"></p>
    <p>选择性别:<input type="radio" name="sex" checked="${userSex == '男'}" value="男">男&nbsp;&nbsp;<input checked="${userSex ='女'}" type="radio" name="sex" value="女">女</p>
    <p>选择城市：<select name="home">
        <option value="北京" selected="${userHome == '北京'}">北京</option>
        <option value="上海" selected="${userHome== '上海'}">上海</option>
    </select></p>
    <p>填写个人信息： <textarea name="info" cols="30" rows="10">${userInfo}</textarea></p>
    <p><input type="submit" value="注册">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"></p>
</form>
</body>
<script>
    let inputEvent = document.getElementsByClassName("clearText");
    let textDanger = document.getElementsByClassName("text-danger");
    inputEvent[0].addEventListener("focus", () => {
        textDanger[0].innerHTML = "";
    });
    inputEvent[1].addEventListener("focus", () => {
        textDanger[0].innerHTML = "";
    })
</script>
</html>
