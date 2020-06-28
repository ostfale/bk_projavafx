package fxml.controller.builder;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

/**
 * <description>
 * Created :  28.06.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ItemBuilderFactory implements BuilderFactory {

    private final JavaFXBuilderFactory fxFactory = new JavaFXBuilderFactory();

    @Override
    public Builder<?> getBuilder(Class<?> aClass) {
        if (aClass == Item.class) {
            return new ItemBuilder();
        }

        // Let the default Builder do the magic
        return fxFactory.getBuilder(aClass);
    }
}
