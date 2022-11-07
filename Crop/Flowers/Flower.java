package Crop.Flowers;

import Crop.Crop;
import Player.FarmerType.*;

public class Flower extends Crop{
    /** 
    * Flower class constructor.
    */
    public Flower(int plantDay){
        super(plantDay);
        this.cropType = "Flower";
    }
    public Flower() {
        this.cropType = "Flower";
    }

    /**
	 * Overrides <code>computeFinalPrice()</code> in <code>Crop</code>.
     * <p>
     * Computes the final price of the harvested crop by adding the
	 * water and fertilizer bonuses to the initial harvest total and
     * adds the Flower crop type multiplier.
	 *
	 * @return the final harvest price.
     * @see Crop.Crop.#computeFinalPrice(Farmer farmer)
	 */
    @Override
    public double computeFinalPrice(Farmer farmer){
        this.finalPrice = (computeHarvestTotal(farmer) + computeWaterBonus(farmer) + computeFertBonus(farmer)) * 1.1;
        return Math.round(this.finalPrice * 100.0) / 100.0;
	}
}
