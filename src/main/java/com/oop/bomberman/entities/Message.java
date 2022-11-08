package com.oop.bomberman.entities;

import com.oop.bomberman.graphics.Sprite;
import javafx.animation.PauseTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Message extends Entity {
    private final String msg;

    public Message(double x, double y, String msg) {
        super(x + (Sprite.getScaledSize() / 5.0), y + (Sprite.getScaledSize() / 4.0), true);
        gc.setFill(Color.WHITE);
        this.msg = msg;

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(400));
        pauseTransition.setOnFinished(event -> toRemove.add(this));
        pauseTransition.play();
    }

    @Override
    public void render() {
        gc.fillText(msg, x,y);
    }

    @Override
    public void clear() {
        gc.clearRect(x, y, 10, 10);
    }

    @Override
    public void update() {
        clear();
        render();
    }
}
