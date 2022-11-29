package Player;

import java.util.ArrayList;

import Crop.Crop;
import Crop.Flowers.*;
import Crop.RootCrops.*;

public class MyFarm {
    public final int TILE_ROW = 5;
    public final int TILE_COL = 10;
    private int day;
    private Tile[][] tile = new Tile[TILE_ROW][TILE_COL];
    private Player player;
    private ArrayList<Crop> crops;

    /*
     * The constructor method for the MyFarm class. Initializing all the necessary requirements.
     */
    public MyFarm() {
        this.day = 1;
        this.player = new Player();
        this.crops = new ArrayList<Crop>();
        this.crops.add(new Tulip());
        this.crops.add(new Sunflower());
        this.crops.add(new Rose());
        this.crops.add(new Carrot());
        this.crops.add(new Potato());
        this.crops.add(new Turnip());
        for(int i = 0; i < TILE_ROW; i++) {
            for(int j = 0; j < TILE_COL; j++) {
                this.tile[i][j] = new Tile();
            }
        }
    }

    /*
     * The advanceDay function increases the day count.
     */
    public void advanceDay() {
        this.day++;
        for(int i = 0; i < TILE_ROW; i++) {
            for(int j = 0; j < TILE_COL; j++) {
                if(this.tile[i][j].getCrop() != null)
                    this.tile[i][j].getCrop().setWithered(this.tile[i][j], this.tile[i][j].getCrop().checkStatus(this.day));
            }
        }
    }
    
    /*
     * The getCrops function gets all the names of the crops in the crops array list.
     * 
     * @return cropsAvailable   the names of all the crops.
     */
    public ArrayList<String> getCrops() {
        ArrayList<String> cropsAvailable = new ArrayList<String>();
        for(Crop crop:crops) {
            cropsAvailable.add(crop.getCropName());
        }
        return cropsAvailable;
    }

    /*
     * checks if all the game ending scenarios are true, will return true if either of them are true and false if not.
     * 
     * @return a boolean if the game continues or not.
     */
    public boolean checkGameOver() {
        boolean temp = false;
        for(int i = 0; i < TILE_ROW; i++) {
            for(int j = 0; j < TILE_COL; j++) {
                temp = !tile[i][j].checkPlanted();
            }
        }
        if (player.getObjectcoins() < 5) {
            return true;
        } 
        else if (temp) {
            return true;
        }
        return false;
    }

    /*
     * basically resetting all the game values.
     */
    public void gameReset() {
        player.playerReset();
        this.day = 1;
        for(int i = 0; i < TILE_ROW; i++) {
            for(int j = 0; j < TILE_COL; j++) {
                tile[i][j] = new Tile();
            }
        }
        this.crops = new ArrayList<Crop>();
        this.crops.add(new Tulip());
        this.crops.add(new Sunflower());
        this.crops.add(new Rose());
        this.crops.add(new Carrot());
        this.crops.add(new Potato());
        this.crops.add(new Turnip());
    }

    /*
     * a getter function for the tiles in play
     * 
     * @return the tile inside my farm
     */
    public Tile[][] getTile() {
        return this.tile;
    }

    /*
     * a getter function for the current day
     * 
     * @return the current day of the game loop.
     */
    public int getCurrentDay() {
        return this.day;
    }

    public Player getPlayer() {
        return this.player;
    }
}
