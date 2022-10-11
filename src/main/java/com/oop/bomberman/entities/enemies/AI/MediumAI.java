package com.oop.bomberman.entities.enemies.AI;

import com.oop.bomberman.entities.enemies.Enemy;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;

public class MediumAI extends AI {
    private final Player player;
    private final Enemy enemy;
    private double steps;

    public MediumAI(Player player, Enemy enemy, int maxSteps) {
        this.player = player;
        this.enemy = enemy;
        this.maxSteps = maxSteps * Sprite.SCALED_SIZE;
    }

    @Override
    public int calculate() {
        if(steps++ > maxSteps) {
            steps = 0;
            return -1;
        }
        int rand = random.nextInt(2);
        int direction;
        if (rand == 1) {
            direction = calculateRow();
            if (direction == -1) {
                direction = calculateCol();
            }
        } else {
            direction = calculateCol();
            if (direction == -1) {
                direction = calculateRow();
            }
        }
        return direction;
    }

    private int calculateCol() {
        if(player.getCoordinate().getXTile() < enemy.getCoordinate().getXTile()) {
            return 2;
        }
        if(player.getCoordinate().getXTile() > enemy.getCoordinate().getXTile()) {
            return 3;
        }
        return -1;
    }

    private int calculateRow() {
        if(player.getCoordinate().getYTile() < enemy.getCoordinate().getYTile()) {
            return 0;
        }
        if(player.getCoordinate().getYTile() > enemy.getCoordinate().getYTile()) {
            return 1;
        }
        return -1;
    }
}
