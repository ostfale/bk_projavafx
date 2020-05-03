package obscollections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Shows how to create observable lists and how to use some of the methods of the
 * ObservableList interface to manipulate the lists. At the end, it shows how to use the concat() method of
 * the FXCollections class to concatenate elements of two observable lists.
 * Created :  03.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ObservableListTest {

    public static void main(String[] args) {
        // Create a list with some elements
        ObservableList<String> list = FXCollections.observableArrayList("one", "two");
        System.out.println("After creating list: " + list);

        // Add some more elements to the list
        list.addAll("three", "four");
        System.out.println("After adding elements: " + list);

        // You have four elements. Remove the middle two from index 1 (inclusive) to index 3 (exclusive)
        list.remove(1, 3);
        System.out.println("After removing elements: " + list);

        // Retain only the element "one"
        list.retainAll("one");
        System.out.println("After retaining \"one\": " + list);

        // Create another ObservableList
        ObservableList<String> list2 = FXCollections.observableArrayList("1", "2", "3");
        // Set list2 to list
        list.setAll(list2);
        System.out.println("After setting list2 to list: " + list);
        // Create another list
        ObservableList<String> list3 = FXCollections.observableArrayList("ten", "twenty", "thirty");
        // Concatenate elements of list2 and list3
        ObservableList<String> list4 = FXCollections.concat(list2, list3);
        System.out.println("list2 is " + list2);
        System.out.println("list3 is " + list3);
        System.out.println("After concatenating list2 and list3:" + list4);
    }
}
