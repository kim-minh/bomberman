package com.oop.bomberman;

import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.enemies.Enemy;
import com.oop.bomberman.entities.tiles.Wall;
import com.oop.bomberman.level.FileLevel;
import javafx.animation.AnimationTimer;

public class Game {
    private boolean passedLevel;
    private static int totalPoints;

    public static int getTotalPoints() {
        return totalPoints;
    }

    public static void setTotalPoints(int totalPoints) {
        Game.totalPoints = totalPoints;
    }

    private void createLevel(int level) {
        FileLevel fileLevel = new FileLevel();
        fileLevel.loadLevel(level);
        fileLevel.createEntities();
    }

    public void update() {
        createLevel(1);
        
        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Entity.updateList();
                passedLevel = true;
                for(Entity e : Entity.entityList) {
                    if (!(e instanceof Wall)) {
                        e.update();
                    }
                    if (e instanceof Enemy) {
                        passedLevel = false;
                    }
                }
                if (passedLevel) {
                    this.stop();
                }
            }
        };
        animation.start();
    }
}
