package com.oop.bomberman.entities.tiles;

import com.oop.bomberman.entities.AnimatedEntity;

public abstract class AnimatedTile extends AnimatedEntity {
    /**
     * Initialize object.
     *
     * @param x       coordinate x
     * @param y       coordinate y
     * @param spawned spawned
     */
    public AnimatedTile(double x, double y, boolean spawned) {
        super(x, y, spawned);
        direction = 0;
    }
}
