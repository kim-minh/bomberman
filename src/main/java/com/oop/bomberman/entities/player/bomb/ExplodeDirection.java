package com.oop.bomberman.entities.player.bomb;

import com.oop.bomberman.Game;
import com.oop.bomberman.control.Audio;
import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.Message;
import com.oop.bomberman.entities.enemies.Enemy;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.entities.tiles.Portal;
import com.oop.bomberman.entities.tiles.Wall;
import com.oop.bomberman.entities.tiles.powerups.PowerUp;
import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ExplodeDirection extends AnimatedEntity {
    private boolean flag;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public ExplodeDirection(double x, double y, int direction) {
        super(x, y, true);
        this.direction = direction;
        ExplodeDirection explodeDirection = this;

        List<Sprite> explode = new ArrayList<>();
        explode.add(Sprite.bomb_exploded);
        explode.add(Sprite.bomb_exploded1);
        explode.add(Sprite.bomb_exploded2);
        spritesList.add(explode);

        List<Sprite> horizontal = new ArrayList<>();
        horizontal.add(Sprite.explosion_horizontal);
        horizontal.add(Sprite.explosion_horizontal1);
        horizontal.add(Sprite.explosion_horizontal2);
        spritesList.add(horizontal);

        List<Sprite> vertical = new ArrayList<>();
        vertical.add(Sprite.explosion_vertical);
        vertical.add(Sprite.explosion_vertical1);
        vertical.add(Sprite.explosion_vertical2);
        spritesList.add(vertical);

        List<Sprite> leftLast = new ArrayList<>();
        leftLast.add(Sprite.explosion_horizontal_left_last);
        leftLast.add(Sprite.explosion_horizontal_left_last1);
        leftLast.add(Sprite.explosion_horizontal_left_last2);
        spritesList.add(leftLast);

        List<Sprite> rightLast = new ArrayList<>();
        rightLast.add(Sprite.explosion_horizontal_right_last);
        rightLast.add(Sprite.explosion_horizontal_right_last1);
        rightLast.add(Sprite.explosion_horizontal_right_last2);
        spritesList.add(rightLast);

        List<Sprite> topLast = new ArrayList<>();
        topLast.add(Sprite.explosion_vertical_top_last);
        topLast.add(Sprite.explosion_vertical_top_last1);
        topLast.add(Sprite.explosion_vertical_top_last2);
        spritesList.add(topLast);

        List<Sprite> downLast = new ArrayList<>();
        downLast.add(Sprite.explosion_vertical_down_last);
        downLast.add(Sprite.explosion_vertical_down_last1);
        downLast.add(Sprite.explosion_vertical_down_last2);
        spritesList.add(downLast);

        TimerTask disappearTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> toRemove.add(explodeDirection));
            }
        };
        Timer disappearTimer = new Timer();
        disappearTimer.schedule(disappearTask, 500L);
    }

    public boolean flagged() {
        return flag;
    }

    public boolean collide(Entity e) {
        if (e instanceof Player && ((Player) e).canPassFlame()) {
            return false;
        }
        return collide(e, this.getX(), this.getY());
    }

    @Override
    public void update() {
        for (Entity e : entityList) {
            if (collide(e)) {
                if (e instanceof Wall) {
                    flag = true;
                } else if (e instanceof PowerUp) {
                    ((PowerUp) e).setCanActivate(true);
                } else if (e instanceof Portal) {
                    ((Portal) e).setCanActivate(true);
                } else if (e instanceof AnimatedEntity) {
                    boolean isRemoved = ((AnimatedEntity) e).isRemoved();
                    if (e instanceof Enemy) {
                        new Message(e.getX(), e.getY(), "+" + ((Enemy) e).getPoint());
                        if (!isRemoved) {
                            Game.addTotalPoints(((Enemy) e).getPoint());
                            Audio audio = new Audio("mobDead.wav");
                            audio.playFx();
                        }
                    }
                    if (e instanceof Player) {
                        new Message(e.getX(), e.getY(), "-1");
                    }
                    ((AnimatedEntity) e).remove();
                }
            }
        }
        if(!flag) {
            animate();
            render();
        }
    }
}
