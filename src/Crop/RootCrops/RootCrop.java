package Crop.RootCrops;

import Crop.Crop;

public class RootCrop extends Crop{
    /** 
    * RootCrop class constructor.
    * @param plantDay the day the crop was planted.
    */
    public RootCrop(int plantDay){
        super(plantDay);
        this.cropType = "RootCrop";
    }
    public RootCrop() {
        this.cropType = "RootCrop";
    }
}