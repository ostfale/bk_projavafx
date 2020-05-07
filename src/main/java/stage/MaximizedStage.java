package stage;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * <description>
 * Created :  07.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class MaximizedStage extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new Group()));
        stage.setTitle("A Maximized Stage");
        // Set the position and size of the stage equal to the position and size of the screen
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(visualBounds.getMinX());
        stage.setY(visualBounds.getMinY());
        stage.setWidth(visualBounds.getWidth());
        stage.setHeight(visualBounds.getHeight());
        // Show the stage
        stage.show();
    }
}
