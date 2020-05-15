package layout.group;

import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * The program adds two buttons (OK and Cancel) to the Group. The OK button uses absolute
 * positioning; it is placed at (10, 10). The Cancel button is placed relative to the OK button; its vertical position
 * is the same as the OK button; its horizontal position is 20px after the right edge of the OK button. Notice the
 * use of the Fluent Binding API to accomplish the relative positioning for the Cancel button.
 * Created :  15.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class NodesLayoutInGroup extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create two buttons
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // Set the location of the OK button
        okBtn.setLayoutX(10);
        okBtn.setLayoutY(10);

        // Set the location of the Cancel botton relative to the OK button
        NumberBinding layoutXBinding = okBtn.layoutXProperty().add(okBtn.widthProperty().add(10));
        cancelBtn.layoutXProperty().bind(layoutXBinding);
        cancelBtn.layoutYProperty().bind(okBtn.layoutYProperty());

        Group root = new Group();
        root.getChildren().addAll(okBtn, cancelBtn);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Positioning Nodes in a Group");
        stage.show();
    }
}
