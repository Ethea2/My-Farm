package Player.FarmerType;

public class RegisteredFarmer extends Farmer {
    public RegisteredFarmer() {
        this.levelRequirement = 5;
        this.bonusEarnings = 1;
        this.seedCostReduction = 1;
        this.waterBonusIncrease = 0;
        this.fertilizerBonus = 0;
        this.registrationFee = 200; 
        this.farmerType = "Registered Farmer";
    }
}
