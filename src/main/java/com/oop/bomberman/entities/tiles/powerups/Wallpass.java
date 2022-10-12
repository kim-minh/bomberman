package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;

import java.util.Timer;
import java.util.TimerTask;

public class Wallpass extends Powerup {
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     */
    public Wallpass(Coordinate coordinate) {
        super(coordinate);
        spritesList.add(Sprite.powerup_wallpass);
    }

    @Override
    public void activatePower(Player player) {
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
