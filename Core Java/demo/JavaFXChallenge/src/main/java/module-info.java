module com.challenge.javafxchallenge {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.challenge.javafxchallenge to javafx.fxml;
    exports com.challenge.javafxchallenge;
    exports com.challenge.javafxchallenge.datamodel;
    opens com.challenge.javafxchallenge.datamodel to javafx.fxml;
}