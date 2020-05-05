package obscollections.list;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

/**
 * It is possible to bind to a specific element of the ObservableList wrapped in a ListProperty using one
 * of the following methods of the ListExpression class:
 * <ul>
 *     <li>ObjectBinding<E> valueAt(int index)</li>
 *     <li>ObjectBinding<E> valueAt(ObservableIntegerValue index)</li>
 * </ul>
 * The first version of the method creates an ObjectBinding to an element in the list at a specific index.
 * The second version of the method takes an index as an argument, which is an ObservableIntegerValue
 * that can change over time. When the bound index in the valueAt() method is outside the list range, the
 * ObjectBinding contains null.
 * Created :  05.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class BindingToListElements {

    public static void main(String[] args) {
        ListProperty<String> lp = new SimpleListProperty<>(FXCollections.observableArrayList());

        // Create a binding to the last element of the list
        ObjectBinding<String> last = lp.valueAt(lp.sizeProperty().subtract(1));
        System.out.println("List:" + lp.get() + ", Last Value: " + last.get());

        lp.add("John");
        System.out.println("List:" + lp.get() + ", Last Value: " + last.get());

        lp.addAll("Donna", "Geshan");
        System.out.println("List:" + lp.get() + ", Last Value: " + last.get());

        lp.remove("Geshan");
        System.out.println("List:" + lp.get() + ", Last Value: " + last.get());

        lp.clear();
        System.out.println("List:" + lp.get() + ", Last Value: " + last.get());
    }
}
