package Player.Tools;

import Player.*;

public class Tools {
    protected int costUsage;
    protected double expGained;
    protected String toolName;

    /*
     * The getter function for the cost of usage of the tool
     * 
     * @return cost of usage of the tool.
     */
    public int getCost() {
        return this.costUsage;
    }

    /*
     * A getter function for the experience gained when the tool is used
     * 
     * @return the experience gained from the use of the tool
     */
    public double getExpGained() {
        return this.expGained;
    }

    /*
     * Getter function for the name of the tool
     * 
     * @return the tool name.
     */
    public String getToolName() {
        return this.toolName;
    }

    /*
     * The use tool function will serve as the main function to be overridden by its
     * children functions.
     * 
     * @params tile the tile that is going to be targeted
     * 
     * @params player the player class that gains experience
     * 
     * @params currentDay the current day count
     */
    public void useTool(Tile tile, Player player, int currentDay) {
        player.addExperience(expGained);
        player.subtractObjectcoins(costUsage);
    }
}
