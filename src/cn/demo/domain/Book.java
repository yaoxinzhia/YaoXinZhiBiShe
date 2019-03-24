package cn.demo.domain;

public class Book {
    private int bookid;
    private String bookname;
    private String author;
    private String booktypename;

    public Book() {
    }

    public Book(int bookid, String bookname, String author, String booktypename) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.booktypename = booktypename;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooktypename() {
        return booktypename;
    }

    public void setBooktypename(String booktypename) {
        this.booktypename = booktypename;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", booktypename='" + booktypename + '\'' +
                '}';
    }
}
