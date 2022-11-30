package Crop.Flowers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import Gui.GuiTile;

public class Sunflower extends Flower{
    /** 
    * Sunflower class constructor.
    */
    public Sunflower(int plantDay){
        super(plantDay);
        this.cropName = "Sunflower";
        this.harvestTime = 3;

        this.waterNeeds = 2;
        this.waterBonusLimit = 3;
        this.fertNeeds = 1;
        this.fertBonusLimit = 2;

        this.yieldMin = 1;
        this.yieldMax = 1;
        
        this.seedCost = 20;
        this.basePrice = 19;

        this.expYield = 7.5;
        
        this.guiTiles = new GuiTile[3];
        loadImages();
    }
    public Sunflower() {
        this.cropName = "Sunflower";
    }
    
    @Override
    public void loadImages() {
        try {
            this.guiTiles[0] = new GuiTile();
            this.guiTiles[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/flowers/sunflower_0.png"));
            
            this.guiTiles[1] = new GuiTile();
            this.guiTiles[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/flowers/sunflower_1.png"));

            this.guiTiles[2] = new GuiTile();
            this.guiTiles[2].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/flowers/sunflower_h.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BufferedImage setImage(int currentDay) {
        if(getStage(currentDay) == 'h') {
            return this.guiTiles[2].image;
        }
        else if(getStage(currentDay) == '1') {
            return this.guiTiles[1].image;
        }
        else {
            return this.guiTiles[0].image;
        }
    }

    @Override
    public char getStage(int currentDay){
        switch(currentDay-this.plantDay){
            case 3:
                return 'h';
            case 2:
                return '1';
            case 1:
                return '1';
            default:
                return '0';
        }
    }
}
