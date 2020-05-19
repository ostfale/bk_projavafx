package layout.gridpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * There are two ways of fixing the problem of overlapping children <p>
 *     <ul>
 *         <li>set the position in which they are placed, before or after adding them to the list.</li>
 *         <li>use convenience methods of the GridPane class that allow specifying the positions, among other
 *         constraints, while adding children to the GridPane</li>
 *     </ul>
 * </p>
 * Created :  18.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class GridPaneChildrenPositions extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button b1 = new Button("One One One One One");
        Button b2 = new Button("Two Two Two");
        Button b3 = new Button("Three");

        GridPane root = new GridPane();

        // Add three buttons to the list of children of the GridPane directly
        root.getChildren().addAll(b1, b2, b3);

        // Set the cells the buttons
        GridPane.setConstraints(b1, 0, 0); // (c0, r0)
        GridPane.setConstraints(b2, 1, 0); // (c1, r0)
        GridPane.setConstraints(b3, 2, 0); // (c2, r0)

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Setting Positions for Children in a GridPane");
        stage.show();
    }
}
