package tomrowicki.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TilePaneScene {

    static Scene getScene(Stage stage) throws IOException {
        stage.setTitle("Welcome to TilePane!");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tilepane-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 240);

        return scene;
    }
}
