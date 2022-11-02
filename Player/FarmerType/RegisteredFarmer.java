package Player.FarmerType;

public class RegisteredFarmer extends Farmer {
    private int levelRequirement = 5;
    private int bonusEarnings = 1;
    private int seedCostReduction = 1;
    private int waterBonusIncrease = 0;
    private int fertilizerBonus = 0;
    private int registrationFee = 200; 
    private String farmerType = "Registered Farmer";

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
