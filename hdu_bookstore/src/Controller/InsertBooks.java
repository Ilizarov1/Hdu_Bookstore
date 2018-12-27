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
import java.text.DecimalFormat;

@WebServlet(name = "InsertBooks",urlPatterns = "/insertBooks")
public class InsertBooks extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String isbn=request.getParameter("isbn");
        String bookName=request.getParameter("bookName");
        String writer=request.getParameter("writer");
        String price=request.getParameter("price");
        String intro=request.getParameter("intro");
        Books book=new Books();
        book.setIsbn(isbn);
        book.setBookname(bookName);
        book.setWriter(writer);
        DecimalFormat df = new DecimalFormat("#########.##");
        book.setPrice(Float.parseFloat(df.format(Float.parseFloat(price))));
        book.setIntro(intro);
        BooksCon bc=new BooksCon();
        int result=bc.Insert(book);
        if(result==1)
        {
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('编辑成功')");
            out.println("window.open ('"+request.getContextPath()+"/checkBooks','_top')");
            out.println("</script>");
            out.println("</html>");
        }
        else
        {
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('编辑失败')");
            out.println("window.open ('"+request.getContextPath()+"/checkBooks','_top')");
            out.println("</script>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
