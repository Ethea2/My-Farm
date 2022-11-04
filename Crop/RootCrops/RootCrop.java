package Crop.RootCrops;

import Crop.Crop;

public class RootCrop extends Crop{
    public RootCrop(int plantDay){
        super(plantDay);
        this.cropType = "RootCrop";
    }
    public RootCrop() {
        this.cropType = "RootCrop";
    }
}