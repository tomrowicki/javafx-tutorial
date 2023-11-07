package tomrowicki.javafx.todoapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TodoApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TodoApp.class.getResource("main-view.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 900, 500));
        stage.setTitle("Todo List");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

