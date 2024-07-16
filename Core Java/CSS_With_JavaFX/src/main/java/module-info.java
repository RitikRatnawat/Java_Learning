module com.css.css_with_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.css.css_with_javafx to javafx.fxml;
    exports com.css.css_with_javafx;
}