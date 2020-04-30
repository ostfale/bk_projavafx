package propertyhandling;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Compared to simple JavaBeans properties, JavaFX properties are more powerful. Their power comes from
 * their observable and binding features at a price that every JavaFX property is an object. If you consider
 * ten instances of a JavaFX class with 50 properties, you will have 500 objects in memory. However, not all
 * properties use their advanced features. Most of them will be used as JavaBeans properties, using only getters
 * and setters, or they will just use their default values. When it is likely that a JavaFX property will rarely
 * use its advanced features, the property object may be instantiated lazily to optimize memory usage. The
 * optimization comes at a price of adding a few extra lines of code.
 * The following are the two use cases where you can lazily instantiate a property:
 * <ul>
 *     <li>When the property will use its default value in most of the cases</li>
 *     <li>When the property will not use its observable and binding features in most cases</li>
 * </ul>
 * Created :  29.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class LazyMonitor {

    public static final String DEFAULT_SCREEN_TYPE = "flat";
    private StringProperty screenType;

    // returns value for default screen type without creating a property
    public String getScreenType() {
        return (screenType == null) ? DEFAULT_SCREEN_TYPE : screenType.get();
    }

    public void setScreenType(String newScreenType) {
        if (screenType != null || !DEFAULT_SCREEN_TYPE.equals(newScreenType)) {
            screenTypeProperty().set(newScreenType);
        }
    }

    public StringProperty screenTypeProperty() {
        if (screenType == null) {
            screenType = new SimpleStringProperty(this, "screenType",
                    DEFAULT_SCREEN_TYPE);
        }
        return screenType;
    }

    public static void main(String[] args) {
        LazyMonitor monitor = new LazyMonitor();
        String st_lazy = monitor.getScreenType();  // Does not instantiate the property object
        String st_instance = monitor.screenTypeProperty().get();  // Instantiates the property object
        System.out.println("Instantiated: " + st_instance);
        System.out.println("Lazy: " + st_lazy);
    }
}
