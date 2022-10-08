package com.oop.bomberman.entities;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.Canvas;

public class AnimatedEntity extends Entity {
    protected boolean goUp;
    protected boolean goDown;
    protected boolean goLeft;
    protected boolean goRight;
    protected boolean isMoving;
    private int movement = 3;
    private final double size = Sprite.SCALED_SIZE / 2.0;
    private int frame = 0;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param canvas canvas
     */
    public AnimatedEntity(Coordinate coordinate, Canvas canvas) {
        super(coordinate, canvas);
    }

    public void animate() {
        clear();

        int dx = 0, dy = 0;

        if (goUp) {
            dy -= 2;
            movement = 0;
        }
        if (goDown) {
            dy += 2;
            movement = 1;
        }
        if (goLeft) {
            dx -= 2;
            movement = 2;
        }
        if (goRight)  {
            dx += 2;
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
            spriteIndex = ++spriteIndex % sprites.get(movement).size();
            frame = 0;
        }
    }

    private void moveBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        double x = size + coordinate.getX() + dx;
        double y = size + coordinate.getY() + dy;

        moveTo(x, y);
    }

    private void moveTo(double x, double y) {
        double width = canvas.getWidth();
        double height = canvas.getHeight();

        if (x - size >= 0 &&
                x + size <= width &&
                y - size >= 0 &&
                y + size <= height) {
            coordinate.relocate(x - size, y - size);
        }
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }

    @Override
    public void render() {
        gc.drawImage(sprites.get(movement).get(spriteIndex).getTexture(), coordinate.getX(), coordinate.getY());
    }
}
