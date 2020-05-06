package stage;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX Application Thread is terminated when the Platform.exit() method is called or the last
 * shown stage is closed. The JVM terminates when all nondaemon threads die.
 * JavaFX Application Thread is a nondaemon thread. The Application.launch() method returns when
 * the JavaFX Application Thread terminates.
 * Created :  06.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ShortLivedApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

  /*  @Override
    public void start(Stage stage) throws Exception {
        Platform.exit(); // Exit the application
    }*/


    /*
     * The close() method of the Stage class has the same effect as calling the hide() method of the
     * Window class.
     */
    @Override
    public void start(Stage stage) {
        stage.show(); // First show the stage
        stage.close(); // Now close it
    }

   /*   Even with this code for the start() method, the EverRunningApp runs forever. The close() method
        does not close the stage if the stage is not showing. The primary stage was never shown. Therefore, adding a
        stage.close() call to the start() method did not do any good.
    @Override
    public void start(Stage stage) throws Exception {
        stage.close(); // Close the only stage you have not the app
    }*/
}
