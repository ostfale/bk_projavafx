package fxml.controller.builder;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

/**
 * Factory function
 * Created :  28.06.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ItemBuilderFactoryMap implements BuilderFactory {

    private final JavaFXBuilderFactory fxFactory = new JavaFXBuilderFactory();

    @Override
    public Builder<?> getBuilder(Class<?> aClass) {
        if (aClass == Item.class) {
            return new ItemBuilderMap();
        }
        return fxFactory.getBuilder(aClass);
    }
}
