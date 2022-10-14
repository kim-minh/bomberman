package com.oop.bomberman.level;

import com.oop.bomberman.entities.tiles.Brick;
import com.oop.bomberman.entities.tiles.Wall;
import com.oop.bomberman.exceptions.LoadLevelException;

import java.io.*;
import java.net.URL;
import java.util.StringTokenizer;

public class FileLevel {
    protected int _level, _height, _width;
    protected String[] _lineTiles;

    public int getWidth() {
        return _width;
    }

    public int getHeight() {
        return _height;
    }

    public int getLevel() {
        return _level;
    }

    public void loadLevel(String path) throws LoadLevelException {
        try {
            URL absPath = FileLevel.class.getResource("C:\\Users\\Admin\\Documents\\IntelliJ\\bombermann\\src\\main\\resources\\com\\oop\\bomberman\\Level1.txt");
            File file = new File("C:\\Users\\Admin\\Documents\\IntelliJ\\bombermann\\src\\main\\resources\\com\\oop\\bomberman\\Level1.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader in = new BufferedReader(fileReader);

            String data = in.readLine();
            StringTokenizer tokens = new StringTokenizer(data);

            _level = Integer.parseInt(tokens.nextToken());
            _height = Integer.parseInt(tokens.nextToken());
            _width = Integer.parseInt(tokens.nextToken());

            _lineTiles = new String[_height];

            for (int i = 0; i < _height; i++) {
                _lineTiles[i] = in.readLine().substring(0, _width);
            }

            in.close();
        } catch (IOException e) {
            throw new LoadLevelException("Error loading level " + path, e);
        }
    }

    public void createEntities() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                addLevelEntity(_lineTiles[i].charAt(j), j, i);
            }
        }
    }

    public void addLevelEntity(char c, int x, int y) {
        int pos = x + y + getWidth();

        switch (c) {
            case '#':
                Wall wall = new Wall(x, y);
                break;
            case '*':
                Brick brick = new Brick(x, y);
                break;
        }
    }

}
