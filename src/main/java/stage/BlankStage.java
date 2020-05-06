package stage;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * The bounds of a stage consist of four properties: x, y, width, and height. The x and y properties determine
 * the location (or position) of the upper-left corner of the stage. The width and height properties determine
 * its size.
 * If you specify the size of the stage but not its position, the stage is sized according the set size and
 * centered on the screen, irrespective of the presence of a scene and the size of the scene. If you specify the
 * position of the stage (x, y coordinates), it is positioned accordingly.
 * Created :  06.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class BlankStage extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Stage with a Sized Scene");
        Group root = new Group(new Button("Hello"));
        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);
        stage.setWidth(400);
        stage.setHeight(100);
        stage.show();
    }
}
