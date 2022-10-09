package com.oop.bomberman.entities.enemies.AI;

public class LowAI extends AI {
    private final int maxSteps;
    private int steps;

    public LowAI(int maxSteps) {
        this.maxSteps = maxSteps;
    }

    @Override
    public void calculate() {
        if(steps++ >= maxSteps) {
            isMoving = false;
            steps = 0;
        }
        if (!isMoving) {
            goUp = goDown = goLeft = goRight = false;
            int direction = random.nextInt(4);
            switch (direction) {
                case 0 -> goUp = true;
                case 1 -> goDown = true;
                case 2 -> goLeft = true;
                case 3 -> goRight = true;
            }
            isMoving = true;
        }
    }
}
