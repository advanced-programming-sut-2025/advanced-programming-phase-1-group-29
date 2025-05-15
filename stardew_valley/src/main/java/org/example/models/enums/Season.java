package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum Season {
    Spring(
            new ArrayList<>(List.of(
                    CropEnum.CAULIFLOWER, CropEnum.PARSNIP, CropEnum.POTATO,
                    CropEnum.BLUEJAZZ, CropEnum.TULIP
            )),
            new ArrayList<>(List.of(Weather.SUNNY, Weather.RAINY, Weather.STORMY))
    ),
    Summer(
            new ArrayList<>(List.of(
                    CropEnum.CORN, CropEnum.HOTPEPPER, CropEnum.RADISH,
                    CropEnum.WHEAT, CropEnum.POPPY, CropEnum.SUNFLOWER, CropEnum.SUMMERSPANGLE
            )),
            new ArrayList<>(List.of(Weather.SUNNY, Weather.RAINY, Weather.STORMY))
    ),
    Fall(
            new ArrayList<>(List.of(
                    CropEnum.ARTICHOKE, CropEnum.CORN, CropEnum.EGGPLANT,
                    CropEnum.PUMPKIN, CropEnum.SUNFLOWER, CropEnum.FAIRYROSE
            )),
            new ArrayList<>(List.of(Weather.SUNNY, Weather.RAINY, Weather.STORMY))
    ),
    Winter(
            new ArrayList<>(List.of(CropEnum.POWDERMELON)),
            new ArrayList<>(List.of(Weather.SUNNY, Weather.SNOWY))
    );

    private final ArrayList<CropEnum> mixedSeedPossibleCrops;
    private final ArrayList<Weather> weathers;

    Season(ArrayList<CropEnum> mixedSeedPossibleCrops, ArrayList<Weather> weathers) {
        this.mixedSeedPossibleCrops = mixedSeedPossibleCrops;
        this.weathers = weathers;
    }

    public ArrayList<CropEnum> getMixedSeedPossibleCrops() {
        return mixedSeedPossibleCrops;
    }

    public ArrayList<Weather> getWeathers() {
        return weathers;
    }
}
