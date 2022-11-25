package Crop.FruitTrees;

import Crop.Crop;
import Player.MyFarm;
import Player.Tile;

import java.util.ArrayList;

public class FruitTree extends Crop{
    public FruitTree(int plantDay){
        super(plantDay);
        this.cropType = "FruitTree";
    }
    public FruitTree() {
        this.cropType = "FruitTree";
    }
    
    @Override
    public boolean canPlant(int x, int y, MyFarm farm){
        if(farm.getTile()[x][y].checkEmpty() && //checks planting tile
            farm.getTile()[x-1][y-1].checkEmpty() && //checks above-left tile
            farm.getTile()[x-1][y].checkEmpty() && //checks above tile
            farm.getTile()[x-1][y+1].checkEmpty() && //checks above-right tile
            farm.getTile()[x][y-1].checkEmpty() && //checks left tile
            farm.getTile()[x][y+1].checkEmpty() && //checks right tile
            farm.getTile()[x+1][y-1].checkEmpty() && //checks below-left tile
            farm.getTile()[x+1][y].checkEmpty() && //checks below tile
            farm.getTile()[x+1][y+1].checkEmpty()) { //checks below-right tile
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public char getStage(int currentDay){
        switch(currentDay-this.plantDay){
            case 10:
                return 'h';
            case 9:
                return '3';
            case 8:
                return '3';
            case 7:
                return '3';
            case 6:
                return '3';
            case 5:
                return '2';
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
