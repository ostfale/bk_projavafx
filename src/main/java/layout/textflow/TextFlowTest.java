package layout.textflow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * A TextFlow layout pane is designed to display rich text. The rich text is composed of multiple Text nodes.
 * The TextFlow combines the text in all Text nodes to display in a single text flow. A new line character ('\n')
 * in the text of the Text child nodes indicates the start of a new paragraph. The text is wrapped at the width of
 * the TextFlow.
 * Created :  19.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class TextFlowTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create three Text nodes
        Text tx1 = new Text("TextFlow layout pane is cool! ");
        tx1.setFill(Color.RED);
        tx1.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        Text tx2 = new Text("It supports rich text display.");
        tx2.setFill(Color.BLUE);

        Text tx3 = new Text("\nThis is a new paragraph, which was created using the \\n newline character.");

        // Create a TextFlow object with the three Text nodes
        TextFlow root = new TextFlow(tx1, tx2, tx3);

        // Set the preferred width and line spacing
        root.setPrefWidth(300);
        root.setLineSpacing(5);

        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using TextFlow");
        stage.show();
    }
}
