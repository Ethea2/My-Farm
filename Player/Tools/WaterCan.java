package Player.Tools;

import Player.*;

public class WaterCan extends Tools {
    public WaterCan() {
        this.costUsage = 0;
        this.expGained = 0.5;
        this.toolName = "Watering Can";
    }
    @Override
    public void useTool(Tile tile, Player player, int currentDay) {
        if(!(tile.getCrop() == null)){
            tile.getCrop().addWater();
            player.addExperience(expGained);
            player.subtractObjectcoins(costUsage);
        }
    }
}
