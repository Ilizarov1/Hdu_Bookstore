package model.DAO;

import JDBC.MyJdbc;
import model.Books;
import model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersCon implements OrdersDAO
{
    @Override
    public int Insert(Orders order)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try
        {
            con= MyJdbc.getConnection();
            String sql="INSERT INTO dbo.orders(id,username,isbn,isdealt) VALUES (?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,order.getId());
            ps.setString(2,order.getUsername());
            ps.setString(3,order.getIsbn());
            ps.setInt(4,order.getIsdealt());
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
    public String SelectCountId()
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String result=null;

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT COUNT (id) AS r FROM dbo.orders";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next())
            {
                result=rs.getString("r");
            }
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
    public ArrayList<Orders> SelectByName(String username)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Orders> list=new ArrayList<>();
        Orders order=null;
        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.orders WHERE username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,username);
            rs=ps.executeQuery();
            while (rs.next())
            {
                order=new Orders();
                order.setId(rs.getString("id"));
                order.setUsername(rs.getString("username"));
                order.setIsbn(rs.getString("isbn"));
                order.setIsdealt(rs.getInt("isdealt"));
                list.add(order);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            MyJdbc.free(con,ps,rs);
        }
        return list;
    }

    @Override
    public int DeleteById(String id)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try
        {
            con= MyJdbc.getConnection();
            String sql="DELETE FROM dbo.orders WHERE id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,id);
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
    public int UpdateIsDealt(String id,int isdealt)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try
        {
            con= MyJdbc.getConnection();
            String sql="UPDATE dbo.orders SET isdealt=? FROM dbo.orders WHERE id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,isdealt);
            ps.setString(2,id);
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
    public Orders SelectById(String id)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Orders order=null;
        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.orders WHERE id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,id);
            rs=ps.executeQuery();
            if (rs.next())
            {
                order=new Orders();
                order.setId(rs.getString("id"));
                order.setUsername(rs.getString("username"));
                order.setIsbn(rs.getString("isbn"));
                order.setIsdealt(rs.getInt("isdealt"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            MyJdbc.free(con,ps,rs);
        }
        return order;
    }
    @Override
    public ArrayList<Orders> SelectAll()
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Orders> list=new ArrayList<>();
        Orders order=null;

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.orders";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next())
            {
                order=new Orders();
                order.setId(rs.getString("id"));
                order.setIsdealt(rs.getInt("isdealt"));
                order.setIsbn(rs.getString("isbn"));
                order.setUsername(rs.getString("username"));
                list.add(order);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
