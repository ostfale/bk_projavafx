package eventbinding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * The first two bindings bind the centerX and centerY of the circle to the middle of the width and height
 * of the scene, respectively. The third binding binds the radius of the circle to the half (see divide(2)) of the
 * minimum of the width and the height of the scene. That’s it! The binding API does the magic of keeping the
 * circle centered when the application is run.
 * Created :  03.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class CenteredCircle extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }


    public void start(Stage stage) {
        Circle c = new Circle();
        Group root = new Group(c);
        Scene scene = new Scene(root, 100, 100);
        // Bind the centerX, centerY, and radius to the scene width and height
        c.centerXProperty().bind(scene.widthProperty().divide(2));
        c.centerYProperty().bind(scene.heightProperty().divide(2));
        c.radiusProperty().bind(Bindings.min(scene.widthProperty(), scene.heightProperty()).divide(2));
        // Set the stage properties and make it visible
        stage.setTitle("Binding in JavaFX");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
