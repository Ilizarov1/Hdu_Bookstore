package Controller;

import model.Books;
import model.Comments;
import model.DAO.CommentsCon;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "InsertComm",urlPatterns = "/inComment")
public class InsertComm extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();

        ArrayList<Books> booksInOrder=(ArrayList)request.getSession().getAttribute("booksInOrder");
        Users user=(Users)request.getSession().getAttribute("user");
        for(int i=0;i<booksInOrder.size();i++)
        {
            Books tempBook=booksInOrder.get(i);
            Comments comment=new Comments();
            CommentsCon cc=new CommentsCon();
            String id;
            id=cc.SelectCountId();
            if(id==null)
            {
                id="0";
            }
            Date date=new Date();
            id=Long.toString(date.getTime())+Integer.toString(Integer.parseInt(id)+1);
            comment.setId(id);
            comment.setIsbn(tempBook.getIsbn());
            comment.setUsername(user.getUsername());
            comment.setComment(request.getParameter("comment"+tempBook.getIsbn()));
            cc.Insert(comment);
        }
        out.println("<html>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
        out.println("alert('评论成功')");
        out.println("window.open ('"+request.getContextPath()+"/getBooks','_top')");
        out.println("</script>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
