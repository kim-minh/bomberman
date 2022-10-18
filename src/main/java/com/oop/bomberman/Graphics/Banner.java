package com.oop.bomberman.graphics;

import com.oop.bomberman.BombermanController;
import com.oop.bomberman.Game;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Banner {
    private final GraphicsContext gc;

    public Banner() {
        gc = BombermanController.getGcBanner();
        gc.setFill(Color.WHITE);
        gc.setTextBaseline(VPos.CENTER);
    }

    public void update() {
        gc.clearRect(0, 0, 800, 34);
        gc.fillText("Score: " + Game.getTotalPoints(), 10, 15);
    }
}
