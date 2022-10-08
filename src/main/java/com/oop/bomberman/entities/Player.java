package com.oop.bomberman.entities;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.control.Keyboard;
import com.oop.bomberman.graphics.Sprite;
import javafx.scene.canvas.Canvas;
import java.util.ArrayList;
import java.util.List;

public class Player extends AnimatedEntity {
    /**
     * Initialize object.
     *
     * @param coordinate Coordinate
     * @param canvas canvas
     */
    public Player(Coordinate coordinate, Canvas canvas) {
        super(coordinate, canvas);

        //Initialize up animation
        List<Sprite> up = new ArrayList<>();
        up.add(Sprite.player_up);
        up.add(Sprite.player_up_1);
        up.add(Sprite.player_up_2);

        List<Sprite> down = new ArrayList<>();
        down.add(Sprite.player_down);
        down.add(Sprite.player_down_1);
        down.add(Sprite.player_down_2);

        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.player_left);
        left.add(Sprite.player_left_1);
        left.add(Sprite.player_left_2);

        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.player_right);
        right.add(Sprite.player_right_1);
        right.add(Sprite.player_right_2);

        sprites.add(up);
        sprites.add(down);
        sprites.add(left);
        sprites.add(right);

    }

    @Override
    public void animate() {
        isMoving = Keyboard.pressed;
        goUp = Keyboard.up;
        goDown = Keyboard.down;
        goLeft = Keyboard.left;
        goRight = Keyboard.right;
        super.animate();
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }
}
