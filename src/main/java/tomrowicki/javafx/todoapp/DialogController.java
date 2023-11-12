package tomrowicki.javafx.todoapp;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import tomrowicki.javafx.todoapp.datamodel.TodoData;
import tomrowicki.javafx.todoapp.datamodel.TodoItem;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    public TodoItem processResults() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadline = deadlinePicker.getValue();
        TodoItem newItem = new TodoItem(shortDescription, details, deadline);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
