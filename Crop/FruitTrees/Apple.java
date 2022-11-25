package Crop.FruitTrees;

public class Apple extends FruitTree {
    /** 
    * Mango class constructor.
    */
    public Apple(int plantDay){
        super(plantDay);
        this.cropName = "Apple";
        this.harvestTime = 10;

        this.waterNeeds = 7;
        this.waterBonusLimit = 7;
        this.fertNeeds = 5;
        this.fertBonusLimit = 5;

        this.yieldMin = 10;
        this.yieldMax = 15;
        
        this.seedCost = 200;
        this.basePrice = 5;

        this.expYield = 25;
    }
    public Apple() {
        this.cropName = "Apple";
    }
}
