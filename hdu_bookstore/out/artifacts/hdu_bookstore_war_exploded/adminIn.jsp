<%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/23
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登陆</title>
</head>
<body>
<form action="/getBooks" method="post" id="return"></form>
<form action="/adminIn" method="post" id="adminForm">
    <table border="1">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="adminName"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="pwd"></td>
        </tr>
    </table>
</form>
<input type="submit" value="登陆" form="adminForm">
<input type="button" value="返回" form="return">
</body>
</html>
