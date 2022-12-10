package Crop.Flowers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import Gui.GuiTile;

public class Tulip extends Flower{
    /** 
    * Tulip class constructor.
    * @param plantDay the day the crop was planted.
    */
    public Tulip(int plantDay){
        super(plantDay);
        this.cropName = "Tulip";
        this.harvestTime = 2;

        this.waterNeeds = 2;
        this.waterBonusLimit = 3;
        this.fertNeeds = 0;
        this.fertBonusLimit = 1;

        this.yieldMin = 1;
        this.yieldMax = 1;
        
        this.seedCost = 10;
        this.basePrice = 9;

        this.expYield = 5;

        this.guiTiles = new GuiTile[3];
        loadImages();
    }
    public Tulip() {
        this.cropName = "Tulip";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void loadImages() {
        try {
            this.guiTiles[0] = new GuiTile();
            this.guiTiles[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/flowers/tulip_0.png"));
            
            this.guiTiles[1] = new GuiTile();
            this.guiTiles[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/flowers/tulip_1.png"));

            this.guiTiles[2] = new GuiTile();
            this.guiTiles[2].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/flowers/tulip_h.png"));
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
