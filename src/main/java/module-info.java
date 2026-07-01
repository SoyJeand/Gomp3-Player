module com.jd.solutions.mireproductor {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;
    requires java.desktop;
    requires javafx.media;


    opens com.jd.solutions.mireproductor to javafx.fxml;
    exports com.jd.solutions.mireproductor;
}