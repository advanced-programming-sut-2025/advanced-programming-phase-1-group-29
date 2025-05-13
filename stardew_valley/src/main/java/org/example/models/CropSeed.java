package org.example.models;

import org.example.models.enums.CropSeedEnum;

public class CropSeed extends Seed{
    private final CropSeedEnum cropSeedEnum;

    public CropSeed(String name, int price) {
        super(name, price);
        name = name.toUpperCase();
        cropSeedEnum = CropSeedEnum.valueOf(name);
    }


    public CropSeedEnum getCropSeedEnum() {
        return cropSeedEnum;
    }
}
