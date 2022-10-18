package com.oop.bomberman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuController {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void start() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Bomberman.class.getResource("FXML/app-view.fxml"));
        anchorPane.getChildren().setAll((AnchorPane)fxmlLoader.load());
        anchorPane.setStyle("-fx-background-color: #000000");
    }
}
