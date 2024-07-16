module com.example.tasks.javafxtasks {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tasks.javafxtasks to javafx.fxml;
    exports com.example.tasks.javafxtasks;
}