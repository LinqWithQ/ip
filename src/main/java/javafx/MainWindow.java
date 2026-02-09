package javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import qlin.Qlin;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Qlin qlin;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/HimmelScared.png"));
    private Image qlinImage = new Image(this.getClass().getResourceAsStream("/images/FrierenCrying.png"));
    /**
     * Initialize the stage and print the greeting.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        //Greeting
        dialogContainer.getChildren().addAll(DialogBox.getQlinDialog(qlin.getGreeting(), qlinImage));
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
        String response = qlin.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getQlinDialog(response, qlinImage)
        );
        userInput.clear();
    }
}

