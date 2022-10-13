package com.oop.bomberman.graphics;

import com.oop.bomberman.Bomberman;
import javafx.scene.image.Image;

import java.io.InputStream;

public class SpriteSheet {
    private final String path;
    private final int size;
    private final int[] pixels;

    public static final SpriteSheet spriteSheet = new SpriteSheet("textures/classic.png", 256);

    public SpriteSheet(String path, int size) {
        this.path = path;
        this.size = size;
        pixels = new int[size * size];
        load();
    }

    public int[] getPixels() {
        return pixels;
    }

    private void load() {
        InputStream inputImage = Bomberman.class.getResourceAsStream(path);

        assert inputImage != null;
        Image image = new Image(inputImage);

        //Get RGB color from image
        for (int y = 0; y < size; ++y) {
            for(int x = 0; x < size; ++x) {
                pixels[x + y * size] = image.getPixelReader().getArgb(x, y);
            }
        }
    }

    public int getSize() {
        return size;
    }
}
