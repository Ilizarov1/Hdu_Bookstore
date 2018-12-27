package Controller;

import model.Admins;
import model.DAO.AdminsCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AdminIn",urlPatterns = "/adminIn")
public class AdminIn extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        AdminsCon ac=new AdminsCon();
        ArrayList<Admins> adminsList=ac.SelectAll();
        String adminname=request.getParameter("adminName");
        String pwd=request.getParameter("pwd");
        Boolean adminTag=false;
        Admins temp=new Admins();
        for(int i=0;i<adminsList.size();i++)
        {
            temp=adminsList.get(i);
            if(temp.getAdminName().equals(adminname) && temp.getPwd().equals(pwd))
            {

                adminTag=true;
                break;
            }
        }
        request.getSession().setAttribute("adminTag",adminTag);
        if(adminTag)
        {
            request.getSession().setAttribute("admin",temp);
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
            out.println("window.open ('" + request.getContextPath() + "/login.jsp','_top')");
            out.println("</script>");
            out.println("</html>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
