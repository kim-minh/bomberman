package com.oop.bomberman.entities;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected Coordinate coordinate;

    protected final List<List<Sprite>> sprites;
    protected int spriteIndex = 0 ;
    protected Canvas canvas;
    protected GraphicsContext gc;


    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param canvas canvas
     */
    public Entity(Coordinate coordinate, Canvas canvas) {
        this.coordinate = new Coordinate(coordinate.getX() * Sprite.SCALED_SIZE,
                coordinate.getY() * Sprite.SCALED_SIZE);
        this.canvas = canvas;
        gc = canvas.getGraphicsContext2D();
        sprites = new ArrayList<>();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public abstract boolean collide(Entity e);

    public abstract void render();

    public void clear() {
        gc.clearRect(coordinate.getX(), coordinate.getY(), Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }
}

