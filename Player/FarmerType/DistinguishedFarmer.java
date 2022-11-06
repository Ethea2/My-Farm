package Player.FarmerType;

/*
 * This class represents the type of the Farmer
 */

public class DistinguishedFarmer extends Farmer {
    // Constructor of Distinguished farmer.
    public DistinguishedFarmer() {
        this.levelRequirement = 10;
        this.bonusEarnings = 2;
        this.seedCostReduction = 2;
        this.waterBonusIncrease = 1;
        this.fertilizerBonus = 0;
        this.registrationFee = 300;
        this.farmerType = "Distinguished Farmer";
    }
}
