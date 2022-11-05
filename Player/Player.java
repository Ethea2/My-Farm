package Player;

import Crop.Crop;
import Player.FarmerType.*;
import Player.Tools.*;

public class Player {
    private int objectCoin;
    private double experience;
    private Farmer farmerType;
    private int level;

    public Player() {
        this.objectCoin = 10000;
        this.experience = 12300;
        this.level = 0;
        this.farmerType = new Farmer();
    }

    public void buySeed(Tile tile, int plantDay, Crop cropSeed) {
        if (tile.plantCrop(cropSeed)) {
            this.objectCoin -= (cropSeed.getSeedCost() - farmerType.getSeedCostReduction());
        }
    }

    public void harvestTile(Tile tile, int currentDay) {
        if (tile.getCrop() == null) {
            System.out.println("");
        } else {
            Crop crop = tile.getCrop();
            String status = crop.checkStatus(currentDay);
            if (status.equals("harvestable")) {
                this.objectCoin += crop.computeFinalPrice(farmerType);
                this.experience += crop.getExpYield();
                tile.harvest(currentDay);
                System.out.println("The crop was successfully harvested.");
            } else if (status.equals("withered")) {
                tile.cropWithered();
                System.out.println("The crop has withered.");
            } else if (status.equals("growing")) {
                System.out.println("This crop is still growing and is unharvestable.");
            }
        }

    }

    public void levelUp() {
        int temp = this.level;
        this.level = (int) this.experience / 100;
        if (this.level == temp) {
            System.out.println("You were unable to level up due to the lack of experience.");
        } else if (this.level != temp) {
            System.out.println(String.format("You have leveled up to %d!", this.level));
        }
    }

    public void register(int choice) {
        if (choice == 1 && (this.objectCoin >= 200 && level >= 5) && !this.farmerType.getFarmerType().equals("Registered Farmer")) {
            this.farmerType = new RegisteredFarmer();
            this.objectCoin -= 200;
            System.out.println("You have successfully become a Registered Farmer");
        } 
        else if (choice == 1 && !(this.objectCoin >= 200 && level >= 5)){
            System.out.println("You are inelgible for this Registered Farmer status");
        }
        else if (choice == 1 && this.farmerType.getFarmerType().equals("Registered Farmer")) {
            System.out.println("You are already a Registered Farmer");
        }


        if (choice == 2 && (this.objectCoin >= 300 && level >= 10) && !this.farmerType.getFarmerType().equals("Distinguished Farmer")) {
            this.farmerType = new DistinguishedFarmer();
            this.objectCoin -= 300;
            System.out.println("You have successfully become a Distinguished Farmer");
        } 
        else if (choice == 2 && !(this.objectCoin >= 300 && level >= 10)) {
            System.out.println("You are inelgible for this Distinguished Farmer status");
        }
        else if (choice == 2 && this.farmerType.getFarmerType().equals("Distinguished Farmer")) {
            System.out.println("You are already a Distinguished Farmer...");
        }


        if (choice == 3 && (this.objectCoin >= 400 && level >= 15) && !this.farmerType.getFarmerType().equals("Legendary Farmer")) {
            this.farmerType = new LegendaryFarmer();
            this.objectCoin -= 400;
            System.out.println("You have successfully become a Legendary Farmer");
        }
        else if (choice == 3 && !(this.objectCoin >= 400 && level >= 15)) {
            System.out.println("You are inelgible for this Legendary Farmer status");
        }
        else if (choice == 3 && this.farmerType.getFarmerType().equals("Legendary Farmer")) {
            System.out.println("You are already a Legendary Farmer");
        }
    }

    // GETTERS
    public int getLevel() {
        return this.level;
    }

    public double getExperience() {
        return this.experience;
    }

    public Farmer getFarmerType() {
        return this.farmerType;
    }

    public double getObjectcoins() {
        return this.objectCoin;
    }

    // Subtract
    public void subtractObjectcoins(double cost) {
        this.objectCoin -= cost;
    }

    // Add
    public void addObjectcoins(double gain) {
        this.objectCoin += gain;
    }

    public void addExperience(double gain) {
        this.experience += gain;
    }
}