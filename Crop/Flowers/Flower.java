package Crop.Flowers;

import Crop.Crop;
import Player.FarmerType.*;

public class Flower extends Crop{
    public Flower(int plantDay){
        super(plantDay);
        this.cropType = "Flower";
    }

    public Flower() {
        this.cropType = "Flower";
    }

    @Override
    public double computeFinalPrice(Farmer farmer){
        this.finalPrice = (computeHarvestTotal() + computeWaterBonus(farmer) + computeFertBonus(farmer)) * 1.1;
        return Math.round(this.finalPrice * 100.0) / 100.0;
	}
}
