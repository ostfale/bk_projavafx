package propbinding;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Properties in the second category are used without advanced features in most of the cases.
 * Shows the declaration of an Item class that instantiates the property object when it is needed.
 * The Item class declares an extra variable, _weight, which is used to hold the value of the weight
 * property until the property object is instantiated. Unlike the Monitor class, changing the weight property
 * does not instantiate the property object. It is instantiated when the weightProperty() method is called.
 * Created :  29.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class RareItem {

    private DoubleProperty weight;
    private double _weight = 150;

    public double getWeight() {
        return (weight == null) ? _weight : weight.get();
    }

    public void setWeight(double newWeight) {
        if (weight == null) {
            _weight = newWeight;
        } else {
            weight.set(newWeight);
        }
    }

    public DoubleProperty weightProperty() {
        if (weight == null) {
            weight = new SimpleDoubleProperty(this, "weight", _weight);
        }
        return weight;
    }

    public static void main(String[] args) {
        RareItem item = new RareItem();
        System.out.println("Lazy: " + item.getWeight());
        item.setWeight(200.15);
        System.out.println("Lazy again: " + item.getWeight());
        System.out.println("Init property: " + item.weightProperty().get());
    }
}
