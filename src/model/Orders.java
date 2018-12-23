package model;

public class Orders
{
    private String id;
    private String username;
    private String content;
    private int isdealt;

    public void setId(String id)
    {
        this.id = id;
    }

    public void setIsdealt(int isdealt)
    {
        this.isdealt = isdealt;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getId()
    {
        return id;
    }

    public int getIsdealt()
    {
        return isdealt;
    }

    public String getUsername()
    {
        return username;
    }

    public String getContent()
    {
        return content;
    }
}
