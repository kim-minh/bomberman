package com.oop.bomberman.entities.player;

import com.oop.bomberman.control.Control;
import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.player.bomb.Bomb;
import com.oop.bomberman.entities.player.bomb.ExplodeDirection;
import com.oop.bomberman.entities.tiles.Brick;
import com.oop.bomberman.entities.tiles.powerups.Powerup;
import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends AnimatedEntity {
    private int maxBombs;
    private boolean increaseRadius;
    private boolean wallpass;
    private boolean flamepass;

    /**
     * Initialize object.
     *
     * @param coordinate Coordinate
     */

    public Player(Coordinate coordinate) {
        super(coordinate, false);
        speed = 1;
        maxBombs = 1;

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

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.player_dead1);
        dead.add(Sprite.player_dead2);
        dead.add(Sprite.player_dead3);

        spritesList.add(up);
        spritesList.add(down);
        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(dead);
    }

    public void increaseMaxBombs() {
        ++maxBombs;
    }

    public void increaseRadius(boolean increaseRadius) {
        this.increaseRadius = increaseRadius;
    }

    public void increaseSpeed() {
        ++speed;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> --speed);
            }
        };
        timer.schedule(task, 15000);
    }

    public void setWallpass(boolean wallpass) {
        this.wallpass = wallpass;
    }

    public void setFlamepass(boolean flamepass) {
        this.flamepass = flamepass;
    }

    public boolean canPassFlame() {
        return flamepass;
    }

    @Override
    public boolean collide(Entity e, double x, double y) {
        if (e instanceof Bomb) {
            return false;
        }
        if (wallpass && e instanceof Brick) {
            return false;
        }

        if (flamepass && e instanceof ExplodeDirection) {
            return false;
        }

        boolean collide = super.collide(e, x, y);

        if (collide && e instanceof Powerup && ((Powerup) e).canActivate()) {
            ((Powerup) e).activatePower(this);
            toRemove.add(e);
        }
        return collide;
    }

    @Override
    public void update() {
        isMoving = Control.move;
        goUp = Control.up;
        goDown = Control.down;
        goLeft = Control.left;
        goRight = Control.right;
        if (Control.bomb && Bomb.bombCount < maxBombs) {
            new Bomb(coordinate, increaseRadius);
            Control.bomb = false;
        }
        super.update();
    }
}
