package com.oop.bomberman;

import com.oop.bomberman.graphics.Sprite;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class BombermanController {
    @FXML
    private Canvas canvas;
    @FXML
    private Pane pane;
    private static Pane staticPane;
    private static GraphicsContext gc;

    public static Pane getPane() {
        return staticPane;
    }

    public static GraphicsContext getGraphicContext() {
        return gc;
    }

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        staticPane = pane;

        Game game = new Game();

        canvas.setWidth(31 * Sprite.getScaledSize());
        canvas.setHeight(17 * Sprite.getScaledSize());

        pane.setMinSize(31 * Sprite.getScaledSize(), 17 * Sprite.getScaledSize());
        pane.setPrefSize(31 * Sprite.getScaledSize(), 17 * Sprite.getScaledSize());
        pane.setMaxSize(31 * Sprite.getScaledSize(), 17 * Sprite.getScaledSize());

        game.start();
    }
}
