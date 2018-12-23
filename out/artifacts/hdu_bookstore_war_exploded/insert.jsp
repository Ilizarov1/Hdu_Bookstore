<%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/23
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
</head>
<body>
<form action="/insertBooks" method="post" id="inForm">
    <table border="1">
        <tr>
            <td>ISBN</td>
            <td><input type="text" name="isbn"></td>
        </tr>
        <tr>
            <td>书名</td>
            <td><input type="text" name="bookName"></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="writer"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>介绍</td>
            <td><input type="text" name="intro"></td>
        </tr>
    </table>
</form>
<input type="submit" form="inForm" value="添加">
<a href="adminBooks.jsp"><button>返回</button></a>
</body>
</html>
