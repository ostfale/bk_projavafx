import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

/**
 * First simple example of a starter class
 * Created :  21.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class HelloFx extends Application {

    @Override
    public void start(Stage primaryStage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        Text aText = new Text("Example for a text\nSecond Line");
        aText.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        aText.setFill(Color.GOLD);
        aText.setStroke(Color.GREEN);

        FontIcon icon = new FontIcon(FontAwesomeSolid.COGS);
        Button button = new Button("US Button");
        button.setGraphic(icon);

        Scene scene = new Scene(new StackPane(button), 800, 600);
        scene.setCursor(Cursor.CROSSHAIR);
        primaryStage.setTitle("My first (again) JavaFX Application");
        primaryStage.setX(50);
        primaryStage.setY(50);
        primaryStage.initStyle(StageStyle.DECORATED);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        // primaryStage.initStyle(StageStyle.UNIFIED);
        // primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
