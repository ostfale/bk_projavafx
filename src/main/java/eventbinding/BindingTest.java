package eventbinding;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * In JavaFX, a binding is an expression that evaluates to a value. It consists of one or more observable values
 * known as its dependencies. A binding observes its dependencies for changes and recomputes its value
 * automatically. JavaFX uses lazy evaluation for all bindings. When a binding is initially defined or when its
 * dependencies change, its value is marked as invalid. The value of an invalid binding is computed when it is
 * requested next time, usually using its get() or getValue() method. All property classes in JavaFX have
 * built-in support for binding.
 * Created :  30.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class BindingTest {

    public static void main(String[] args) {
        exampleWithSumBindung();
    }


    /**
     * When the sum binding is created, it is invalid and it does not know its value. This is evident from the output.
     * Once you request its value, using the sum.initValue() method, it computes its value and marks itself as
     * valid. When you change one of its dependencies, it becomes invalid until you request its value again.
     */
    private static void exampleWithSumBindung() {
        IntegerProperty x = new SimpleIntegerProperty(100);
        IntegerProperty y = new SimpleIntegerProperty(200);

        // Create a binding: sum = x + y
        NumberBinding sum = x.add(y);

        System.out.println("After creating sum");
        System.out.println("sum.isValid(): " + sum.isValid());

        // Let us get the value of sum, so it computes its value and becomes valid
        int value = sum.intValue();

        System.out.println("\nAfter requesting value");
        System.out.println("sum.isValid(): " + sum.isValid());
        System.out.println("sum = " + value);

        // Change the value of x
        x.set(250);

        System.out.println("\nAfter changing x");
        System.out.println("sum.isValid(): " + sum.isValid());

        // Get the value of sum again
        value = sum.intValue();
        System.out.println("\nAfter requesting value");
        System.out.println("sum.isValid(): " + sum.isValid());
        System.out.println("sum = " + value);
    }
}
