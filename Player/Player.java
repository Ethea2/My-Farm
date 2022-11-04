package Player;

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
		
	}

	public void buySeed(Tile tile, int plantDay){
        Crop crop = new Crop(this.farmerType.getBonusEarnings(), plantDay);
        tile.plantCrop(crop);
    }

	public void harvestTile(Tile tile){
        Crop crop = tile.getCrop();
        this.experience += crop.getExpYield();
	}


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