import Status.StatusBarUi;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

/**
 * First simple example of a starter class
 * Created :  21.04.2020
 *
 * @author : Uwe Sauerbrei
 */
public class HelloFx extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("First FX Test Application!");
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(createMenuBar());
        borderPane.setCenter(createTabPane());
        borderPane.setBottom(new StatusBarUi().create());


        Scene scene = new Scene(borderPane, 960, 600);
        scene.setCursor(Cursor.CROSSHAIR);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setX(50);
        primaryStage.setY(50);
        primaryStage.show();


//        Text aText = new Text("Example for a text\nSecond Line");
//        aText.setFont(Font.font("Arial", FontWeight.BOLD, 36));
//        aText.setFill(Color.GOLD);
//        aText.setStroke(Color.GREEN);
//
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private Node createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu appMenu = new Menu("App");
        Menu helpMenu = new Menu("Help");

        FontIcon openDoor = new FontIcon(FontAwesomeSolid.DOOR_OPEN);
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setGraphic(openDoor);
        exitItem.setOnAction(e -> Platform.exit());
        appMenu.getItems().add(exitItem);

        FontIcon aboutIcon = new FontIcon(FontAwesomeSolid.QUESTION);
        MenuItem aboutItem = new MenuItem("About");
        aboutItem.setGraphic(aboutIcon);
        aboutItem.setOnAction(e -> createAboutDialog().showAndWait());
        helpMenu.getItems().add(aboutItem);


        menuBar.getMenus().addAll(appMenu, helpMenu);
        return menuBar;
    }

    private Node createTabPane() {
        TabPane tabPane = new TabPane();
        tabPane.setSide(Side.RIGHT);

        Tab dashboard = new Tab("Dashboard");
        dashboard.setClosable(false);

        Tab csConfig = new Tab("CS Config");
        csConfig.setClosable(false);

        Tab csmsConfig = new Tab("CSMS Config");
        csmsConfig.setClosable(false);

        tabPane.getTabs().addAll(dashboard, csConfig, csmsConfig);
        return tabPane;
    }

    private Alert createAboutDialog() {

        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Test Application About");
        alert.setHeaderText("Shows some system information");
        alert.setContentText("Java Version: " + javaVersion + "\nJavaFX Version: " + javafxVersion);

        return alert;
    }
}
