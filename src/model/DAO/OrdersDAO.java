package model.DAO;

import model.Orders;
import model.Users;

import java.util.ArrayList;

public interface OrdersDAO
{
    public int Insert(Orders order);
    public String SelectCountId();
    public ArrayList<Orders> SelectByName(String username);
    public int DeleteById(String id);
    public int UpdateIsDealt(String id,int isdealt);
    public Orders SelectById(String id);
    public ArrayList<Orders> SelectAll();
}
