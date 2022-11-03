package Crop;

public class Tulip extends Flower{
    public Tulip(String farmerType, int plantDay){
        super(farmerType, plantDay);
        this.cropName = "Tulip";
        this.harvestTime = 2;

        this.waterNeeds = 2;
        this.waterBonusLimit = 3;
        this.fertNeeds = 0;
        this.fertBonusLimit = 1;

        this.yieldMin = 1;
        this.yieldMax = 1;
        
        this.seedCost = 10;
        this.basePrice = 9;

        this.expYield = 5;
    }
}