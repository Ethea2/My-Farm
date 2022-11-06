import java.util.ArrayList;

import Crop.Crop;
import Crop.Flowers.*;
import Crop.RootCrops.*;
import Player.Player;
import Player.Tile;

public class MyFarm {
    private int day;
    private Tile tile;
    private ArrayList<Crop> crops;

    /*
     * The constructor method for the MyFarm class. Initializing all the necessary requirements.
     */
    public MyFarm() {
        this.day = 1;
        this.tile = new Tile();
        this.crops = new ArrayList<Crop>();
        this.crops.add(new Tulip());
        this.crops.add(new Sunflower());
        this.crops.add(new Rose());
        this.crops.add(new Carrot());
        this.crops.add(new Potato());
        this.crops.add(new Turnip());
    }

    /*
     * The advanceDay function increases the day count.
     */
    public void advanceDay() {
        this.day++;
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
    public boolean checkGameOver(Player player) {
        if (player.getObjectcoins() < 5) {
            return true;
        } 
        else if (!tile.checkPlanted()) {
            return true;
        }
        return false;
    }

    /*
     * basically resetting all the game values.
     */
    public void gameReset(Player player) {
        player.playerReset();
        this.day = 1;
        this.tile = new Tile();
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
    public Tile getTile() {
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
}
