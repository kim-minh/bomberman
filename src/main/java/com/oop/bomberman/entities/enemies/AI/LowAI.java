package com.oop.bomberman.entities.enemies.AI;

import com.oop.bomberman.graphics.Sprite;

import java.util.Random;

public class LowAI extends AI {
    private int steps;
    private final Random random;

    public LowAI(int maxSteps) {
        this.maxSteps = maxSteps * Sprite.SCALED_SIZE;
        random = new Random();
    }

    @Override
    public int calculate() {
        if(steps++ >= maxSteps) {
            steps = 0;
            return -1;
        }
        return random.nextInt(4);
    }
}
