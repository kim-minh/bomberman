package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class Flamepass extends Powerup{
    /**
     * Initialize object.
     *
     * @param x coordinate y
     * @param y coordinate y
     */
    public Flamepass(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_flamepass);
    }

    @Override
    public void activatePower(Player player) {
        player.setFlamepass(true);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> player.setFlamepass(false));
            }
        };
        timer.schedule(task, 15000);
    }
}
