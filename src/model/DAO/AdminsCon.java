package model.DAO;

import JDBC.MyJdbc;
import model.Admins;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminsCon implements AdminsDAO
{
    @Override
    public ArrayList<Admins> SelectAll()
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Admins> list=new ArrayList<>();
        Admins admin=null;

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.admins";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next())
            {
                admin=new Admins();
                admin.setAdminName(rs.getString("adminName"));
                admin.setPwd(rs.getString("pwd"));
                list.add(admin);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
