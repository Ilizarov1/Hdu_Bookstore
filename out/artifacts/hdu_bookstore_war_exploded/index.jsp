<%--
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
  <form  action="/login" method="post">
    <table border="1">
      <tr>
        <td>用户名</td>
        <td><input  type="text" name="username"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name="password"></td>
      </tr>
    </table>
    <button>登陆</button>
  </form>
  <form class="form1" action="/signup" method="post">
    <input type="submit" value="注册">
  </form>
  </div>
  </body>
</html>
