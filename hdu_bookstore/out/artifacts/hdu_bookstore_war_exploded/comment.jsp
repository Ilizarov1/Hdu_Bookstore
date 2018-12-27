<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Books" %><%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/23
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论</title>
</head>
<body>
<form action="/inComment" method="post">
<table>
    <tr>
        <th>ISBN</th>
        <th>书名</th>
        <th>评论</th>
    </tr>
    <%
        ArrayList<Books> booksInOrder=(ArrayList<Books>)request.getSession().getAttribute("booksInOrder");
        for(int i=0;i<booksInOrder.size();i++)
        {
            Books tempBook=booksInOrder.get(i);
            out.print("<tr>");
            out.print("<td>"+tempBook.getIsbn()+"</td>");
            out.print("<td>"+tempBook.getBookname()+"</td>");
            out.print("<td><input type=\"text\" name=\"comment"+tempBook.getIsbn()+"\"></td>");
            out.print("</tr>");
        }
    %>
</table>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
