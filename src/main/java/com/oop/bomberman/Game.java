package com.oop.bomberman;

import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.enemies.Enemy;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.entities.tiles.Wall;
import com.oop.bomberman.Graphics.Banner;
import com.oop.bomberman.level.Level;
import javafx.animation.AnimationTimer;

public class Game {
    private Level level;
    private boolean passedLevel;
    private boolean playerDead = false;
    private static int totalPoints;

    public static int getTotalPoints() {
        return totalPoints;
    }

    public static void addTotalPoints(int points) {
        Game.totalPoints += points;
    }

    public void start() {
        Banner banner = new Banner();

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
                if (passedLevel && Player.activatedPortal()) {
                    level.nextLevel();
                }
                if(playerDead) {
                    level.restartLevel();
                }
            }
        };

        level = new Level(animation);
        level.newGame();
    }
}
