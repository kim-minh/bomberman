package com.oop.bomberman.control;

import javafx.scene.Scene;

public class Keyboard {
    public static boolean pressed;
    public static boolean goUp;
    public static boolean goDown;
    public static boolean goLeft;
    public static boolean goRight;

    public static Keyboard keyboard = new Keyboard();

    public void handle(Scene scene) {
        scene.setOnKeyPressed(event -> {
            pressed = true;
            switch (event.getCode()) {
                case W, UP -> goUp = true;
                case S, DOWN -> goDown = true;
                case A, LEFT -> goLeft = true;
                case D, RIGHT -> goRight = true;
            }
        });

        scene.setOnKeyReleased(event -> {
            pressed = false;
            switch (event.getCode()) {
                case W, UP -> goUp = false;
                case S, DOWN -> goDown = false;
                case A, LEFT -> goLeft = false;
                case D, RIGHT -> goRight = false;
            }
        });
    }
}