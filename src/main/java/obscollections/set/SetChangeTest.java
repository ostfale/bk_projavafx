package obscollections.set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import java.util.HashSet;
import java.util.Set;

/**
 * An ObservableSet can be observed for changes. You need to add a SetChangeListener whose onChanged()
 * method is called for every addition or removal of elements. It means if you use methods like addAll() or
 * removeAll() on an ObservableSet, which affects multiple elements, multiple change notifications will be
 * fired—one for each element added or removed.
 * Created :  04.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class SetChangeTest {

    public static void main(String[] args) {
        // Create an observable set with some elements
        ObservableSet<String> set = FXCollections.observableSet("one", "two");

        // Add a change lisetener to the set
        set.addListener(SetChangeTest::onChanged);

        set.add("three"); // Fires an add change event
        // Will not fire a change event as "one" already exists in the set
        set.add("one");

        // Create a Set
        Set<String> s = new HashSet<>();
        s.add("four");
        s.add("five");
        // Add all elements of s to set in one go
        set.addAll(s); // Fires two add change events
        set.remove("one"); // Fires a removal change event
        set.clear(); // Fires four removal change events
    }

    public static void onChanged(SetChangeListener.Change<? extends String> change) {
        if (change.wasAdded()) {
            System.out.print("Added: " + change.getElementAdded());
        } else if (change.wasRemoved()) {
            System.out.print("Removed: " + change.getElementRemoved());
        }
        System.out.println(", Set after the change: " + change.getSet());
    }
}
