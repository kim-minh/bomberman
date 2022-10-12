package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.entities.enemies.AI.AI;

public abstract class Enemy extends AnimatedEntity {
    protected AI ai;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     * @param spawned    spawned
     */
    public Enemy(double x, double y, boolean spawned) {
        super(x, y, spawned);
    }

    public void update() {
        int direction = ai.calculate();

        if (direction == -1 || !canMove) {
            isMoving = false;
        }

        if (!isMoving) {
            goUp = goDown = goLeft = goRight = false;
            isMoving = true;
            switch (direction) {
                case 0 -> goUp = true;
                case 1 -> goDown = true;
                case 2 -> goLeft = true;
                case 3 -> goRight = true;
                default -> isMoving = false;
            }
        }

        super.update();
    }
}
