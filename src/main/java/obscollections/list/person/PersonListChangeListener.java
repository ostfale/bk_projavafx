package obscollections.list.person;

import javafx.collections.ListChangeListener;

import java.util.List;

/**
 * Implements the onChanged() method of the ListChangeListener interface to handle all types of change
 * notifications for an ObservableList of Person objects.
 * Created :  04.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class PersonListChangeListener implements ListChangeListener<Person> {

    @Override
    public void onChanged(Change<? extends Person> change) {
        while (change.next()) {
            if (change.wasPermutated()) {
                handlePermutated(change);
            } else if (change.wasUpdated()) {
                handleUpdated(change);
            } else if (change.wasReplaced()) {
                handleReplaced(change);
            } else {
                if (change.wasRemoved()) {
                    handleRemoved(change);
                } else if (change.wasAdded()) {
                    handleAdded(change);
                }
            }
        }
    }

    public void handlePermutated(ListChangeListener.Change<? extends Person> change) {
        System.out.println("Change Type: Permutated");
        System.out.println("Permutated Range: " + getRangeText(change));
        int start = change.getFrom();
        int end = change.getTo();
        for (int oldIndex = start; oldIndex < end; oldIndex++) {
            int newIndex = change.getPermutation(oldIndex);
            System.out.println("index[" + oldIndex + "] moved to " +
                    "index[" + newIndex + "]");
        }
    }

    public void handleUpdated(ListChangeListener.Change<? extends Person> change) {
        System.out.println("Change Type: Updated");
        System.out.println("Updated Range : " + getRangeText(change));
        System.out.println("Updated elements are: " +
                change.getList().subList(change.getFrom(), change.getTo()));
    }

    public void handleReplaced(ListChangeListener.Change<? extends Person> change) {
        System.out.println("Change Type: Replaced");
        // A "replace" is the same as a “remove” followed with an "add"
        handleRemoved(change);
        handleAdded(change);
    }

    public void handleRemoved(ListChangeListener.Change<? extends Person> change) {
        System.out.println("Change Type: Removed");
        int removedSize = change.getRemovedSize();
        List<? extends Person> subList = change.getRemoved();
        System.out.println("Removed Size: " + removedSize);
        System.out.println("Removed Range: " + getRangeText(change));
        System.out.println("Removed List: " + subList);
    }

    public void handleAdded(ListChangeListener.Change<? extends Person> change) {
        System.out.println("Change Type: Added");
        int addedSize = change.getAddedSize();
        List<? extends Person> subList = change.getAddedSubList();
        System.out.println("Added Size: " + addedSize);
        System.out.println("Added Range: " + getRangeText(change));
        System.out.println("Added List: " + subList);
    }

    public String getRangeText(ListChangeListener.Change<? extends Person> change) {
        return "[" + change.getFrom() + ", " + change.getTo() + "]";
    }
}
