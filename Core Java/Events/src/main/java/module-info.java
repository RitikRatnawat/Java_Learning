module com.rp.events {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rp.events to javafx.fxml;
    exports com.rp.events;
}