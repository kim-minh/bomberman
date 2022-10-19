package com.oop.bomberman.entities.player.bomb;

import com.oop.bomberman.control.Audio;
import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Bomb extends AnimatedEntity {
    private static int bombCount;
    private boolean passedBomb;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Bomb(double x, double y, boolean increaseRadius) {
        super(x, y, true);
        final Bomb bomb = this;
        direction = 0;
        ++bombCount;

        TimerTask explodeTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    clear();
                    new Explosion(bomb.getX(), bomb.getY(), increaseRadius);
                    toRemove.add(bomb);
                    --bombCount;
                });
            }
        };
        Timer explodeTimer = new Timer();
        explodeTimer.schedule(explodeTask, 2500L);

        //Animation
        List<Sprite> animation = new ArrayList<>();
        animation.add(Sprite.bomb);
        animation.add(Sprite.bomb_1);
        animation.add(Sprite.bomb_2);

        spritesList.add(animation);

        Audio audio = new Audio("placeBomb.wav");
        audio.playFx();
    }

    public static int getBombCount() {
        return bombCount;
    }

    public boolean passedBomb() {
        return passedBomb;
    }

    public void setPassedBomb(boolean passedBomb) {
        this.passedBomb = passedBomb;
    }

    @Override
    public void update() {
        animate();
        render();
    }
}
