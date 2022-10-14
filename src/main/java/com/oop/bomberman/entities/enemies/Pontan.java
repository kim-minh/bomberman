package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.entities.enemies.AI.MediumAI;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Pontan extends Enemy {
    /**
     * Initialize object.
     *
     * @param x       coordinate x
     * @param y       coordinate y
     */
    public Pontan(double x, double y) {
        super(x, y, 8000, false);
        speed = 3;
        ai = new MediumAI(Player.getPlayer(), this, 2);
        wallpass = true;

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.pontan_left1);
        left.add(Sprite.pontan_left2);
        left.add(Sprite.pontan_left3);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.pontan_right1);
        right.add(Sprite.pontan_right2);
        right.add(Sprite.pontan_right3);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.pontan_dead);
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
