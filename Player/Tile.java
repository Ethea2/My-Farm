package Player;

import Crop.Crop;

public class Tile {
    private Crop crop;
    private boolean rocked;
    private boolean plowed = false;
    private boolean hasCrop = false;

    public String getStatus() {
        String report = "";

        if(plowed && !hasCrop) {
            report += "This tile is has been plowed and is plantable.";
        }
        else if(plowed && hasCrop) {
            report += "This tile has been plowed and has a crop in it.";
        }
        else if(!plowed) {
            report += "This tile has not been plowed and cannot be planted on.";
        }

        if(hasCrop) {
            report += "\nThe crop planted is " + this.crop.getCropName();
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
        return this.crop;
    }


    public void setRock() {
        this.rocked = true;
    }
    public void setPlowed() {
        this.plowed = true;
    }
    public void plantCrop(Crop crop) {
        this.crop = crop;
    }
}
