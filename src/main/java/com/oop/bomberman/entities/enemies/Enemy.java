package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.entities.enemies.AI.AI;

public abstract class Enemy extends AnimatedEntity {
    protected AI ai;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param spawned    spawned
     */
    public Enemy(Coordinate coordinate, boolean spawned) {
        super(coordinate, spawned);
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
