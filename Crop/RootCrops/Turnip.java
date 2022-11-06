package Crop.RootCrops;

public class Turnip extends RootCrop{
    /** 
    * Turnip class constructor.
    */
    public Turnip(int plantDay){
        super(plantDay);
        this.cropName = "Turnip";
        this.harvestTime = 2;

        this.waterNeeds = 1;
        this.waterBonusLimit = 2;
        this.fertNeeds = 0;
        this.fertBonusLimit = 1;

        this.yieldMin = 1;
        this.yieldMax = 2;

        this.expYield = 5;
        
        this.seedCost = 5;
        this.basePrice = 6;

        this.expYield = 5;
    }
    public Turnip() {
        this.cropName = "Turnip";
    }
}