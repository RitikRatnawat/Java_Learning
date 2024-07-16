module com.rp.scenebuilder.scenebuilderdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rp.scenebuilder.scenebuilderdemo to javafx.fxml;
    exports com.rp.scenebuilder.scenebuilderdemo;
}