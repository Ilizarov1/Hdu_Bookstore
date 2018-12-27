package model.DAO;

import JDBC.MyJdbc;
import model.Books;
import model.Users;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BooksCon implements BooksDAO
{
    @Override
    public ArrayList<Books> SelectAll()
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Books> list=new ArrayList<>();
        Books book=null;

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.books";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next())
            {
                book =new Books();
                book.setIsbn(rs.getString("ISBN"));
                book.setBookname(rs.getString("bookName"));
                book.setWriter(rs.getString("writer"));
                book.setIntro(rs.getString("intro"));
                book.setPrice(rs.getFloat("price"));
                list.add(book);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public ArrayList<Books> SelectAllByDESC()
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Books> list=new ArrayList<>();
        Books book=null;

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.books ORDER BY price DESC";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next())
            {
                book =new Books();
                book.setIsbn(rs.getString("ISBN"));
                book.setBookname(rs.getString("bookName"));
                book.setWriter(rs.getString("writer"));
                book.setIntro(rs.getString("intro"));
                book.setPrice(rs.getFloat("price"));
                list.add(book);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public ArrayList<Books> SelectAllByASC()
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Books> list=new ArrayList<>();
        Books book=null;

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.books ORDER BY price ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next())
            {
                book =new Books();
                book.setIsbn(rs.getString("ISBN"));
                book.setBookname(rs.getString("bookName"));
                book.setWriter(rs.getString("writer"));
                book.setIntro(rs.getString("intro"));
                book.setPrice(rs.getFloat("price"));
                list.add(book);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Books SelectByBookName(String name)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Books book=null;

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.books WHERE bookName=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if (rs.next())
            {
                book =new Books();
                book.setIsbn(rs.getString("ISBN"));
                book.setBookname(rs.getString("bookName"));
                book.setWriter(rs.getString("writer"));
                book.setIntro(rs.getString("intro"));
                book.setPrice(rs.getFloat("price"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return book;
    }
    @Override
    public Books SelectByIsbn(String isbn)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Books book=null;

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.books WHERE ISBN=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,isbn);
            rs=ps.executeQuery();
            if (rs.next())
            {
                book =new Books();
                book.setIsbn(rs.getString("ISBN"));
                book.setBookname(rs.getString("bookName"));
                book.setWriter(rs.getString("writer"));
                book.setIntro(rs.getString("intro"));
                book.setPrice(rs.getFloat("price"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return book;
    }
    @Override
    public int Update(Books book)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try
        {
            con= MyJdbc.getConnection();
            String sql="UPDATE dbo.books SET bookName=?,writer=?,price=?,intro=? where ISBN=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,book.getBookname());
            ps.setString(2,book.getWriter());
            ps.setFloat(3,book.getPrice());
            ps.setString(4,book.getIntro());
            ps.setString(5,book.getIsbn());
            result=ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int Delete(String isbn)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try
        {
            con= MyJdbc.getConnection();
            String sql="DELETE FROM dbo.books WHERE ISBN=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,isbn);
            result=ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            MyJdbc.free(con,ps,rs);
        }
        return result;
    }

    @Override
    public int Insert(Books book)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try
        {
            con= MyJdbc.getConnection();
            String sql="INSERT INTO dbo.books(ISBN,bookName,writer,price,intro) VALUES (?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,book.getIsbn());
            ps.setString(2,book.getBookname());
            ps.setString(3,book.getWriter());
            ps.setFloat(4,book.getPrice());
            ps.setString(5,book.getIntro());
            result=ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
