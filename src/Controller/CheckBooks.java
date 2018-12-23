package Controller;

import model.Books;
import model.DAO.BooksCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CheckBooks",urlPatterns = "/checkBooks")
public class CheckBooks extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();

        BooksCon bc=new BooksCon();
        ArrayList<Books> list;
        list=bc.SelectAll();
        request.getSession().setAttribute("booksList",list);

        out.println("<html>");
        out.println("<script>");
        out.println("window.open ('"+request.getContextPath()+"/adminBooks.jsp','_top')");
        out.println("</script>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
