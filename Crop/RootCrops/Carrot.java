package Crop.RootCrops;

public class Carrot extends RootCrop{
    /** 
    * Carrot class constructor.
    */
    public Carrot(int plantDay){
        super(plantDay);
        this.cropName = "Carrot";
        this.harvestTime = 3;

        this.waterNeeds = 1;
        this.waterBonusLimit = 2;
        this.fertNeeds = 0;
        this.fertBonusLimit = 1;

        this.yieldMin = 1;
        this.yieldMax = 2;
        
        this.expYield = 7.5;
        
        this.seedCost = 10;
        this.basePrice = 9;

        this.expYield = 7.5;
    }
    public Carrot() {
        this.cropName = "Carrot";
    }
}