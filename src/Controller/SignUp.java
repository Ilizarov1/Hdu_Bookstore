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

@WebServlet(name = "SignUp",urlPatterns = "/signup")
public class SignUp extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String nUsername=request.getParameter("nUsername");
        String nPassword=request.getParameter("nPassword");
        String nAddress=request.getParameter("nAddress");
        String nPhone=request.getParameter("nPhone");
        Users user=new Users();
        user.setUsername(nUsername);
        user.setPwd(nPassword);
        user.setAddress(nAddress);
        user.setPhone(nPhone);
        UsersCon uc=new UsersCon();
        int result=uc.Insert(user);

        if(result==1)
        {
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('注册成功')");
            out.println("window.open ('"+request.getContextPath()+"/login.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
        }
        else
        {
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('注册失败')");
            out.println("window.open ('"+request.getContextPath()+"/signup.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
