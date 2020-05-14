package eventhandling;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Shows a Label and a TextField. It adds a key-typed event handler to the
 * TextField, which consumes the event if the character typed is not a letter. Otherwise, it prints the character
 * typed on the standard output. Run the program. You should be able to enter letters in the TextField. When
 * you press any nonletter keys, for example, 1, 2, 3, nothing happens.
 * Created :  14.05.2020
 *
 * @author : Uwe Sauerbrei
 */
public class KeyTyped extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label nameLbl = new Label("Name:");
        TextField nameTfl = new TextField();

        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(nameLbl, nameTfl);

        // Add key-typed event to the TextField
        nameTfl.setOnKeyTyped(this::handle);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Key Typed Event");
        stage.show();
    }

    public void handle(KeyEvent e) {
        // Consume the event if it is not a letter
        String str = e.getCharacter();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c)) {
                e.consume();
            }
        }
        // Print the details if it is not consumed
        if (!e.isConsumed()) {
            String type = e.getEventType().getName();
            System.out.println(type + ": Character=" + e.getCharacter());
        }
    }
}
