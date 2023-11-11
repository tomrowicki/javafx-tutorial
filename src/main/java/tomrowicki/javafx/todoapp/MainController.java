package tomrowicki.javafx.todoapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import tomrowicki.javafx.todoapp.datamodel.TodoData;
import tomrowicki.javafx.todoapp.datamodel.TodoItem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainController {

    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;

    public void initialize() {
//        TodoItem item1 = new TodoItem("Birthday card",
//                "Buy a birthday card for some person",
//                LocalDate.of(2023, 12, 1));
//        TodoItem item2 = new TodoItem("Doctor's appointment",
//                "Go to the doc",
//                LocalDate.of(2023, 12, 3));
//        TodoItem item3 = new TodoItem("Design proposal",
//                "Finish the design proposal for the very important client",
//                LocalDate.of(2023, 12, 4));
//        TodoItem item4 = new TodoItem("Pickup John",
//                "Pick John up at the train station",
//                LocalDate.of(2023, 12, 5));
//        TodoItem item5 = new TodoItem("Dry cleaning",
//                "Get the clothes on Wednesday",
//                LocalDate.of(2023, 12, 6));
//
//        todoItems = List.of(item1, item2, item3, item4, item5);
//        TodoData.getInstance().setTodoItems(todoItems);

        todoListView.getSelectionModel().selectedItemProperty()
                .addListener((observableValue, oldItem, newItem) -> {
                    if (newItem != null) {
                        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                        itemDetailsTextArea.setText(item.getDetails());
                        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                        deadlineLabel.setText(df.format(item.getDeadline()));
                    }
                });

        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        // setup for being able to select only one item at a time
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
//        deadlineLabel.setText(item.getDeadline().toString());
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetailsTextArea.setText(sb.toString());
    }
}
