package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;

public class BombUp extends PowerUp {
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public BombUp(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_bombs);
        update();
    }

    @Override
    public void activatePower(Player player) {
        player.increaseMaxBombs();
    }
}
