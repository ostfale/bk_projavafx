package eventhandling;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Complete program to demonstrate the handling of the mouse-clicked events of a
 * Circle object. It uses an event filter and an event handler. Run the program and click inside the circle. When
 * the circle is clicked, the event filter is called first, followed by the event handler. This is evident from the
 * output. The mouse-clicked event occurs every time you click any point inside the circle. If you click outside
 * the circle, the mouse-clicked event still occurs; however, you do not see any output because you have not
 * registered event filters or handlers on the HBox, Scene, and Stage.
 * Created :  13.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class EventRegistration extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.CORAL);

        // Create a MouseEvent filter
        EventHandler<MouseEvent> mouseEventFilter = e -> System.out.println("Mouse event filter has been called.");

        // Create a MouseEvent handler
        EventHandler<MouseEvent> mouseEventHandler = e -> System.out.println("Mouse event handler has been called.");

        // Register the MouseEvent filter and handler to the Circle for mouse-clicked events
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventFilter);
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);

        HBox root = new HBox();
        root.getChildren().add(circle);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Registering Event Filters and Handlers");
        stage.show();
        stage.sizeToScene();
    }
}
