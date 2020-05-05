package obscollections.list;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * The ListProperty class implements the ObservableValue and ObservableList interfaces. It is an observable
 * value in the sense that it wraps the reference of an ObservableList. Implementing the ObservableList
 * interface makes all of its methods available to a ListProperty object. Calling methods of the ObservableList
 * on a ListProperty has the same effect as if they were called on the wrapped ObservableList. <p>
 * One of the common mistakes in using the ListProperty class is not passing an ObservableList to its
 * constructor before using it. A ListProperty must have a reference to an ObservableList before you can
 * perform a meaningful operation on it.
 * </p>
 * Created :  05.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ListPropertyTest {

    public static void main(String[] args) {

        // Create an observable list property
        ListProperty<String> lp = new SimpleListProperty<>(FXCollections.observableArrayList());

        // Add invalidation, change, and list change listeners
        lp.addListener(ListPropertyTest::invalidated);
        lp.addListener(ListPropertyTest::changed);
        lp.addListener(ListPropertyTest::onChanged);

        System.out.println("Before addAll()");
        lp.addAll("one", "two", "three");
        System.out.println("After addAll()");

        System.out.println("\nBefore set()");

        // Replace the wrapped list with a new one
        lp.set(FXCollections.observableArrayList("two", "three"));
        System.out.println("After set()");

        System.out.println("\nBefore remove()");
        lp.remove("two");
        System.out.println("After remove()");
    }

    // An invalidation listener
    public static void invalidated(Observable list) {
        System.out.println("List property is invalid.");
    }

    // A change listener
    public static void changed(ObservableValue<? extends ObservableList<String>> observable,
                               ObservableList<String> oldList,
                               ObservableList<String> newList) {
        System.out.print("List Property has changed.");
        System.out.print(" Old List: " + oldList);
        System.out.println(", New List: " + newList);
    }

    // A list change listener
    public static void onChanged(ListChangeListener.Change<? extends String> change) {
        while (change.next()) {
            String action = change.wasPermutated() ? "Permutated"
                    : change.wasUpdated() ? "Updated"
                    : change.wasRemoved() && change.wasAdded() ? "Replaced"
                    : change.wasRemoved() ? "Removed" : "Added";
            System.out.print("Action taken on the list: " + action);
            System.out.print(". Removed: " + change.getRemoved());
            System.out.println(", Added: " + change.getAddedSubList());
        }
    }
}
