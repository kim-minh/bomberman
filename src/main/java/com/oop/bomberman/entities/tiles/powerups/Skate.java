package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;

public class Skate extends PowerUp {
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Skate(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_speed);
        update();
    }

    @Override
    public void activatePower(Player player) {
        playSound();
        player.increaseSpeed();
    }
}
