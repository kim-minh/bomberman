package com.oop.bomberman.entities.tiles;

import com.oop.bomberman.graphics.Sprite;

public class Wall extends Tile{
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Wall(double x, double y) {
        super(x, y);
        spritesList.add(Sprite.wall);
        update();
    }

}
