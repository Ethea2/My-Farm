package Player;

import java.util.Currency;

import Crop.Crop;

public class Tile {
    private Crop crop;
    private boolean rocked = false;
    private boolean plowed = false;
    private boolean hasCrop = false;
    private boolean withered = false;

    public String getStatus(int currentDay) {
        String report = "";
        String status;
        if(this.crop != null) {
            status = this.crop.checkStatus(currentDay);
            if (status.equals("harvestable")) {
                System.out.println("The crop is harvestable.");
            } else if (status.equals("withered")) {
                this.withered = true;
            } else if (status.equals("growing")) {
                System.out.println("This crop is still growing and is unharvestable.");
            }
        }

        if(withered) {
            report += "The crop in this tile has withered.";
        }
        else if(plowed && !hasCrop) {
            report += "This tile is has been plowed and is plantable.";
        }
        else if(plowed && hasCrop) {
            report += String.format("This tile has been plowed and has a %s in it.", crop.getCropName());
        }
        else if(!plowed) {
            report += "This tile has not been plowed and cannot be planted on.";
        }

        return report;
    }

    public boolean checkRocked() {
        return this.rocked;
    }
    public boolean checkPlowed() {
        return this.plowed;
    }
    public boolean checkPlanted() {
        return this.hasCrop;
    }
    public String checkCrop() {
        return this.crop.getCropName();
    }
    public Crop getCrop() {
        if(hasCrop) {
            return this.crop;
        }
        else {
            System.out.println("This tile does not have a crop");
            return this.crop;
        }
    }


    public void setRock() {
        this.rocked = true;
    }
    public boolean removeRock() {
        if(this.rocked == true) {
            this.rocked = false;
            System.out.println("The rock was successfully removed.");
            return true;
        }
        else {
            System.out.println("The tile is not rocked.");
            return false;
        }
    }
    public boolean setPlowed() {
        if(hasCrop) {
            System.out.println("The tile already has a crop.");
            return false;
        }
        else if (plowed) {
            System.out.println("The tile has already been plowed.");
            return false;
        }
        else {
            this.plowed = true;
            System.out.println("The tile has successfully been plowed.");
            return true;
        }
    }
    public boolean plantCrop(Crop crop) {
        if(!plowed) {
            System.out.println("The tile has not been plowed.");
            return false;
        }
        else if(hasCrop) {
            System.out.println("The tile already has a crop.");
            return false;
        }
        else {
            this.crop = crop;
            this.hasCrop = true;
            System.out.println("The crop has been successfully planted!");
            return true;
        }
    }
    public boolean removeWithered(int currentDay) {
        if(this.crop == null) {
            System.out.println("This tile does not have a crop");
            return false;
        }
        else if(this.crop.checkStatus(currentDay).equals("withered")) {
            this.withered = false;
            this.hasCrop = false;
            System.out.println("The withered crop has been shoveled.");
            return true;
        }
        else {
            System.out.println("The crop is not withered or there are no crops.");
            return false;
        }
    }
    public void harvest(int currentDay) {
        String status;
        if(this.crop != null) {
            status = this.crop.checkStatus(currentDay);
            if (status.equals("harvestable")) {
                this.crop = null;
                this.hasCrop = false;
            } 
        }
    }
    public void cropWithered() {
        this.withered = true;
    }
}
