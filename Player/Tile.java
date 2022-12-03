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

        //random rocked
        // if (ThreadLocalRandom.current().nextInt(0,1+1) == 1) {
        //     this.rocked = true;
        // }

    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Tile Error", JOptionPane.PLAIN_MESSAGE);
    }

    /*
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

    /*
     * checks if the tile is rocked or not
     * 
     * @return a boolean if the tile is rocked
     */
    public boolean checkRocked() {
        return this.rocked;
    }

    /*
     * checks if the tile is plowed and plantable or not
     * 
     * @return true if plowed; false if not
     */
    public boolean checkPlowed() {
        return this.plowed;
    }

    /*
     * checks if the tile has a plant/crop in it.
     * 
     * @return a boolean if the tile has a crop or not
     */
    public boolean checkPlanted() {
        return this.hasCrop;
    }

    /*
     * checks if the tile contains a plant or a rock
     * 
     * @return the name of the crop
     */
    public boolean checkEmpty() {
        if(this.hasCrop || this.rocked){
            return false;
        }
        else{
            return true;
        }
    }

    /*
     * checks what's the name of the crop
     * 
     * @return the name of the crop
     */
    public String checkCrop() {
        return this.crop.getCropName();
    }

    /*
     * checks if the tile has a crop or not. If it doesn't it will return null.
     * If it does it will return the crop
     * 
     * @return the crop or null if there's none
     */
    public Crop getCrop() {
        if (hasCrop) {
            return this.crop;
        } else {
            return this.crop;
        }
    }

    /*
     * this function sets the tile to rocked if triggered
     */
    public void setRock() {
        this.rocked = true;
    }

    /*
     * this function removes the rock if the tile is rocked.
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

    /*
     * This function plows the tile. It also checks if the tile is already plowed or
     * has a plant in it.
     * It will return false if plowed or has a plant; true if it's not
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
            System.out.println("The tile has successfully been plowed.");
            return true;
        }
    }

    /*
     * Plants a crop inside the tile. It also prints the status of the crop.
     * 
     * @param crop the crop will become the crop inside the tile
     * 
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
            System.out.println("The crop has been successfully planted!");
            return true;
        }
    }

    /*
     * removes the withered crop. It also checks the status of the crop whether it's
     * withered or not.
     * 
     * @param currentDay used to get the status of the crop inside the tile
     * 
     * @return a boolean whether removing the withered crop was successful or not
     */
    public boolean removeWithered(int currentDay) {
        if (this.crop == null) {
            System.out.println("This tile does not have a crop");
            return false;
        } else if (this.crop.checkStatus(currentDay).equals("withered")) {
            this.withered = false;
            this.hasCrop = false;
            this.crop = null;
            this.plowed = false;
            System.out.println("The withered crop has been shoveled.");
            return true;
        } else {
            System.out.println("The crop is not withered or there are no crops.");
            return false;
        }
    }

    /*
     * the harvest function harvests the crop inside the tile. It also sets the crop
     * back to null and hasCrop to false.
     */
    public void harvest(int currentDay) {
        String status;
        if (this.crop != null) {
            status = this.crop.checkStatus(currentDay);
            if (status.equals("harvestable")) {
                this.crop = null;
                this.hasCrop = false;
            }
            else{
                showMessage("This crop is not ready to be harvested.");
            }
        }
    }

    /*
     * Makes the tile have a withered status.
     */
    public void cropWithered() {
        this.withered = true;
    }

    public Tile getTileByXY(int x, int y) {
        if(this.coordinateX == x && this.coordinateY == y) {
            return this;
        }
        return null;
    }

    public void printTileInfo(int currentDay){
        if(this.hasCrop){
            System.out.println("-----------------------------------");
            System.out.println("Crop: " + this.crop.getCropName());
            System.out.println("Crop Type: " + this.crop.getCropType());
            System.out.println("Plant Day: " + this.crop.getPlantDay());
            System.out.println("Harvest In: " + (currentDay - (this.crop.getPlantDay() + this.crop.getHarvestTime())) + "days");

            System.out.println("\nTimes Watered: " + this.crop.getWaterCount());
            System.out.println("Times Fertilized: " + this.crop.getFertCount());
            System.out.println("-----------------------------------");
        } else{
            System.out.println("Crop: No crop");
        }
        System.out.println("Rocked: " + this.crop.getCropName());
        
    }

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
