package com.oop.bomberman.entities.player.bomb;

import com.oop.bomberman.control.Coordinate;
import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.enemies.Enemy;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.entities.tiles.Wall;
import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ExplodeDirection extends AnimatedEntity {
    private boolean flag;

    /**
     * Initialize object.
     *
     * @param coordinate coordinate
     * @param gc         GraphicContext
     */
    public ExplodeDirection(Coordinate coordinate, int direction, GraphicsContext gc) {
        super(coordinate, true, gc);
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
        return collide(e, this.getCoordinate().getX(), this.getCoordinate().getY());
    }

    @Override
    public void update() {
        for (Entity e : entityList) {
            if (collide(e)) {
                if (e instanceof Wall) {
                    flag = true;
                }
                if (e instanceof Enemy || e instanceof Player) {
                    toRemove.add(e);
                }
            }
        }
        if(!flag) {
            animate();
            render();
        }
    }
}
