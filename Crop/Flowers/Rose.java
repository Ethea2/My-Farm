package Crop.Flowers;

import java.awt.image.*;

import javax.imageio.ImageIO;

import Gui.GuiTile;

public class Rose extends Flower{
    /** 
    * Rose class constructor.
    */
    public Rose(int plantDay){
        super(plantDay);
        this.cropName = "Rose";
        this.harvestTime = 1;

        this.waterNeeds = 1;
        this.waterBonusLimit = 2;
        this.fertNeeds = 0;
        this.fertBonusLimit = 1;

        this.yieldMin = 1;
        this.yieldMax = 1;
        
        this.seedCost = 5;
        this.basePrice = 5;

        this.expYield = 2.5;

        this.guiTiles = new GuiTile[2];
        loadImages();
    }

    public Rose() {
        this.cropName = "Rose";
    }

    @Override
    public void loadImages() {
        try {
            this.guiTiles[0] = new GuiTile();
            this.guiTiles[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/flowers/rose_0.png"));
            
            this.guiTiles[1] = new GuiTile();
            this.guiTiles[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/flowers/rose_h.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BufferedImage setImage(int currentDay) {
        if(getStage(currentDay) == 'h') {
            return this.guiTiles[1].image;
        }
        else {
            return this.guiTiles[0].image;
        }
    }

    @Override
    public char getStage(int currentDay){
        //System.out.println(checkStatus(currentDay));
        switch(currentDay-this.plantDay){
            case 1:
                return 'h';
            default:
                return '0';
        }
    }
}
