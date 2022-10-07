package com.oop.bomberman;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.Player;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class BombermanController {
    @FXML
    private Canvas canvas;

    public void update() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Player player = new Player(new Coordinate(0, 0), gc);
        player.animate();
    }

    @FXML
    public void initialize() {
        update();
    }
}
