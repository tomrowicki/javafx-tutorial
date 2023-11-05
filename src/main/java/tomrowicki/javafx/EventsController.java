package tomrowicki.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class EventsController {
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckbox;

    // this requires the exact name 'initialize' to work outside the box
    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    // can use this without specifying event; can make the method private but add annotation
//    public void onButtonClicked() {
//        System.out.printf("Hello, %s!%n", nameField.getText());
//    }

    public void onEitherButtonClicked(ActionEvent e) {
        if (e.getSource().equals(helloButton)) {
            System.out.printf("Hello, %s!%n", nameField.getText());
        } else if (e.getSource().equals(byeButton)) {
            System.out.printf("Bye, %s!%n", nameField.getText());
        }
        if (ourCheckbox.isSelected()) {
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }

    @FXML
    private void handleKeyReleased() {
        String text = nameField.getText();
        boolean disabledButtons = text.trim().isEmpty();
        helloButton.setDisable(disabledButtons);
        byeButton.setDisable(disabledButtons);
    }

    public void handleChange() {
        System.out.println("The checkbox is " + (ourCheckbox.isSelected() ? "checked" : "unchecked"));
    }
}
