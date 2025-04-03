import java.util.*;

public class BookStoreManagement {
    private List<Book> books = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(updatedBook.getIsbn())) {
                books.set(i, updatedBook);
                break;
            }
        }
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void displayCustomers() {
        customers.forEach(System.out::println);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        orders.forEach(System.out::println);
    }

    public static void main(String[] args) {
        BookStoreManagement bsm = new BookStoreManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBook Store Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Display Books");
            System.out.println("5. Add Customer");
            System.out.println("6. Display Customers");
            System.out.println("7. Add Order");
            System.out.println("8. Display Orders");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Book newBook = new Book(isbn, title, author, price, quantity);
                    bsm.addBook(newBook);
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String removeIsbn = scanner.nextLine();
                    bsm.removeBook(removeIsbn);
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to update: ");
                    String updateIsbn = scanner.nextLine();
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new Price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new Quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Book updatedBook = new Book(updateIsbn, newTitle, newAuthor, newPrice, newQuantity);
                    bsm.updateBook(updatedBook);
                    break;
                case 4:
                    bsm.displayBooks();
                    break;
                case 5:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Customer Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Customer Phone: ");
                    String phone = scanner.nextLine();
                    Customer newCustomer = new Customer(name, address, phone);
                    bsm.addCustomer(newCustomer);
                    break;
                case 6:
                    bsm.displayCustomers();
                    break;
                case 7:
                    System.out.print("Enter Customer Name for the Order: ");
                    String customerName = scanner.nextLine();
                    Customer orderCustomer = bsm.customers.stream()
                            .filter(c -> c.getName().equals(customerName))
                            .findFirst()
                            .orElse(null);

                    if (orderCustomer == null) {
                        System.out.println("Customer not found!");
                        break;
                    }

                    List<Book> orderBooks = new ArrayList<>();
                    while (true) {
                        System.out.print("Enter ISBN of the book to order (or type 'done' to finish): ");
                        String orderIsbn = scanner.nextLine();
                        if (orderIsbn.equalsIgnoreCase("done")) {
                            break;
                        }
                        Book orderBook = bsm.books.stream()
                                .filter(b -> b.getIsbn().equals(orderIsbn))
                                .findFirst()
                                .orElse(null);

                        if (orderBook == null) {
                            System.out.println("Book not found!");
                        } else {
                            orderBooks.add(orderBook);
                        }
                    }

                    if (orderBooks.isEmpty()) {
                        System.out.println("No books added to the order!");
                        break;
                    }

                    System.out.print("Enter Order Date: ");
                    String orderDate = scanner.nextLine();
                    System.out.print("Enter Order Status: ");
                    String orderStatus = scanner.nextLine();

                    Order newOrder = new Order(orderCustomer, orderBooks, orderDate, orderStatus);
                    bsm.addOrder(newOrder);
                    break;
                case 8:
                    bsm.displayOrders();
                    break;
                case 9:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
