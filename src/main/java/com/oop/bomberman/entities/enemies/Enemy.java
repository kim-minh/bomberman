package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.entities.enemies.AI.AI;
import javafx.scene.canvas.GraphicsContext;

public abstract class Enemy extends AnimatedEntity {
    protected AI ai;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param spawned    spawned
     * @param gc         GraphicContext
     */
    public Enemy(Coordinate coordinate, boolean spawned, GraphicsContext gc) {
        super(coordinate, spawned, gc);
    }

    public void update() {
        ai.calculate();

        goUp = ai.goUp;
        goDown = ai.goDown;
        goRight = ai.goRight;
        goLeft = ai.goLeft;
        isMoving = ai.isMoving;

        if (canMove) {
            ai.isMoving = false;
        }

        super.update();
    }
}
