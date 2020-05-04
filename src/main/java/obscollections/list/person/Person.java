package obscollections.list.person;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Simple Pojo
 * Created :  04.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class Person implements Comparable<Person> {

    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();

    public Person() {
        this.setFirstName("Unknown");
        this.setLastName("Unknown");
    }

    public Person(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public final String getFirstName() {
        return firstName.get();
    }

    public final void setFirstName(String newFirstName) {
        firstName.set(newFirstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public final String getLastName() {
        return lastName.get();
    }

    public final void setLastName(String newLastName) {
        lastName.set(newLastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    @Override
    public int compareTo(Person p) {
        // Assume that the first and last names are always not null
        int diff = this.getFirstName().compareTo(p.getFirstName());
        if (diff == 0) {
            diff = this.getLastName().compareTo(p.getLastName());
        }
        return diff;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
