<%@ page import="java.util.ArrayList" %><%--
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
        <th>数量</th>
        <th>操作</th>
    </tr>
<%
    ArrayList<String> cartInfo=(ArrayList<String>)request.getSession().getAttribute("cartInfo");
    ArrayList<String> names=new ArrayList<>();
    ArrayList<String> ISBNs=new ArrayList<>();
    ArrayList<Float> prices=new ArrayList<>();
    ArrayList<Integer> counts=new ArrayList<>();
    if(cartInfo!=null)
    {
        for(int i=0;i<cartInfo.size();i++)
        {
            String info[]=cartInfo.get(i).split("#");
            ISBNs.add(info[0]);
            names.add(info[1]);
            prices.add(Float.parseFloat(info[2]));
            counts.add(Integer.parseInt(info[3]));
            out.print("<tr>");
            out.print("<td>"+ISBNs.get(i));
            out.print("</td>");
            out.print("<td>"+names.get(i));
            out.print("</td>");
            out.print("<td>"+prices.get(i));
            out.print("</td>");
            out.print("<td>"+counts.get(i));
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"hidden\" value=\""+cartInfo.get(i)+"\" name=\"remove\" form=\"delete\">");
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
        sum+=prices.get(i)*counts.get(i);
    }
    out.print("总价格："+sum);
%>
<input type="submit" value="结算" form="settleForm">
<a href="/bookInfo.jsp"><button>返回</button></a>
</body>
</html>
