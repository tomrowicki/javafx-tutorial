package tomrowicki.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlsScene {

    static Scene getScene(Stage stage) throws IOException {
        stage.setTitle("Welcome to Controls lesson!");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("controls-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 240);

        return scene;
    }
}
