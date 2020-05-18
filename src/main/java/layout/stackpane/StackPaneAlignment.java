package layout.stackpane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * StackPane has several other uses besides overlaying nodes. Whenever you have a requirement to align
 * a node or a collection of nodes in a specific position, try using a StackPane. For example, if you want to
 * display text in the center of your screen, use a StackPane with a Text node as the root node of the scene. The
 * StackPane takes care of keeping the text in the center as the window is resized. Without a StackPane, you will
 * need to use binding to keep the text positioned in the center of the window.
 * Created :  18.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class StackPaneAlignment extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane topLeft = createStackPane(Pos.TOP_LEFT);
        StackPane topRight = createStackPane(Pos.TOP_RIGHT);
        StackPane bottomLeft = createStackPane(Pos.BOTTOM_LEFT);
        StackPane bottomRight = createStackPane(Pos.BOTTOM_RIGHT);
        StackPane center = createStackPane(Pos.CENTER);

        double spacing = 10.0;
        HBox root = new HBox(spacing,
                topLeft,
                topRight,
                bottomLeft,
                bottomRight,
                center);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using StackPane");
        stage.show();
    }

    public StackPane createStackPane(Pos alignment) {
        Rectangle rect = new Rectangle(80, 50);
        rect.setFill(Color.LAVENDER);

        Text text = new Text(alignment.toString());
        text.setStyle("-fx-font-size: 7pt;");

        StackPane spane = new StackPane(rect, text);
        spane.setAlignment(alignment);
        spane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        return spane;
    }
}
