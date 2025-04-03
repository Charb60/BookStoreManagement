public class Book {
    private String isbn;
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(String isnb, String title, String author, double price, int quantity) {
        this.isbn = isnb;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;

    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Book{ " + 
        "isbn=" + isbn +"\"" +
        "title=" + title+"\""+
        "author=" + author +"\"" +
        "price=" + price +"\"" + 
        "quantity=" + quantity + "}";
    }
    
}
