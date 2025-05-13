package org.example.models;

import org.example.models.enums.CropEnum;

public class Crop extends Plant{
    private CropEnum crop;

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

    public CropEnum getCrop() {
        return crop;
    }

}
