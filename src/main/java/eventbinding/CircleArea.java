package eventbinding;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Creates a DoubleBinding that computes the area of a circle. It also creates a
 * DoubleProperty and binds it to the same expression to compute the area. It is your choice whether you want
 * to work with Binding objects or bound property objects. The program shows you both approaches.
 * Created :  01.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class CircleArea {

    public static void main(String[] args) {
        DoubleProperty radius = new SimpleDoubleProperty(7.0);

        // Create a binding for computing arae of the circle
        DoubleBinding area = radius.multiply(radius).multiply(Math.PI);

        System.out.println("Radius = " + radius.get() + ", Area = " + area.get());

        // Change the radius
        radius.set(14.0);
        System.out.println("Radius = " + radius.get() + ", Area = " + area.get());

        // Create a DoubleProperty and bind it to an expression that computes the area of the circle
        DoubleProperty area2 = new SimpleDoubleProperty();
        area2.bind(radius.multiply(radius).multiply(Math.PI));
        System.out.println("Radius = " + radius.get() + ", Area2 = " + area2.get());
    }
}
