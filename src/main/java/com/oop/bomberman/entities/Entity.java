package com.oop.bomberman.entities;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public abstract class Entity {
    protected Coordinate coordinate;
    protected Sprite sprite;
    protected GraphicsContext gc;

    /**
     * Initialize object.
     * @param coordinate coordinate
     * @param sprite sprite
     */
    public Entity(Coordinate coordinate, Sprite sprite, GraphicsContext gc) {
        this.coordinate = new Coordinate(coordinate.getX() * Sprite.SCALED_SIZE,
                coordinate.getY() * Sprite.SCALED_SIZE);
        this.sprite = sprite;
        this.gc = gc;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public abstract boolean collide(Entity e);

}

