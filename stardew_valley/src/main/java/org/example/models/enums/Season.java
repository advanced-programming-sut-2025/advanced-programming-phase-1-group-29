package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum Season {
    Spring(new ArrayList<>(List.of(
            CropEnum.CAULIFLOWER, CropEnum.PARSNIP, CropEnum.POTATO,
            CropEnum.BLUEJAZZ, CropEnum.TULIP
    ))),
    Summer(new ArrayList<>(List.of(
            CropEnum.CORN, CropEnum.HOTPEPPER, CropEnum.RADISH,
            CropEnum.WHEAT, CropEnum.POPPY, CropEnum.SUNFLOWER, CropEnum.SUMMERSPANGLE
    ))),
    Fall(new ArrayList<>(List.of(
            CropEnum.ARTICHOKE, CropEnum.CORN, CropEnum.EGGPLANT,
            CropEnum.PUMPKIN, CropEnum.SUNFLOWER, CropEnum.FAIRYROSE
    ))),
    Winter(new ArrayList<>(List.of(CropEnum.POWDERMELON)));

    private final ArrayList<CropEnum> mixedSeedPossibleCrops;

    Season(ArrayList<CropEnum> mixedSeedPossibleCrops) {
        this.mixedSeedPossibleCrops = mixedSeedPossibleCrops;
    }

    public ArrayList<CropEnum> getMixedSeedPossibleCrops() {
        return mixedSeedPossibleCrops;
    }
}
