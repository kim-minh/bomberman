package com.oop.bomberman.level;

import com.oop.bomberman.BombermanController;
import com.oop.bomberman.Game;
import com.oop.bomberman.control.Audio;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.player.Player;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Level {
    private final AnimationTimer animation;
    private final FileLevel fileLevel;
    private int currentLevel;
    private final GraphicsContext gc;
    private static DoubleProperty x;

    public Level(AnimationTimer animation) {
        fileLevel = new FileLevel();
        gc = BombermanController.getGraphicContext();
        x = new SimpleDoubleProperty();
        this.animation = animation;
        currentLevel = 1;
    }

    public static DoubleProperty xProperty() {
        return x;
    }

    public void newGame() {
        transition();
        Game.resetTotalPoints();
        Player.resetLife();
        fileLevel.loadLevel(1);
    }

    public void nextLevel() {
        Audio audio = new Audio("clearLevel.wav");
        audio.playFx();
        ++currentLevel;
        transition();
        fileLevel.loadLevel(currentLevel);
    }

    public void restartLevel() {
        transition();
        fileLevel.loadLevel(currentLevel);
    }

    public void startGimmick() {
        fileLevel.gimmick();
    }

    private void transition() {
        Entity.entityList.clear();

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        gc.setFont(new Font(100));

        gc.setFill(Color.WHITE);
        gc.fillText("Level " + currentLevel , Level.x.get() + 250, 325);
        gc.setFont(new Font(12));

        animation.stop();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));
        pauseTransition.setOnFinished(event -> {
            gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
            fileLevel.createEntities();
            animation.start();
        });
        pauseTransition.play();
    }
}
