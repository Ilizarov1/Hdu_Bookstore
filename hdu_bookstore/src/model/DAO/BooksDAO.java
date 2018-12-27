package model.DAO;

import model.Books;

import java.util.ArrayList;

public interface BooksDAO
{
    public ArrayList<Books> SelectAll();
    public Books SelectByBookName(String name);
    public Books SelectByIsbn(String isbn);
    public ArrayList<Books> SelectAllByDESC();
    public ArrayList<Books> SelectAllByASC();
    public int Update(Books book);
    public int Delete(String isbn);
    public int Insert(Books book);
}
