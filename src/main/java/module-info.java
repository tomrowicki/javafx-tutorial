module tomrowicki.garbagespotter {
    requires javafx.controls;
    requires javafx.fxml;


    opens tomrowicki.javafx to javafx.fxml;
    exports tomrowicki.javafx;
}