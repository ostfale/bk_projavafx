package tableview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mvc.Person;

/**
 * Shows how to create a TableView with a model and add columns to it. It uses the
 * PersonTableUtil class to get the list of persons and columns.
 * Created :  20.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class SimplestTableView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create a TableView with a list of persons
        TableView<Person> table = new TableView<>(PersonTableUtil.getPersonList());

        // Add columns to the TableView
        table.getColumns().addAll(PersonTableUtil.getIdColumn(),
                PersonTableUtil.getFirstNameColumn(),
                PersonTableUtil.getLastNameColumn(),
                PersonTableUtil.getBirthDateColumn());

        VBox root = new VBox(table);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Simplest TableView");
        stage.show();
    }
}
