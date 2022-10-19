module com.oop.bomberman {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.oop.bomberman to javafx.fxml;
    exports com.oop.bomberman;
}