package model.DAO;

import JDBC.MyJdbc;
import model.Books;
import model.Comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentsCon implements CommentsDAO
{
    @Override
    public int Insert(Comments comment)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try
        {
            con= MyJdbc.getConnection();
            String sql="INSERT INTO dbo.comments(commentId,userName,ISBN,comment) VALUES (?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,comment.getId());
            ps.setString(2,comment.getUsername());
            ps.setString(3,comment.getIsbn());
            ps.setString(4,comment.getComment());
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
            String sql="SELECT COUNT (commentId) AS r FROM dbo.comments";
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
    public String SelectByNameAndIsbn(String username,String isbn)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String result=new String();

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT comment FROM dbo.comments WHERE userName=? AND ISBN=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,isbn);
            rs=ps.executeQuery();
            if (rs.next())
            {
                result=rs.getString("comment");
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
    public ArrayList<Comments> SelectByIsbn(String isbn)
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Comments> list=new ArrayList<>();
        Comments comment;

        try
        {
            con= MyJdbc.getConnection();
            String sql="SELECT * FROM dbo.comments WHERE ISBN=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,isbn);
            rs=ps.executeQuery();
            while (rs.next())
            {
                comment=new Comments();
                comment.setComment(rs.getString("comment"));
                comment.setId(rs.getString("commentId"));
                comment.setIsbn(rs.getString("ISBN"));
                comment.setUsername(rs.getString("username"));
                list.add(comment);
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

}
