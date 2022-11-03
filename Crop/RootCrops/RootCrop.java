package Crop.RootCrops;

import Crop.Crop;

public class RootCrop extends Crop{
    public RootCrop(String farmerType, int plantDay){
        super(farmerType, plantDay);
        this.cropType = "RootCrop";
    }
}