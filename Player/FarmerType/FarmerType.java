package Player.FarmerType;

public class FarmerType {
    protected int levelRequirement;
    protected int bonusEarnings;
    protected int seedCostReduction;
    protected int waterBonusIncrease;
    protected int fertilizerBonus;
    protected int registrationFee;
    protected String farmerType;

    public FarmerType(){
        
    }

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