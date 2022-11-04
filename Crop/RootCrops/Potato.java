package Crop.RootCrops;

public class Potato extends RootCrop{
    public Potato(int earningBonus, int plantDay){
        super(earningBonus, plantDay);
        this.cropName = "Potato";
        this.harvestTime = 5;

        this.waterNeeds = 3;
        this.waterBonusLimit = 4;
        this.fertNeeds = 1;
        this.fertBonusLimit = 2;

        this.yieldMin = 1;
        this.yieldMax = 10;
        
        this.seedCost = 20;
        this.basePrice = 3;

        this.expYield = 12.5;
    }
}
