package tomrowicki.javafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
    @FXML
    private Label ourLabel;

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

        // long calculation
        Runnable task = () -> {
            try {
                String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                System.out.println("I'm going to sleep on: " + s);
                Thread.sleep(5_000);
                Platform.runLater(() -> {
                    ourLabel.setText("We did something!");
                    String s2 = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm waking up on: " + s2);
                });
            } catch (InterruptedException ex) {
            }
        };
        new Thread(task).start();

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
