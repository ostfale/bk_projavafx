package propertyhandling;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * All properties in JavaFX are observable. They can be observed for invalidation and value changes.
 * There can be read/write or read-only properties. All read/write properties support binding.
 * Created :  27.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class PropertyClasses {

    public static void main(String[] args) {
        propertyExample();
        exampleReadonlyWrapper();
    }

    private static void propertyExample() {
        IntegerProperty counter = new SimpleIntegerProperty(1);
        int counterValue = counter.get();
        System.out.println("Counter:" + counterValue);
        counter.set(2);
        counterValue = counter.get();
        System.out.println("Counter:" + counterValue);
    }

    /*
     * A ReadOnlyXXXWrapper class wraps two properties of XXX type: one read-only and one read/write.
     * Both properties are synchronized. Its getReadOnlyProperty() method returns a ReadOnlyXXXProperty object.
     */
    private static void exampleReadonlyWrapper() {
        ReadOnlyIntegerWrapper idWrapper = new ReadOnlyIntegerWrapper(100);
        ReadOnlyIntegerProperty id = idWrapper.getReadOnlyProperty();

        System.out.println("idWrapper:" + idWrapper.get());
        System.out.println("id:" + id.get());

        // Change the value
        idWrapper.set(101);
        System.out.println("idWrapper:" + idWrapper.get());
        System.out.println("id:" + id.get());
    }
}
