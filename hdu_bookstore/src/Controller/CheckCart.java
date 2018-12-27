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

@WebServlet(name = "CheckCart",urlPatterns = "/checkCart")
public class CheckCart extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        ArrayList<Books> cartList=(ArrayList<Books>)request.getSession().getAttribute("cartList");
        String remove=request.getParameter("remove");
        if(remove!=null)
        {
            for(int i=0;i<cartList.size();i++)
            {
                if(remove.equals(cartList.get(i).getIsbn()))
                {
                    cartList.remove(i);
                    break;
                }
            }
        }

        out.println("<html>");
        out.println("<script>");
        out.println("window.open ('"+request.getContextPath()+"/cart.jsp','_top')");
        out.println("</script>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doPost(request,response);
    }
}
