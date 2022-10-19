package com.oop.bomberman.control;

import com.oop.bomberman.Bomberman;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Audio {
    private final Media media;
    private static MediaPlayer mediaPlayer;
    private final AudioClip audioClip;

    public Audio(String path) {
        path = "audio/" + path;
        media = new Media(Bomberman.class.getResource(path).toExternalForm());
        audioClip = new AudioClip(Bomberman.class.getResource(path).toExternalForm());
    }

    public void playFx() {
        audioClip.play();
    }

    public void playMusic() {
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
}
