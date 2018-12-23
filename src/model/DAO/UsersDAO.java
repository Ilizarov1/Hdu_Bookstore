package model.DAO;

import model.Users;

import java.util.ArrayList;

public interface UsersDAO
{
    public ArrayList<Users> SelectAll();
    public int Insert(Users user);
    public int Update(Users user);
}
