package com.oop.bomberman.entities.player.bomb;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Bomb extends AnimatedEntity {
    private final Bomb bomb = this;
    public static int bombCount;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public Bomb(Coordinate coordinate, GraphicsContext gc) {
        super(coordinate, true, gc);
        direction = 0;
        ++bombCount;

        TimerTask explodeTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    clear();
                    new Explosion(bomb.coordinate, gc);
                    toRemove.add(bomb);
                    --bombCount;
                });
            }
        };
        Timer explodeTimer = new Timer();
        explodeTimer.schedule(explodeTask, 2000L);

        //Animation
        List<Sprite> animation = new ArrayList<>();
        animation.add(Sprite.bomb);
        animation.add(Sprite.bomb_1);
        animation.add(Sprite.bomb_2);

        spritesList.add(animation);
    }

    @Override
    public void update() {
        animate();
        render();
    }
}
