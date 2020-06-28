package fxml.controller.builder;

import javafx.fxml.FXMLLoader;
import javafx.util.BuilderFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Test both factories
 * Created :  28.06.2020
 *
 * @author : Uwe Sauerbrei
 */
public class BuilderTest {

    public static void main(String[] args) throws IOException {
        // Use the Builder with property getter and setter
        new BuilderTest().loadItems(new ItemBuilderFactory());

        // Use the Builder with Map
        new BuilderTest().loadItems(new ItemBuilderFactoryMap());
    }

    // TODO to be fixed 
    private void loadItems(BuilderFactory builderFactory) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        final URL resource = getClass().getClassLoader().getResource("items.fxml");
        loader.setLocation(getClass().getResource("items.fxml"));
        loader.setBuilderFactory(builderFactory);
        ArrayList items = loader.load();
        System.out.println("List:" + items);
    }
}
