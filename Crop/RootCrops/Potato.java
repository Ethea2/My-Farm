package Crop.RootCrops;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import Gui.GuiTile;

public class Potato extends RootCrop{
    /** 
    * Potato class constructor.
    */
    public Potato(int plantDay){
        super(plantDay);
        this.cropName = "Potato";
        this.harvestTime = 5;

        this.waterNeeds = 3;
        this.waterBonusLimit = 4;
        this.fertNeeds = 1;
        this.fertBonusLimit = 2;

        this.yieldMin = 1;
        this.yieldMax = 10;
        
        this.seedCost = 20;
        this.basePrice = 3;

        this.expYield = 12.5;

        this.guiTiles = new GuiTile[4];
        loadImages();
    }
    public Potato() {
        this.cropName = "Potato";
    }

    @Override
    public void loadImages() {
        try {
            this.guiTiles[0] = new GuiTile();
            this.guiTiles[0].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/root_crops/potato_0.png"));
            
            this.guiTiles[1] = new GuiTile();
            this.guiTiles[1].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/root_crops/potato_1.png"));

            this.guiTiles[2] = new GuiTile();
            this.guiTiles[2].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/root_crops/potato_2.png"));

            this.guiTiles[3] = new GuiTile();
            this.guiTiles[3].image = ImageIO.read(getClass().getResourceAsStream("/resources/crops/root_crops/potato_h.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BufferedImage setImage(int currentDay) {
        if(getStage(currentDay) == 'h') {
            return this.guiTiles[3].image;
        }
        else if(getStage(currentDay) == '1') {
            return this.guiTiles[1].image;
        }
        else if(getStage(currentDay) == '2') {
            return this.guiTiles[2].image;
        }
        else {
            return this.guiTiles[0].image;
        }
    }

    @Override
    public char getStage(int currentDay){
        switch(currentDay-this.plantDay){
            case 5:
                return 'h';
            case 4:
                return '2';
            case 3:
                return '2';
            case 2:
                return '1';
            case 1:
                return '1';
            default:
                return '0';
        }
    }
}
