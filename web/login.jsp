<%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/22
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form  action="/login" method="post" id="loginForm">
    <table border="1">
        <tr>
            <td>用户名</td>
            <td><input  type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
    </table>
</form>
<div style="float: left">
<input type="submit" value="登陆" form="loginForm">
</div>
<div style="float: left">
<form action="/signup.jsp" method="post">
    <input type="submit" value="注册">
</form>
</div>
</body>
</html>
