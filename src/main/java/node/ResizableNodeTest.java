package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Shows the behavior of resizable and nonresizable nodes during a layout. It adds a button and a rectangle to an HBox.
 * After you run the program, make the stage shorter in width. The button becomes smaller up to a point when it displays
 * an ellipsis (...). The rectangle remains the same size all the time.
 * Created :  11.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ResizableNodeTest extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button("A big button");
        Rectangle rect = new Rectangle(100, 50);
        rect.setFill(Color.WHITE);
        rect.setStrokeWidth(1);
        rect.setStroke(Color.BLACK);

        HBox root = new HBox();
        root.setSpacing(20);
        root.getChildren().addAll(btn, rect);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Resizable Nodes");
        stage.show();

        System.out.println("btn.isResizable(): " + btn.isResizable());
        System.out.println("rect.isResizable(): " + rect.isResizable());
    }
}
