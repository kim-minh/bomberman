package com.oop.bomberman;

import com.oop.bomberman.graphics.Sprite;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BombermanController {
    @FXML
    private Canvas canvas;

    public void setImageView() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image image = Sprite.player_right.getTexture();
        gc.drawImage(image, 0, 0);
    }

    @FXML
    public void initialize() {
        setImageView();
    }
}
