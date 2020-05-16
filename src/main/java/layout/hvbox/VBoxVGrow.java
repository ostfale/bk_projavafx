package layout.hvbox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * By default, the children in a VBox get their preferred heights. If the VBox is expanded vertically, its children
 * may get the additional available space, provided their vgrow priority is set to grow. If a VBox is expanded
 * vertically and none of its children has its vgrow constraint set, the additional space is left unused.
 * Created :  16.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class VBoxVGrow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label descLbl = new Label("Descrption:");
        TextArea desc = new TextArea();
        desc.setPrefColumnCount(10);
        desc.setPrefRowCount(3);

        VBox root = new VBox(10);
        root.getChildren().addAll(descLbl, desc);

        // Let the TextArea always grow vertically
        VBox.setVgrow(desc, Priority.ALWAYS);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Vertical Grow Priority in a VBox");
        stage.show();
    }
}
