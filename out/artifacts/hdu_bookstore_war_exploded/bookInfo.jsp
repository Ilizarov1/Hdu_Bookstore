<%@ page import="model.Books" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Comments" %><%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/22
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍信息</title>
</head>
<body>
<%
    Books theBook=(Books)request.getSession().getAttribute("theBook");
%>
<table border="1">
    <tr>
        <td>ISBN</td>
        <td><%=theBook.getIsbn()%></td>
    </tr>
    <tr>
        <td>书名</td>
        <td><%=theBook.getBookname()%></td>
    </tr>
    <tr>
        <td>作者</td>
        <td><%=theBook.getWriter()%></td>
    </tr>
    <tr>
        <td>价格</td>
        <td><%=theBook.getPrice()%></td>
    </tr>
    <tr>
        <td>介绍</td>
        <td><%=theBook.getIntro()%></td>
    </tr>
</table>
<table border="1">
    <tr>
        <td>用户名</td>
        <td>评论</td>
    </tr>
    <%
        ArrayList<Comments> commentsList=(ArrayList<Comments>)request.getSession().getAttribute("commentsList");
        for(int i=0;i<commentsList.size();i++)
        {
            Comments com=commentsList.get(i);
            out.print("<tr>");
            out.print("<td>"+com.getUsername()+"</td>");
            out.print("<td>"+com.getComment()+"</td>");
            out.print("</tr>");
        }
    %>
</table>
<form action="/cart" method="post" id="cartForm">
    <input type="hidden" value="<%=theBook.getIsbn()%>" name="isbn">
    <input type="hidden" value="<%=theBook.getBookname()%>" name="bookName">
    <input type="hidden" value="<%=theBook.getPrice()%>" name="price">
</form>
<input type="submit" value="添加购物车" form="cartForm">
<a href="index.jsp"><button>返回</button></a>
<a href="/checkCart"><button>查看购物车</button></a>
</body>
</html>
