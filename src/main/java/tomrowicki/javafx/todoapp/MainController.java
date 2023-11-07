package tomrowicki.javafx.todoapp;

import tomrowicki.javafx.todoapp.datamodel.TodoItem;

import java.time.LocalDate;
import java.util.List;

public class MainController {

    private List<TodoItem> todoItems;

    public void initialize() {
        TodoItem item1 = new TodoItem("Birthday card",
                "Buy a birthday card for some person",
                LocalDate.of(2023, 12, 1));
        TodoItem item2 = new TodoItem("Doctor's appointment",
                "Go to the doc",
                LocalDate.of(2023, 12, 3));
        TodoItem item3 = new TodoItem("Design proposal",
                "Finish the design proposal for the very important client",
                LocalDate.of(2023, 12, 4));
        TodoItem item4 = new TodoItem("Pickup John",
                "Pick John up at the train station",
                LocalDate.of(2023, 12, 5));
        TodoItem item5 = new TodoItem("Dry cleaning",
                "Get the clothes on Wednesday",
                LocalDate.of(2023, 12, 6));

       todoItems = List.of(item1, item2, item3, item4, item5);
    }
}
