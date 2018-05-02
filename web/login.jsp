<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/4/28
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <style>
        .text-danger {
            font-size: 12px;
            color: red;
        }
    </style>
</head>
<body>
<form action="DengluServlet" method="post">
    <p>用户名：<input type="text" name="name" value="${Dangername}" class="clearText"></p>
    <p>密码：<input type="text" name="pwd" value="${Dangerpwd}" class="clearText"></p>
    <p class="text-danger">${pwdDanger}</p>
    <p class="text-danger">${userDanger}</p>
    <p><input type="submit" value="登录" name="denglu">
        <input type="reset" value="重置">
    </p>
</form>
<form action="zhuce.jsp" method="post">
    <p><input type="submit" value="新用户注册"></p>
</form>
</body>
<script>
    let inputEvent = document.getElementsByClassName("clearText");
    let textDanger = document.getElementsByClassName("text-danger");
    inputEvent[0].addEventListener("focus", () => {
        console.log(textDanger.length);
        if (textDanger[0].innerHTML || textDanger[1].innerHTML) {
            textDanger[0].innerHTML = "";
            textDanger[1].innerHTML = "";
        }
    });
    inputEvent[1].addEventListener("focus", () => {
        if (textDanger[0].innerHTML || textDanger[1].innerHTML) {
            textDanger[0].innerHTML = "";
            textDanger[1].innerHTML = "";
        }
    })
</script>
</html>
