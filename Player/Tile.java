package Player;

import Crop.Crop;

public class Tile {
    private Crop crop;
    private boolean rocked = false;
    private boolean plowed = false;
    private boolean hasCrop = false;
    private boolean withered = false;

    <<<<<<<HEAD
    /*
     * This function gets the status of the tile, checking if the crop is
     * harvestable, growing, and withered.
     * 
     * @return report a string that tells the user on what he or she can do with the
     * tile/crop.
     */
    =======

    public Tile() {

    }

    >>>>>>>f180c714a3b0ee40d3ce9223334f7e0e85d7b3e3

    public String getStatus(int currentDay) {
        String report = "";
        String status;
        if (this.crop != null) {
            status = this.crop.checkStatus(currentDay);
            if (status.equals("harvestable")) {
                System.out.println("The crop is harvestable.");
            } else if (status.equals("withered")) {
                this.withered = true;
            } else if (status.equals("growing")) {
                System.out.println("This crop is still growing and is unharvestable.");
            }
        }

        if (withered) {
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
            System.out.println("This tile does not have a crop");
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
            System.out.println("The tile is not rocked.");
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
            System.out.println("The tile already has a crop.");
            return false;
        } else if (plowed) {
            System.out.println("The tile has already been plowed.");
            return false;
        } else {
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
    public boolean plantCrop(Crop crop) {
        if (!plowed) {
            System.out.println("The tile has not been plowed.");
            return false;
        } else if (hasCrop) {
            System.out.println("The tile already has a crop.");
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
        }
    }

    /*
     * Makes the tile have a withered status.
     */
    public void cropWithered() {
        this.withered = true;
    }
}
