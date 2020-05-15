package layout.panes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The program shows how to create a Pane, add two Buttons to it, and how to position the
 * Buttons.
 * Created :  15.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class PaneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        okBtn.relocate(10, 10);
        cancelBtn.relocate(60, 10);

        Pane root = new Pane();
        root.getChildren().addAll(okBtn, cancelBtn);
        root.setStyle("-fx-border-style: solid inside;" +
                "-fx-border-width: 3;" +
                "-fx-border-color: red;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Panes");
        stage.show();
    }
}
