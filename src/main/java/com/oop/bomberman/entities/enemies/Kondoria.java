package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.entities.enemies.AI.MediumAI;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Kondoria extends Enemy {
    /**
     * Initialize object.
     *
     * @param x       coordinate x
     */
    public Kondoria(double x, double y) {
        super(x, y, 1000,  false);
        wallpass = true;
        speed = 0.5;
        ai = new MediumAI(Player.getPlayer(), this, 1);

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.kondoria_left1);
        left.add(Sprite.kondoria_left2);
        left.add(Sprite.kondoria_left3);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.kondoria_right1);
        right.add(Sprite.kondoria_right2);
        right.add(Sprite.kondoria_right3);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.kondoria_dead);
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
