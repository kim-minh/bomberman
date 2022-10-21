package com.oop.bomberman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView imageView;

    @FXML
    private void start() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Bomberman.class.getResource("FXML/app-view.fxml"));
        anchorPane.getChildren().setAll((AnchorPane)fxmlLoader.load());
        anchorPane.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void help() {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/help.png")));
        ImageView view = new ImageView(image);
        Group root = new Group(view);

        Scene scene = new Scene(root, 400, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void initialize() {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("textures/menuBackground.png")));
        imageView.setImage(image);
    }
}
