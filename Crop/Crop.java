package Crop;

import Player.FarmerType.Farmer;

public class Crop{
	protected String cropName;
	protected String cropType;

	protected int plantDay;
	protected int harvestTime;
	
	protected int waterNeeds;
	protected int waterBonusLimit;
	protected int fertNeeds;
	protected int fertBonusLimit;

	protected int yield;
	protected int yieldMin;
	protected int yieldMax;

	protected int seedCost;
	protected int basePrice;
	protected int harvestTotal;
	protected double finalPrice;

	protected double expYield;

	protected int waterCount = 0;	
	protected int fertCount = 0;

	//STATUS
	protected boolean withered = false;
	protected boolean harvestable = false;

	public Crop(int plantDay){
		this.plantDay = plantDay;
	}

    public Crop() {
        
    }

	//METHODS
	public String checkStatus(int currentDay){
		if((currentDay - this.plantDay) == this.harvestTime){
			if((this.waterCount >= this.waterNeeds) && this.fertCount >= this.fertNeeds){
				this.harvestable = true;
				return "harvestable";
			}
			else{
				this.withered = true;
				return "withered";
			}
		}
		else if((currentDay - this.plantDay) > this.harvestTime){
			this.withered = true;
			return "withered";
		}

		if(this.withered == true)
			this.harvestable = false;

		return "growing";
	}

	public int randomizeYield(){
		return this.yield = (int) ((Math.random() * (this.yieldMax - this.yieldMin)) + this.yieldMin);
	}

	public double computeHarvestTotal(){
		return this.harvestTotal = (randomizeYield() * (this.basePrice));
		//return this.harvestTotal = randomizeYield() * (this.basePrice + earningBonus);
			//change "earningBonus" with method for getting FarmerType multipliers
	}

	public double computeWaterBonus(Farmer farmer){
        int actualBonus = this.waterBonusLimit + farmer.getWaterBonusIncrease();
		if(this.waterCount > actualBonus)
			this.waterCount = actualBonus;

		double waterBonus = this.harvestTotal * 0.2 * (this.waterCount - 1);
		return waterBonus;
	}

	public double computeFertBonus(Farmer farmer){
        int actualLimit = this.fertBonusLimit + farmer.getFertilizerBonus();
		if(this.fertCount > actualLimit)
			this.fertCount = actualLimit;

		double fertBonus = this.harvestTotal * 0.5 * this.fertCount;
		return fertBonus;
	}

	public double computeFinalPrice(Farmer farmer){
		this.finalPrice = computeHarvestTotal() + computeWaterBonus(farmer) + computeFertBonus(farmer) + farmer.getBonusEarnings();
		return Math.round(this.finalPrice * 100.0) / 100.0;
	}

    public double getExpYield() {
        return this.expYield;
    }

	//GETTERS
	public String getCropName(){
		return this.cropName;
	}

	public String getCropType(){
		return this.cropType;
	}

	public double getFinalPrice(){
		return this.finalPrice;
	}

	public int getWaterCount(){
		return this.waterCount;
	}

	public int getFertCount(){
		return this.fertCount;
	}

	public int getPlantDay(){
		return this.plantDay;
	}

	public boolean getHarvestable(){
		return this.harvestable;
	}

	public boolean getWithered(){
		return this.withered;
	}

	public int getHarvestTotal(){
		return this.harvestTotal;
	}

	public int getYield(){
		return this.yield;
	}

    public int getSeedCost() {
        return this.seedCost;
    }

	//"SETTERS"
	public void addWater(){
		this.waterCount = this.waterCount + 1;
        System.out.println("The crop was successfully watered!");
	}

	public void addFert(){
		this.fertCount = this.fertCount + 1;
        System.out.println("The crop was successfully fertilized!");
	}
}