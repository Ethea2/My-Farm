package Player.FarmerType;

public class LegendaryFarmer extends Farmer {
    /**
     * The constructor for the Legendary Farmer class
     */
    public LegendaryFarmer() {
        this.levelRequirement = 15;
        this.bonusEarnings = 4;
        this.seedCostReduction = 3;
        this.waterBonusIncrease = 2;
        this.fertilizerBonus = 1;
        this.registrationFee = 400;
        this.farmerType = "Legendary Farmer";
    }
}
