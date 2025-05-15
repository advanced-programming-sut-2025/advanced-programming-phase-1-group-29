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
        totalHarvestTime = crop.getTotalHarvestTime();
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

    @Override
    public void grow() {
        this.decrementRemainingTime();
        int sum = 0;
        for (int i = 0; i < crop.getStages().size() - 1; i++) {
            sum += crop.getStages().get(i);
            if (sum == crop.getTotalHarvestTime() - this.getRemainingTime())
                this.incrementStage();
        }
    }

    public CropEnum getCrop() {
        return crop;
    }

    public ForagingCrop getForagingCrop() {
        return foragingCrop;
    }
}
