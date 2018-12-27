package Controller;

import model.DAO.BooksCon;
import model.DAO.OrdersCon;
import model.Orders;
import model.Books;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CommentTurn",urlPatterns = "/commentTurn")
public class CommentTurn extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String orderid=request.getParameter("orderid");
        OrdersCon oc=new OrdersCon();
        BooksCon bc=new BooksCon();
        Orders orders=oc.SelectById(orderid);
        ArrayList<Books> booksInOrder=new ArrayList<>();
        Books abook=bc.SelectByIsbn(orders.getIsbn());
        booksInOrder.add(abook);
            request.getSession().setAttribute("booksInOrder",booksInOrder);
            out.println("<html>");
            out.println("<script>");
            out.println("window.open ('"+request.getContextPath()+"/comment.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
