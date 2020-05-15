package layout.hvbox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * An HBox lays out its children in a single horizontal row. It lets you set the horizontal spacing between adjacent
 * children, margins for any children, resizing behavior of children, etc. It uses 0px as the default spacing
 * between adjacent children. The default width of the content area and HBox is wide enough to display all its
 * children at their preferred widths, and the default height is the largest of the heights of all its children.
 * You cannot set the locations for children in an HBox. They are automatically computed by the HBox.
 * You can control the locations of children to some extent by customizing the properties of the HBox and
 * setting constraints on the children.
 * Created :  15.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class HBoxTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        HBox root = new HBox(10); // 10px spacing
        root.getChildren().addAll(nameLbl, nameFld, okBtn, cancelBtn);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using HBox");
        stage.show();
    }
}
