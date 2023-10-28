package tomrowicki.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GridPaneController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("GridPane FTW!");
    }
}