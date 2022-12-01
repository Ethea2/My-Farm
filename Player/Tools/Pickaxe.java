package Player.Tools;

import Player.*;

public class Pickaxe extends Tools {
    /*
     * The pickaxe class constructor.
     */
    public Pickaxe() {
        this.costUsage = 50;
        this.expGained = 15;
        this.toolName = "Pickaxe";
    }

    /*
     * The use tool override allows the pickaxe to add experience and remove
     * the rock from the tile.
     * 
     * @params tile the tile that is going to be derocked
     * 
     * @params player the player class that gains experience
     * 
     * @params currentDay the current day count
     */
    @Override
    public void useTool(Tile tile, Player player, int currentDay) {
        if(checkAfford(player)){
            if (tile.removeRock()) {
                player.addExperience(expGained);
                player.subtractObjectcoins(costUsage);
            }
        }
    }
}
