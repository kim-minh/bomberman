package com.oop.bomberman.graphics;

import com.oop.bomberman.BombermanController;
import com.oop.bomberman.Game;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Banner {
    private final GraphicsContext gc;
    private final Timeline timeline;
    private final IntegerProperty timeSeconds;

    public Banner() {
        gc = BombermanController.getGcBanner();
        gc.setFill(Color.WHITE);
        gc.setTextBaseline(VPos.CENTER);

        timeSeconds = new SimpleIntegerProperty();
        timeline = new Timeline();
        startTimer();
    }

    public int getTime() {
        return timeSeconds.get();
    }

    public void startTimer() {
        int time = 200;
        timeSeconds.set(time);

        timeline.getKeyFrames().clear();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(time + 1), new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();
    }

    public void update() {
        gc.clearRect(0, 0, 800, 34);
        gc.fillText("Score: " + Game.getTotalPoints(), 10, 15);
        gc.fillText("Timer: " + timeSeconds.get(), 100, 15);
    }
}
