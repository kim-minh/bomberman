package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;

public class FireUp extends Powerup {
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     */
    public FireUp(Coordinate coordinate) {
        super(coordinate);
        spritesList.add(Sprite.powerup_flames);
        update();
    }

    @Override
    public void activatePower(Player player) {
        active = true;
        player.increaseRadius(true);
    }
}
