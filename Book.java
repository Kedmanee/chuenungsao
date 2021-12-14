package model;
import java.util.*;

import com.mongodb.client.FindIterable;
import database.MongoDB;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import java.util.List;

public class Book {
    private int bookID;
    private String title;
    private String categories;
    private boolean status;
    private String writer;
    private double price;

    public Book(int bookID, String title, String categories, boolean status, String writer, double price) {
        this.bookID = bookID;
        this.title = title;
        this.categories = categories;
        this.status = status;
        this.writer = writer;
        this.price = price;
    }
    public Book() {
        this.bookID = 0;
        this.title = "";
        this.categories = "";
        this.status = false;
        this.writer = "";
        this.price = 0;
    }

    //insert book to database
    public void insertBook(Book book){
        MongoDB mongoDB = new MongoDB();
        Document doc = new Document("bookID", book.bookID)
                .append("title", book.title)
                .append("status", book.status)
                .append("writer", book.writer)
                .append("price", book.price);
        mongoDB.getBookCollection().insertOne(doc);
    }

    //get book list from database
    public List<Book> getBookList(){
        List<Book> bookList = new LinkedList<Book>();
        MongoDB mongoDB = new MongoDB();
        List<Document> results = new ArrayList<>();
        FindIterable<Document> iterable = mongoDB.getBookCollection().find();
        iterable.into(results);
        for(Document iterate : iterable) {
            Book book = new Book(iterate.getInteger("bookID"),iterate.getString("title"),iterate.getString("categories"),iterate.getBoolean("status"),iterate.getString("writer"),iterate.getDouble("price"));
            bookList.add(book);
        }
        return bookList;
    }

    //delete book from database by id
     public void deleteBook(int bookid){
         MongoDB mongoDB = new MongoDB();
         Document doc = new Document("bookID", "bookid");
         mongoDB.getBookCollection().deleteOne(doc);
     }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
