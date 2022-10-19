package com.oop.bomberman.entities.tiles.powerups;

import com.oop.bomberman.control.Audio;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.entities.tiles.Brick;
import com.oop.bomberman.entities.tiles.Tile;

public abstract class PowerUp extends Tile {
    protected boolean canActivate;
    protected boolean active;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public PowerUp(double x, double y) {
        super(x, y);
        new Brick(x, y);
    }

    public abstract void activatePower(Player player);

    protected void playSound() {
        Audio audio = new Audio("getItem.wav");
        audio.playFx();
    }

    public void setCanActivate(boolean canActivate) {
        this.canActivate = canActivate;
    }

    public boolean canActivate() {
        return canActivate;
    }
}
