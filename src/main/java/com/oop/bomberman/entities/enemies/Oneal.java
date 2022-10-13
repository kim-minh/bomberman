package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.Game;
import com.oop.bomberman.entities.enemies.AI.MediumAI;
import com.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Oneal extends Enemy {

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Oneal(double x, double y) {
        super(x, y, false);
        speed = 2;

        ai = new MediumAI(Game.getPlayer(), this, 1);

        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.oneal_left1);
        left.add(Sprite.oneal_left2);
        left.add(Sprite.oneal_left3);

        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.oneal_right1);
        right.add(Sprite.oneal_right2);
        right.add(Sprite.oneal_right3);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.oneal_dead);
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
