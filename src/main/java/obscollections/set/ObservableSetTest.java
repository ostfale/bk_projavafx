package obscollections.set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Example of creation of an observable set
 * Created :  04.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ObservableSetTest {

    public static void main(String[] args) {
        // Create an ObservableSet with three initial elements
        ObservableSet<String> s1 = FXCollections.observableSet("one", "two", "three");
        System.out.println("Observable set s1: " + s1);

        // Create a Set, and not an ObservableSet
        Set<String> s2 = new HashSet<String>();
        s2.add("one");
        s2.add("two");
        System.out.println("Set s2: " + s2);

        // Create an ObservableSet backed by the Set s2
        ObservableSet<String> s3 = FXCollections.observableSet(s2);
        s3.add("three");
        System.out.println("s3: " + s3);
    }
}
