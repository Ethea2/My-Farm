package Player.Tools;

import Player.*;

public class Pickaxe extends Tools {
    public Pickaxe() {
        this.costUsage = 50;
        this.expGained = 15;
        this.toolName = "Pickaxe";
    }
    @Override
    public void useTool(Tile tile, Player player, int currentDay) {
        if(tile.removeRock()){
            player.addExperience(expGained);
            player.subtractObjectcoins(costUsage);
        }
    }
}
