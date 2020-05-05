package obscollections.map;

import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;

/**
 * An ObservableMap can be observed for changes by adding a MapChangeListener. The onChanged() method
 * of map change listeners is called for every addition and removal of a (key, value) pair and for a change in the
 * value of an existing key.
 * Created :  05.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class MapChangeTest {

    public static void main(String[] args) {

        ObservableMap<String, Integer> changeMap = FXCollections.observableHashMap();

        // Add an MapChangeListener to the changeMap
        changeMap.addListener(MapChangeTest::onChanged);

        System.out.println("Before adding (\"one\", 1)");
        changeMap.put("one", 1);
        System.out.println("After adding (\"one\", 1)");

        System.out.println("\nBefore adding (\"two\", 2)");
        changeMap.put("two", 2);
        System.out.println("After adding (\"two\", 2)");

        System.out.println("\nBefore adding (\"one\", 3)");

        // Will remove ("one", 1) and add("one", 3)
        changeMap.put("one", 3);
        System.out.println("After adding (\"one\", 3)");

        System.out.println("\nBefore calling clear()");
        changeMap.clear();
        System.out.println("After calling clear()");
    }

    public static void onChanged(
            MapChangeListener.Change<? extends String, ? extends Integer> change) {
        if (change.wasRemoved()) {
            System.out.println("Removed (" + change.getKey() + ", " + change.getValueRemoved() + ")");
        }
        if (change.wasAdded()) {
            System.out.println("Added (" + change.getKey() + ", " + change.getValueAdded() + ")");
        }
    }
}
