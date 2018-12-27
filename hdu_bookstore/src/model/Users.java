package model;

public class Users
{
    private String username;
    private String pwd;
    private String address;
    private String phone;

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPwd()
    {
        return pwd;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPhone()
    {
        return phone;
    }
}
