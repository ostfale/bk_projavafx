package propbinding;

import javafx.beans.property.*;

/**
 * Example for Property
 * Created :  28.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class Book {

    public static void main(String[] args) {
       // setNewTitle();
        new Book().bookTest();
    }

    public Book() {
    }

    public Book(String title, double price, String ISBN) {
        this.title.set(title);
        this.price.set(price);
        this.ISBN.set(ISBN);
    }

    private static void setNewTitle() {
        Book b = new Book();
        System.out.println("Title before: " + b.title.getValue());
        b.titleProperty().set("Harnessing JavaFX 8.0");
        String title = b.titleProperty().get();
        System.out.println("Title after: " + b.getTitle());
    }

    private DoubleProperty price = new SimpleDoubleProperty(this, "price", 0.0);
    private StringProperty title = new SimpleStringProperty(this, "title", "Unknown");

    public final double getPrice() {
        return price.get();
    }

    public final void setPrice(double price) {
        this.price.set(price);
    }

    public final DoubleProperty priceProperty() {
        return price;
    }

    /*
     * You declare a public getter for the property, which is named, by convention, as XXXProperty,
     * where XXX is the name of the property. This getter returns the reference of the property.
     */
    public final StringProperty titleProperty() {
        return title;
    }

    public final String getTitle() {
        return title.get();
    }

    public final void setTitle(String title) {
        this.title.set(title);
    }

    /*
     * For the users of the Book class, its ISBN property is read-only. However, it can be changed internally,
     * and the change will be reflected in the read-only version of the property object automatically.
     */
    private ReadOnlyStringWrapper ISBN = new ReadOnlyStringWrapper(this, "ISBN", "Unknown");

    public final String getISBN() {
        return ISBN.get();
    }

    public final ReadOnlyStringProperty ISBNProperty() {
        return ISBN.getReadOnlyProperty();
    }

    private void bookTest() {
        Book book = new Book("Harnessing JavaFX", 9.99, "0123456789");
        System.out.println("After creating the Book object...");
        // Print Property details
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNProperty());
        // Change the book's properties
        book.setTitle("Harnessing JavaFX 8.0");
        book.setPrice(9.49);
        System.out.println("\nAfter changing the Book properties...");
        // Print Property details
        printDetails(book.titleProperty());
        printDetails(book.priceProperty());
        printDetails(book.ISBNProperty());
    }

    public static void printDetails(ReadOnlyProperty<?> p) {
        String name = p.getName();
        Object value = p.getValue();
        Object bean = p.getBean();
        String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
        String propClassName = p.getClass().getSimpleName();
        System.out.print(propClassName);
        System.out.print("[Name:" + name);
        System.out.print(", Bean Class:" + beanClassName);
        System.out.println(", Value:" + value + "]");
    }
}
