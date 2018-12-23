package Controller;

import model.Books;
import model.DAO.BooksCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GetBooks",urlPatterns = "/getBooks")
public class GetBooks extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        BooksCon bc=new BooksCon();
        String DESC=request.getParameter("DESC");
        String ASC=request.getParameter("ASC");
        ArrayList<Books> list;
        if(DESC!=null)
        {
            list=bc.SelectAllByDESC();
        }
        else if(ASC!=null)
        {
            list=bc.SelectAllByASC();
        }
        else
        {
            list=bc.SelectAll();
        }
        System.out.println("书籍表中有："+list.size()+"记录");
        PrintWriter out=response.getWriter();
        request.getSession().setAttribute("booksList",list);
        out.println("<html>");
        out.println("<script>");
        out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')");
        out.println("</script>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
