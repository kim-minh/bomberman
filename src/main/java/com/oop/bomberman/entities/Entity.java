package com.oop.bomberman.entities;

import com.oop.bomberman.BombermanController;
import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.player.bomb.ExplodeDirection;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected Coordinate coordinate;
    public static List<Entity> entityList = new ArrayList<>();
    public static List<Entity> toRemove = new ArrayList<>();
    public static List<Entity> toAdd = new ArrayList<>();
    protected int spriteIndex = 0 ;
    protected GraphicsContext gc;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param spawned    spawned
     */
    public Entity(Coordinate coordinate, boolean spawned) {
        this.coordinate = new Coordinate(coordinate.getX(), coordinate.getY());
        this.gc = BombermanController.gc;
        if (!spawned) {
            entityList.add(this);
        } else {
            toAdd.add(this);
        }
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public abstract void render();

    public abstract void update();

    public static void updateList() {
        entityList.addAll(0, toAdd);

        entityList.removeAll(toRemove);
        for (Entity e : toRemove) {
            if(e instanceof ExplodeDirection && ((ExplodeDirection) e).flagged()) {
                continue;
            }
            e.clear();
        }

        toAdd.clear();
        toRemove.clear();
    }

    public void clear() {
        gc.clearRect(coordinate.getX(), coordinate.getY(), Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }
}

