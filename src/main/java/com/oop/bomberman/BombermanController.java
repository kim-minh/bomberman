package com.oop.bomberman;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class BombermanController {
    @FXML
    private Canvas canvas;

    public static GraphicsContext gc;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        Game game = new Game();
        game.update();
    }
}
