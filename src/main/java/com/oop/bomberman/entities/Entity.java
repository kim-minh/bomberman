package com.oop.bomberman.entities;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.control.Keyboard;
import com.oop.bomberman.graphics.Sprite;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public abstract class Entity {
    protected Coordinate coordinate;
    protected Sprite sprite;
    private final double size = Sprite.SCALED_SIZE / 2.0;
    protected GraphicsContext gc;

    /**
     * Initialize object.
     * @param coordinate coordinate
     * @param sprite sprite
     */
    public Entity(Coordinate coordinate, Sprite sprite, GraphicsContext gc) {
        this.coordinate = new Coordinate(coordinate.getX() * Sprite.SCALED_SIZE,
                coordinate.getY() * Sprite.SCALED_SIZE);
        this.sprite = sprite;
        this.gc = gc;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void move() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (Keyboard.goUp) dy -= 2;
                if (Keyboard.goDown) dy += 2;
                if (Keyboard.goLeft)  dx += 2;
                if (Keyboard.goRight)  dx -= 2;

                moveBy(dx, dy);
                render();
            }
        };
        timer.start();
    }

    private void moveBy(int dx, int dy) {
        if (dx == 0 && dy == 0) {
            return;
        }

        double x = size + coordinate.getX() + dx;
        double y = size + coordinate.getY() + dy;

        moveTo(x, y);
    }

    int width = 800;
    int height = 600;

    private void moveTo(double x, double y) {
        if (x - size >= 0 &&
                x + size <= width &&
                y - size >= 0 &&
                y + size <= height) {
            coordinate.relocate(x - size, y - size);
        }
    }


    public abstract boolean collide(Entity e);

    public void render() {
        gc.drawImage(sprite.getTexture(), coordinate.getX(), coordinate.getY());
    }
}

