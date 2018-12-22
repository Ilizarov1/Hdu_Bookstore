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
        String user=request.getParameter("username");
        String pwd=request.getParameter("password");
        PrintWriter out = response.getWriter();
        UsersCon userCon=new UsersCon();
        ArrayList<Users> list=userCon.SelectAll();
        System.out.println("用户表中有用户："+list.size());
        Boolean loginTag=false;
        for(int i=0;i<list.size();i++)
        {
            Users temp=list.get(i);
            if(user.equals(temp.getUsername()) && pwd.equals(temp.getPwd()))
            {
                loginTag=true;
                break;
            }
        }
        if(loginTag)
        {
            request.getSession().setAttribute("username",user);
            out.println("<html>");
            out.println("<script>");
            out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
