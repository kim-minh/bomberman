package com.oop.bomberman.entities.player.bomb;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class Explosion {
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public Explosion(Coordinate coordinate, GraphicsContext gc) {
        int tileSize = Sprite.SCALED_SIZE;

        new ExplodeDirection(coordinate, 0, gc);
        new ExplodeDirection(new Coordinate(coordinate.getX() - tileSize, coordinate.getY()), 1, gc);
        new ExplodeDirection(new Coordinate(coordinate.getX() + tileSize, coordinate.getY()), 1, gc);
        new ExplodeDirection(new Coordinate(coordinate.getX(), coordinate.getY() - tileSize), 2, gc);
        new ExplodeDirection(new Coordinate(coordinate.getX(), coordinate.getY() + tileSize), 2, gc);
    }
}
