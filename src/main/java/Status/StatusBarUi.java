package Status;

import javafx.scene.Node;
import javafx.scene.control.Button;
import org.controlsfx.control.StatusBar;

/**
 * Creates Statusbar from ControlsFX
 * Created :  24.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class StatusBarUi {

    public Node create() {
        StatusBar statusBar = new StatusBar();
        statusBar.getRightItems().add(new Button("Info"));
        return statusBar;
    }
}
