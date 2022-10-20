package com.oop.bomberman.graphics;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import static com.oop.bomberman.graphics.SpriteSheet.spriteSheet;

public class Sprite {
    private static final int DEFAULT_SIZE = 16;
    private static final int SCALED_FACTOR = 3; //times the default size
    private static final int SCALED_SIZE = DEFAULT_SIZE * SCALED_FACTOR;
    private static final int TRANSPARENT = 0xffff00ff;
    private final int[] pixels;
    private final int X;
    private final int Y;

    /*
	|--------------------------------------------------------------------------
	| Board sprites
	|--------------------------------------------------------------------------
	 */
    public static final Sprite grass = new Sprite(6, 0);
    public static final Sprite brick = new Sprite(7, 0);
    public static final Sprite wall = new Sprite(5, 0);
    public static final Sprite portal = new Sprite(4, 0);

    /*
    |--------------------------------------------------------------------------
    | Bomber Sprites
    |--------------------------------------------------------------------------
     */
    public static final Sprite player_up = new Sprite(0, 0);
    public static final Sprite player_down = new Sprite(2, 0);
    public static final Sprite player_left = new Sprite(3, 0);
    public static final Sprite player_right = new Sprite(1, 0);

    public static final Sprite player_up_1 = new Sprite(0, 1);
    public static final Sprite player_up_2 = new Sprite(0, 2);

    public static final Sprite player_down_1 = new Sprite(2, 1);
    public static final Sprite player_down_2 = new Sprite(2, 2);

    public static final Sprite player_left_1 = new Sprite(3, 1);
    public static final Sprite player_left_2 = new Sprite(3, 2);

    public static final Sprite player_right_1 = new Sprite(1, 1);
    public static final Sprite player_right_2 = new Sprite(1, 2);

    public static final Sprite player_dead1 = new Sprite(4, 2);
    public static final Sprite player_dead2 = new Sprite(5, 2);
    public static final Sprite player_dead3 = new Sprite(6, 2);

    /*
    |--------------------------------------------------------------------------
    | Character
    |--------------------------------------------------------------------------
     */
    //BALLOM
    public static final Sprite balloom_left1 = new Sprite(9, 0);
    public static final Sprite balloom_left2 = new Sprite(9, 1);
    public static final Sprite balloom_left3 = new Sprite(9, 2);

    public static final Sprite balloom_right1 = new Sprite(10, 0);
    public static final Sprite balloom_right2 = new Sprite(10, 1);
    public static final Sprite balloom_right3 = new Sprite(10, 2);

    public static final Sprite balloom_dead = new Sprite(9, 3);

    //ONEAL
    public static final Sprite oneal_left1 = new Sprite(11, 0);
    public static final Sprite oneal_left2 = new Sprite(11, 1);
    public static final Sprite oneal_left3 = new Sprite(11, 2);

    public static final Sprite oneal_right1 = new Sprite(12, 0);
    public static final Sprite oneal_right2 = new Sprite(12, 1);
    public static final Sprite oneal_right3 = new Sprite(12, 2);

    public static final Sprite oneal_dead = new Sprite(11, 3);

    //Doll
    public static final Sprite dahl_left1 = new Sprite(13, 0);
    public static final Sprite dahl_left2 = new Sprite(13, 1);
    public static final Sprite dahl_left3 = new Sprite(13, 2);

    public static final Sprite dahl_right1 = new Sprite(14, 0);
    public static final Sprite dahl_right2 = new Sprite(14, 1);
    public static final Sprite dahl_right3 = new Sprite(14, 2);

    public static final Sprite dall_dead = new Sprite(13, 3);

    //Minvo
    public static final Sprite minvo_left1 = new Sprite(8, 5);
    public static final Sprite minvo_left2 = new Sprite(8, 6);
    public static final Sprite minvo_left3 = new Sprite(8, 7);

    public static final Sprite minvo_right1 = new Sprite(9, 5);
    public static final Sprite minvo_right2 = new Sprite(9, 6);
    public static final Sprite minvo_right3 = new Sprite(9, 7);

    public static final Sprite minvo_dead = new Sprite(8, 8);

    //Ovape
    public static final Sprite ovape_left1 = new Sprite(6, 5);
    public static final Sprite ovape_left2 = new Sprite(6, 6);
    public static final Sprite ovape_left3 = new Sprite(6, 7);

    public static final Sprite ovape_right1 = new Sprite(7, 5);
    public static final Sprite ovape_right2 = new Sprite(7, 6);
    public static final Sprite ovape_right3 = new Sprite(7, 7);

    public static final Sprite ovape_dead = new Sprite(6, 8);

    //Kondoria
    public static final Sprite kondoria_left1 = new Sprite(10, 5);
    public static final Sprite kondoria_left2 = new Sprite(10, 6);
    public static final Sprite kondoria_left3 = new Sprite(10, 7);

    public static final Sprite kondoria_right1 = new Sprite(11, 5);
    public static final Sprite kondoria_right2 = new Sprite(11, 6);
    public static final Sprite kondoria_right3 = new Sprite(11, 7);

    public static final Sprite kondoria_dead = new Sprite(10, 8);

    //Pontan
    public static final Sprite pontan_left1 = new Sprite(12, 5);
    public static final Sprite pontan_left2 = new Sprite(12, 6);
    public static final Sprite pontan_left3 = new Sprite(12, 7);

    public static final Sprite pontan_right1 = new Sprite(13, 5);
    public static final Sprite pontan_right2 = new Sprite(13, 6);
    public static final Sprite pontan_right3 = new Sprite(13, 7);

    public static final Sprite pontan_dead = new Sprite(12, 8);

    //Tiger
    public static final Sprite tiger_left1 = new Sprite(4, 5);
    public static final Sprite tiger_left2 = new Sprite(4, 6);
    public static final Sprite tiger_left3 = new Sprite(4, 7);

    public static final Sprite tiger_right1 = new Sprite(5, 5);
    public static final Sprite tiger_right2 = new Sprite(5, 6);
    public static final Sprite tiger_right3 = new Sprite(5, 7);

    public static final Sprite tiger_dead = new Sprite(4, 8);

    //ALL
    public static final Sprite mob_dead1 = new Sprite(15, 0);
    public static final Sprite mob_dead2 = new Sprite(15, 1);
    public static final Sprite mob_dead3 = new Sprite(15, 2);

    /*
    |--------------------------------------------------------------------------
    | Bomb Sprites
    |--------------------------------------------------------------------------
     */
    public static final Sprite bomb = new Sprite(0, 3);
    public static final Sprite bomb_1 = new Sprite(1, 3);
    public static final Sprite bomb_2 = new Sprite(2, 3);

    /*
    |--------------------------------------------------------------------------
    | FlameSegment Sprites
    |--------------------------------------------------------------------------
     */
    public static final Sprite bomb_exploded = new Sprite(0, 4);
    public static final Sprite bomb_exploded1 = new Sprite(0, 5);
    public static final Sprite bomb_exploded2 = new Sprite(0, 6);

    public static final Sprite explosion_vertical = new Sprite(1, 5);
    public static final Sprite explosion_vertical1 = new Sprite(2, 5);
    public static final Sprite explosion_vertical2 = new Sprite(3, 5);

    public static final Sprite explosion_horizontal = new Sprite(1, 7);
    public static final Sprite explosion_horizontal1 = new Sprite(1, 8);
    public static final Sprite explosion_horizontal2 = new Sprite(1, 9);

    public static final Sprite explosion_horizontal_left_last = new Sprite(0, 7);
    public static final Sprite explosion_horizontal_left_last1 = new Sprite(0, 8);
    public static final Sprite explosion_horizontal_left_last2 = new Sprite(0, 9);

    public static final Sprite explosion_horizontal_right_last = new Sprite(2, 7);
    public static final Sprite explosion_horizontal_right_last1 = new Sprite(2, 8);
    public static final Sprite explosion_horizontal_right_last2 = new Sprite(2, 9);

    public static final Sprite explosion_vertical_top_last = new Sprite(1, 4);
    public static final Sprite explosion_vertical_top_last1 = new Sprite(2, 4);
    public static final Sprite explosion_vertical_top_last2 = new Sprite(3, 4);

    public static final Sprite explosion_vertical_down_last = new Sprite(1, 6);
    public static final Sprite explosion_vertical_down_last1 = new Sprite(2, 6);
    public static final Sprite explosion_vertical_down_last2 = new Sprite(3, 6);

    /*
    |--------------------------------------------------------------------------
    | Brick FlameSegment
    |--------------------------------------------------------------------------
     */
    public static final Sprite brick_exploded = new Sprite(7, 1);
    public static final Sprite brick_exploded1 = new Sprite(7, 2);
    public static final Sprite brick_exploded2 = new Sprite(7, 3);

    /*
    |--------------------------------------------------------------------------
    | Powerups
    |--------------------------------------------------------------------------
     */
    public static final Sprite powerup_bombs = new Sprite(0, 10);
    public static final Sprite powerup_flames = new Sprite(1, 10);
    public static final Sprite powerup_speed = new Sprite(2, 10);
    public static final Sprite powerup_wallpass = new Sprite(3, 10);
    public static Sprite powerup_detonator = new Sprite(4, 10);
    public static final Sprite powerup_bombpass = new Sprite(5, 10);
    public static final Sprite powerup_flamepass = new Sprite(6, 10);

    private Sprite(int x, int y) {
        X = x * DEFAULT_SIZE;
        Y = y * DEFAULT_SIZE;
        pixels = new int[DEFAULT_SIZE * DEFAULT_SIZE];
        load();
    }

    public static int getScaledSize() {
        return SCALED_SIZE;
    }

    private void load() {
        for (int y = 0; y < DEFAULT_SIZE; ++y) {
			System.arraycopy(spriteSheet.getPixels(), X + (y + Y) * spriteSheet.getSize(), pixels, y * 16, DEFAULT_SIZE);
        }
    }

    /**
     * Return an upscaled texture.
     */
    public Image getTexture() {
        WritableImage image = new WritableImage(DEFAULT_SIZE, DEFAULT_SIZE);
        PixelWriter pixelWriter = image.getPixelWriter();

        for (int x = 0; x < DEFAULT_SIZE; ++x) {
            for (int y = 0; y < DEFAULT_SIZE; ++y) {
                if (pixels[x + y * DEFAULT_SIZE] == TRANSPARENT) {
                    pixelWriter.setArgb(x, y, 0);
                } else {
                    pixelWriter.setArgb(x, y, pixels[x + y * DEFAULT_SIZE]);
                }
            }
        }

        return upscale(image);
    }

    /**
     * Upscale image.
     * @param inputImage input image
     * @return An upscaled image
     */
    private Image upscale(WritableImage inputImage) {
        final int width = (int) inputImage.getWidth();
        final int height = (int) inputImage.getHeight();

        WritableImage outputImage = new WritableImage(width * SCALED_FACTOR, height * SCALED_FACTOR);
        PixelReader pixelReader = inputImage.getPixelReader();
        PixelWriter pixelWriter = outputImage.getPixelWriter();

        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                final int argb = pixelReader.getArgb(x, y);
                for (int scaledY = 0; scaledY < SCALED_FACTOR; ++scaledY) {
                    for (int scaledX = 0; scaledX < SCALED_FACTOR; ++scaledX) {
                        pixelWriter.setArgb(x * SCALED_FACTOR + scaledX, y * SCALED_FACTOR + scaledY, argb);
                    }
                }
            }
        }

        return outputImage;
    }
}
