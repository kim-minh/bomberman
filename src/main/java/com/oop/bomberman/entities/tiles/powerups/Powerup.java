package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.entities.tiles.Brick;
import com.oop.bomberman.entities.tiles.Tile;

public abstract class Powerup extends Tile {
    protected boolean canActivate;
    protected boolean active;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     */
    public Powerup(Coordinate coordinate) {
        super(coordinate);
        new Brick(coordinate);
    }

    public abstract void activatePower(Player player);

    public void setCanActivate(boolean canActivate) {
        this.canActivate = canActivate;
    }

    public boolean canActivate() {
        return canActivate;
    }
}
