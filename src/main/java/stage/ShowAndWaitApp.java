package stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The primary stage is opened with an Open button. Clicking the Open button opens a
 * secondary stage using the showAndWait() method. The secondary stage has two buttons—Say Hello and
 * Open—which will, respectively, will print a message on the console and open another secondary stage.
 * A message is printed on the console before and after the call to the showAndWait() method. You need to
 * open multiple secondary stages, print messages by clicking the Say Hello button, close them in any order
 * you want, and then look at the output on the console.
 * <p>
 * Created :  07.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ShowAndWaitApp extends Application {

    protected static int counter = 0;
    protected Stage lastOpenStage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        Button openButton = new Button("Open");
        openButton.setOnAction(e -> open(++counter));
        root.getChildren().add(openButton);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("The Primary Stage");
        stage.show();
        this.lastOpenStage = stage;
    }

    private void open(int stageNumber) {
        Stage stage = new Stage();
        stage.setTitle("#" + stageNumber);
        Button sayHelloButton = new Button("Say Hello");
        sayHelloButton.setOnAction(
                e -> System.out.println("Hello from #" + stageNumber));
        Button openButton = new Button("Open");
        openButton.setOnAction(e -> open(++counter));
        VBox root = new VBox();
        root.getChildren().addAll(sayHelloButton, openButton);
        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        stage.setX(this.lastOpenStage.getX() + 50);
        stage.setY(this.lastOpenStage.getY() + 50);
        this.lastOpenStage = stage;
        System.out.println("Before stage.showAndWait(): " + stageNumber);
        // Show the stage and wait for it to close
        stage.showAndWait();
        System.out.println("After stage.showAndWait(): " + stageNumber);
    }
}
