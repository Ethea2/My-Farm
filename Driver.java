import javax.xml.stream.FactoryConfigurationError;

import Crop.Crop;
import Crop.Flowers.Tulip;
import Player.FarmerType.Farmer;
import Player.FarmerType.LegendaryFarmer;

public class Driver {
    public static void main(String[] args) {
        MyFarm farm = new MyFarm();
        Farmer player = new LegendaryFarmer();
        boolean loop = true;

        System.out.println(player.getFarmerType());
        // System.out.println("Welcome to the farm!");
        // while(loop) {
        //     System.out.println("What do you want to do?");
            
        // }
    }
}
