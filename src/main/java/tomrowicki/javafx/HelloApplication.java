package tomrowicki.javafx;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 700, 240);


//        making the app not relying on the fxml
//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setVgap(10);
//        root.setHgap(10);
//        Scene scene = new Scene(root, 700, 240);
//
//        Label greeting = new Label("Hello to JavaFx!");
//        greeting.setTextFill(Color.GREEN);
//        greeting.setFont(Font.font("Times New Roman", FontWeight.BOLD, 70));
//        root.getChildren().add(greeting);

//        stage.setTitle("Hello!");



        stage.setScene(BorderPaneScene.getScene(stage));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}