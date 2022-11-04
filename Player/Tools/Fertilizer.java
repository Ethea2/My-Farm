package Player.Tools;

import Player.*;

public class Fertilizer extends Tools {
    public Fertilizer() {
        this.costUsage = 10;
        this.expGained = 4.0;
        this.toolName = "Fertilizer";
    }
    @Override
    public void useTool(Tile tile, Player player, int currentDay) {
        if(!(tile.getCrop() == null)){
            player.addExperience(expGained);
            player.subtractObjectcoins(costUsage);
            tile.getCrop().addFert();
        }
    }
}
