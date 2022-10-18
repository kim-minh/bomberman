package com.oop.bomberman.entities.player;

import com.oop.bomberman.Bomberman;
import com.oop.bomberman.BombermanController;
import com.oop.bomberman.control.Control;
import com.oop.bomberman.entities.AnimatedEntity;
import com.oop.bomberman.entities.Entity;
import com.oop.bomberman.entities.player.bomb.Bomb;
import com.oop.bomberman.entities.player.bomb.ExplodeDirection;
import com.oop.bomberman.entities.tiles.Brick;
import com.oop.bomberman.entities.tiles.Tile;
import com.oop.bomberman.entities.tiles.powerups.PowerUp;
import com.oop.bomberman.graphics.Sprite;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends AnimatedEntity {
    private final DoubleProperty xProperty;
    private final DoubleProperty yProperty;
    private int maxBombs;
    private boolean increaseRadius;
    private boolean wallpass;
    private boolean flamepass;
    private boolean bombpass;

    /**
     * Initialize object.
     *
     * @param x coordinate x
     * @param y coordinate y
     */

    public Player(double x, double y) {
        super(x, y, false);
        this.xProperty = new SimpleDoubleProperty();
        this.yProperty = new SimpleDoubleProperty();
        speed = 2;
        maxBombs = 1;

        //Initialize up animation sprites
        List<Sprite> up = new ArrayList<>();
        up.add(Sprite.player_up);
        up.add(Sprite.player_up_1);
        up.add(Sprite.player_up_2);

        //Initialize down animation sprites
        List<Sprite> down = new ArrayList<>();
        down.add(Sprite.player_down);
        down.add(Sprite.player_down_1);
        down.add(Sprite.player_down_2);

        //Initialize left animation sprites
        List<Sprite> left = new ArrayList<>();
        left.add(Sprite.player_left);
        left.add(Sprite.player_left_1);
        left.add(Sprite.player_left_2);

        //Initialize right animation sprites
        List<Sprite> right = new ArrayList<>();
        right.add(Sprite.player_right);
        right.add(Sprite.player_right_1);
        right.add(Sprite.player_right_2);

        List<Sprite> dead = new ArrayList<>();
        dead.add(Sprite.player_dead1);
        dead.add(Sprite.player_dead2);
        dead.add(Sprite.player_dead3);

        spritesList.add(up);
        spritesList.add(down);
        spritesList.add(left);
        spritesList.add(right);
        spritesList.add(dead);

        addCamera();
    }

    public final DoubleProperty xProperty() {
        return xProperty;
    }

    public final DoubleProperty yProperty() {
        return yProperty;
    }

    @Override
    public double getX() {
        return xProperty.get();
    }

    @Override
    public double getY() {
        return yProperty.get();
    }

    private double clampRange(double value, double max) {
        if (value < 0) {
            return 0;
        }
        return Math.min(value, max);
    }

    private void addCamera() {
        Pane pane = BombermanController.getPane();
        Scene scene = Bomberman.getScene();
        Rectangle clip = new Rectangle();
        Player player = this;

        clip.widthProperty().bind(scene.widthProperty());
        clip.heightProperty().bind(scene.heightProperty());
        clip.xProperty().bind(Bindings.createDoubleBinding(
                () -> clampRange(x - scene.getWidth() / 2,
                        pane.getWidth() - scene.getWidth()), player.xProperty(),
                pane.widthProperty()));

        pane.setClip(clip);
        pane.translateXProperty().bind(clip.xProperty().multiply(-1));
    }

    public void increaseMaxBombs() {
        ++maxBombs;
    }

    public void increaseRadius(boolean increaseRadius) {
        this.increaseRadius = increaseRadius;
    }

    public void increaseSpeed() {
        ++speed;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> --speed);
            }
        };
        timer.schedule(task, 15000);
    }

    public void setWallpass(boolean wallpass) {
        this.wallpass = wallpass;
    }

    public void setFlamepass(boolean flamepass) {
        this.flamepass = flamepass;
    }

    public void setBombpass(boolean bombpass) {
        this.bombpass = bombpass;
    }

    public boolean canPassFlame() {
        return flamepass;
    }

    @Override
    protected void moveBy(double dx, double dy) {
        super.moveBy(dx, dy);
        xProperty.set(x);
        yProperty.set(y);
    }

    @Override
    public boolean collide(Entity e, double x, double y) {
        if (wallpass && e instanceof Brick) {
            return false;
        }

        if (flamepass && e instanceof ExplodeDirection) {
            return false;
        }

        if (bombpass && e instanceof Bomb) {
            return false;
        }

        boolean collide = super.collide(e, x, y);

        if (e instanceof Tile) {
            clear();
            this.x = Math.round(this.x / Sprite.getScaledSize()) * Sprite.getScaledSize();
            this.y = Math.round(this.y/ Sprite.getScaledSize()) * Sprite.getScaledSize();
        }

        if (e instanceof Bomb && !((Bomb) e).passedBomb()) {
            if (this.getX() <= e.getX() - Sprite.getScaledSize()
                    || this.getX() >= e.getX() + Sprite.getScaledSize()
                    || this.getY() <= e.getY() - Sprite.getScaledSize()
                    || this.getY() >= e.getY() + Sprite.getScaledSize()) {
                ((Bomb) e).setPassedBomb(true);
                return true;
            }
            return false;
        }

        if (collide && e instanceof PowerUp && ((PowerUp) e).canActivate()) {
            ((PowerUp) e).activatePower(this);
            toRemove.add(e);
        }
        return collide;
    }

    @Override
    public void update() {
        isMoving = Control.move;
        goUp = Control.up;
        goDown = Control.down;
        goLeft = Control.left;
        goRight = Control.right;
        if (Control.bomb && Bomb.getBombCount() < maxBombs) {
            double bombX = Math.round(x / Sprite.getScaledSize()) * Sprite.getScaledSize();
            double bombY = Math.round(y / Sprite.getScaledSize()) * Sprite.getScaledSize();
            new Bomb(bombX, bombY, increaseRadius);
            Control.bomb = false;
        }
        super.update();
        if (isRemoved) {
            x = Sprite.getScaledSize();
            y = Sprite.getScaledSize();
            xProperty.set(x);
        }
    }
}
