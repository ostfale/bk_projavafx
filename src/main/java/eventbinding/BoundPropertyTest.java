package eventbinding;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * In JavaFX, you can also bind a property to a binding. Recall that a binding is an expression that is
 * synchronized with its dependencies automatically. Using this definition, a bound property is a property
 * whose value is computed based on an expression, which is automatically synchronized when the
 * dependencies change.
 * Created :  30.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class BoundPropertyTest {

    public static void main(String[] args) {
        IntegerProperty x = new SimpleIntegerProperty(10);
        IntegerProperty y = new SimpleIntegerProperty(20);
        IntegerProperty z = new SimpleIntegerProperty(60);

        z.bind(x.add(y));
        System.out.println("After binding z: Bound = " + z.isBound() + ", z = " + z.get());

        // Change x and y
        x.set(15);
        y.set(19);
        System.out.println("After changing x and y: Bound = " + z.isBound() + ", z = " + z.get());

        // Unbind z
        z.unbind();
        // Will not affect the value of z as it is not bound to x and y anymore
        x.set(100);
        y.set(200);
        System.out.println("After unbinding z: Bound = " + z.isBound() + ", z = " + z.get());
    }
}
