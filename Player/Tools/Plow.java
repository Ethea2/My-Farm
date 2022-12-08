package Player.Tools;

import Player.*;

public class Plow extends Tools {
    /**
     * The plow class constructor
     */
    public Plow() {
        this.costUsage = 0;
        this.expGained = 0.5;
        this.toolName = "Plow";
    }

    /**
     * The use tool override allows the plow to add experience and plow
     * the the unplowed tile.
     * 
     * @param tile the tile that is going to be plowed
     * @param player the player class that gains experience
     * @param currentDay the current day count
     */
    @Override
    public void useTool(Tile tile, Player player, int currentDay) {
        if (checkAfford(player)){
            if(tile.setPlowed()) {
                player.addExperience(expGained);
                player.subtractObjectcoins(costUsage);
            }
        }
    }
}
