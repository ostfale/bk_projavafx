package layout.group;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.stage.Stage;

/**
 * The program adds two buttons to the Group. It applies a rotation transformation of 10 degrees,
 * a drop shadow effect, and opacity of 80%.
 * Created :  15.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class GroupEffect extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create two buttons
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // Set the locations of the buttons
        okBtn.setLayoutX(10);
        okBtn.setLayoutY(10);
        cancelBtn.setLayoutX(80);
        cancelBtn.setLayoutY(10);

        Group root = new Group();
        root.setEffect(new DropShadow()); // Set a drop shadow effect
        root.setRotate(10); // Rotate by 10 degrees clockwise
        root.setOpacity(0.80); // Set the opacity to 80%

        root.getChildren().addAll(okBtn, cancelBtn);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Applying Transformations and Effects to a Group");
        stage.show();
    }
}
