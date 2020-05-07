package stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * You cannot get screen descriptions in a non-JavaFX application.
 * this is the reason that you would write the code in the start() method of a JavaFX application class.
 * Created :  06.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ScreenDetailsApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<Screen> screenList = Screen.getScreens();
        System.out.println("Screens Count: " + screenList.size());

        // Print the details of all screens
        for (Screen screen : screenList) {
            print(screen);
        }
        Platform.exit();
    }

    public void print(Screen s) {
        System.out.println("DPI: " + s.getDpi());
        System.out.print("Screen Bounds: ");
        Rectangle2D bounds = s.getBounds();
        print(bounds);
        System.out.print("Screen Visual Bounds: ");
        Rectangle2D visualBounds = s.getVisualBounds();
        print(visualBounds);
        System.out.println("-----------------------");
    }

    public void print(Rectangle2D r) {
        System.out.format("minX=%.2f, minY=%.2f, width=%.2f, height=%.2f%n", r.getMinX(), r.getMinY(), r.getWidth(), r.getHeight());
    }
}