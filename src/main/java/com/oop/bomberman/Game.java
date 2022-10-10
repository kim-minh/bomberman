package com.oop.bomberman;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.enemies.Balloom;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.entities.tiles.Wall;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class Game {
    private final GraphicsContext gc;

    public Game(GraphicsContext gc) {
        this.gc = gc;
    }
    public void update() {
        for(int i = 0; i < 800; i += 32) {
            Entity.entityList.add(new Wall(new Coordinate(i, 0), gc));
            Entity.entityList.add(new Wall(new Coordinate(i, 544), gc));
        }
        for(int i = 0; i < 544; i += 32) {
            Entity.entityList.add(new Wall(new Coordinate(0, i), gc));
            Entity.entityList.add(new Wall(new Coordinate(768, i), gc));
        }

        new Player(new Coordinate(32, 32), gc);
        new Balloom(new Coordinate(300, 32), gc);
        new Balloom(new Coordinate(200, 32), gc);

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
