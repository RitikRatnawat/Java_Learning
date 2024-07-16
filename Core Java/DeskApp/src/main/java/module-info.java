module com.rp.deskapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rp.deskapp to javafx.fxml;
    exports com.rp.deskapp;
}