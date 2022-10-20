package com.oop.bomberman.entities.enemies;

import com.oop.bomberman.entities.enemies.AI.LowAI;
import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Tiger extends Enemy {
    private boolean spawned;
    /**
     * Initialize object.
     *
     * @param x       coordinate x
     * @param y       coordinate y
     */
    public Tiger(double x, double y) {
        super(x, y, 200, false);
        ai = new LowAI(3);
        speed = 2;

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.tiger_left1);
        left.add(Sprite.tiger_left2);
        left.add(Sprite.tiger_left3);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.tiger_right1);
        right.add(Sprite.tiger_right2);
        right.add(Sprite.tiger_right3);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.tiger_dead);
        dead.add(Sprite.mob_dead1);
        dead.add(Sprite.mob_dead2);
        dead.add(Sprite.mob_dead3);

        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(dead);
    }

    @Override
    public void update() {
        if (isRemoved() && !spawned) {
            spawned = true;
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    double spawnedX = Math.round(x / Sprite.getScaledSize()) * Sprite.getScaledSize();
                    double spawnedY = Math.round(y / Sprite.getScaledSize()) * Sprite.getScaledSize();
                    Platform.runLater(() -> {
                        toAdd.add(new SpawnedTiger(spawnedX, spawnedY));
                        toAdd.add(new SpawnedTiger(spawnedX + Sprite.getScaledSize(), spawnedY));
                        toAdd.add(new SpawnedTiger(spawnedX - Sprite.getScaledSize(), spawnedY));
                    });
                }
            };
            timer.schedule(task, 600);
        }
        super.update();
    }
}
