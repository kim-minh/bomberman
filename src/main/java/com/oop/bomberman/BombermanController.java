package com.oop.bomberman;

import com.oop.bomberman.Graphics.Sprite;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class BombermanController {
    @FXML
    private Canvas canvas;

    public void setImageView(MouseEvent e) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image image = Sprite.player_right.getFxImage();
        gc.drawImage(image, 0, 0);
    }
}
