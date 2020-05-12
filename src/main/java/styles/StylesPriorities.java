package styles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * The JavaFX runtime uses the following priority rules to set the visual properties of a node. The source
 * with a higher priority that has a value for a property is used:<p>
 *     <ul>
 *         <li>Inline style (the highest priority)</li>
 *         <li>Parent style sheets</li>
 *         <li>Scene style sheets</li>
 *         <li>Values set in the code using JavaFX API</li>
 *         <li>User agent style sheets (the lowest priority)</li>
 *     </ul>
 * </p>
 * Created :  12.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class StylesPriorities extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        Button cancelBtn = new Button("Cancel");

        // Change the font size for the Yes button using two methods: inline style and JavaFX API
        yesBtn.setStyle("-fx-font-size: 16px");
        yesBtn.setFont(new Font(10));

        // Change the font size for the No button using the JavaFX API
        noBtn.setFont(new Font(8));

        HBox root = new HBox();
        root.setSpacing(10);
        root.getChildren().addAll(yesBtn, noBtn, cancelBtn);

        Scene scene = new Scene(root);
        // Add a style sheet to the scene
        scene.getStylesheets().addAll("/css/stylesPriorities.css");

        stage.setScene(scene);
        stage.setTitle("Styles Priorities");
        stage.show();
    }
}
