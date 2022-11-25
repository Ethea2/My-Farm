package Crop.Flowers;

public class Rose extends Flower{
    /** 
    * Rose class constructor.
    */
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
        
        this.seedCost = 5;
        this.basePrice = 5;

        this.expYield = 2.5;
    }
    public Rose() {
        this.cropName = "Rose";
    }

    @Override
    public char getStage(int currentDay){
        switch(currentDay-this.plantDay){
            case 1:
                return 'h';
            default:
                return '0';
        }
    }
}
