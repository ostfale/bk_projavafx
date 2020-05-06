package stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * You can move a stage to a different location by dragging its title bar. In an undecorated or transparent stage,
 * a title bar is not available. You need to write a few lines of code to let the user move this kind of stage by
 * dragging the mouse over the scene area.
 * When you press the mouse in the scene (except the button area), the handleMousePressed()
 * method is called. The getScreenX() and getScreenY() methods of the MouseEvent object return the x
 * and y coordinates of the mouse with respect to the upper-left corner of the screen.
 * Created :  06.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class DraggingStage extends Application {

    private Stage stage;
    private double dragOffsetX;
    private double dragOffsetY;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Store the stage reference in the instance variable to use it in the mouse pressed event handler later.
        this.stage = stage;

        Label msgLabel = new Label("Press the mouse button and drag.");
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> stage.close());

        VBox root = new VBox();
        root.getChildren().addAll(msgLabel, closeButton);

        Scene scene = new Scene(root, 300, 200);

        // Set mouse pressed and dragged even handlers for the scene
        scene.setOnMousePressed(this::handleMousePressed);
        scene.setOnMouseDragged(this::handleMouseDragged);

        stage.setScene(scene);
        stage.setTitle("Moving a Stage");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    protected void handleMousePressed(MouseEvent e) {
        // Store the mouse x and y coordinates with respect to the stage in the reference variables to use them in the drag event
        this.dragOffsetX = e.getScreenX() - stage.getX();
        this.dragOffsetY = e.getScreenY() - stage.getY();
    }

    protected void handleMouseDragged(MouseEvent e) {
        // Move the stage by the drag amount
        stage.setX(e.getScreenX() - this.dragOffsetX);
        stage.setY(e.getScreenY() - this.dragOffsetY);
    }
}
