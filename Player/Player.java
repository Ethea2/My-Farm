package Player;

import Crop.Crop;
import Player.FarmerType.*;
import Player.Tools.*;

public class Player{
	private double objectCoin;
	private double experience;
    private FarmerType farmerType = new Farmer();
	private int level;
    private Tools tool;

	public Player(){
		
	}

	//METHODS
	public void buySeed(Tile tile, int plantDay){
        Crop crop = new Crop(this.farmerType.getBonusEarnings(), plantDay);//change parameters
        tile.plantCrop(crop);
		//subtract seedCost from Objectcoins and account for any seed cost reductions
    }

	public void harvestTile(Tile tile){
        Crop crop = tile.getCrop();
        this.experience += crop.getExpYield();
	}

	//replace values with appropriate variables
	public void register(){
        if(objectCoin >= 200 && level >= 5)
            this.farmerType = new RegisteredFarmer();
        else if(objectCoin >= 300 && level >= 10)
            this.farmerType = new DistinguishedFarmer();
        else if(objectCoin >= 400 && level >= 15)
            this.farmerType = new LegendaryFarmer();
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