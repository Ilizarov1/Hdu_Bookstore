<%@ page import="model.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Books" %>
<%@ page import="model.Admins" %><%--
  Created by IntelliJ IDEA.
  User: zjzjn
  Date: 2018/12/21
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcome!</title>
  </head>
  <body>
    <div>
        <form action="/getBooks" method="post" id="DESC">
            <input type="hidden" value="DESC" name="DESC">
        </form>
        <form action="/getBooks" method="post" id="ASC" >
            <input type="hidden" value="ASC" name="ASC">
        </form>
        <form action="/search" method="post" id="searchForm">
        </form>
        <input type="submit" value="价格降序" form="DESC">
        <input type="submit" value="价格升序" form="ASC">
        <input type="text" name="searchName" form="searchForm">
        <input type="submit" value="搜索书名" form="searchForm">
        <table border="1">
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>价格</th>
            </tr>
            <%
                ArrayList<Books> booksList=(ArrayList<Books>)request.getSession().getAttribute("booksList");
                for(int i=0;i<booksList.size();i++)
                {
                    Books book=booksList.get(i);
                    out.println("<tr>");
                    out.println("<td>");
                    out.println("<a href=\"/getInfo?isbn="+book.getIsbn()+"\">"+book.getBookname()+"</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println(book.getWriter());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(book.getPrice());
                    out.println("</td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </div>
  <div>

      <%
          Boolean loginTag=false;
          Boolean adminTag=false;
        Object obj=request.getSession().getAttribute("loginTag");
        Object obj_ad=request.getSession().getAttribute("adminTag");

        if(obj==null && obj_ad==null)
        {
            out.print("      <a href=\"login.jsp\"><button>登陆</button></a>\n" +
                    "      <a href=\"signup.jsp\"><button>注册</button></a>");
            out.print("<a href=\"adminIn.jsp\"><button>管理员登陆</button></a>");
        }
        else if(obj!=null && obj_ad==null)
        {
            loginTag=(Boolean)obj;
            if(loginTag)
            {
                out.print("欢迎,"+((Users)request.getSession().getAttribute("user")).getUsername());
                out.print("<a href=\"update.jsp\"><button>修改个人信息</button></a>");
                out.print("<a href=\"/checkBill\"><button>查看订单</button></a>");
            }
            else
            {
                out.print("      <a href=\"login.jsp\"><button>登陆</button></a>\n" +
                        "      <a href=\"signup.jsp\"><button>注册</button></a>");
                out.print("<a href=\"adminIn.jsp\"><button>管理员登陆</button></a>");
            }
        }
        else if (obj==null && obj_ad!=null)
        {
            adminTag=(Boolean)obj_ad;
            if(adminTag)
            {
                out.print("欢迎管理员,"+((Admins)request.getSession().getAttribute("admin")).getAdminName());
                out.print("<a href=\"/checkBill\"><button>查看所有订单</button></a>");
                out.print("<a href=\"/checkBooks\"><button>编辑书籍</button></a>");
            }
        }
      %>

  </div>
  </body>
</html>
