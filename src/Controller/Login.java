package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.DAO.UsersCon;
import model.Users;

@WebServlet(name = "Login",urlPatterns = "/login")
public class Login extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String user=request.getParameter("username");
        String pwd=request.getParameter("password");
        PrintWriter out = response.getWriter();
        UsersCon userCon=new UsersCon();
        ArrayList<Users> list=userCon.SelectAll();
        System.out.println("用户表中有用户："+list.size());
        Boolean loginTag=false;
        Users temp=null;
        for(int i=0;i<list.size();i++)
        {
            temp=list.get(i);
            if(user.equals(temp.getUsername()) && pwd.equals(temp.getPwd()))
            {
                loginTag=true;
                break;
            }
        }
        request.getSession().setAttribute("loginTag",loginTag);
        if(loginTag)
        {
            request.getSession().setAttribute("user",temp);
            out.println("<html>");
            out.println("<script>");
            out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
        }
        else
        {
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('登陆失败')");
            out.println("window.open ('"+request.getContextPath()+"/login.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
