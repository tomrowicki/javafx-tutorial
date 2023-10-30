package tomrowicki.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FlowPaneScene {

    static Scene getScene(Stage stage) throws IOException {
        stage.setTitle("Welcome to FlowPane!");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("flowpane-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 240);

        return scene;
    }
}
