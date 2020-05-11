package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The boundsInLocal property includes the drop shadow effect around the button. Notice that the coordinates of
 * the upper left corner of the bounding box defined by the layoutBounds are (0.0, 0.0) and they are
 * (-9.0, -9.0) for the boundsInLocal.
 * The output may be a bit different on different platforms as the size of nodes is computed automatically
 * based on the platform running the program
 * Created :  08.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class BoundsInLocalTest extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button("Close");
        b1.setEffect(new DropShadow());

        VBox root = new VBox();
        root.getChildren().addAll(b1);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Testing LayoutBounds");
        stage.show();
        
        System.out.println("b1(layoutBounds)=" + b1.getLayoutBounds());
        System.out.println("b1(boundsInLocal)=" + b1.getBoundsInLocal());
    }
}
