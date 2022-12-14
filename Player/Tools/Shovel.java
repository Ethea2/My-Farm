package Player.Tools;

import Player.*;

public class Shovel extends Tools {
    /*
     * The shovel class constructor
     */
    public Shovel() {
        this.costUsage = 7;
        this.expGained = 2.0;
        this.toolName = "Shovel";
    }

    /*
     * The use tool override allows the shovel to add experience and shovel
     * the withered crop in the tile.
     * 
     * @params tile the tile that is going to be fertilized
     * 
     * @params player the player class that gains experience
     * 
     * @params currentDay the current day count
     */
    @Override
    public void useTool(Tile tile, Player player, int currentDay) {
        if (tile.removeWithered(currentDay)) {
            player.addExperience(expGained);
            player.subtractObjectcoins(costUsage);
        }
    }
}
