package Crop.Flowers;

public class Tulip extends Flower{
    /** 
    * Tulip class constructor.
    */
    public Tulip(int plantDay){
        super(plantDay);
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
    public Tulip() {
        this.cropName = "Tulip";
    }

    @Override
    public char getStage(int currentDay){
        switch(currentDay-this.plantDay){
            case 2:
                return 'h';
            case 1:
                return '1';
            default:
                return '0';
        }
    }
}
