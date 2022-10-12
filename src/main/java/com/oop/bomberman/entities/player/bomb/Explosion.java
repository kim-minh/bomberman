package com.oop.bomberman.entities.player.bomb;

import com.oop.bomberman.graphics.Sprite;

public class Explosion {
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Explosion(double x, double y, boolean increaseRadius) {
        int tileSize = Sprite.SCALED_SIZE;

        new ExplodeDirection(x, y, 0);
        new ExplodeDirection(x - tileSize, y, 1);
        new ExplodeDirection(x + tileSize, y, 1);
        new ExplodeDirection(x, y - tileSize, 2);
        new ExplodeDirection(x, y + tileSize, 2);
        if (increaseRadius) {
            new ExplodeDirection(x - 2 * tileSize, y, 3);
            new ExplodeDirection(x + 2 * tileSize, y, 4);
            new ExplodeDirection(x, y - 2 * tileSize, 5);
            new ExplodeDirection(x, y + 2 * tileSize, 6);
        }
    }
}
