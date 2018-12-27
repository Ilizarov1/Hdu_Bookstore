package Controller;

import model.Books;
import model.Comments;
import model.DAO.CommentsCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GetInfo",urlPatterns = "/getInfo")
public class GetInfo extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String isbn=request.getParameter("isbn");
        PrintWriter out=response.getWriter();
        ArrayList<Books> list=(ArrayList<Books>)request.getSession().getAttribute("booksList");
        Books book=null;
        for(int i=0;i<list.size();i++)
        {
            book=list.get(i);
            if(isbn.equals(book.getIsbn()))
            {
                break;
            }
        }
        CommentsCon cc=new CommentsCon();
        ArrayList<Comments> commentsList=cc.SelectByIsbn(book.getIsbn());
        request.getSession().setAttribute("theBook",book);
        request.getSession().setAttribute("commentsList",commentsList);
        out.println("<html>");
        out.println("<script>");
        out.println("window.open ('"+request.getContextPath()+"/bookInfo.jsp','_top')");
        out.println("</script>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
