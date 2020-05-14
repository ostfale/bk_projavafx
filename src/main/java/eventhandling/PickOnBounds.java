package eventhandling;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * The Rectangle uses red as the fill color, whereas light gray is used as the fill color for the Circle. The
 * area in red is the area between the perimeters of the geometric shape and bounds of the Circle.
 * You have a check box that controls the pickOnBounds property of the circle. If it is selected, the property
 * is set to true. Otherwise, it is set to false.
 * When you click the gray area, Circle always picks up the mouse-clicked event. When you click the
 * red area with the check box unselected, the Rectangle picks up the event. When you click the red area
 * with the check box selected, the Circle picks up the event. The output shows who picks up the mouseclicked event.
 * Created :  14.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class PickOnBounds extends Application {

    private final CheckBox pickOnBoundsCbx = new CheckBox("Pick on Bounds");
    Circle circle = new Circle(50, 50, 50, Color.LIGHTGRAY);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Rectangle rect = new Rectangle(100, 100);
        rect.setFill(Color.RED);

        Group group = new Group();
        group.getChildren().addAll(rect, circle);

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(group, pickOnBoundsCbx);

        // Add MOUSE_CLICKED event handlers to the circle and rectangle
        circle.setOnMouseClicked(this::handleMouseClicked);
        rect.setOnMouseClicked(this::handleMouseClicked);

        // Add an Action handler to the checkbox
        pickOnBoundsCbx.setOnAction(this::handleActionEvent);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Pick on Bounds");
        stage.show();
    }

    public void handleMouseClicked(MouseEvent e) {
        String target = e.getTarget().getClass().getSimpleName();
        String type = e.getEventType().getName();
        System.out.println(type + " on " + target);
    }

    public void handleActionEvent(ActionEvent e) {
        if (pickOnBoundsCbx.isSelected()) {
            circle.setPickOnBounds(true);
        } else {
            circle.setPickOnBounds(false);
        }
    }
}
