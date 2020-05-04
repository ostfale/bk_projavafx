package obscollections.list;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

/**
 * There could be several kinds of changes to a list. Some of the changes could be exclusive, whereas some
 * can occur along with other changes. Elements of a list can be permutated, updated, replaced, added, and removed.
 * Created :  04.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class SimpleListChangeTest {

    public static void main(String[] args) {
        // Create an observable list
        ObservableList<String> list = FXCollections.observableArrayList();

        // Add a change listener to the list
        list.addListener(SimpleListChangeTest::onChanged);

        // Manipulate the elements of the list
        list.add("one");
        list.add("two");
        FXCollections.sort(list);
        list.clear();
    }

    /**
     * Sometimes you may want to analyze changes to a list in more detail rather than just knowing that the list
     * has changed. The ListChangeListener.Change object that is passed to the onChanged() method contains a
     * report to a change performed on the list. You need to use a combination of its methods to know the details of
     * a change.
     */
    public static void onChanged(ListChangeListener.Change<? extends String> change) {
        System.out.println("List has changed");
        while (change.next()) {
            if (change.wasPermutated()) {
                System.out.println("Some permutation...");
            } else if (change.wasUpdated()) {
                System.out.println("Some updates");
            } else if (change.wasReplaced()) {
                System.out.println("Some replacement");
            } else {
                if (change.wasRemoved()) {
                    System.out.println("Something removed");
                } else if (change.wasAdded()) {
                    System.out.println("Something added...");
                }
            }
        }

    }
}
