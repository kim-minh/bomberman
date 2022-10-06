package com.oop.bomberman.entities;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Player extends Entity{


    /**
     * Initialize object
     *
     * @param coordinate Coordinate
     */
    public Player(Coordinate coordinate, GraphicsContext gc) {
        super(coordinate, Sprite.player_right, gc);
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }
}
