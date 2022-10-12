package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.entities.enemies.AI.LowAI;
import com.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Balloom extends Enemy {
    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Balloom(double x, double y) {
        super(x, y, false);
        ai = new LowAI(5);
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
