package com.oop.bomberman;

import com.oop.bomberman.control.Control;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Bomberman extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Bomberman.class.getResource("FXML/app-view.fxml"));
        AnchorPane root = fxmlLoader.load();
        root.setStyle("-fx-background-color: #50a000");

        Scene scene = new Scene(root, 800, 600);
        Control control = new Control();
        control.handle(scene);

        stage.setTitle("Bomberman");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}