package com.oop.bomberman.entities.player;

import com.oop.bomberman.control.Control;
import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.player.bomb.Bomb;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Player extends AnimatedEntity {
    /**
     * Initialize object.
     *
     * @param coordinate Coordinate
     * @param gc         GraphicContext
     */
    public Player(Coordinate coordinate, GraphicsContext gc) {
        super(coordinate, false, gc);
        speed = 1.2;

        //Initialize up animation sprites
        List<Sprite> up = new ArrayList<>();
        up.add(Sprite.player_up);
        up.add(Sprite.player_up_1);
        up.add(Sprite.player_up_2);

        //Initialize down animation sprites
        List<Sprite> down = new ArrayList<>();
        down.add(Sprite.player_down);
        down.add(Sprite.player_down_1);
        down.add(Sprite.player_down_2);

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.player_left);
        left.add(Sprite.player_left_1);
        left.add(Sprite.player_left_2);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.player_right);
        right.add(Sprite.player_right_1);
        right.add(Sprite.player_right_2);

        spritesList.add(up);
        spritesList.add(down);
        spritesList.add(left);
        spritesList.add(right);

    }

    @Override
    public boolean collide(Entity e, double x, double y) {
        if (e instanceof Bomb) {
            return false;
        }
        return super.collide(e, x, y);
    }

    @Override
    public void update() {
        isMoving = Control.move;
        goUp = Control.up;
        goDown = Control.down;
        goLeft = Control.left;
        goRight = Control.right;
        if (Control.bomb) {
            new Bomb(coordinate, gc);
            Control.bomb = false;
        }
        super.update();
    }
}
