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
        super(coordinate, false, gc);
        ai = new LowAI(5 * Sprite.SCALED_SIZE);
        speed = 0.5;

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

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.balloom_dead);
        dead.add(Sprite.mob_dead1);
        dead.add(Sprite.mob_dead2);
        dead.add(Sprite.mob_dead3);

        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(dead);
    }
}
