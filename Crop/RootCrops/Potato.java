package Crop.RootCrops;

public class Potato extends RootCrop{
    /** 
    * Potato class constructor.
    */
    public Potato(int plantDay){
        super(plantDay);
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
    public Potato() {
        this.cropName = "Potato";
    }

    @Override
    public char getStage(int currentDay){
        switch(currentDay-this.plantDay){
            case 5:
                return 'h';
            case 4:
                return '2';
            case 3:
                return '2';
            case 2:
                return '1';
            case 1:
                return '1';
            default:
                return '0';
        }
    }
}
