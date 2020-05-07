package scene;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The runLater() method is used to submit a Runnable task to an event queue, so it is executed on
 * the JavaFX Application Thread. JavaFX allow developers to execute some of the code only on the JavaFX
 * Application Thread.
 * Created :  07.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class RunLaterApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init(): " + Thread.currentThread().getName());

        // Create a Runnable task
        Runnable task = () -> System.out.println("Running the task on the " + Thread.currentThread().getName());

        // Submit the task to be run on the JavaFX Application Thread
        Platform.runLater(task);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new Group(), 400, 100));
        stage.setTitle("Using Platform.runLater() Method");
        stage.show();
    }
}
