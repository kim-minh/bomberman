package com.oop.bomberman.entities;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class AnimatedEntity extends Entity {
    protected List<List<Sprite>> spritesList;
    protected boolean goUp;
    protected boolean goDown;
    protected boolean goLeft;
    protected boolean goRight;
    protected boolean isMoving;
    protected double speed;
    protected int direction = 3;
    protected int frame = 0;
    protected boolean canMove;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param spawned    spawned
     * @param gc         GraphicContext
     */
    public AnimatedEntity(Coordinate coordinate, boolean spawned, GraphicsContext gc) {
        super(coordinate, spawned, gc);
        spritesList = new ArrayList<>();
    }

    public void update() {

        double dx = 0, dy = 0;

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

    private void moveBy(double dx, double dy) {
        if (dx == 0 && dy == 0) return;

        double x = coordinate.getX() + dx;
        double y = coordinate.getY() + dy;

        if(!moveCheck(x, y)) {
            return;
        }

        coordinate.relocate(x, y);
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
        Coordinate other = e.getCoordinate();
        canMove = x < other.getX() + Sprite.SCALED_SIZE &&
                x + Sprite.SCALED_SIZE > other.getX() &&
                y < other.getY() + Sprite.SCALED_SIZE &&
                y + Sprite.SCALED_SIZE > other.getY();
        return canMove;
    }

    @Override
    public void render() {
        gc.drawImage(spritesList.get(direction).get(spriteIndex).getTexture(), coordinate.getX(), coordinate.getY());
    }
}
