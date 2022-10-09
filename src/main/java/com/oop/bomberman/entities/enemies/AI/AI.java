package com.oop.bomberman.entities.enemies.AI;

import java.util.Random;

public abstract class AI {
    public boolean goUp;
    public boolean goDown;
    public boolean goLeft;
    public boolean goRight;
    public boolean isMoving;
    protected Random random;

    public AI() {
        random = new Random();
    }

    public abstract void calculate();
}
