package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class Wallpass extends PowerUp {
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Wallpass(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_wallpass);
    }

    @Override
    public void activatePower(Player player) {
        playSound();
        player.setWallpass(true);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> player.setWallpass(false));
            }
        };
        timer.schedule(task, 15000);
    }
}
