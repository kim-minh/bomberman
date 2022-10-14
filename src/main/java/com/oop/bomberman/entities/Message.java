package com.oop.bomberman.entities;

import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;
import javafx.scene.paint.Color;

import java.util.Timer;
import java.util.TimerTask;

public class Message extends Entity {
    private final String msg;

    public Message(double x, double y, String msg) {
        super(x + (Sprite.getScaledSize() / 6.0), y + (Sprite.getScaledSize() / 4.0), true);
        gc.setFill(Color.WHITE);
        this.msg = msg;
        Message message = this;

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> toRemove.add(message));
            }
        };
        timer.schedule(task, 400);
    }

    @Override
    public void render() {
        gc.fillText(msg, x,y);
    }

    @Override
    public void update() {
        clear();
        render();
    }
}
