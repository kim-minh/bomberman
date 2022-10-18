package com.oop.bomberman.entities.tiles;

import com.oop.bomberman.graphics.Sprite;

public class Portal extends Tile {
    private boolean canActivate;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Portal(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.portal);
        new Brick(x, y);
    }

    public void setCanActivate(boolean canActivate) {
        this.canActivate = canActivate;
    }

    public boolean canActivate() {
        return canActivate;
    }
}
