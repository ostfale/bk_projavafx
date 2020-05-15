package layout.hvbox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Using the alignment property is simple. It specifies how children are aligned within the content area of the HBox.
 * By default, an HBox allocates just enough space for its content to lay out all children at their preferred size.
 * The effect of the alignment property is noticeable when the HBox grows bigger than its preferred size.
 * Created :  15.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class HBoxAlignment extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        HBox hbox = new HBox(10);
        hbox.setPrefSize(200, 100);
        hbox.getChildren().addAll(okBtn, cancelBtn);

        // Set the alignment to bottom right
        hbox.setAlignment(Pos.BOTTOM_RIGHT);

        hbox.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.setTitle("Using HBox Alignment Property");
        stage.show();
    }
}
