package com.oop.bomberman.entities.player.bomb;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;

public class Explosion {
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     */
    public Explosion(Coordinate coordinate) {
        int tileSize = Sprite.SCALED_SIZE;

        new ExplodeDirection(coordinate, 0);
        new ExplodeDirection(new Coordinate(coordinate.getX() - tileSize, coordinate.getY()), 1);
        new ExplodeDirection(new Coordinate(coordinate.getX() + tileSize, coordinate.getY()), 1);
        new ExplodeDirection(new Coordinate(coordinate.getX(), coordinate.getY() - tileSize), 2);
        new ExplodeDirection(new Coordinate(coordinate.getX(), coordinate.getY() + tileSize), 2);
    }
}
