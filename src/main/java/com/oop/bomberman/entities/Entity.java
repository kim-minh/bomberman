package com.oop.bomberman.entities;

import com.oop.bomberman.BombermanController;
import com.oop.bomberman.entities.player.bomb.ExplodeDirection;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected double x;
    protected double y;
    public static List<Entity> entityList = new ArrayList<>();
    public static List<Entity> toRemove = new ArrayList<>();
    public static List<Entity> toAdd = new ArrayList<>();
    protected int spriteIndex = 0 ;
    protected GraphicsContext gc;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     * @param spawned    spawned
     */
    public Entity(double x, double y, boolean spawned) {
        this.gc = BombermanController.gc;
        if (!spawned) {
            entityList.add(this);
            this.x = x * Sprite.SCALED_SIZE;
            this.y = y * Sprite.SCALED_SIZE;
        } else {
            this.x = x;
            this.y = y;
            toAdd.add(this);
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Calculate x tile from coordinate
     * @return x tile
     */
    public int getXTile() {
        return (int) (x / Sprite.SCALED_SIZE);
    }

    /**
     * Calculate y tile from coordinate
     * @return y tile
     */
    public int getYTile() {
        return (int) (y / Sprite.SCALED_SIZE);
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
        gc.clearRect(x, y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }
}

