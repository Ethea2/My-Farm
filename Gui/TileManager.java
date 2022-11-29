package Gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    GuiTile[] tile;
    public int mapTileNumber[][];

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tile = new GuiTile[10];
        mapTileNumber = new int[gamePanel.MAX_SCREEN_COLUMN][gamePanel.MAX_SCREEN_ROW];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {
        try {
            //SOIL TILES
            tile[0] = new GuiTile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/soil.png"));
            
            //GRASS TILES
            tile[1] = new GuiTile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/grass.png"));

            tile[2] = new GuiTile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/grass_top.png"));

            tile[3] = new GuiTile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/grass_left.png"));

            tile[4] = new GuiTile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/grass_right.png"));

            tile[5] = new GuiTile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/grass_bott.png"));

            //TREE BOARDER
            tile[6] = new GuiTile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/trees_top.png"));
            tile[6].collision = true;

            tile[7] = new GuiTile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/trees_left.png"));
            tile[7].collision = true;

            tile[8] = new GuiTile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/trees_right"));
            tile[8].collision = true;

            tile[9] = new GuiTile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/trees_bott"));
            tile[9].collision = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("../resources/maps/farmMapPlain.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            int tilecol = 0;
            int tilerow = -3; //idk why but it fucking works

            while(col < gamePanel.MAX_SCREEN_COLUMN && row < gamePanel.MAX_SCREEN_ROW) {

                String line = br.readLine();
                System.out.println(line);

                while(col < gamePanel.MAX_SCREEN_COLUMN) {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    if(num == 1) {
                        gamePanel.farm.getTile()[tilerow][tilecol].coordinateX = col;
                        gamePanel.farm.getTile()[tilerow][tilecol].coordinateY = row;
                        tilecol++;
                        // System.out.println(tilecol);
                    }

                    mapTileNumber[col][row] = num;
                    col++;
                }
                if(col == gamePanel.MAX_SCREEN_COLUMN) {
                    col = 0;
                    tilecol = 0;
                    row++;
                    tilerow++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gamePanel.MAX_SCREEN_COLUMN && row < gamePanel.MAX_SCREEN_ROW) {

            int tileNum = mapTileNumber[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            col++;
            x += gamePanel.TILE_SIZE;

            if (col == gamePanel.MAX_SCREEN_COLUMN) {
                col = 0;
                x = 0;
                row++;
                y += gamePanel.TILE_SIZE;
            }
        }
    }
}
