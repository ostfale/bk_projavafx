package layout.flowpane;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.geometry.Orientation.HORIZONTAL;
import static javafx.geometry.Orientation.VERTICAL;

/**
 * A FlowPane lays out its children at their preferred sizes. Rows and columns could be of different sizes.
 * You can align children in each row or column using the rowValignment and columnHalignment properties.
 * In a horizontal FlowPane, children in one row may be of different heights. The height of a row is the largest
 * of the preferred heights of all children in the row. The rowValignment property lets you specify the vertical
 * alignment of children in each row. Its value could be set to one of the constants of the VPos enum: BASELINE,
 * TOP, CENTER, and BOTTOM. If the maximum height value of a child node allows for vertical expansion, the child
 * node will be expanded to fill the height of the row. If the rowValignment property is set to VPos.BASELINE,
 * children are resized to their preferred height instead of expanding to fill the full height of the row.
 * Created :  16.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class FlowPaneRowColAlignment extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        FlowPane fp1 = createFlowPane(HORIZONTAL, VPos.TOP, HPos.LEFT);
        FlowPane fp2 = createFlowPane(HORIZONTAL, VPos.CENTER, HPos.LEFT);
        FlowPane fp3 = createFlowPane(VERTICAL, VPos.CENTER, HPos.RIGHT);

        HBox root = new HBox(fp1, fp2, fp3);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FlowPane Row and Column Alignment");
        stage.show();
    }

    private FlowPane createFlowPane(Orientation orientation, VPos rowAlign, HPos colAlign) {

        // Show the row or column alignment value in a Text
        Text t = new Text();
        if (orientation == HORIZONTAL) {
            t.setText(rowAlign.toString());
        } else {
            t.setText(colAlign.toString());
        }

        // Show the orientation of the FlowPane in a TextArea
        TextArea ta = new TextArea(orientation.toString());
        ta.setPrefColumnCount(5);
        ta.setPrefRowCount(3);

        FlowPane fp = new FlowPane(orientation, 5, 5);
        fp.setRowValignment(rowAlign);
        fp.setColumnHalignment(colAlign);
        fp.setPrefSize(175, 130);
        fp.getChildren().addAll(t, ta);
        fp.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        return fp;
    }
}
