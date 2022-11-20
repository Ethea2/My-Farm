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
            tile[0] = new GuiTile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/grass.png"));

            tile[1] = new GuiTile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/wall.png"));
            tile[1].collision = true;

            tile[2] = new GuiTile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("../resources/farm/dirt.png"));
            tile[2].collision = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("../resources/maps/farmMap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gamePanel.MAX_SCREEN_COLUMN && row < gamePanel.MAX_SCREEN_ROW) {

                String line = br.readLine();

                while(col < gamePanel.MAX_SCREEN_COLUMN) {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNumber[col][row] = num;
                    col++;
                }
                if(col == gamePanel.MAX_SCREEN_COLUMN) {
                    col = 0;
                    row++;
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
