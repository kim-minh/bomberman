package com.oop.bomberman.entities.tiles;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;

public class Wall extends Tile{
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     */
    public Wall(Coordinate coordinate) {
        super(coordinate);
        spritesList.add(Sprite.wall);
        update();
    }

}
