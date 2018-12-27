package Controller;

import model.Books;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Cart",urlPatterns = "/cart")
public class Cart extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        String isbn=request.getParameter("isbn");
        String bookName=request.getParameter("bookName");
        String price=request.getParameter("price");
        Books abook=new Books();
        abook.setIsbn(isbn);
        abook.setBookname(bookName);
        abook.setPrice(Float.parseFloat(price));
        ArrayList<Books> cartList=null;
        cartList=(ArrayList<Books>) request.getSession().getAttribute("cartList");
        if(cartList==null)
        {
            cartList=new ArrayList<>();
        }
        cartList.add(abook);
        request.getSession().setAttribute("cartList",cartList);
        out.println("<html>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        out.println("<script language=\"JavaScript\" charset=\"UTF-8\">");
        out.println("alert('添加成功')");
        out.println("window.open ('"+request.getContextPath()+"/bookInfo.jsp','_top')");
        out.println("</script>");
        out.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
