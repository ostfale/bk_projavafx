package node;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The preferred size of a node is its ideal width and height to display its contents. For example, a button in its
 * preferred size would be big enough to display all its contents, based on the current properties such as the image,
 * text, font, and text wrapping. The minimum size of a node is the smallest width and height that it would like to
 * have. For example, a button in its minimum size would be big enough to display the image and an ellipsis for its
 * text. The maximum size of a node is the largest width and height that it would like to have. In the case of a button,
 * the maximum size of a button is the same as its preferred size. Sometimes you may want to extend a node to an
 * unlimited size. In those cases, the maximum width and height are set to Double.MAX_VALUE.
 * Created :  11.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class NodeSizeSentinelValues extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // Override the intrinsic width of the cancel button
        cancelBtn.setPrefWidth(100);

        VBox root = new VBox();
        root.getChildren().addAll(okBtn, cancelBtn);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Overriding Node Sizes");
        stage.show();

        System.out.println("okBtn.getPrefWidth(): " + okBtn.getPrefWidth());
        System.out.println("okBtn.getMinWidth(): " + okBtn.getMinWidth());
        System.out.println("okBtn.getMaxWidth(): " + okBtn.getMaxWidth());
        System.out.println("cancelBtn.getPrefWidth(): " + cancelBtn.getPrefWidth());
        System.out.println("cancelBtn.getMinWidth(): " + cancelBtn.getMinWidth());
        System.out.println("cancelBtn.getMaxWidth(): " + cancelBtn.getMaxWidth());
    }
}
