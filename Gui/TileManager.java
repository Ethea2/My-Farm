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

    /**
     * The constructor for the TileManager class.
     * 
     * @param gamePanel the GamePanel class for the accessing of screen values.
     */
    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tile = new GuiTile[11];
        mapTileNumber = new int[gamePanel.MAX_SCREEN_COLUMN][gamePanel.MAX_SCREEN_ROW];

        getTileImage();
        loadMap();
    }

    /**
     * Loads all the images/tiles in the tile attribute. It also decides
     * whether the tile is collision true or false.
     */
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
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/trees_right.png"));
            tile[8].collision = true;

            tile[9] = new GuiTile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/trees_bott.png"));
            tile[9].collision = true;

            tile[10] = new GuiTile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/soil.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes a file input and reads it line by line, it uses the array
     * index for the tile map and loads the corresponding image.
     */
    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("../resources/maps/farmMap.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            int tilecol = 0;
            int tilerow = -3; //idk why but it fucking works
            while(col < gamePanel.MAX_SCREEN_COLUMN && row < gamePanel.MAX_SCREEN_ROW) {

                String line = br.readLine();
                
                while(col < gamePanel.MAX_SCREEN_COLUMN) {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    if(num == 0 || num == 10) {
                        gamePanel.farm.getTile()[tilerow][tilecol].coordinateX = col;
                        gamePanel.farm.getTile()[tilerow][tilecol].coordinateY = row;
                        if(num == 10)
                            gamePanel.farm.getTile()[tilerow][tilecol].setRock();
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

    /**
     * This function draws the tiles based on the assigned tile map 2d array indices
     * and puts them in the screen.
     * 
     * @param g2 graphics object to be used in the drawing of components.
     */
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
