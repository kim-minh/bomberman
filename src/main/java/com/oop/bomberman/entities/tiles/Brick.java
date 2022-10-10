package com.oop.bomberman.entities.tiles;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Brick extends AnimatedTile {
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public Brick(Coordinate coordinate, GraphicsContext gc) {
        super(coordinate, false, gc);

        List<Sprite> normal = new ArrayList<>();
        normal.add(Sprite.brick);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.brick_exploded);
        dead.add(Sprite.brick_exploded1);
        dead.add(Sprite.brick_exploded2);

        spritesList.add(normal);
        spritesList.add(dead);
    }

    @Override
    public void deadAnimate() {
        direction = 1;
        super.deadAnimate();
    }
}
