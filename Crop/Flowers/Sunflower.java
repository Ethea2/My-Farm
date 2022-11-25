package Crop.Flowers;

public class Sunflower extends Flower{
    /** 
    * Sunflower class constructor.
    */
    public Sunflower(int plantDay){
        super(plantDay);
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
    public Sunflower() {
        this.cropName = "Sunflower";
    }

    @Override
    public char getStage(int currentDay){
        switch(currentDay-this.plantDay){
            case 3:
                return 'h';
            case 2:
                return '1';
            case 1:
                return '1';
            default:
                return '0';
        }
    }
}
