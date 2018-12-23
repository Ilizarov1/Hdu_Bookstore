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

@WebServlet(name = "UpdateBTurn",urlPatterns = "/updateBTurn")
public class UpdateBTurn extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String isbn=request.getParameter("isbn");
        BooksCon bc=new BooksCon();
        Books abook=bc.SelectByIsbn(isbn);
        request.getSession().setAttribute("book_updating",abook);
        out.println("<html>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
        out.println("window.open ('"+request.getContextPath()+"/updateBook.jsp','_top')");
        out.println("</script>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
