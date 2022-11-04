package Player.Tools;

import Player.*;

public class Shovel extends Tools {
    public Shovel() {
        this.costUsage = 7;
        this.expGained = 2.0;
        this.toolName = "Shovel";
    }
    
    @Override
    public void useTool(Tile tile, Player player, int currentDay) {
        if(tile.removeWithered(currentDay)){
            player.addExperience(expGained);
            player.subtractObjectcoins(costUsage);
        }
    }
}
