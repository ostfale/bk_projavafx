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
 * The Node, Scene, and Window classes contain event properties to store event handlers of some selected
 * event types. The property names use the event type pattern. They are named as onXXX. For example, the
 * onMouseClicked property stores the event handler for the mouse-clicked event type; the onKeyTyped
 * property stores the event handler for the key-typed event, and so on. You can use the setOnXXX() methods
 * of these properties to register event handlers for a node. For example, use the setOnMouseClicked() method
 * to register an event handler for the mouse-clicked event and use the setOnKeyTyped() method to register an
 * event handler for the key-typed event, and so on. The setOnXXX() methods in various classes are known as
 * convenience methods for registering event handlers.
 * <ul>
 *     <li>They only support the registration of event handlers, not event filters. If you need to
 * register event filters, use the addEventFilter() method</li>
 *     <li>They only support the registration of one event handler for a node. Multiple event
 * handlers for a node may be registered using the addEventHandler() method</li>
 *     <li>These properties exist only for the commonly used events for a node type. For
 * example, the onMouseClicked property exists in the Node and Scene classes, but not
 * the Window class</li>
 * </ul>
 * Created :  13.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class EventHandlerProperties extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.CORAL);

        HBox root = new HBox();
        root.getChildren().add(circle);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using convenience event handler properties");
        stage.show();
        stage.sizeToScene();

        // Create a MouseEvent filter
        EventHandler<MouseEvent> eventFilter = e -> System.out.println("Mouse event filter has been called.");
        // Create a MouseEvent handler
        EventHandler<MouseEvent> eventHandler = e -> System.out.println("Mouse event handler has been called.");

        // Register the filter using the addEventFilter() method
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventFilter);

        // Register the handler using the setter method for the onMouseClicked convenience event property
        circle.setOnMouseClicked(eventHandler);
    }
}
