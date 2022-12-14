package com.oop.bomberman.entities;

import com.oop.bomberman.graphics.Sprite;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public abstract class AnimatedEntity extends Entity {
    protected final List<List<Sprite>> spritesList;
    protected boolean goUp;
    protected boolean goDown;
    protected boolean goLeft;
    protected boolean goRight;
    protected boolean isMoving;
    protected double speed;
    protected int direction = 3;
    protected boolean canMove;
    private boolean removed;
    private int frame = 0;

    /**
     * Initialize object.
     *
     * @param x       coordinate x
     * @param y       coordinate y
     * @param spawned spawned
     */
    public AnimatedEntity(double x, double y, boolean spawned) {
        super(x, y, spawned);
        spritesList = new ArrayList<>();
    }

    public boolean isRemoved() {
        return removed;
    }

    public void remove() {
        removed = true;
    }

    public void update() {
        double dx = 0, dy = 0;

        if (removed) {
            direction = 4;
            deadAnimate();
            return;
        }

        if (goUp) {
            dy -= speed;
            direction = 0;
        }
        if (goDown) {
            dy += speed;
            direction = 1;
        }
        if (goLeft) {
            dx -= speed;
            direction = 2;
        }
        if (goRight)  {
            dx += speed;
            direction = 3;
        }

        if(isMoving) {
            animate();
            moveBy(dx, dy);
        } else {
            spriteIndex = 0;
        }
        render();
    }

    protected void animate() {
        clear();
        ++frame;
        if (frame >= 10) {
            spriteIndex = ++spriteIndex % spritesList.get(direction).size();
            frame = 0;
        }
    }

    protected void deadAnimate() {
        PauseTransition pauseTransition = new PauseTransition(Duration.millis(500));
        pauseTransition.setOnFinished(event -> toRemove.add(this));
        pauseTransition.play();
        animate();
        render();
    }

    protected void moveBy(double dx, double dy) {
        if (dx == 0 && dy == 0) return;

        double x = this.x + dx;
        double y = this.y + dy;

        if(!moveCheck(x, y)) {
            return;
        }

        this.x = x;
        this.y = y;
    }

    private boolean moveCheck(double x, double y) {
        for (Entity entity : entityList) {
            if (collide(entity, x, y)) {
                return false;
            }
        }
        return true;
    }

    protected boolean collide(Entity e, double x, double y) {
        if (this == e) {
            return false;
        }

        int spriteSize = Sprite.getScaledSize();
        canMove = !(x < e.getX() + spriteSize &&
                x + spriteSize > e.getX() &&
                y < e.getY() + spriteSize &&
                y + spriteSize > e.getY());
        return !canMove;
    }

    @Override
    public void render() {
        gc.drawImage(spritesList.get(direction).get(spriteIndex).getTexture(), x, y);
    }
}
