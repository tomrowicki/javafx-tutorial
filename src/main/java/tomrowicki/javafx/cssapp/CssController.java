package tomrowicki.javafx.cssapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.io.File;

public class CssController {
    @FXML
    private Label label;
    @FXML
    private Button button4;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;

    public void initialize() {
        button4.setEffect(new DropShadow());
    }

    @FXML
    private void handleMouseEnter() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    private void handleMouseExit() {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    public void handleClick(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(gridPane.getScene().getWindow());
        if (file != null) {
            System.out.println("Chose file: " + file.getPath());
        } else {
            System.out.println("Chooser was cancelled");
        }
    }

    public void saveFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save application file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image", "*.jpg", "*.png"),
                new FileChooser.ExtensionFilter("All", "*.*")
        );
        File file = fileChooser.showSaveDialog(gridPane.getScene().getWindow());
        if (file != null) {
            System.out.println("Chose save file location: " + file.getPath());
        } else {
            System.out.println("Chooser was cancelled");
        }
    }

    public void handleLinkClick(ActionEvent actionEvent) {
        System.out.println("Link clicked");
        // solution from the course to open default browser is outdated,
        // see: https://stackoverflow.com/questions/33094981/javafx-8-open-a-link-in-a-browser-without-reference-to-application
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://openjfx.io/");
    }
}