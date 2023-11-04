package tomrowicki.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EventsHandlingScene {

    static Scene getScene(Stage stage) throws IOException {
        stage.setTitle("Welcome to Events lesson!");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("events.fxml"));
        return new Scene(fxmlLoader.load(), 900, 600);
    }
}
