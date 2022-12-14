package Player;

import Crop.Crop;
import Gui.GamePanel;

import java.awt.*;
import java.awt.image.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Tile {
    private Crop crop;
    private boolean rocked = false;
    private boolean plowed = false;
    private boolean hasCrop = false;
    private boolean withered = false;
    public int row;
    public int col;
    public int coordinateX;
    public int coordinateY;
    public int randomNum;
    public BufferedImage[] rockedImage;
    public BufferedImage plowedImage;
    public BufferedImage witheredImage;
    public BufferedImage normalTile;

    
    /**
     * Constuructior for the Tile class
     */
    public Tile() {
        randomNum = ThreadLocalRandom.current().nextInt(0, 2 + 1);
        this.rockedImage = new BufferedImage[3];
        try {
            this.rockedImage[0] = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/rock_1.png"));
            this.rockedImage[1] = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/rock_2.png"));
            this.rockedImage[2] = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/rock_3.png"));
            this.plowedImage = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/soil_plowed.png"));
            this.witheredImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/withered.png"));
            this.normalTile = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/soil.png"));
        } catch (Exception e) {
            e.printStackTrace();    
        }
    }
    
    /**
     * Helper function for displaying messages as pop-ups.
     * 
     * @param message the text to be displayed on the pop-up.
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Tile Error", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * This function gets the status of the tile, checking if the crop is
     * harvestable, growing, and withered.
     * 
     * @return report a string that tells the user on what he or she can do with the
     * tile/crop.
     */
    public String getStatus() {
        String report = "";

        if(this.crop == null) {
            report += "The tile does not have a crop.";
        }
        else if (withered) {
            report += "The crop in this tile has withered.";
        } else if (plowed && !hasCrop) {
            report += "This tile is has been plowed and is plantable.";
        } else if (plowed && hasCrop) {
            report += String.format("This tile has been plowed and has a %s in it.", crop.getCropName());
        } else if (!plowed) {
            report += "This tile has not been plowed and cannot be planted on.";
        }

        return report;
    }

    /**
     * Checks if the tile is rocked or not.
     * 
     * @return a boolean if the tile is rocked.
     */
    public boolean checkRocked() {
        return this.rocked;
    }

    /**
     * Checks if the tile is plowed and plantable or not.
     * 
     * @return true if plowed; false if not.
     */
    public boolean checkPlowed() {
        return this.plowed;
    }

    /**
     * Checks if the tile has a plant/crop in it.
     * 
     * @return a boolean if the tile has a crop or not.
     */
    public boolean checkPlanted() {
        return this.hasCrop;
    }

    /**
     * Checks if the tile is empty (contains a plant or a rock).
     * 
     * @return false if the tile contains either a plant or a rock
     *          otherwise true.
     */
    public boolean checkEmpty() {
        if(this.hasCrop || this.rocked){
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * Checks what the crop's name is.
     * 
     * @return the name of the crop.
     */
    public String checkCrop() {
        return this.crop.getCropName();
    }

    /**
     * Checks if the tile has a crop or not. If it doesn't it will return null.
     * If it does it will return the crop.
     * 
     * @return the crop or null if there's none.
     */
    public Crop getCrop() {
        if (hasCrop) {
            return this.crop;
        } else {
            return this.crop;
        }
    }

    /**
     * Sets the tile to rocked if triggered.
     */
    public void setRock() {
        this.rocked = true;
    }

    /**
     * Removes the rock if the tile is rocked.
     * 
     * @return a boolean if the tile's rock was successfully removed
     */
    public boolean removeRock() {
        if (this.rocked == true) {
            this.rocked = false;
            System.out.println("The rock was successfully removed.");
            return true;
        } else {
            showMessage("The tile is not rocked.");
            return false;
        }
    }

    /**
     * This function plows the tile. It also checks if the tile is already plowed or
     * has a plant in it.
     * It will return false if plowed or has a plant; true if it's not.
     * 
     * @return true if not plowed or planted. False otherwise.
     */
    public boolean setPlowed() {
        if (hasCrop) {
            showMessage("The tile already has a crop.");
            return false;
        } else if (plowed) {
            showMessage("The tile has already been plowed.");
            return false;
        }
        else if(rocked) {
            showMessage("The tile has a rock.");
            return false;
        }
        else {
            this.plowed = true;
            return true;
        }
    }

    
    /**
     * Checks if the tile has a withered crop.
     * 
     * @return true if tile has a withered crop, false if it doesn't.
     */
    public boolean getWithered() {
        return this.withered;
    }

    /**
     * Plants a crop inside the tile. It also prints the status of the crop.
     * 
     * @param crop the crop will become the crop inside the tile
     * @return a boolean if the planting was successful.
     */
    public boolean plantCrop(Crop crop, MyFarm farm) {
        if (!plowed) {
            showMessage("The tile has not been plowed.");
            return false;
        } else if (hasCrop) {
            showMessage("The tile already has a crop.");
            return false;
        } else if(crop.getSeedCost() > farm.getPlayer().getObjectcoins()){
            showMessage("You do not have enough coins to buy these seeds.");
            return false;
        } else if(crop.getCropType() == "FruitTree" && !crop.canPlant(row, col, farm)){
            showMessage("There is not enough space to plant this crop.");
            return false;
        } else {
            this.crop = crop;
            this.hasCrop = true;
            return true;
        }
    }

    /**
     * removes the withered crop. It also checks the status of the crop whether it's
     * withered or not.
     * 
     * @param currentDay used to get the status of the crop inside the tile
     * @return a boolean whether removing the withered crop was successful or not
     */
    public boolean removeWithered(int currentDay) {
        if (this.crop == null) {
            JOptionPane.showMessageDialog(null, "This tile does not have a withered crop.", "Shovel Error", JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (this.crop.checkStatus(currentDay).equals("withered")) {
            this.withered = false;
            this.hasCrop = false;
            this.crop = null;
            this.plowed = false;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "This tile does not have a withered crop.", "Shovel Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    /**
     * The harvest function harvests the crop inside the tile. It also sets the crop
     * back to null and hasCrop to false.
     */
    public void harvest(int currentDay) {
        String status;
        if (this.crop != null) {
            status = this.crop.checkStatus(currentDay);
            if (status.equals("harvestable")) {
                this.crop = null;
                this.hasCrop = false;
                this.plowed = false;
            }
            else{
                showMessage("This crop is not ready to be harvested.");
            }
        }
    }

    /**
     * Sets the tile's withered status to true.
     */
    public void cropWithered() {
        this.withered = true;
    }

    /**
     * Gets the tile based on the coordinates given.
     * 
     * @param x the x-axis coordinate of the tile.
     * @param y the y-axis coordinate of the tile.
     * @return the tile if it matchs the coordinates.
     */
    public Tile getTileByXY(int x, int y) {
        if(this.coordinateX == x && this.coordinateY == y) {
            return this;
        }
        return null;
    }

    /**
     * Prints relevant information about the tile in the terminal if triggered.
     * 
     * @param currentDay the current day in the game loop.
     */
    public void printTileInfo(int currentDay){
        System.out.println("-----------------------------------");
        System.out.println("Tile Coordinates X: " + this.coordinateX + "Y: " + this.coordinateY);
        if(this.hasCrop){
            System.out.println("Crop: " + this.crop.getCropName());
            System.out.println("Crop Type: " + this.crop.getCropType());
            System.out.println("Status: " + this.crop.checkStatus(currentDay));
            System.out.println("Plant Day: " + this.crop.getPlantDay());
            System.out.println("Harvest In: " + (currentDay - (this.crop.getPlantDay() + this.crop.getHarvestTime())) + "days");

            System.out.println("\nTimes Watered: " + this.crop.getWaterCount());
            System.out.println("Times Fertilized: " + this.crop.getFertCount());
        } else{
            System.out.println("This tile has no crop");
            if(this.plowed){
                System.out.println("This tile is plowed.");
            } else {
                System.out.println("This tile is not plowed.");
            }
            
            if(this.rocked){
                System.out.println("This tile is rocked.");
            } else {
                System.out.println("This tile is not rocked.");
            }
        }
        System.out.println("-----------------------------------");
    }

    /**
     * Displays the tile's image based on its contents.
     *
     * @param g2 the graphics object.
     * @param gamePanel the area where the farm, crops, and charcter are displayed.
     */
    public void draw(Graphics2D g2, GamePanel gamePanel) {
        //System.out.println("I got triggered " + this.rocked + coordinateX+coordinateY);
        //fix withered status.
        if(this.crop != null && !this.withered) {
            g2.drawImage(this.crop.setImage(gamePanel.farm.getCurrentDay()), (this.coordinateX * gamePanel.TILE_SIZE), (this.coordinateY * gamePanel.TILE_SIZE), gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
        else if(this.plowed && !this.hasCrop) {
            g2.drawImage(this.plowedImage, (this.coordinateX * gamePanel.TILE_SIZE), (this.coordinateY * gamePanel.TILE_SIZE), gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
        else if(this.withered) {
            g2.drawImage(this.witheredImage, (this.coordinateX * gamePanel.TILE_SIZE), (this.coordinateY * gamePanel.TILE_SIZE), gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
        else if(this.rocked) {
            g2.drawImage(this.rockedImage[this.randomNum], (this.coordinateX * gamePanel.TILE_SIZE), (this.coordinateY * gamePanel.TILE_SIZE), gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
        else {
            g2.drawImage(this.normalTile, (this.coordinateX * gamePanel.TILE_SIZE), (this.coordinateY * gamePanel.TILE_SIZE), gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
    }
}