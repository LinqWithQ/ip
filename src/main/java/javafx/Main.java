package javafx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import qlin.Qlin;

/**
 * A GUI for Qlin using FXML.
 */
public class Main extends Application {

    private final Qlin qlin = new Qlin();
    @Override
    public void start(Stage stage) {
        try {
            MainWindow.setStage(stage);
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            // inject the Qlin instance
            fxmlLoader.<MainWindow>getController().setQlin(qlin);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

