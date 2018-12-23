<%@ page import="model.Users" %><%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/22
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
</head>
<body>
<form action="/update" method="post" id="upForm">
    <table border="1">
        <tr>
            <td>用户名</td>
            <td><%=((Users)request.getSession().getAttribute("user")).getUsername()%></td>
        </tr>
        <tr>
            <td>原密码</td>
            <td><%=((Users)request.getSession().getAttribute("user")).getPwd()%></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td><input type="password" name="nPwd"></td>
        </tr>
        <tr>
            <td>原地址</td>
            <td><%=((Users)request.getSession().getAttribute("user")).getAddress()%></td>
        </tr>
        <tr>
            <td>新地址</td>
            <td><input type="text" name="nAddress"></td>
        </tr>
        <tr>
            <td>原电话</td>
            <td><%=((Users)request.getSession().getAttribute("user")).getPhone()%></td>
        </tr>
        <tr>
            <td>新电话</td>
            <td><input type="text" name="nPhone"></td>
        </tr>
    </table>
</form>
<input type="submit" value="提交" form="upForm">
<a href="index.jsp"><button>返回</button></a>
</body>
</html>
