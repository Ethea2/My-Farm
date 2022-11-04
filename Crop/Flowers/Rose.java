package Crop.Flowers;

public class Rose extends Flower{
    public Rose(int plantDay){
        super(plantDay);
        this.cropName = "Rose";
        this.harvestTime = 1;

        this.waterNeeds = 1;
        this.waterBonusLimit = 2;
        this.fertNeeds = 0;
        this.fertBonusLimit = 1;

        this.yieldMin = 1;
        this.yieldMax = 1;
        
        this.expYield = 2.5;
        
        this.seedCost = 5;
        this.basePrice = 5;

        this.expYield = 2.5;
    }
    public Rose() {
        this.cropName = "Rose";
    }
}
