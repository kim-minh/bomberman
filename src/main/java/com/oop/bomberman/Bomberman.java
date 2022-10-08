package com.oop.bomberman;

import com.oop.bomberman.control.Keyboard;
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

        Scene scene = new Scene(root, 800, 600);
        Keyboard keyboard = new Keyboard();
        keyboard.handle(scene);

        stage.setTitle("Bomberman");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}