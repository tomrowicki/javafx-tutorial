package tomrowicki.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EventsController {

    @FXML
    private TextField nameField;

    public void onButtonClicked() {
        System.out.printf("Hello, %s!%n", nameField.getText());
    }
}
