import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        Scene scene = new Scene(new StackPane(l), 640, 480);
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
