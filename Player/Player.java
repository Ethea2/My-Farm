package Player;

import Crop.Crop;
import Player.FarmerType.*;
import Player.Tools.*;

public class Player{
	private int objectCoin;
	private double experience;
    private Farmer farmerType;
	private int level;

	public Player(){
        this.objectCoin = 100;
        this.experience = 0;
        this.level = 0;
        this.farmerType = new Farmer();
	}

	public void buySeed(Tile tile, int plantDay, Crop cropSeed){
        tile.plantCrop(cropSeed);
        this.objectCoin -= (cropSeed.getSeedCost() - farmerType.getSeedCostReduction());
    }

	public void harvestTile(Tile tile, int currentDay){
        Crop crop = tile.getCrop();
        String status = crop.checkStatus(currentDay);
        if(status.equals("harvestable")) {
            this.objectCoin += crop.computeFinalPrice(farmerType);
            this.experience += crop.getExpYield();
            System.out.println("The crop was successfully harvested.");
        }
        else if(status.equals("withered")) {
            tile.cropWithered();
            System.out.println("The crop has withered.");
        }
        else if(status.equals("growing")) {
            System.out.println("This crop is still growing and is unharvestable.");
        }
	}

    public void levelUp() {
        int temp = this.level;
        this.level = (int) this.experience / 100;
        if(this.level == temp) {
            System.out.println("You are still the same level.");
        }
        else if(this.level != temp) {
            System.out.println(String.format("You have leveled up to %d!", this.level));
        }
    }

	public void register(int choice){
        if(choice == 1 && (this.objectCoin >= 200 && level >= 5)) {
            this.farmerType = new RegisteredFarmer();
            this.objectCoin -= 200;
        }
        else if(choice == 2 && (this.objectCoin >= 300 && level >= 10)) {
            this.farmerType = new DistinguishedFarmer();
            this.objectCoin -= 300;
        }
        else if(choice == 3 && (this.objectCoin >= 400 && level >= 15)){
            this.farmerType = new LegendaryFarmer();
            this.objectCoin -= 400;
        }
        else
            System.out.println("You are ineligble for any farmer registration");
    }

	//GETTERS
	public int getLevel(){
		return this.level;
	}

	public double getExperience(){
		return this.experience;
	}

    public Farmer getFarmerType() {
        return this.farmerType;
    }

	public double getObjectcoins(){
		return this.objectCoin;
	}

    //Subtract
    public void subtractObjectcoins(double cost) {
        this.objectCoin -= cost;
    }
    
    //Add
    public void addObjectcoins(double gain) {
        this.objectCoin += gain;
    }
    public void addExperience(double gain) {
        this.experience += gain;
    }
}