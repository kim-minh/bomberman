package com.oop.bomberman.entities.tiles;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Brick extends Tile{
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public Brick(Coordinate coordinate, GraphicsContext gc) {
        super(coordinate, gc);
        spritesList.add(Sprite.brick);
        spritesList.add(Sprite.brick_exploded);
        spritesList.add(Sprite.brick_exploded1);
        spritesList.add(Sprite.brick_exploded2);
    }
}
