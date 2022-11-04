package Player.FarmerType;

public class Farmer {
    protected int levelRequirement = 0;
    protected int bonusEarnings = 0;
    protected int seedCostReduction = 0;
    protected int waterBonusIncrease = 0;
    protected int fertilizerBonus = 0;
    protected int registrationFee = 0; 
    protected String farmerType = "Farmer";

    public int getLevelRequirement() {
        return this.levelRequirement;
    }
    public int getBonusEarnings() {
        return this.bonusEarnings;
    }
    public int getSeedCostReduction() {
        return this.seedCostReduction;
    }
    public int getWaterBonusIncrease() {
        return this.waterBonusIncrease;
    }
    public int getFertilizerBonus() {
        return this.fertilizerBonus;
    }
    public int getRegistrationFee() {
        return this.registrationFee;
    }
    public String getFarmerType() {
        return this.farmerType;
    }
}
