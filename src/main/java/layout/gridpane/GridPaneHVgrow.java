package layout.gridpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

/**
 * The hgrow and vgrow constraints specify the horizontal and vertical grow priorities for the entire column
 * and row, even though it can be set for children individually. These constraints can also be set using the
 * ColumnConstraints and RowConstraints objects for columns and rows. By default, columns and rows do
 * not grow.
 * Notice that the second column grows, but not the first column. The program adds
 * six buttons arranged in two columns. The first column sets the hgrow constraints to Priority.NEVER. The
 * hgrow value set by the column takes priority; the first column does not grow when the GridPane is expanded
 * horizontally. The second column does not use column constraints. The children in this column use three
 * different types of priorities: ALWAYS, NEVER, and SOMETIMES. The maximum of the three priorities is ALWAYS,
 * which makes the second column grow horizontally
 * Created :  19.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class GridPaneHVgrow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        root.setStyle("-fx-padding: 10;");
        root.setGridLinesVisible(true);

        // Add three buttons to a column
        Button b1 = new Button("One");
        Button b2 = new Button("Two");
        Button b3 = new Button("Three");
        Button b4 = new Button("Four");
        Button b5 = new Button("Five");
        Button b6 = new Button("Six");

        root.addColumn(0, b1, b2, b3);
        root.addColumn(1, b4, b5, b6);

        // Set the column constraints
        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setHgrow(Priority.NEVER);
        root.getColumnConstraints().add(cc1);

        // Set three different hgrow priorities for children in the second column. The highest priority, ALWAYS, will be used.
        GridPane.setHgrow(b4, Priority.ALWAYS);
        GridPane.setHgrow(b5, Priority.NEVER);
        GridPane.setHgrow(b6, Priority.SOMETIMES);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("hgrow and vgrow Constraints");
        stage.show();
    }
}
