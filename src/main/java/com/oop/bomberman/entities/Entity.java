package com.oop.bomberman.entities;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.control.Keyboard;
import com.oop.bomberman.graphics.Sprite;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected Coordinate coordinate;

    protected final List<List<Sprite>> sprites;
    private int spriteIndex = 0 ;
    private int movement = 3;
    private final double size = Sprite.SCALED_SIZE / 2.0;
    protected GraphicsContext gc;
    private int frame = 0;

    /**
     * Initialize object.
     * @param coordinate coordinate
     */
    public Entity(Coordinate coordinate, GraphicsContext gc) {
        this.coordinate = new Coordinate(coordinate.getX() * Sprite.SCALED_SIZE,
                coordinate.getY() * Sprite.SCALED_SIZE);
        this.gc = gc;
        sprites = new ArrayList<>();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void animate() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                ++frame;
                clear();
                move();
                render();
            }
        };
        timer.start();
    }

    private void move() {
        int dx = 0, dy = 0;

        if (Keyboard.goUp) {
            dy -= 2;
            movement = 0;
        }
        if (Keyboard.goDown) {
            dy += 2;
            movement = 1;
        }
        if (Keyboard.goLeft) {
            dx -= 2;
            movement = 2;
        }
        if (Keyboard.goRight)  {
            dx += 2;
            movement = 3;
        }
        moveBy(dx, dy);
        if(Keyboard.pressed) {
            animateMove();
        } else {
            spriteIndex = 0;
        }
    }

    private void animateMove() {
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
        gc.drawImage(sprites.get(movement).get(spriteIndex).getTexture(), coordinate.getX(), coordinate.getY());
    }

    public void clear() {
        gc.clearRect(coordinate.getX(), coordinate.getY(), Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }
}

