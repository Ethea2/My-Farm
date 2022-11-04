package Player.Tools;

import Player.*;

public class Plow extends Tools {
    public Plow() {
        this.costUsage = 0;
        this.expGained = 0.5;
        this.toolName = "Plow";
    }
    @Override
    public void useTool(Tile tile, Player player, int currentDay) {
        tile.setPlowed();
        player.addExperience(expGained);
        player.subtractObjectcoins(costUsage);
    }
}
