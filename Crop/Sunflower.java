package Crop;

public class Sunflower extends Flower{
    public Sunflower(String farmerType, int plantDay){
        super(farmerType, plantDay);
        this.cropName = "Sunflower";
        this.harvestTime = 3;

        this.waterNeeds = 2;
        this.waterBonusLimit = 3;
        this.fertNeeds = 1;
        this.fertBonusLimit = 2;

        this.yieldMin = 1;
        this.yieldMax = 1;
        
        this.seedCost = 20;
        this.basePrice = 19;

        this.expYield = 7.5;
    }
}
