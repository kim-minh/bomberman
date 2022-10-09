package com.oop.bomberman.entities.tiles;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class Tile extends Entity {
    protected final List<Sprite> spritesList;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public Tile(Coordinate coordinate, GraphicsContext gc) {
        super(coordinate, gc);
        spritesList = new ArrayList<>();
    }

    @Override
    public void update() {
        render();
    }

    @Override
    public void render() {
        gc.drawImage(spritesList.get(0).getTexture(), coordinate.getX(), coordinate.getY());
    }
}
