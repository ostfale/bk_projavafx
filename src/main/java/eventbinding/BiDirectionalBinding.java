package eventbinding;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * A binding has a direction, which is the direction in which changes are propagated. JavaFX supports two
 * types of binding for properties: unidirectional binding and bidirectional binding. A unidirectional binding
 * works only in one direction; changes in dependencies are propagated to the bound property and not
 * vice versa. A bidirectional binding works in both directions; changes in dependencies are reflected in the
 * property and vice versa.
 * Created :  30.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class BiDirectionalBinding {

    public static void main(String[] args) {

        IntegerProperty x = new SimpleIntegerProperty(1);
        IntegerProperty y = new SimpleIntegerProperty(2);
        IntegerProperty z = new SimpleIntegerProperty(3);

        System.out.println("Before binding:");
        System.out.println("x=" + x.get() + ", y=" + y.get() + ", z=" + z.get());
        x.bindBidirectional(y);
        System.out.println("After binding-1:");
        System.out.println("x=" + x.get() + ", y=" + y.get() + ", z=" + z.get());
        x.bindBidirectional(z);
        System.out.println("After binding-2:");
        System.out.println("x=" + x.get() + ", y=" + y.get() + ", z=" + z.get());
        System.out.println("After changing z:");
        z.set(19);
        System.out.println("x=" + x.get() + ", y=" + y.get() + ", z=" + z.get());

        // Remove bindings
        x.unbindBidirectional(y);
        x.unbindBidirectional(z);
        System.out.println("After unbinding and changing them separately:");
        x.set(100);
        y.set(200);
        z.set(300);
        System.out.println("x=" + x.get() + ", y=" + y.get() + ", z=" + z.get());
    }
}
