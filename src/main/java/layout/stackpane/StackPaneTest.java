package layout.stackpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Children are drawn in the order they are added. That is, the first child node is drawn
 * first; the second child node is drawn next, etc.
 * The preferred width of a StackPane is the width of its widest children. Its preferred height is the height of
 * its tallest children. StackPane does clip its content. Therefore, its children may be drawn outside its bounds.
 * A StackPane resizes its resizable children to fill its content area, provided their maximum size allows
 * them to expand beyond their preferred size. By default, a StackPane aligns all its children to the center of its
 * content area.
 * Created :  18.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class StackPaneTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create a Rectangle and a Text
        Rectangle rect = new Rectangle(200, 50);
        rect.setStyle("-fx-fill: lavender;" +
                "-fx-stroke-type: inside;" +
                "-fx-stroke-dash-array: 5 5;" +
                "-fx-stroke-width: 1;" +
                "-fx-stroke: black;" +
                "-fx-stroke-radius: 5;");

        Text text = new Text("A Rectangle");

        // Create a StackPane with a Rectangle and a Text
        StackPane root = new StackPane(rect, text);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using StackPane");
        stage.show();
    }
}
