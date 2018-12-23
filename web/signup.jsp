<%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/22
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="/signup" method="post">
<table border="1">
    <tr>
        <td>用户名</td>
        <td><input type="text" name="nUsername"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="password" name="nPassword"></td>
    </tr>
    <tr>
        <td>地址</td>
        <td><input type="text" name="nAddress"></td>
    </tr>
    <tr>
        <td>电话</td>
        <td><input type="text" name="nPhone"></td>
    </tr>
</table>
    <input type="submit" value="注册">
    <input type="reset" value="重置">
</form>
</body>
</html>
