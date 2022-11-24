package Crop.FruitTrees;

public class Mango extends FruitTree {
    /** 
    * Mango class constructor.
    */
    public Mango(int plantDay){
        super(plantDay);
        this.cropName = "Mango";
        this.harvestTime = 10;

        this.waterNeeds = 7;
        this.waterBonusLimit = 7;
        this.fertNeeds = 4;
        this.fertBonusLimit = 4;

        this.yieldMin = 5;
        this.yieldMax = 15;
        
        this.seedCost = 100;
        this.basePrice = 8;

        this.expYield = 25;
    }
    public Mango() {
        this.cropName = "Mango";
    }
}
