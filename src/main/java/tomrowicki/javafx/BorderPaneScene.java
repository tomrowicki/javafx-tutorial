package tomrowicki.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BorderPaneScene {

    static Scene getScene(Stage stage) throws IOException {
        stage.setTitle("Welcome to BorderPane!");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("borderpane-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 240);

        return scene;
    }
}
