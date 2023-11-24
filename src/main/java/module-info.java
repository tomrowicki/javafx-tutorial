module tomrowicki.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens tomrowicki.javafx to javafx.fxml;
    opens tomrowicki.javafx.todoapp;
    opens tomrowicki.javafx.cssapp;

    exports tomrowicki.javafx;
    exports tomrowicki.javafx.todoapp;
    exports tomrowicki.javafx.cssapp;
}