module com.example.numberguessinggame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.swingEmpty;
    requires javafx.swing;

    exports com.example.numberguessinggame to javafx.fxml;
    opens com.example.numberguessinggame;
}