package com.oop.bomberman.entities.tiles;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.AnimatedEntity;
import javafx.scene.canvas.GraphicsContext;

public class AnimatedTile extends AnimatedEntity {
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param spawned    spawned
     * @param gc         GraphicContext
     */
    public AnimatedTile(Coordinate coordinate, boolean spawned, GraphicsContext gc) {
        super(coordinate, spawned, gc);
        direction = 0;
    }
}
