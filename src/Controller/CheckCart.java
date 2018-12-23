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
        ArrayList<Books> cartList=(ArrayList<Books>) request.getSession().getAttribute("cartList");
        ArrayList<String> cartInfo=new ArrayList<>();
        if(cartList!=null)
        {
            for(int i=0;i<cartList.size();i++)
            {
                int count=1;
                Books abook=cartList.get(i);
                for(int j=i+1;j<cartList.size();j++)
                {
                    Books sbook=cartList.get(j);
                    if(sbook.getIsbn().equals(abook.getIsbn()))
                    {
                        count++;
                        cartList.remove(j);
                    }
                }
                String info=abook.getIsbn()+"#"+abook.getBookname()+"#"+abook.getPrice()+"#"+count;
                cartInfo.add(info);
            }
        }
        String remove=request.getParameter("remove");
        System.out.println(remove);
        if(remove!=null)
        {
            for(int i=0;i<cartInfo.size();i++)
            {
                if(remove.equals(cartInfo.get(i)))
                {
                    cartInfo.remove(i);
                    break;
                }
            }
        }
        request.getSession().setAttribute("cartInfo",cartInfo);
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
