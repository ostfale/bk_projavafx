package eventhandling;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

/**
 * An event is consumed by calling its consume() method. The event class contains the method and it is
 * inherited by all event classes. Typically, the consume() method is called inside the handle() method of the
 * event filters and handlers.
 * Consuming an event indicates to the event dispatcher that the event processing is complete and that
 * the event should not travel any farther in the event dispatch chain. If an event is consumed in an event filter
 * of a node, the event does not travel to any child node. If an event is consumed in an event handler of a node,
 * the event does not travel to any parent node.
 * Clicking the check box does not execute the mouse-clicked event handlers for the HBox, Scene, and
 * Stage, whereas clicking the rectangle does. The check box has a default event handler that takes a default action and consumes the event, preventing it
 * from traveling up the event dispatch chain. The rectangle does not consume the event, allowing it to travel
 * up the event dispatch chain.
 * Created :  13.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class ConsumingEvents extends Application {

    private final CheckBox consumeEventCbx = new CheckBox("Consume Mouse Click at Circle");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle(60, 60, 60);
        circle.setFill(Color.CORAL);

        Rectangle rect = new Rectangle(100, 100);
        rect.setFill(Color.TAN);

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle, rect, consumeEventCbx);

        Scene scene = new Scene(root);

        // Register mouse-clicked event handlers to all nodes, except the rectangle and checkbox
        EventHandler<MouseEvent> handler = e -> handleEvent(e);
        EventHandler<MouseEvent> circleMeHandler = e -> handleEventforCircle(e);

        stage.addEventHandler(MOUSE_CLICKED, handler);
        scene.addEventHandler(MOUSE_CLICKED, handler);
        root.addEventHandler(MOUSE_CLICKED, handler);
        circle.addEventHandler(MOUSE_CLICKED, circleMeHandler);

        stage.setScene(scene);
        stage.setTitle("Consuming Events");
        stage.show();
    }

    public void handleEvent(MouseEvent e) {
        print(e);
    }

    public void handleEventforCircle(MouseEvent e) {
        print(e);
        if (consumeEventCbx.isSelected()) {
            e.consume();
        }
    }

    public void print(MouseEvent e) {
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();
        // Get coordinates of the mouse cursor relative to the event source
        double x = e.getX();
        double y = e.getY();

        System.out.println("Type=" + type + ", Target=" + target + ", Source=" + source + ", location(" + x + ", " + y + ")");
    }
}
