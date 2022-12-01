package Player.Tools;

import Player.*;

public class Fertilizer extends Tools {
    /*
     * The construction for the Fertilizer class
     */
    public Fertilizer() {
        this.costUsage = 10;
        this.expGained = 4.0;
        this.toolName = "Fertilizer";
    }

    /*
     * The use tool override allows the Fertilizer to add experience and fertilize
     * the crop in the tile.
     * 
     * @params tile the tile that is going to be fertilized
     * 
     * @params player the player class that gains experience
     * 
     * @params currentDay the current day count
     */
    @Override
    public void useTool(Tile tile, Player player, int currentDay) {
        if (checkAfford(player)){
            if (!(tile.getCrop() == null)) {
                player.addExperience(expGained);
                player.subtractObjectcoins(costUsage);
                tile.getCrop().addFert();
            }
        }
    }
}
