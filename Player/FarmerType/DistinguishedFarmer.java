package Player.FarmerType;

public class DistinguishedFarmer extends FarmerType{
    public DistinguishedFarmer(){
        this.levelRequirement = 10;
        this.bonusEarnings = 2;
        this.seedCostReduction = 2;
        this.waterBonusIncrease = 1;
        this.fertilizerBonus = 0;
        this.registrationFee = 300; 
        this.farmerType = "Distinguished Farmer";
    }
}