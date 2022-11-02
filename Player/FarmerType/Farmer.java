package Player.FarmerType;

public class Farmer {
    private int levelRequirement = 0;
    private int bonusEarnings = 0;
    private int seedCostReduction = 0;
    private int waterBonusIncrease = 0;
    private int fertilizerBonus = 0;
    private int registrationFee = 0; 
    private String farmerType = "Farmer";

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
