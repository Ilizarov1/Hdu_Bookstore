<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Books" %><%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/22
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<form action="/checkCart" method="post" id="delete"></form>
<table border="1">
    <tr>
        <th>ISBN</th>
        <th>书名</th>
        <th>价格</th>
        <th>操作</th>
    </tr>
<%
    ArrayList<Books> cartList=(ArrayList<Books>)request.getSession().getAttribute("cartList");
    ArrayList<Float> prices=new ArrayList<>();
    if(cartList!=null)
    {

        for(int i=0;i<cartList.size();i++)
        {
            Books abook=cartList.get(i);
            prices.add(abook.getPrice());
            out.print("<tr>");
            out.print("<td>"+abook.getIsbn());
            out.print("</td>");
            out.print("<td>"+abook.getBookname());
            out.print("</td>");
            out.print("<td>"+abook.getPrice());
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"hidden\" value=\""+abook.getIsbn()+"\" name=\"remove\" form=\"delete\">");
            out.print("<input type=\"submit\" value=\"删除\" form=\"delete\" ");
            out.print("</td>");
            out.print("</tr>");
        }
    }
%>
</table>
<form action="/settleBill" method="post" id="settleForm">
</form>
<%
    float sum=0;
    for(int i=0;i<prices.size();i++)
    {
        sum+=prices.get(i);
    }
    out.print("总价格："+sum);
%>
<input type="submit" value="结算" form="settleForm">
<a href="/bookInfo.jsp"><button>返回</button></a>
</body>
</html>
