package org.example.models;

import org.example.models.enums.CropEnum;
import org.example.models.enums.ForagingCrop;

public class Crop extends Plant{
    private CropEnum crop;
    private ForagingCrop foragingCrop;

    public Crop(Seed seed) {
        super(seed);
        for (CropEnum value : CropEnum.values()) {
            if (value.getSource().equals(((CropSeed) seed).getCropSeedEnum())) {
                crop = value;
            }
        }
        name = crop.getName();
        stage = 0;
        remainingTime = crop.getTotalHarvestTime();
    }

    public Crop(ForagingCrop foragingCrop) {
        super(null);
        this.foragingCrop = foragingCrop;
        stage = 0;
        remainingTime = 0;
        name = foragingCrop.getName();
        isWateredToday = true;
        isReadyForHarvest = true;
        isForaging = true;
    }

    public CropEnum getCrop() {
        return crop;
    }

    public ForagingCrop getForagingCrop() {
        return foragingCrop;
    }
}
