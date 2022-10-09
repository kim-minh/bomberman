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
    private int movement = 3;
    protected int frame = 0;
    protected boolean isCollide;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public AnimatedEntity(Coordinate coordinate, GraphicsContext gc) {
        super(coordinate, gc);
        spritesList = new ArrayList<>();
    }

    public void update() {
        clear();

        double dx = 0, dy = 0;

        if (goUp) {
            dy -= speed;
            movement = 0;
        }
        if (goDown) {
            dy += speed;
            movement = 1;
        }
        if (goLeft) {
            dx -= speed;
            movement = 2;
        }
        if (goRight)  {
            dx += speed;
            movement = 3;
        }
        moveBy(dx, dy);
        if(isMoving) {
            animateMove();
        } else {
            spriteIndex = 0;
        }
        render();
    }

    private void animateMove() {
        ++frame;
        if (frame >= 5) {
            spriteIndex = ++spriteIndex % spritesList.get(movement).size();
            frame = 0;
        }
    }

    private void moveBy(double dx, double dy) {
        if (dx == 0 && dy == 0) return;

        double x = coordinate.getX() + dx;
        double y = coordinate.getY() + dy;

        if(!canMove(x, y)) {
            return;
        }

        coordinate.relocate(x, y);
    }

    public boolean canMove(double x, double y) {
        for (Entity entity : entities) {
            if (collide(entity, x, y)) {
                return false;
            }
        }
        return true;
    }

    public boolean collide(Entity e, double x, double y) {
        if (this == e) {
            return false;
        }
        Coordinate other = e.getCoordinate();
        isCollide = x < other.getX() + Sprite.SCALED_SIZE &&
                x + Sprite.SCALED_SIZE > other.getX() &&
                y < other.getY() + Sprite.SCALED_SIZE &&
                y + Sprite.SCALED_SIZE > other.getY();
        return isCollide;
    }

    @Override
    public void render() {
        gc.drawImage(spritesList.get(movement).get(spriteIndex).getTexture(), coordinate.getX(), coordinate.getY());
    }
}
