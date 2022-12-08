package Player.Tools;

import Player.*;

public class WaterCan extends Tools {
    /**
     * The watering can class constructor
     */
    public WaterCan() {
        this.costUsage = 0;
        this.expGained = 0.5;
        this.toolName = "Watering Can";
    }

    /**
     * The use tool override allows the watering can to add experience and water
     * the crop in the tile.
     * 
     * @param tile the tile that is going to be watered
     * @param player the player class that gains experience
     * @param currentDay the current day count
     */
    @Override
    public void useTool(Tile tile, Player player, int currentDay) {
        if (!(tile.getCrop() == null) && tile.getCrop().addWater()) {
            player.addExperience(expGained);
            player.subtractObjectcoins(costUsage);
        }
    }
}
