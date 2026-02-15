package javafx;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import qlin.Qlin;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    private static Stage stage;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    private Qlin qlin;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/HimmelScared.png"));
    private final Image qlinImage = new Image(this.getClass().getResourceAsStream("/images/FrierenCrying.png"));
    /**
     * Initialize the stage and print the greeting.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        //Greeting
        dialogContainer.getChildren().addAll(DialogBox.getQlinDialog(Qlin.getGreetingString(), qlinImage));
    }

    /** Injects the Duke instance */
    public void setQlin(Qlin q) {
        qlin = q;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = qlin.getResponseString(input);
        if (response != null) {
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage),
                    DialogBox.getQlinDialog(response, qlinImage)
            );
        } else {
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage)
            );
        }
        userInput.clear();
        if (qlin.getStatus()) {
            stage.close();
        }
    }

    /**
     * Store the stage to access the close() method.
     * @param stage The stage opened.
     */
    public static void setStage(Stage stage) {
        MainWindow.stage = stage;
    }
}

