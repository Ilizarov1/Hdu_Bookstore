package model;

public class Comments
{
    private String id;
    private String username;
    private String isbn;
    private String comment;

    public void setId(String id)
    {
        this.id = id;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getId()
    {
        return id;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getComment()
    {
        return comment;
    }

    public String getUsername()
    {
        return username;
    }
}
