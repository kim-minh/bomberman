package com.oop.bomberman.level;

import com.oop.bomberman.BombermanController;
import com.oop.bomberman.entities.Entity;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Timer;
import java.util.TimerTask;

public class Level {
    private final AnimationTimer animation;
    private final FileLevel fileLevel;
    private int currentLevel;
    private final GraphicsContext gc;

    public Level(AnimationTimer animation) {
        fileLevel = new FileLevel();
        gc = BombermanController.getGraphicContext();
        this.animation = animation;
        currentLevel = 1;
    }

    public void newGame() {
        transition();
        fileLevel.loadLevel(1);
    }

    public void nextLevel() {
        transition();
        fileLevel.loadLevel(++currentLevel);
    }

    public void restartLevel() {
        transition();
        fileLevel.loadLevel(currentLevel);
    }

    private void transition() {
        Entity.entityList.clear();

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 800, 650);
        gc.setFont(new Font(100));

        gc.setFill(Color.WHITE);
        gc.fillText("Level " + currentLevel , 250, 300);
        gc.setFont(new Font(12));

        animation.stop();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
                    fileLevel.createEntities();
                    animation.start();
                });
            }
        };
        timer.schedule(task, 3000);
    }
}
