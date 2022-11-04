package Player;

import java.util.ArrayList;

import Crop.Crop;
import Player.FarmerType.DistinguishedFarmer;
import Player.FarmerType.Farmer;
import Player.FarmerType.LegendaryFarmer;
import Player.FarmerType.RegisteredFarmer;
import Player.Tools.Tools;

public class Player{
	private int objectCoin;
	private double experience;
    private Farmer farmerType = new Farmer();
	private int level;
    private Tools tool;

	public Player(){
        this.objectCoin = 100;
        this.experience = 0;
	}

	public void buySeed(Tile tile, int plantDay, Crop cropSeed){
        tile.plantCrop(cropSeed);
    }

	public void harvestTile(Tile tile){
        Crop crop = tile.getCrop();
        this.objectCoin += crop.computeFinalPrice();
        this.experience += crop.getExpYield();
	}


	public void register(){
        if(this.objectCoin >= 200 && level >= 5) {
            this.farmerType = new RegisteredFarmer();
            this.objectCoin -= 200;
        }
        else if(this.objectCoin >= 300 && level >= 10) {
            this.farmerType = new DistinguishedFarmer();
            this.objectCoin -= 300;
        }
        else if(this.objectCoin >= 400 && level >= 15){
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

	public double getObjectcoins(){
		return this.objectCoin;
	}
}