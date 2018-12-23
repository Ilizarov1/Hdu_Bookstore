package Controller;

import model.Books;
import model.DAO.OrdersCon;
import model.Orders;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CheckBill",urlPatterns = "/checkBill")
public class CheckBill extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        OrdersCon oc=new OrdersCon();
        Object obj=request.getSession().getAttribute("adminTag");
        if(obj!=null)
        {
            Boolean adminTag=(Boolean)obj;
            if(adminTag)
            {
                ArrayList<Orders> ordersList=oc.SelectAll();
                request.getSession().setAttribute("ordersList",ordersList);
                out.println("<html>");
                out.println("<script>");
                out.println("window.open ('"+request.getContextPath()+"/adminBill.jsp','_top')");
                out.println("</script>");
                out.println("</html>");
            }
        }
        else
        {
            Users user=(Users)request.getSession().getAttribute("user");

            ArrayList<Orders> orderList=oc.SelectByName(user.getUsername());
            request.getSession().setAttribute("orderList",orderList);
            out.println("<html>");
            out.println("<script>");
            out.println("window.open ('"+request.getContextPath()+"/bill.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
