<%@ page import="model.Books" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/23
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍管理</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ISBN</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
        <th>介绍</th>
        <th>操作</th>
    </tr>
    <%
        ArrayList<Books> booksList=(ArrayList<Books>)request.getSession().getAttribute("booksList");
        for(int i=0;i<booksList.size();i++)
        {
            Books book=booksList.get(i);
            out.println("<tr>");
            out.print("<td>"+book.getIsbn()+"</td>");
            out.print("<td>"+book.getBookname()+"</td>");
            out.println("<td>");
            out.println(book.getWriter());
            out.println("</td>");
            out.println("<td>");
            out.println(book.getPrice());
            out.println("</td>");
            out.print("<td>"+book.getIntro()+"</td>");
            out.print("<td><a href=\"/updateBTurn?isbn="+book.getIsbn()+"\">编辑</a></br>" +
                    "<a href=\"/deleteBooks?isbn="+book.getIsbn()+"\">删除</a></td>");
            out.println("</tr>");
        }
    %>
</table>
<form action="insert.jsp" method="post" id="insert">
</form>
<input type="submit" value="添加书籍" form="insert">
<a href="index.jsp"><button>返回</button></a>
</body>
</html>
