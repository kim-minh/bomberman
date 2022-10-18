package com.oop.bomberman;

import com.oop.bomberman.graphics.Sprite;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

public class BombermanController {
    @FXML
    private Canvas canvas;
    @FXML
    private AnchorPane anchorPane;
    private static AnchorPane staticPane;

    public static AnchorPane getAnchorPane() {
        return staticPane;
    }

    private static GraphicsContext gc;

    public static GraphicsContext getGraphicContext() {
        return gc;
    }

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        staticPane = anchorPane;
        Game game = new Game();

        canvas.setWidth(31 * Sprite.getScaledSize());
        canvas.setHeight(17 * Sprite.getScaledSize());

        anchorPane.setMinSize(31 * Sprite.getScaledSize(), 17 * Sprite.getScaledSize());
        anchorPane.setPrefSize(31 * Sprite.getScaledSize(), 17 * Sprite.getScaledSize());
        anchorPane.setMaxSize(31 * Sprite.getScaledSize(), 17 * Sprite.getScaledSize());

        game.start();
    }
}
