package com.oop.bomberman.level;

import com.oop.bomberman.Bomberman;
import com.oop.bomberman.entities.enemies.*;
import com.oop.bomberman.entities.player.Player;
import com.oop.bomberman.entities.tiles.Brick;
import com.oop.bomberman.entities.tiles.Portal;
import com.oop.bomberman.entities.tiles.Wall;
import com.oop.bomberman.entities.tiles.powerups.BombUp;
import com.oop.bomberman.entities.tiles.powerups.FireUp;
import com.oop.bomberman.entities.tiles.powerups.Skate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FileLevel {
    private Player player;
    private int level;
    private static int height;
    private static int width;
    private String[] lineTiles;

    public int getLevel() {
        return level;
    }

    public void loadLevel(int level) {
        try {
            InputStream input = Bomberman.class.getResourceAsStream("levels/Level" + level + ".txt");
            assert input != null;
            InputStreamReader fileReader = new InputStreamReader(input);
            BufferedReader in = new BufferedReader(fileReader);

            String data = in.readLine();
            StringTokenizer tokens = new StringTokenizer(data);

            level = Integer.parseInt(tokens.nextToken());
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());

            lineTiles = new String[height];

            for (int i = 0; i < height; i++) {
                lineTiles[i] = in.readLine().substring(0, width);
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createEntities() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                addLevelEntity(lineTiles[i].charAt(j), j, i);
            }
        }
    }

    private void addLevelEntity(char c, int x, int y) {
        switch (c) {
            case '#' -> new Wall(x, y);
            case '*' -> new Brick(x, y);
            case 'x' -> new Portal(x, y);
            case 'p' -> player = new Player(x, y);
            case '1' -> new Balloom(x, y);
            case '2' -> new Oneal(x, y, player);
            case '3' -> new Dahl(x, y);
            case '4' -> new Minvo(x, y, player);
            case '5' -> new Kondoria(x, y, player);
            case 'b' -> new BombUp(x, y);
            case 'f' -> new FireUp(x, y);
            case 's' -> new Skate(x, y);
        }
    }

    public void gimmick() {
        for (int i = 0; i < 5; ++i) {
            new Pontan(1, 1, player);
        }
    }
}
