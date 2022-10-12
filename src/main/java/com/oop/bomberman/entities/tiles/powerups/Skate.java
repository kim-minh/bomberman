package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;

public class Skate extends Powerup {
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     */
    public Skate(Coordinate coordinate) {
        super(coordinate);
        spritesList.add(Sprite.powerup_speed);
        update();
    }

    @Override
    public void activatePower(Player player) {
        player.increaseSpeed();
    }
}
