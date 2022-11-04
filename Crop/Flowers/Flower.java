package Crop.Flowers;

import Crop.Crop;

public class Flower extends Crop{
    public Flower(String farmerType, int plantDay){
        super(farmerType, plantDay);
        this.cropType = "Flower";
    }

    public Flower() {
        this.cropType = "Flower";
    }

    @Override
    public double computeFinalPrice(){
        this.finalPrice = (computeHarvestTotal() + computeWaterBonus() + computeFertBonus()) * 1.1;
        return Math.round(this.finalPrice * 100.0) / 100.0;
	}
}
