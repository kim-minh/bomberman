package com.oop.bomberman;

import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.enemies.*;
import com.oop.bomberman.entities.tiles.Brick;
import com.oop.bomberman.entities.tiles.Wall;
import com.oop.bomberman.entities.tiles.powerups.FireUp;
import javafx.animation.AnimationTimer;

public class Game {
    private static int totalPoints;

    public static int getTotalPoints() {
        return totalPoints;
    }

    public static void setTotalPoints(int totalPoints) {
        Game.totalPoints = totalPoints;
    }

    public void update() {
        for(int i = 0; i < 25; i++) {
            Entity.entityList.add(new Wall(i, 0));
            Entity.entityList.add(new Wall(i, 17));
        }
        for(int i = 0; i < 17; i++) {
            Entity.entityList.add(new Wall(0, i));
            Entity.entityList.add(new Wall(24, i));
        }

        new Balloom(10, 1);
        new Dahl(6, 1);
        new FireUp(2, 1);
        new Brick(14, 10);
        new Ovape(15,10);
        new Kondoria(17, 15);
        new Pontan(10, 10);
        
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Entity.updateList();
                for(Entity e : Entity.entityList) {
                    if (!(e instanceof Wall)) {
                        e.update();
                    }
                }
            }
        };
        timer.start();
    }
}
