package layout.stackpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Overlay rules work in a StackPane<p>
 *     <ul>
 *         <li>In the first StackPane, the text is overlaid on the rectangle. The rectangle is drawn first and the text second. B
 *         oth are visible.</li>
 *         <li>In the second StackPane, the rectangle is overlaid on the text. The text is hidden behind the rectangle as
 *         the rectangle is drawn over the text and it is bigger than the text.</li>
 *         <li>In the third StackPane, the rectangle is overlaid on the text. Unlike the second StackPane, the text is
 *         visible because we have set the opacity for the rectangle to 0.5,which makes it is 50% transparent.</li>
 *         <li>In the fourth StackPane, the rectangle is overlaid on a big text. The opacity of the  rectangle is 100%.
 *         Therefore, we see only the part of the text that is outside the bounds of the rectangle.</li>
 *         <li>In the fifth StackPane, the rectangle is overlaid on a big text. The opacity of the rectangle is 50%. We can see
 *         the entire text. The visibility of the text within the bounds of the rectangle is 50% and that of outside the bounds
 *         is 100%</li>
 *     </ul>
 * </p>
 * Created :  18.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class StackPaneOverlayTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane textOverRect = createStackPane("Hello", 1.0, true);
        StackPane rectOverText = createStackPane("Hello", 1.0, false);
        StackPane transparentRectOverText = createStackPane("Hello", 0.5, false);
        StackPane rectOverBigText = createStackPane("A bigger text", 1.0, false);
        StackPane transparentRectOverBigText = createStackPane("A bigger text", 0.5, false);

        // Add all StackPanes to an HBox
        HBox root = new HBox(textOverRect,
                rectOverText,
                transparentRectOverText,
                rectOverBigText,
                transparentRectOverBigText);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Overlaying Rules in StackPane");
        stage.show();
    }

    public StackPane createStackPane(String str, double rectOpacity, boolean rectFirst) {
        Rectangle rect = new Rectangle(60, 50);
        rect.setStyle("-fx-fill: lavender;" + "-fx-opacity: " + rectOpacity + ";");

        Text text = new Text(str);

        // Create a StackPane
        StackPane spane = new StackPane();

        // add the Rectangle before the Text if rectFirst is true.Otherwise add the Text first
        if (rectFirst) {
            spane.getChildren().addAll(rect, text);
        } else {
            spane.getChildren().addAll(text, rect);
        }

        spane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        return spane;
    }
}
