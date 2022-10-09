package com.oop.bomberman.entities;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected Coordinate coordinate;
    public static List<Entity> entities = new ArrayList<>();
    protected int spriteIndex = 0 ;
    protected GraphicsContext gc;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public Entity(Coordinate coordinate, GraphicsContext gc) {
        this.coordinate = new Coordinate(coordinate.getX(), coordinate.getY());
        this.gc = gc;
        entities.add(this);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public abstract void render();

    public abstract void update();

    public void clear() {
        gc.clearRect(coordinate.getX(), coordinate.getY(), Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }
}

