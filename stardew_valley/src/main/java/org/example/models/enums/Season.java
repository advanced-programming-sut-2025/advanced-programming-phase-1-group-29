package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum Season {
    Spring(new ArrayList<>(List.of(
            CropEnum.CAULIFLOWER, CropEnum.PARSNIP, CropEnum.POTATO,
            CropEnum.BLUE_JAZZ, CropEnum.TULIP
    ))),
    Summer(new ArrayList<>(List.of(
            CropEnum.CORN, CropEnum.HOT_PEPPER, CropEnum.RADISH,
            CropEnum.WHEAT, CropEnum.POPPY, CropEnum.SUNFLOWER, CropEnum.SUMMER_SPANGLE
    ))),
    Fall(new ArrayList<>(List.of(
            CropEnum.ARTICHOKE, CropEnum.CORN, CropEnum.EGGPLANT,
            CropEnum.PUMPKIN, CropEnum.SUNFLOWER, CropEnum.FAIRY_ROSE
    ))),
    Winter(new ArrayList<>(List.of(CropEnum.POWDER_MELON)));

    private final ArrayList<CropEnum> mixedSeedPossibleCrops;

    Season(ArrayList<CropEnum> mixedSeedPossibleCrops) {
        this.mixedSeedPossibleCrops = mixedSeedPossibleCrops;
    }

    public ArrayList<CropEnum> getMixedSeedPossibleCrops() {
        return mixedSeedPossibleCrops;
    }
}
