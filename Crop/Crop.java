package Crop;

import Player.MyFarm;
import Player.Tile;
import Player.FarmerType.Farmer;
import java.awt.image.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Gui.GuiTile;

public class Crop {
	protected String cropName;
	protected String cropType;

	protected int plantDay;
	protected int harvestTime;

	protected int waterNeeds;
	protected int waterBonusLimit;
	protected int fertNeeds;
	protected int fertBonusLimit;

	protected int yield;
	protected int yieldMin;
	protected int yieldMax;

	protected int seedCost;
	protected int basePrice;
	protected int harvestTotal;
	protected double finalPrice;

	protected double expYield;

	protected int waterCount = 0;
	protected int fertCount = 0;

    public GuiTile guiTiles[];

	// STATUS
	protected boolean withered = false;
	protected boolean harvestable = false;
    protected boolean watered = false;

	protected String stage;

	public Crop(int plantDay) {
		this.plantDay = plantDay;
	}

	/** 
    * Crop class constructor.
    */
	public Crop() {

	}

	//METHODS
	/**
	 * Returns a string describing the state of the crop, i.e. "growing",
	 * "harvestable", or "withered".
	 *
	 * @param currentDay the current day in the farm
	 * @return the status of this crop
	 */
	public String checkStatus(int currentDay) {
		if ((currentDay - this.plantDay) == this.harvestTime) {
			if ((this.waterCount >= this.waterNeeds) && this.fertCount >= this.fertNeeds) {
				this.harvestable = true;
				return "harvestable";
			} else {
				this.withered = true;
				return "withered";
			}
		} else if ((currentDay - this.plantDay) > this.harvestTime) {
			this.withered = true;
			return "withered";
		}

		if (this.withered == true)
			this.harvestable = false;

		return "growing";
	}

    public void loadImages() {
        
    }

    public void setWithered(Tile tile, String status) {
        if(status == "withered") {
            tile.cropWithered();
        }
    }

	/**
	 * Generates a random int based on the minimum and maximum yield
	 * of the crop to determine it's yield upon harvest.
	 *
	 * @return the randomly generated yield of this crop
	 */
	public int randomizeYield() {
		return this.yield = (int) ((Math.random() * (this.yieldMax - this.yieldMin)) + this.yieldMin + 1);
	}

	/**
	 * Computes the initial price of the harvest based on the yield,
	 * crop's base price, and farmer type's earning bonus.
	 *
	 * @return this crop's intial harvest total
	 */
	public double computeHarvestTotal(Farmer farmer) {
		return this.harvestTotal = (randomizeYield() * (this.basePrice + farmer.getBonusEarnings()));
	}

	/**
	 * Computes the bonus the player has earned for watering the crop
	 * extra times, if any.
	 *
	 * @return this crop's water bonus
	 */
	public double computeWaterBonus(Farmer farmer) {
		int actualBonus = this.waterBonusLimit + farmer.getWaterBonusIncrease();
		if (this.waterCount > actualBonus)
			this.waterCount = actualBonus;

		double waterBonus = this.harvestTotal * 0.2 * (this.waterCount - 1);
		return waterBonus;
	}

	/**
	 * Computes the bonus the player has earned for fertilizing the crop
	 * extra times, if any.
	 *
	 * @return this crop's fertilizer bonus
	 */
	public double computeFertBonus(Farmer farmer) {
		int actualLimit = this.fertBonusLimit + farmer.getFertilizerBonus();
		if (this.fertCount > actualLimit)
			this.fertCount = actualLimit;

		double fertBonus = this.harvestTotal * 0.5 * this.fertCount;
		return fertBonus;
	}

	/**
	 * Computes the final price of the harvested crop by adding the
	 * water and fertilizer bonuses to the initial harvest total.
	 *
	 * @return this crop's final harvest price
	 */
	public double computeFinalPrice(Farmer farmer) {
		this.finalPrice = computeHarvestTotal(farmer) + computeWaterBonus(farmer) + computeFertBonus(farmer);
		return Math.round(this.finalPrice * 100.0) / 100.0;
	}

	public boolean canPlant(int x, int y, MyFarm farm){
		return true;
	}
	

	//GETTERS

	/** 
	 * Gets this crop's name.
	 * @return this crop's name
	 */
	public String getCropName() {
		return this.cropName;
	}

	/** 
	 * Gets this crop's type, i.e. "RootCrop", "Flower", or "Tree".
	 * @return this crop's type
	 */
	public String getCropType() {
		return this.cropType;
	}

	/** 
	 * Gets the computed final price of this crop.
	 * @return this crop's final price
	 */
	public double getFinalPrice() {
		return this.finalPrice;
	}

	/** 
	 * Gets the amount of times this crop has been watered.
	 * @return this crop's water count
	 */
	public int getWaterCount() {
		return this.waterCount;
	}

	/** 
	 * Gets the amount of times this crop has been fertilized.
	 * @return this crop's fertilizer count
	 */
	public int getFertCount() {
		return this.fertCount;
	}

	/** 
	 * Gets the day this crop was planted.
	 * @return this crop's plant day
	 */
	public int getPlantDay() {
		return this.plantDay;
	}

	/** 
	 * Gets the days it takes for the plant to be
	 * ready for harvest.
	 * @return this crop's harvest time
	 */
	public int getHarvestTime(){
		return this.harvestTime;
	}

	/** 
	 * Checks if this crop is harvestable or not.
	 * @return this crop's harvestable status
	 */
	public boolean getHarvestable() {
		return this.harvestable;
	}

	/** 
	 * Checks if this crop is withered or not
	 * @return this crop's withered status
	 */
	public boolean getWithered() {
		return this.withered;
	}

	/** 
	 * Gets the crop's initial harvest price before the added
	 * water and fertilizer bonuses.
	 * @return this crop's inital harvest total
	 */
	public int getHarvestTotal() {
		return this.harvestTotal;
	}

	/** 
	 * Gets the yield this crop's harvest has produced.
	 * @return this crop's yield
	 */
	public int getYield() {
		return this.yield;
	}

	/** 
	 * Gets the cost of planting this crop's seed.
	 * @return the cost of this crop's seed
	 */
	public int getSeedCost() {
		return this.seedCost;
	}

	/** 
	 * Gets the experience the player earns from harvesting this crop.
	 * @return the experience gained from this crop.
	 */
	public double getExpYield() {
		return this.expYield;
	}

    public BufferedImage setImage(int currentDay) {
        return this.guiTiles[0].image;
    }

	public char getStage(int currentDay){
		return '0';
	}

	// "SETTERS"

	/** 
	 * Adds water to this crop's water count.
	 */
	public boolean addWater() {
        if(watered) {
            JOptionPane.showMessageDialog(null, "The crop has already been watered today.", "Water error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        this.waterCount = this.waterCount + 1;
        this.watered = true;
        return true;
	}

    public void resetWater() {
        this.watered = false;
    }

	/** 
	 * Adds fertilizer to this crop's fertilizer water count.
	 */
	public void addFert() {
		this.fertCount = this.fertCount + 1;
		JOptionPane.showMessageDialog(null, "This tile was successfully fertilized!", "Fertilize Success!", JOptionPane.WARNING_MESSAGE);
	}
}