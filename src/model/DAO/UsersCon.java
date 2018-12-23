package model.DAO;

import JDBC.MyJdbc;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersCon implements UsersDAO
{
    @Override
    public ArrayList<Users> SelectAll()
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Users> list=new ArrayList<>();
        Users users =null;

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.users";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next())
            {
                users =new Users();
                users.setUsername(rs.getString("username"));
                users.setPwd(rs.getString("pwd"));
                users.setAddress(rs.getString("address"));
                users.setPhone(rs.getString("phone"));
                list.add(users);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public int Insert(Users user)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try
        {
            con= MyJdbc.getConnection();
            String sql="INSERT INTO dbo.users(username,pwd,address,phone) VALUES (?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPwd());
            ps.setString(3,user.getAddress());
            ps.setString(4,user.getPhone());
            result=ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public int Update(Users user)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try
        {
            con= MyJdbc.getConnection();
            String sql="UPDATE dbo.users SET pwd=?,address=?,phone=? where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getPwd());
            ps.setString(2,user.getAddress());
            ps.setString(3,user.getPhone());
            ps.setString(4,user.getUsername());
            result=ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
