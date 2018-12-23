package model;

public class Books
{
    private String isbn;
    private String bookname;
    private String writer;
    private float price;
    private String intro;

    public void setBookname(String bookname)
    {
        this.bookname = bookname;
    }

    public void setIntro(String intro)
    {
        this.intro = intro;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public void setWriter(String writer)
    {
        this.writer = writer;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getBookname()
    {
        return bookname;
    }

    public String getWriter()
    {
        return writer;
    }

    public float getPrice()
    {
        return price;
    }

    public String getIntro()
    {
        return intro;
    }
}
