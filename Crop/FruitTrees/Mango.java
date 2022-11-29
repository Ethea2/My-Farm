package Crop.FruitTrees;

import Gui.GuiTile;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Mango extends FruitTree {
    /** 
    * Mango class constructor.
    */
    public Mango(int plantDay){
        super(plantDay);
        this.cropName = "Mango";
        this.harvestTime = 10;

        this.waterNeeds = 7;
        this.waterBonusLimit = 7;
        this.fertNeeds = 4;
        this.fertBonusLimit = 4;

        this.yieldMin = 5;
        this.yieldMax = 15;
        
        this.seedCost = 100;
        this.basePrice = 8;

        this.expYield = 25;
    }
    public Mango() {
        this.cropName = "Mango";
    }

    @Override
    public void loadImages() {
        try {
            this.guiTiles[0] = new GuiTile();
            this.guiTiles[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/fruit_trees/mango_0.png"));
            
            this.guiTiles[1] = new GuiTile();
            this.guiTiles[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/fruit_trees/mango_1.png"));

            this.guiTiles[2] = new GuiTile();
            this.guiTiles[2].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/fruit_trees/mango_2.png"));

            this.guiTiles[3] = new GuiTile();
            this.guiTiles[3].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/fruit_trees/mango_h.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BufferedImage setImage(int currentDay) {
        if(getStage(currentDay) == 'h') {
            return this.guiTiles[3].image;
        }
        else if(getStage(currentDay) == '2') {
            return this.guiTiles[2].image;
        }
        else if(getStage(currentDay) == '1') {
            return this.guiTiles[1].image;
        }
        else {
            return this.guiTiles[0].image;
        }
    }
}
