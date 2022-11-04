package Crop.RootCrops;

import Crop.Crop;

public class RootCrop extends Crop{
    public RootCrop(int earningBonus, int plantDay){
        super(earningBonus, plantDay);
        this.cropType = "Root Crop";
    }
}