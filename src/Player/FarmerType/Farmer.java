package Player.FarmerType;

/**
 * This class is the blueprint for Farmer types available to the players
 */
public class Farmer {
    protected int levelRequirement = 0;
    protected int bonusEarnings = 0;
    protected int seedCostReduction = 0;
    protected int waterBonusIncrease = 0;
    protected int fertilizerBonus = 0;
    protected int registrationFee = 0;
    protected String farmerType = "Farmer";

    /**
     * This is a getter function for the level requirement for the farmer type.
     * 
     * @return the level requirement for the farmer type
     */
    public int getLevelRequirement() {
        return this.levelRequirement;
    }

    /**
     * This is a getter function for the bonus earnings for the farmer type.
     * 
     * @return the bonus earnings for the farmer type
     */
    public int getBonusEarnings() {
        return this.bonusEarnings;
    }

    /**
     * This is a getter function for the seed cost reduction for the farmer type.
     * 
     * @return the seed cost reduction for the farmer type
     */
    public int getSeedCostReduction() {
        return this.seedCostReduction;
    }

    /**
     * This is a getter function for the water bonus increase for the farmer type.
     * 
     * @return the water bonus increase for the farmer type
     */
    public int getWaterBonusIncrease() {
        return this.waterBonusIncrease;
    }

    /**
     * This is a getter function for the fertilizer bonus for the farmer type.
     * 
     * @return the fertilizer bonuse for the farmer type
     */
    public int getFertilizerBonus() {
        return this.fertilizerBonus;
    }

    /**
     * This is a getter function for the registration fee for the farmer type.
     * 
     * @return the registration fee required to upgrade the farmer type
     */
    public int getRegistrationFee() {
        return this.registrationFee;
    }

    /**
     * This is a getter function for the farmer type for the farmer type.
     * 
     * @return the name of the farmer type
     */
    public String getFarmerType() {
        return this.farmerType;
    }
}
