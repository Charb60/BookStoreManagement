import java.util.List;

public class Order {
    private Customer customer;
    private List<Book> books;
    private String orderDate;
    private String status;

    public Order(Customer customer, List<Book> books, String orderDate, String status) {
        this.customer = customer;
        this.books = books;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getters and Setters
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", books=" + books +
                ", orderDate='" + orderDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}