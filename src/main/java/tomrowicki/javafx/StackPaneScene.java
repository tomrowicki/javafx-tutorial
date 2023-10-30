package tomrowicki.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StackPaneScene {

    static Scene getScene(Stage stage) throws IOException {
        stage.setTitle("Welcome to StackPane!");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stackpane-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 240);

        return scene;
    }
}
