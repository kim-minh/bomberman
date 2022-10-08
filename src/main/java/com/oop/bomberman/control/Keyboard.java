package com.oop.bomberman.control;

import javafx.scene.Scene;

public class Keyboard {
    public static boolean pressed;
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    public void handle(Scene scene) {
        scene.setOnKeyPressed(event -> {
            pressed = true;
            switch (event.getCode()) {
                case W, UP -> up = true;
                case S, DOWN -> down = true;
                case A, LEFT -> left = true;
                case D, RIGHT -> right = true;
            }
        });

        scene.setOnKeyReleased(event -> {
            pressed = false;
            switch (event.getCode()) {
                case W, UP -> up = false;
                case S, DOWN -> down = false;
                case A, LEFT -> left = false;
                case D, RIGHT -> right = false;
            }
        });
    }
}