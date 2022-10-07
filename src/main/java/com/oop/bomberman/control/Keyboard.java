package com.oop.bomberman.control;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class Keyboard {

    public static Keyboard keyboard = new Keyboard();

    public static boolean goUp, goDown, goLeft, goRight;

    public void handle(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W: goUp = true; break;
                    case S: goDown = true; break;
                    case A: goRight = true; break;
                    case D: goLeft = true; break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W:    goUp = false; break;
                    case S:  goDown = false; break;
                    case A:  goRight = false; break;
                    case D: goLeft = false; break;
                }
            }
        });
    }
}