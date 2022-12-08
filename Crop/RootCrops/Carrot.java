package Crop.RootCrops;

import Gui.GuiTile;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Carrot extends RootCrop{
    /** 
    * Carrot class constructor.
    * @param plantDay the day the crop was planted.
    */
    public Carrot(int plantDay){
        super(plantDay);
        this.cropName = "Carrot";
        this.harvestTime = 3;

        this.waterNeeds = 1;
        this.waterBonusLimit = 2;
        this.fertNeeds = 0;
        this.fertBonusLimit = 1;

        this.yieldMin = 1;
        this.yieldMax = 2;
        
        this.seedCost = 10;
        this.basePrice = 9;

        this.expYield = 7.5;

        this.guiTiles = new GuiTile[3];
        loadImages();
    }
    public Carrot() {
        this.cropName = "Carrot";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loadImages() {
        try {
            this.guiTiles[0] = new GuiTile();
            this.guiTiles[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/root_crops/carrot_0.png"));
            
            this.guiTiles[1] = new GuiTile();
            this.guiTiles[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/root_crops/carrot_1.png"));

            this.guiTiles[2] = new GuiTile();
            this.guiTiles[2].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/root_crops/carrot_h.png"));
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