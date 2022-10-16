package com.oop.bomberman;

import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class BombermanController {
    @FXML
    private Canvas canvas;
    @FXML
    private AnchorPane anchorPane;

    private static GraphicsContext gc;

    public static GraphicsContext getGraphicContext() {
        return gc;
    }

    private double clampRange(double value, double max) {
        if (value < 0) {
            return 0;
        }
        return Math.min(value, max);
    }

    private void addCamera() {
        Scene scene = Bomberman.getScene();
        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(scene.widthProperty());
        clip.heightProperty().bind(scene.heightProperty());
        clip.xProperty().bind(Bindings.createDoubleBinding(
                () -> clampRange(Player.getPlayer().getX() - scene.getWidth() / 2,
                        anchorPane.getWidth() - scene.getWidth()), Player.getPlayer().xProperty(),
                anchorPane.widthProperty()));
        anchorPane.setClip(clip);
        anchorPane.translateXProperty().bind(clip.xProperty().multiply(-1));
    }

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        Game game = new Game();

        canvas.setWidth(31 * Sprite.getScaledSize());
        canvas.setHeight(17 * Sprite.getScaledSize());

        anchorPane.setMinSize(31 * Sprite.getScaledSize(), 17 * Sprite.getScaledSize());
        anchorPane.setPrefSize(31 * Sprite.getScaledSize(), 17 * Sprite.getScaledSize());
        anchorPane.setMaxSize(31 * Sprite.getScaledSize(), 17 * Sprite.getScaledSize());
        addCamera();

        game.update();
    }
}
