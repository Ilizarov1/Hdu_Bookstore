package JDBC;

import java.sql.*;

public class MyJdbc
{
    public static Connection getConnection()
    {
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=BOOKSTORE;";
        String pwd="123456";
        String name="sa";

        try
        {
            Class.forName(driver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        Connection con=null;
        try
        {
            con=(Connection) DriverManager.getConnection(url,name,pwd);
            System.out.println("数据库连接成功");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return con;
    }

    public static void free(Connection con, Statement st,ResultSet rs)
    {
        try
        {
            if(con!=null)
            {
                con.close();
            }
            if(st!=null)
            {
                st.close();
            }
            if(rs!=null)
            {
                rs.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
