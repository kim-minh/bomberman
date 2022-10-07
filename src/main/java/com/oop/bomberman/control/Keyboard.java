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
                case W -> goUp = true;
                case S -> goDown = true;
                case A -> goLeft = true;
                case D -> goRight = true;
            }
        });

        scene.setOnKeyReleased(event -> {
            pressed = false;
            switch (event.getCode()) {
                case W -> goUp = false;
                case S -> goDown = false;
                case A -> goLeft = false;
                case D -> goRight = false;
            }
        });
    }
}