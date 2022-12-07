package Player;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import Crop.Crop;
import Player.FarmerType.*;
import Player.Tools.*;
import Player.MyFarm;

/*
 * The player class are where most of the player related functions are in. Functions such as leveling up,
 * registering the farmertype, increasing the objectcoins, and more...
 */

public class Player {
    private double objectCoin;
    private double experience;
    private Farmer farmerType;
    private int level;
    private ArrayList<Tools> tools;

    /*
     * The constructor for the player class.
     */
    public Player() {
        this.objectCoin = 2000; //100
        this.experience = 1500; //0
        this.level = 15; //0
        this.farmerType = new Farmer(); //Farmer()
        tools = new ArrayList<Tools>();
        tools.add(new Shovel());
        tools.add(new WaterCan());
        tools.add(new Pickaxe());
        tools.add(new Fertilizer());
        tools.add(new Plow());
    }

    /*
     * Buying seeds automatically plants the crop seed. It also takes from the
     * player's wallet, depending on the crop price.
     * 
     * @param tile the targeted tile for planting
     * 
     * @param plantDay takes the plant day of the plant
     * 
     * @param cropSeed the crop that is going to be planted
     * 
     * @param farm the
     */
    public void buySeed(Tile tile, int plantDay, Crop cropSeed, MyFarm farm) {
        if (tile.plantCrop(cropSeed, farm)) { // The checks if the tile plant crop was successful
            subtractObjectcoins((cropSeed.getSeedCost() - farmerType.getSeedCostReduction()));
                                                                                            // on a successful
                                                                                             // planting, we subtract
                                                                                             // the seed cost with the
                                                                                             // cost reduction of t he
                                                                                             // farmer type. This will
                                                                                             // then be subtracted to
                                                                                             // tthe total of our object
                                                                                             // coins
        }
    }

    /*
     * The harvestTile function harvests the crop in the tile, this also takes into
     * consideration when the harvest time is.
     * It also checks the status of the crop whether it's withered, harvestable, or
     * growing.
     * 
     * @param tile the targeted tile for harvesting
     * 
     * @param currentDay the current day count of the farm
     */
    public void harvestTile(Tile tile, int currentDay) {
        if (tile.getCrop() == null) { // checks if the tile has a crop or not.

        } else {
            Crop crop = tile.getCrop(); // stores the tile's crop reference
            String status = crop.checkStatus(currentDay);
            if (status.equals("harvestable")) {
                addObjectcoins(crop.computeFinalPrice(farmerType));
                addExperience(crop.getExpYield());
                tile.harvest(currentDay);
                JOptionPane.showMessageDialog(null, String.format(
                        "The %s was harvested successfully!\nYield: %d\nObjectcoins Gained: %.2f\nExperience Gained: %.2f",
                        crop.getCropName(), crop.getYield(), crop.getFinalPrice(), crop.getExpYield()), "Harvest Pane",
                        JOptionPane.WARNING_MESSAGE);
            } else if (status.equals("withered")) {
                tile.cropWithered();
                showMessage("The crop has withered.");
            } else if (status.equals("growing")) {
                showMessage("This crop is still growing and is unharvestable.");
            }
        }

    }

    public void checkLevelUp(){
        int temp = (int) Math.floor(this.experience / 100);
        if(temp>this.level){
            this.level = temp;
            System.out.println("You have leveled up!");
        }
    }

    /*
     * The register function decides whether the farmer is eligible to register for
     * a new farmer type. If the farmer is eligible, he can then register for the
     * farmer type he's aiming.
     * 
     * @param choice the choice of the user on what farmer type
     */
    public void register() {
        //System.out.println("***CHECKED***");
        if(this.farmerType.getFarmerType() == "Farmer"){
            //System.out.println("***CHECKED***");
            if(this.objectCoin >= 200 && this.level >= 5){
                this.farmerType = new RegisteredFarmer();
                this.subtractObjectcoins(200);
                System.out.println("You have successfully become a Registered Farmer");
            } else{
                showMessage("You are not eligible to become a Registered Farmer.");
            }
        } else if (this.farmerType.getFarmerType() == "Registered Farmer"){
            if(this.objectCoin >= 300 && this.level >= 10){
                this.farmerType = new DistinguishedFarmer();
                this.subtractObjectcoins(300);
                System.out.println("You have successfully become a Distinguished Farmer");
            } else{
                showMessage("You are not eligible to become a Distinguished Farmer.");
            }
        } else if (this.farmerType.getFarmerType() == "Distinguished Farmer"){
            if(this.objectCoin >= 400 && this.level >= 15){
                this.farmerType = new LegendaryFarmer();
                this.subtractObjectcoins(400);
                System.out.println("You have successfully become a Legendary Farmer");
            } else{
                showMessage("You are not eligible to become a Legendary Farmer.");
            }
        } else if (this.farmerType.getFarmerType() == "Legendary Farmer"){
            showMessage("You are already the best farmer ever. There are no farmer types beyond this.");
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, " ", JOptionPane.PLAIN_MESSAGE);
    }

    // GETTERS

    /*
     * The getter function for the level of the player.
     * Player gains 1 level for every 100 experience points.
     * 
     * @return level the level of the player
     */
    public int getLevel() {
        return this.level;
    }

    /*
     * The getter function for the experience of the player
     * 
     * @return experience the experience of the player
     */
    public double getExperience() {
        return this.experience;
    }

    /*
     * The getter function for the farmer type.
     * 
     * @return farmerType the current farmer type of the player.
     */
    public Farmer getFarmerType() {
        return this.farmerType;
    }

    /*
     * The getter function for objectCoins.
     * 
     * @return objectCoin the player's current object coin amount
     */
    public double getObjectcoins() {
        return this.objectCoin;
    }

    // Subtract

    /*
     * The subtractObjectcoins function basically subtracts the amount of cost to
     * the
     * current amount of objectCoins
     * 
     * @param cost the cost of transaction.
     */
    public void subtractObjectcoins(double cost) {
        this.objectCoin -= cost;
    }

    // Add

    /*
     * addObjectcoins adds to the current object coins of the player
     * depending on the gains input.
     * 
     * @param gain the player's gain from the transaction
     */
    public void addObjectcoins(double gain) {
        this.objectCoin += gain;
    }

    /*
     * The addExperience function appends the gained experience to the current
     * overall experience of the player.
     * 
     * @param gain the player's gain from the transaction
     */
    public void addExperience(double gain) {
        this.experience += gain;
        checkLevelUp();
    }

    public Tools getTool(int index) {
        return this.tools.get(index);
    }

    /*
     * a function to reset all the player stats when the game starts again.
     */
    public void playerReset() {
        this.objectCoin = 100;
        this.experience = 0;
        this.level = 0;
        this.farmerType = new Farmer();
        tools = new ArrayList<Tools>();
        tools.add(new Shovel());
        tools.add(new WaterCan());
        tools.add(new Pickaxe());
        tools.add(new Fertilizer());
        tools.add(new Plow());
    }
}