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

@WebServlet(name = "Search",urlPatterns = "/search")
public class Search extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String searchName=request.getParameter("searchName");
        BooksCon bc=new BooksCon();
        ArrayList<Books> list=new ArrayList<>();
        Books result=bc.SelectByBookName(searchName);
        if(result==null)
        {
            out.println("<html>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
            out.println("alert('搜索失败')");
            out.println("window.open ('"+request.getContextPath()+"/getBooks','_top')");
            out.println("</script>");
            out.println("</html>");
        }
        else
        {
            list.add(bc.SelectByBookName(searchName));
            request.getSession().setAttribute("booksList",list);
            out.println("<html>");
            out.println("<script>");
            out.println("window.open ('"+request.getContextPath()+"/index.jsp','_top')");
            out.println("</script>");
            out.println("</html>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
