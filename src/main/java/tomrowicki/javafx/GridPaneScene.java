package tomrowicki.javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GridPaneScene {
    static Scene getScene(Stage stage) throws IOException {
        stage.setTitle("Welcome to GridPane!");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gridpane-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 240);



        return scene;
    }
}
