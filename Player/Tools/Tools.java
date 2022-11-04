package Player.Tools;

import Player.*;

public class Tools {
    protected int costUsage;
    protected double expGained;
    protected String toolName;

    public int getCost() {
        return this.costUsage;
    }
    public double getExpGained() {
        return this.expGained;
    }
    public String getToolName() {
        return this.toolName;
    }
    public void useTool(Tile tile, Player player, int currentDay) {
        player.addExperience(expGained);
        player.subtractObjectcoins(costUsage);
    }
}
