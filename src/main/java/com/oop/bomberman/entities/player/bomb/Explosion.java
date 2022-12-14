package com.oop.bomberman.entities.player.bomb;

import com.oop.bomberman.control.Audio;
import com.oop.bomberman.graphics.Sprite;

public class Explosion {

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    public Explosion(double x, double y, boolean increaseRadius) {
        int tileSize = Sprite.getScaledSize();

        new ExplodeDirection(x, y, 0);
        ExplodeDirection left = new ExplodeDirection(x - tileSize, y, 1);
        ExplodeDirection right = new ExplodeDirection(x + tileSize, y, 1);
        ExplodeDirection up = new ExplodeDirection(x, y - tileSize, 2);
        ExplodeDirection down = new ExplodeDirection(x, y + tileSize, 2);

        if (increaseRadius) {
            if (left.flagged2()) {
                new ExplodeDirection(x - 2 * tileSize, y, 3);
            }
            if (right.flagged2()) {
                new ExplodeDirection(x + 2 * tileSize, y, 4);
            }
            if (up.flagged2()) {
                new ExplodeDirection(x, y - 2 * tileSize, 5);
            }
            if (down.flagged2()) {
                new ExplodeDirection(x, y + 2 * tileSize, 6);
            }
        }

        Audio audio = new Audio("explode.wav");
        audio.playFx();
    }
}
