package eventhandling;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

/**
 * The program adds a Circle and a Rectangle to an HBox. The HBox is added to the Scene.
 * An event filter and an event handler are added to the Stage, Scene, HBox, and Circle
 * for the mouse-clicked event. Run the program and click anywhere inside the circle.
 * The output shows the order in which filters and handlers are called. The output contains
 * the event phase, type, target, source, and location. Notice that the source of the
 * event changes as the event travels from one node to another. The location is relative to the event source.
 * Because every node uses its own local coordinate system, the same point, where the mouse is clicked, has
 * different values for (x, y) coordinates relative to different nodes.
 * Created :  13.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class CaptureBubblingOrder extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle(50, 50, 50);
        circle.setFill(Color.CORAL);

        Rectangle rect = new Rectangle(100, 100);
        rect.setFill(Color.TAN);

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle, rect);

        Scene scene = new Scene(root);

        // Create two EventHandlers
        EventHandler<MouseEvent> filter = e -> handleEvent("Capture", e);
        EventHandler<MouseEvent> handler = e -> handleEvent("Bubbling", e);

        // Register filters
        stage.addEventFilter(MOUSE_CLICKED, filter);
        scene.addEventFilter(MOUSE_CLICKED, filter);
        root.addEventFilter(MOUSE_CLICKED, filter);
        circle.addEventFilter(MOUSE_CLICKED, filter);

        // Register handlers
        stage.addEventHandler(MOUSE_CLICKED, handler);
        scene.addEventHandler(MOUSE_CLICKED, handler);
        root.addEventHandler(MOUSE_CLICKED, handler);
        circle.addEventHandler(MOUSE_CLICKED, handler);

        stage.setScene(scene);
        stage.setTitle("Event Capture and Bubbling Execution Order");
        stage.show();
    }

    public void handleEvent(String phase, MouseEvent e) {
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();

        // Get coordinates of the mouse cursor relative to the event source
        double x = e.getX();
        double y = e.getY();

        System.out.println(phase + ": Type=" + type + ", Target=" + target + ", Source=" + source + ", location(" + x + ", " + y + ")");
    }
}
