package Controller;

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
import java.util.Date;

@WebServlet(name = "SettleBill",urlPatterns = "/settleBill")
public class SettleBill extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        ArrayList<String> cartInfo=(ArrayList<String>)request.getSession().getAttribute("cartInfo");
        OrdersCon oc=new OrdersCon();
        String maxId;
        if(cartInfo!=null)
        {
            Orders orders=new Orders();
            maxId=oc.SelectCountId();
            if(maxId==null)
            {
                maxId="0";
            }
            Date date=new Date();
            String id=Long.toString(date.getTime())+Integer.toString(Integer.parseInt(maxId)+1);
            orders.setId(id);
            String AllInfo=new String();
            for(int i=0;i<cartInfo.size();i++)
            {
                AllInfo+=cartInfo.get(i)+"|";
            }
            orders.setContent(AllInfo);
            orders.setIsdealt(0);

            Users users=(Users)request.getSession().getAttribute("user");
            if(users==null)
            {
                out.println("<html>");
                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
                out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
                out.println("alert('您还没登陆')");
                out.println("window.open ('"+request.getContextPath()+"/login.jsp','_top')");
                out.println("</script>");
                out.println("</html>");
                return;
            }
            orders.setUsername(users.getUsername());
            oc.Insert(orders);
            request.getSession().setAttribute("order",orders);
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('结算成功')");
            out.println("window.open ('"+request.getContextPath()+"/checkBill','_top')");
            out.println("</script>");
            out.println("</html>");
        }
        else
        {
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('购物车是空的')");
            out.println("window.open ('"+request.getContextPath()+"/checkCart','_top')");
            out.println("</script>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
