package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.enemies.AI.LowAI;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Balloom extends Enemy {
    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public Balloom(Coordinate coordinate, GraphicsContext gc) {
        super(coordinate, gc);
        ai = new LowAI(6 * Sprite.SCALED_SIZE);

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.balloom_left1);
        left.add(Sprite.balloom_left2);
        left.add(Sprite.balloom_left3);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.balloom_right1);
        right.add(Sprite.balloom_right2);
        right.add(Sprite.balloom_right3);

        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(left);
        spritesList.add(right);
    }
}
