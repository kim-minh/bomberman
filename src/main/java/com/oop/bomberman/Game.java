package com.oop.bomberman;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.enemies.Balloom;
import com.oop.bomberman.entities.enemies.Oneal;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.entities.tiles.Brick;
import com.oop.bomberman.entities.tiles.Wall;
import com.oop.bomberman.entities.tiles.powerups.FireUp;
import javafx.animation.AnimationTimer;

public class Game {
    private static final Player player = new Player(Coordinate.tileToCoordinate(1, 1));

    public Game() {
        for(int i = 0; i < 800; i += 32) {
            Entity.entityList.add(new Wall(new Coordinate(i, 0)));
            Entity.entityList.add(new Wall(new Coordinate(i, 544)));
        }
        for(int i = 0; i < 544; i += 32) {
            Entity.entityList.add(new Wall(new Coordinate(0, i)));
            Entity.entityList.add(new Wall(new Coordinate(768, i)));
        }

        new Balloom(Coordinate.tileToCoordinate(10, 1));
        new Balloom(Coordinate.tileToCoordinate(6, 1));
        new FireUp(Coordinate.tileToCoordinate(2, 1));
        new Brick(Coordinate.tileToCoordinate(14, 10));
        new Oneal(Coordinate.tileToCoordinate(15,10));
    }

    public static Player getPlayer() {
        return player;
    }

    public void update() {
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
