package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * It displays four buttons in a VBox. The first button has a drop shadow effect. The third
 * button has a drop shadow effect and a 30-degree rotation transformation. The second and the
 * fourth buttons have no effect or transformation.
 * The output shows that irrespective of the effect and transformation, all buttons have the same
 * layoutBounds values. The size (width and height) in the layoutBounds objects for all buttons
 * is determined by the text of the button and the font, which is the same for all buttons.
 * Created :  08.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class LayoutBoundsTest extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button b1 = new Button("Close");
        b1.setEffect(new DropShadow());

        Button b2 = new Button("Close");

        Button b3 = new Button("Close");
        b3.setEffect(new DropShadow());
        b3.setRotate(30);

        Button b4 = new Button("Close");

        VBox root = new VBox();
        root.getChildren().addAll(b1, b2, b3, b4);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Testing LayoutBounds");
        stage.show();

        System.out.println("b1=" + b1.getLayoutBounds());
        System.out.println("b2=" + b2.getLayoutBounds());
        System.out.println("b3=" + b3.getLayoutBounds());
        System.out.println("b4=" + b4.getLayoutBounds());
    }
}
