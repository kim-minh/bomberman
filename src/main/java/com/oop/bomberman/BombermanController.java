package com.oop.bomberman;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.Player;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class BombermanController {
    @FXML
    private Canvas canvas;

    public void update() {
        Player player = new Player(new Coordinate(0, 0), canvas);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                player.animate();
            }
        };
        timer.start();
    }

    @FXML
    public void initialize() {
        update();
    }
}
