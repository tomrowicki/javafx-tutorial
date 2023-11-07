module tomrowicki.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens tomrowicki.javafx to javafx.fxml;

    exports tomrowicki.javafx;
    exports tomrowicki.javafx.todoapp;
}