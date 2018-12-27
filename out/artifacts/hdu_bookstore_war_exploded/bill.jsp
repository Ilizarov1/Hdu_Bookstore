<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Orders" %>
<%@ page import="model.Users" %>
<%@ page import="model.DAO.BooksCon" %><%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/22
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>内容</th>
        <th>地址</th>
        <th>电话</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <%
        ArrayList<Orders> orderList=(ArrayList<Orders>)request.getSession().getAttribute("orderList");
        Users user=(Users)request.getSession().getAttribute("user");
        BooksCon bc=new BooksCon();
        for(int i=0;i<orderList.size();i++)
        {
            String isdealt="发货中...";
            Orders order=orderList.get(i);
            if(order.getIsdealt()==1)
            {
                isdealt="订单已完成";
            }
            out.print("<tr>");
            out.print("<td>"+order.getId());
            out.print("</td>");
            out.print("<td>"+bc.SelectByIsbn(order.getIsbn()).getBookname()+"</td>");
            out.print("<td>");
            out.print(user.getAddress());
            out.print("</td>");
            out.print("<td>");
            out.print(user.getPhone());
            out.print("</td>");
            out.print("<td>");
            out.print(isdealt);
            out.print("</td>");
            out.print("<td>");
            if(order.getIsdealt()==1)
            {
                out.print("<a href=\"/commentTurn?orderid="+order.getId()+"\">评论</a>");
            }
            else
            {
                out.print("<a href=\"/changeIsdealt?id="+order.getId()+"&isdealt="+1+"\">确认</a></br>");
                out.print("<a href=\"/cancelBill?id="+order.getId()+"\">退订</a>");
            }

            out.print("</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
