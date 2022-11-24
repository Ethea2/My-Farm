package Player;

import java.util.ArrayList;

import Crop.Crop;
import Player.FarmerType.*;
import Player.Tools.*;
import Player.MyFarm;

/*
 * The player class are where most of the player related functions are in. Functions such as leveling up,
 * registering the farmertype, increasing the objectcoins, and more...
 */

public class Player {
    private int objectCoin;
    private double experience;
    private Farmer farmerType;
    private int level;
    private ArrayList<Tools> tools;

    /*
     * The constructor for the player class.
     */
    public Player() {
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
            this.objectCoin -= (cropSeed.getSeedCost() - farmerType.getSeedCostReduction()); // on a successful
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
            System.out.println("");
        } else {
            Crop crop = tile.getCrop(); // stores the tile's crop reference
            String status = crop.checkStatus(currentDay);
            if (status.equals("harvestable")) {
                this.objectCoin += crop.computeFinalPrice(farmerType);
                this.experience += crop.getExpYield();
                tile.harvest(currentDay);
                System.out.println("The crop was successfully harvested.");
                System.out.println("Yield: " + crop.getYield());
                System.out.println("Objectcoins Gained: " + crop.getFinalPrice());
                System.out.println("Experience Gained: " + crop.getExpYield());
            } else if (status.equals("withered")) {
                tile.cropWithered();
                System.out.println("The crop has withered.");
            } else if (status.equals("growing")) {
                System.out.println("This crop is still growing and is unharvestable.");
            }
        }

    }

    /*
     * The levelUp function checks the level of the farmer and computes if
     * the farmer is eligible for a level up.
     */
    public void levelUp() {
        int temp = this.level;
        this.level = (int) this.experience / 100;
        if (this.level == temp) {
            System.out.println("You were unable to level up due to the lack of experience.");
        } else if (this.level != temp) {
            System.out.println(String.format("You have leveled up to %d!", this.level));
        }
    }

    /*
     * The register function decides whether the farmer is eligible to register for
     * a new farmer type. If the farmer is eligible, he can then register for the 
     * farmer type he's aiming.
     * 
     * @param choice    the choice of the user on what farmer type
     */
    public void register(int choice) {
        if (choice == 1 && (this.objectCoin >= 200 && level >= 5) //checks if the farmer has enough money and levels for the farmer upgrade
                && !this.farmerType.getFarmerType().equals("Registered Farmer")) { // checks if the farmer is already a registered farmer
            this.farmerType = new RegisteredFarmer();
            this.objectCoin -= 200;
            System.out.println("You have successfully become a Registered Farmer");
        } else if (choice == 1 && !(this.objectCoin >= 200 && level >= 5)) {
            System.out.println("You are inelgible for this Registered Farmer status");
        } else if (choice == 1 && this.farmerType.getFarmerType().equals("Registered Farmer")) {
            System.out.println("You are already a Registered Farmer");
        }

        if (choice == 2 && (this.objectCoin >= 300 && level >= 10)
                && !this.farmerType.getFarmerType().equals("Distinguished Farmer")) {
            this.farmerType = new DistinguishedFarmer();
            this.objectCoin -= 300;
            System.out.println("You have successfully become a Distinguished Farmer");
        } else if (choice == 2 && !(this.objectCoin >= 300 && level >= 10)) {
            System.out.println("You are inelgible for this Distinguished Farmer status");
        } else if (choice == 2 && this.farmerType.getFarmerType().equals("Distinguished Farmer")) {
            System.out.println("You are already a Distinguished Farmer...");
        }

        if (choice == 3 && (this.objectCoin >= 400 && level >= 15)
                && !this.farmerType.getFarmerType().equals("Legendary Farmer")) {
            this.farmerType = new LegendaryFarmer();
            this.objectCoin -= 400;
            System.out.println("You have successfully become a Legendary Farmer");
        } else if (choice == 3 && !(this.objectCoin >= 400 && level >= 15)) {
            System.out.println("You are inelgible for this Legendary Farmer status");
        } else if (choice == 3 && this.farmerType.getFarmerType().equals("Legendary Farmer")) {
            System.out.println("You are already a Legendary Farmer");
        }
    }

    // GETTERS

    /*
     * The getter function for the level of the player.
     * 
     * @return level    the level of the player
     */
    public int getLevel() {
        return this.level;
    }

    /*
     * The getter function for the experience of the player
     * 
     * @return experience   the experience of the player
     */
    public double getExperience() {
        return this.experience;
    }

    /*
     * The getter function for the farmer type. 
     * 
     * @return farmerType   the current farmer type of the player.
     */
    public Farmer getFarmerType() {
        return this.farmerType;
    }

    /*
     * The getter function for objectCoins.
     * 
     * @return objectCoin   the player's current object coin amount
     */
    public double getObjectcoins() {
        return this.objectCoin;
    }

    // Subtract

    /*
     * The subtractObjectcoins function basically subtracts the amount of cost to the 
     * current amount of objectCoins
     * 
     * @param cost  the cost of transaction.
     */
    public void subtractObjectcoins(double cost) {
        this.objectCoin -= cost;
    }

    // Add

    /*
     * addObjectcoins adds to the current object coins of the player
     * depending on the gains input.
     * 
     * @param gain  the player's gain from the transaction
     */
    public void addObjectcoins(double gain) {
        this.objectCoin += gain;
    }

    /*
     * The addExperience function appends the gained experience to the current
     * overall experience of the player.
     * 
     * @param gain  the player's gain from the transaction
     */
    public void addExperience(double gain) {
        this.experience += gain;
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