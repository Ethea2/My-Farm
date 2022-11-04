import java.util.ArrayList;

import Crop.Crop;
import Crop.Flowers.*;
import Crop.RootCrops.*;
import Player.Tile;

public class MyFarm {
    private int day;
    private Tile tile;
    private ArrayList<Crop> crops;
    public MyFarm() {
        this.day = 1;
        this.tile = new Tile();
        this.crops = new ArrayList<Crop>();
        this.crops.add(new Tulip());
        this.crops.add(new Sunflower());
        this.crops.add(new Rose());
        this.crops.add(new Carrot());
        this.crops.add(new Potato());
        this.crops.add(new Turnip());
    }

    public void advanceDay() {
        this.day++;
    }

    public ArrayList<String> getCrops() {
        ArrayList<String> cropsAvailable = new ArrayList<String>();
        for(Crop crop:crops) {
            cropsAvailable.add(crop.getCropName());
        }
        return cropsAvailable;
    }
    public Tile getTile() {
        return this.tile;
    }
    public int getCurrentDay() {
        return this.day;
    }
}
