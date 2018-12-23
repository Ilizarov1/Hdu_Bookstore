<%@ page import="model.Orders" %>
<%@ page import="java.util.ArrayList" %><%--
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
        for(int i=0;i<ordersList.size();i++)
        {
            String isdealt="发货中...";
            Orders order=ordersList.get(i);
            if(order.getIsdealt()==1)
            {
                isdealt="订单已完成";
            }
            String[] contents=order.getContent().split("\\|");
            out.print("<tr>");
            out.print("<td rowspan=\""+contents.length+"\">");
            out.print(order.getId());
            out.print("</td>");
            out.print("<td>"+contents[0]+"</td>");
            out.print("<td rowspan=\""+contents.length+"\">");
            out.print(order.getUsername());
            out.print("</td>");
            out.print("<td rowspan=\""+contents.length+"\">");
            out.print(isdealt);
            out.print("</td>");
            out.print("<td rowspan=\""+contents.length+"\">");
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
            for(int j=1;j<contents.length;j++)
            {
                out.print("<tr>");
                out.print("<td>"+contents[j]+"</td>");
                out.print("</tr>");
            }
        }
    %>
</table>
<a href="index.jsp"><button>返回主页</button></a>
</body>
</html>
