package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;

public class BombUp extends Powerup{
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     */
    public BombUp(Coordinate coordinate) {
        super(coordinate);
        spritesList.add(Sprite.powerup_bombs);
        update();
    }

    @Override
    public void activatePower(Player player) {
        player.increaseMaxBombs();
    }
}
