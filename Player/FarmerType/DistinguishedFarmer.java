package Player.FarmerType;

public class DistinguishedFarmer extends Farmer{
    private int levelRequirement = 10;
    private int bonusEarnings = 2;
    private int seedCostReduction = 2;
    private int waterBonusIncrease = 1;
    private int fertilizerBonus = 0;
    private int registrationFee = 300; 
    private String farmerType = "Distinguished Farmer";

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
