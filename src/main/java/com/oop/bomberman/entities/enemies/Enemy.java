package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.enemies.AI.AI;
import javafx.scene.canvas.GraphicsContext;

public abstract class Enemy extends AnimatedEntity {
    protected AI ai;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public Enemy(Coordinate coordinate, GraphicsContext gc) {
        super(coordinate, gc);
        speed = 1;
    }

    @Override
    public boolean collide(Entity e, double x, double y) {
        if (e instanceof Enemy) {
            return false;
        }
        return super.collide(e, x, y);
    }

    public void update() {
        ai.calculate();

        goUp = ai.goUp;
        goDown = ai.goDown;
        goRight = ai.goRight;
        goLeft = ai.goLeft;
        isMoving = ai.isMoving;

        if (isCollide) {
            ai.isMoving = false;
        }

        super.update();
    }
}
