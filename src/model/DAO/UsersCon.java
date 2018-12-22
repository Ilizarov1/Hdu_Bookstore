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
}
