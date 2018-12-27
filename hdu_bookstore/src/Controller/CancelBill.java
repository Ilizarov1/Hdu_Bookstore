package Controller;

import model.DAO.OrdersCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CancelBill",urlPatterns = "/cancelBill")
public class CancelBill extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String id=request.getParameter("id");
        OrdersCon oc=new OrdersCon();
        int result=oc.DeleteById(id);
        if(result==1)
        {
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('退订成功')");
            out.println("window.open ('"+request.getContextPath()+"/checkBill','_top')");
            out.println("</script>");
            out.println("</html>");
        }
        else
        {
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('退订失败')");
            out.println("window.open ('"+request.getContextPath()+"/checkBill','_top')");
            out.println("</script>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
