<%@ page import="model.Books" %><%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/23
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑书籍</title>
</head>
<body>
<%
    Books abook=(Books)request.getSession().getAttribute("book_updating");
%>
<form action="/updateBook" method="post">
<table border="1">
    <tr>
        <td>ISBN</td>
        <td><%=abook.getIsbn()%></td>
    </tr>
    <tr>
        <td>原书名</td>
        <td><%=abook.getBookname()%></td>
    </tr>
    <tr>
        <td>新书名</td>
        <td><input type="text" name="nBookName"></td>
    </tr>
    <tr>
        <td>原作者</td>
        <td><%=abook.getWriter()%></td>
    </tr>
    <tr>
        <td>新作者</td>
        <td><input type="text" name="nWriter"></td>
    </tr>
    <tr>
        <td>原价格</td>
        <td><%=abook.getPrice()%></td>
    </tr>

    <tr>
        <td>新价格</td>
        <td><input type="text" name="nPrice"></td>
    </tr>
    <tr>
        <td>原介绍</td>
        <td><%=abook.getIntro()%></td>
    </tr>
    <tr>
        <td>新介绍</td>
        <td><input type="text" name="nIntro"></td>
    </tr>
</table>
    <input type="submit" value="提交修改">
</form>
</body>
</html>
