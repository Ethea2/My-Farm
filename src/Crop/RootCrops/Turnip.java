package Crop.RootCrops;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import Gui.GuiTile;

public class Turnip extends RootCrop{
    /** 
    * Turnip class constructor.
    */
    public Turnip(int plantDay){
        super(plantDay);
        this.cropName = "Turnip";
        this.harvestTime = 2;

        this.waterNeeds = 1;
        this.waterBonusLimit = 2;
        this.fertNeeds = 0;
        this.fertBonusLimit = 1;

        this.yieldMin = 1;
        this.yieldMax = 2;
        
        this.seedCost = 5;
        this.basePrice = 6;

        this.expYield = 5;

        this.guiTiles = new GuiTile[3];
        loadImages();
    }
    public Turnip() {
        this.cropName = "Turnip";
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void loadImages() {
        try {
            this.guiTiles[0] = new GuiTile();
            this.guiTiles[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/root_crops/turnip_0.png"));
            
            this.guiTiles[1] = new GuiTile();
            this.guiTiles[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/root_crops/turnip_1.png"));

            this.guiTiles[2] = new GuiTile();
            this.guiTiles[2].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/root_crops/turnip_h.png"));
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
            return this.guiTiles[2].image;
        }
        else if(getStage(currentDay) == '1') {
            return this.guiTiles[1].image;
        }
        else {
            return this.guiTiles[0].image;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char getStage(int currentDay){
        switch(currentDay-this.plantDay){
            case 2:
                return 'h';
            case 1:
                return '1';
            default:
                return '0';
        }
    }
}