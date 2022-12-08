package Crop.FruitTrees;

import Gui.GuiTile;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Apple extends FruitTree {
    /** 
    * Apple class constructor.
    * @param plantDay the day the crop was planted.
    */
    public Apple(int plantDay){
        super(plantDay);
        this.cropName = "Apple";
        this.harvestTime = 10;

        this.waterNeeds = 7;
        this.waterBonusLimit = 7;
        this.fertNeeds = 5;
        this.fertBonusLimit = 5;

        this.yieldMin = 10;
        this.yieldMax = 15;
        
        this.seedCost = 200;
        this.basePrice = 5;

        this.expYield = 25;

        this.guiTiles = new GuiTile[4];
        loadImages();
    }
    public Apple() {
        this.cropName = "Apple";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loadImages() {
        try {
            this.guiTiles[0] = new GuiTile();
            this.guiTiles[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/fruit_trees/Apple_0.png"));
            
            this.guiTiles[1] = new GuiTile();
            this.guiTiles[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/fruit_trees/Apple_1.png"));

            this.guiTiles[2] = new GuiTile();
            this.guiTiles[2].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/fruit_trees/Apple_2.png"));

            this.guiTiles[3] = new GuiTile();
            this.guiTiles[3].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/fruit_trees/Apple_h.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
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