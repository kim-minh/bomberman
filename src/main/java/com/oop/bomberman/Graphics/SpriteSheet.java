package com.oop.bomberman.graphics;

import com.oop.bomberman.Bomberman;
import javafx.scene.image.Image;
import java.io.InputStream;

public class SpriteSheet {
    private final String PATH;
    private final int SIZE;
    public final int[] pixels;

    public static SpriteSheet spriteSheet = new SpriteSheet("textures/classic.png", 256);

    public SpriteSheet(String PATH, int SIZE) {
        this.PATH = PATH;
        this.SIZE = SIZE;
        pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        InputStream inputImage = Bomberman.class.getResourceAsStream(PATH);

        assert inputImage != null;
        Image image = new Image(inputImage);

        //Get RGB color from image
        for (int y = 0; y < SIZE; ++y) {
            for(int x = 0; x < SIZE; ++x) {
                pixels[x + y * SIZE] = image.getPixelReader().getArgb(x, y);
            }
        }
    }

    public int getSIZE() {
        return SIZE;
    }
}
