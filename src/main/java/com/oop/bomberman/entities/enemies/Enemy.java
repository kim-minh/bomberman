package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.enemies.AI.AI;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.entities.tiles.Brick;
import com.oop.bomberman.entities.tiles.Tile;
import com.oop.bomberman.entities.tiles.powerups.PowerUp;
import com.oop.bomberman.graphics.Sprite;

public abstract class Enemy extends AnimatedEntity {
    protected AI ai;
    private final int point;
    protected boolean wallpass;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     * @param spawned    spawned
     */
    public Enemy(double x, double y, int point, boolean spawned) {
        super(x, y, spawned);
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    @Override
    protected boolean collide(Entity e, double x, double y) {
        if (e instanceof Tile) {
            clear();
            this.x = Math.round(this.x / Sprite.getScaledSize()) * Sprite.getScaledSize();
            this.y = Math.round(this.y/ Sprite.getScaledSize()) * Sprite.getScaledSize();
        }

        boolean collide = super.collide(e, x, y);
        if (collide && e instanceof Player) {
            ((Player) e).remove();
        }
        if (this.wallpass && (e instanceof Brick || e instanceof PowerUp || e instanceof Enemy)) {
            return false;
        }

        return collide;
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
