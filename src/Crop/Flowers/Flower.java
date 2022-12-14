package Crop.Flowers;

import Crop.Crop;
import Player.FarmerType.*;

public class Flower extends Crop{
    /** 
    * Flower subclass constructor.
    */
    public Flower(int plantDay){
        super(plantDay);
        this.cropType = "Flower";
    }
    public Flower() {
        this.cropType = "Flower";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double computeFinalPrice(Farmer farmer){ //adds the Flower crop type multiplier.
        this.finalPrice = (computeHarvestTotal(farmer) + computeWaterBonus(farmer) + computeFertBonus(farmer)) * 1.1;
        return Math.round(this.finalPrice * 100.0) / 100.0;
	}
}
