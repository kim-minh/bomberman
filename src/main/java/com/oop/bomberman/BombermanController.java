package com.oop.bomberman;

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

    public static GraphicsContext gc;

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
                () -> clampRange(Game.getPlayer().getX() - scene.getWidth() / 2,
                        anchorPane.getWidth() - scene.getWidth()), Game.getPlayer().xProperty(),
                anchorPane.widthProperty()));
        anchorPane.setClip(clip);
        anchorPane.translateXProperty().bind(clip.xProperty().multiply(-1));
    }

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        Game game = new Game();

        canvas.setWidth(1000);
        anchorPane.setMinSize(1000, 600);
        anchorPane.setPrefSize(1000, 600);
        anchorPane.setMaxSize(1000, 600);
        addCamera();

        game.update();
    }
}
