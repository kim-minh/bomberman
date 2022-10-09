package com.oop.bomberman.entities.tiles;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Wall extends Tile{
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public Wall(Coordinate coordinate, GraphicsContext gc) {
        super(coordinate, gc);
        spritesList.add(Sprite.wall);
        update();
    }

}
