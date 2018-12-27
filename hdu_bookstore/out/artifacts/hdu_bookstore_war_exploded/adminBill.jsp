<%@ page import="model.Orders" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Books" %>
<%@ page import="model.DAO.BooksCon" %><%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/23
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单处理</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>内容</th>
        <th>用户名</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <%
        ArrayList<Orders> ordersList=(ArrayList<Orders>)request.getSession().getAttribute("ordersList");
        BooksCon bc=new BooksCon();
        for(int i=0;i<ordersList.size();i++)
        {
            String isdealt="发货中...";
            Orders order=ordersList.get(i);
            if(order.getIsdealt()==1)
            {
                isdealt="订单已完成";
            }
            out.print("<tr>");
            out.print("<td>");
            out.print(order.getId());
            out.print("</td>");
            out.print("<td>"+bc.SelectByIsbn(order.getIsbn()).getBookname()+"</td>");
            out.print("<td>");
            out.print(order.getUsername());
            out.print("</td>");
            out.print("<td>");
            out.print(isdealt);
            out.print("</td>");
            out.print("<td>");
            if(order.getIsdealt()==1)
            {
                out.print("<a href=\"#\">无</a>");
            }
            else
            {
                out.print("<a href=\"/changeIsdealt?id="+order.getId()+"&isdealt="+1+"\">确认</a></br>");
                out.print("<a href=\"/cancelBill?id="+order.getId()+"\">取消</a>");
            }

            out.print("</td>");
            out.print("</tr>");
        }
    %>
</table>
<a href="index.jsp"><button>返回主页</button></a>
</body>
</html>
