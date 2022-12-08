package Player;

import java.util.ArrayList;

import Crop.Crop;
import Crop.Flowers.*;
import Crop.RootCrops.*;
import Crop.FruitTrees.*;

public class MyFarm {
    public final int TILE_ROW = 5;
    public final int TILE_COL = 10;
    private int day;
    private Tile[][] tile = new Tile[TILE_ROW][TILE_COL];
    private Player player;
    private ArrayList<Crop> crops;

    /**
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
        this.crops.add(new Mango());
        this.crops.add(new Apple());
        for(int i = 0; i < TILE_ROW; i++) {
            for(int j = 0; j < TILE_COL; j++) {
                this.tile[i][j] = new Tile();
                tile[i][j].row = i;
                tile[i][j].col = j;
            }
        }
    }

    /**
     * Advances to the next day and increases the day count. Sets any tiles
     * with withered crops to "withered" and resets the "watered" status on
     * all crops.
     */
    public void advanceDay() {
        this.day++;
        for(int i = 0; i < TILE_ROW; i++) {
            for(int j = 0; j < TILE_COL; j++) {
                if(this.tile[i][j].getCrop() != null){
                    this.tile[i][j].getCrop().setWithered(this.tile[i][j], this.tile[i][j].getCrop().checkStatus(this.day));
                    this.tile[i][j].getCrop().resetWater();
                }
                    
            }
        }
    }
    
    /**
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

    /**
     * Checks all the plantable tiles in the farm if they
     * contain a crop.
     * 
     * @return false if ALL tiles do not have any crops or
     *          only withered crops, otherwise return true.
     */
    public boolean checkTilesHasPlant() {
        boolean temp = false;
        boolean temp2 = false;
        if(this.day == 1) {
            return !temp;
        }
        for(int i = 0; i < TILE_ROW; i++) {
            for(int j = 0; j < TILE_COL; j++) {
                temp = tile[i][j].checkPlanted();
                temp2 = tile[i][j].getWithered();
                if(temp && !temp2) {
                    return true;
                }
            }
        }
        return temp;
    }

    /**
     * Checks if all the game ending scenarios are true, will return true
     * if either of them are true and false if not.
     * 
     * @return a boolean if the game continues or not.
     */
    public boolean checkGameOver() {
        if (player.getObjectcoins() < 5 && !checkTilesHasPlant()) {
            return true;
        } 
        return false;
    }

    /**
     * Resets all the game values.
     */
    public void gameReset() {
        player.playerReset();
        this.day = 1;
        for(int i = 0; i < TILE_ROW; i++) {
            for(int j = 0; j < TILE_COL; j++) {
                tile[i][j] = new Tile();
                tile[i][j].row = i;
                tile[i][j].col = j;
            }
        }
        this.crops = new ArrayList<Crop>();
        this.crops.add(new Tulip());
        this.crops.add(new Sunflower());
        this.crops.add(new Rose());
        this.crops.add(new Carrot());
        this.crops.add(new Potato());
        this.crops.add(new Turnip());
        this.crops.add(new Mango());
        this.crops.add(new Apple());
    }

    /**
     * a getter function for the tiles in play
     * 
     * @return the tile inside the farm.
     */
    public Tile[][] getTile() {
        return this.tile;
    }

    /**
     * a getter function for the current day
     * 
     * @return the current day of the game loop.
     */
    public int getCurrentDay() {
        return this.day;
    }
    
    /**
     * a getter function for the player
     * 
     * @return the player.
     */
    public Player getPlayer() {
        return this.player;
    }
}
