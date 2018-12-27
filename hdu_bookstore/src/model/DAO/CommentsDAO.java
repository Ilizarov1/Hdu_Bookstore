package model.DAO;

import model.Comments;

import java.util.ArrayList;

public interface CommentsDAO
{
    public int Insert(Comments comment);
    public String SelectCountId();
    public String SelectByNameAndIsbn(String username,String isbn);
    public ArrayList<Comments> SelectByIsbn(String isbn);
}
