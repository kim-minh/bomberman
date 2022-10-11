package com.oop.bomberman.entities.tiles;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.AnimatedEntity;

public abstract class AnimatedTile extends AnimatedEntity {
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param spawned    spawned
     */
    public AnimatedTile(Coordinate coordinate, boolean spawned) {
        super(coordinate, spawned);
        direction = 0;
    }
}
