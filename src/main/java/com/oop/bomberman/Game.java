package com.oop.bomberman;

import com.oop.bomberman.control.Audio;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.enemies.Enemy;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.entities.tiles.Wall;
import com.oop.bomberman.graphics.Banner;
import com.oop.bomberman.level.Level;
import javafx.animation.AnimationTimer;

public class Game {
    private Level level;
    private boolean passedLevel;
    private boolean playerDead = false;
    private static int totalPoints;
    private boolean gimmickStarted;

    public static int getTotalPoints() {
        return totalPoints;
    }

    public static void addTotalPoints(int points) {
        totalPoints += points;
    }

    public static void resetTotalPoints() {
        totalPoints = 0;
    }

    public void start() {
        Banner banner = new Banner();
        Audio music = new Audio("music.wav");
        music.playMusic();

        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                banner.update();
                Entity.updateList();
                passedLevel = true;
                playerDead = true;
                for(Entity e : Entity.entityList) {
                    if (!(e instanceof Wall)) {
                        e.update();
                    }
                    if (e instanceof Enemy) {
                        passedLevel = false;
                    }
                    if (e instanceof Player) {
                        playerDead = false;
                    }
                }
                if (banner.timeUp() && !gimmickStarted) {
                    level.startGimmick();
                    gimmickStarted = true;
                } else if (!banner.timeUp()) {
                    gimmickStarted = false;
                }
                if (passedLevel && Player.activatedPortal()) {
                    level.nextLevel();
                    banner.startTimer();
                }
                if(playerDead) {
                    Audio audio = new Audio("playerDead.wav");
                    audio.playFx();
                    Player.decreaseLife();
                    if (Player.getLife() == 0) {
                        level.newGame();
                        banner.startTimer();
                    } else {
                        level.restartLevel();
                    }
                }
            }
        };

        level = new Level(animation);
        level.newGame();
    }
}
