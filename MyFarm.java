import java.util.ArrayList;

import Crop.Crop;
import Player.Tile;

public class MyFarm {
    int day = 0;
    Tile tile = new Tile();
    ArrayList<Crop> crops;
    public MyFarm() {
        
    }
    public void advanceDay() {
        this.day++;
    }
    
}
