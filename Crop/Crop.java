package Crop;

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
	protected double finalPrice;

	protected double expYield;

	protected String cropType;

	protected int waterCount = 0;	
	protected int fertCount = 0;

	//STATUS
	protected boolean withered = false;
	protected boolean harvestable = false;

	public Crop(String farmerType, int plantDay){ //replace farmerType with player?
		this.plantDay = plantDay;
	}

	public checkStatus(int currentDay){
		if((currentDay - this.plantDay) == this.harvestTime){
			if((this.waterCount >= this.waterNeeds) &&
					this.fertCount >= this.fertNeeds)
				this.harvestable = true;
			else
				this.withered = true;
		}
		else if((currentDay - this.plantDay) > this.harvestTime)
			this.withered = true;

		if(this.withered == true)
			this.harvestable = false;
	}

	public int randomizeYield(){
		return this.yield = (Math.random() * (this.yieldMax - this.yieldMin)) + this.yieldMin;
	}

	public double computeHarvestTotal(){
		return this.harvestTotal = randomizeYield() * (this.basePrice + earningBonus); //update earning bonus
	}

	public double computeWaterBonus(){
		double waterBonus = this.harvestTotal * 0.2 * (waterCount - 1);
		return waterBonus;
	}

	public double computeFertBonus(){
		double fertBonus = this.harvestTotal * 0.5 * fertCount;
		return fertBonus;
	}

	public double computeFinalPrice(){
		return this.finalPrice = this.harvestTotal + computeWaterBonus() + computeFertBonus();
	}

	//GETTERS
	public double getFinalPrice(){
		return this.finalPrice;
	}

	public int getPlantDay(){
		return this.plantDay;
	}
}