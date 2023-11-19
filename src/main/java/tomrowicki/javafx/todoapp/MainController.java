package tomrowicki.javafx.todoapp;

import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import tomrowicki.javafx.todoapp.datamodel.TodoData;
import tomrowicki.javafx.todoapp.datamodel.TodoItem;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MainController {

    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggleButton;
    private FilteredList<TodoItem> filteredList;


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

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(actionEvent -> {
            TodoItem item = todoListView.getSelectionModel().getSelectedItem();
            deleteItem(item);
        });
        listContextMenu.getItems().addAll(deleteMenuItem);

        todoListView.getSelectionModel().selectedItemProperty()
                .addListener((observableValue, oldItem, newItem) -> {
                    if (newItem != null) {
                        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                        itemDetailsTextArea.setText(item.getDetails());
                        DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                        deadlineLabel.setText(df.format(item.getDeadline()));
                    }
                });

        // filtering stuff
        filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(), todoItem -> {
           return true;
        });

        // sorting the items in accordance with their deadline
        SortedList<TodoItem> sortedList = new SortedList<>(filteredList,
                Comparator.comparing(TodoItem::getDeadline));

        todoListView.setItems(sortedList);
        // setup for being able to select only one item at a time
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
        // painting item's cell to red if the deadline's today
        todoListView.setCellFactory(todoItemListView -> {
            ListCell<TodoItem> cell = new ListCell<>() {
                @Override
                protected void updateItem(TodoItem todoItem, boolean empty) {
                    super.updateItem(todoItem, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(todoItem.getShortDescription());
                        // determine if the deadline is today, or before today
                        if (todoItem.getDeadline().isBefore(LocalDate.now().plusDays(1))) {
                            setTextFill(Color.RED);
                        }
                    }
                }
            };
            // ensuring that context menu is visible only on non-empty cells
            cell.emptyProperty().addListener((observableValue, wasEmpty, isEmpty) -> {
                if (isEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(listContextMenu);
                }
            });
            return cell;
        });
    }



    public void showNewItemDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        // setting up parent for the modal window
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new Todo Item");
        dialog.setHeaderText("Use this dialog to create a new Todo Item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // adding built-in ok and cancel buttons
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller.processResults();
            // using observable lists introduces data binding, so no need for update here
//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            todoListView.getSelectionModel().select(newItem);
        }
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

    public void handleKeyPressed(KeyEvent keyEvent) {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(selectedItem);
            }
        }
    }

    private void deleteItem(TodoItem item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete item: " + item.getShortDescription());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to back out");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)) {
            TodoData.getInstance().deleteTodoItem(item);
        }
    }

    public void handleFilterButton(ActionEvent actionEvent) {
        if (filterToggleButton.isSelected()) {
            filteredList.setPredicate(todoItem -> todoItem.getDeadline().equals(LocalDate.now()));
        } else {
            filteredList.setPredicate(todoItem -> true);
        }
    }

    public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
