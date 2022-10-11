package com.oop.bomberman.control;

import com.oop.bomberman.graphics.Sprite;

public class Coordinate {
    private double x;
    private double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void relocate(double x, double y) {
        setX(x);
        setY(y);
    }

    /**
     * Calculate coordinate from x, y tile
     * @param x x tile
     * @param y y tile
     * @return coordinate
     */
    public static Coordinate tileToCoordinate(int x, int y) {
        return new Coordinate(x * Sprite.SCALED_SIZE, y * Sprite.SCALED_SIZE);
    }

    /**
     * Calculate x tile from coordinate
     * @return x tile
     */
    public int getXTile() {
        return (int) (x / Sprite.SCALED_SIZE);
    }

    /**
     * Calculate y tile from coordinate
     * @return y tile
     */
    public int getYTile() {
        return (int) (y / Sprite.SCALED_SIZE);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
