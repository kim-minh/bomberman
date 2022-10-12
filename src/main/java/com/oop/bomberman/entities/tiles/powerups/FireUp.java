package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;

public class FireUp extends Powerup {
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public FireUp(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.powerup_flames);
        update();
    }

    @Override
    public void activatePower(Player player) {
        active = true;
        player.increaseRadius(true);
    }
}
