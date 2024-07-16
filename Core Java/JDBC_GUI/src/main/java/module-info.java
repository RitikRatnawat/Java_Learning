module com.example.jdbc_gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.jdbc_gui to javafx.fxml;
    opens com.example.jdbc_gui.model to javafx.fxml;
    exports com.example.jdbc_gui;
    exports com.example.jdbc_gui.model;
}