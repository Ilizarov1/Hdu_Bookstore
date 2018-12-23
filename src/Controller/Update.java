package Controller;

import model.DAO.UsersCon;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Update",urlPatterns = "/update")
public class Update extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String nPassword=request.getParameter("nPwd");
        String nAddress=request.getParameter("nAddress");
        String nPhone=request.getParameter("nPhone");
        Users user=(Users)request.getSession().getAttribute("user");
        Users temp=user;
        user.setPwd(nPassword);
        user.setPhone(nPhone);
        user.setAddress(nAddress);

        UsersCon uc=new UsersCon();
        int result=uc.Update(user);

        if(result==1)
        {
            request.getSession().setAttribute("user",user);
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('修改成功')");
            out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
        }
        else
        {
            user=temp;
            request.getSession().setAttribute("user",user);
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('修改失败')");
            out.println("window.open ('"+request.getContextPath()+"/update.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
