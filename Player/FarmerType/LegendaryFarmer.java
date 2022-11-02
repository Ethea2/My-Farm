package Player.FarmerType;

public class LegendaryFarmer extends Farmer{
    private int levelRequirement = 15;
    private int bonusEarnings = 4;
    private int seedCostReduction = 3;
    private int waterBonusIncrease = 2;
    private int fertilizerBonus = 1;
    private int registrationFee = 400; 
    private String farmerType = "Legendary Farmer";

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
