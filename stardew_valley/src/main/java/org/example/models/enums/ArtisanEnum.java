package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum ArtisanEnum {
    BeeHouse ("Bee House",
            new ArrayList<>(List.of(ArtisanProductEnum.Honey))),
    CheesePress ("Cheese Press",
            new ArrayList<>(List.of(
                    ArtisanProductEnum.Cheese,
                    ArtisanProductEnum.GoatCheese))),
    Keg ("Keg",
            new ArrayList<>(List.of(
                    ArtisanProductEnum.Beer,
                    ArtisanProductEnum.Vinegar,
                    ArtisanProductEnum.Coffee,
                    ArtisanProductEnum.Juice,
                    ArtisanProductEnum.Mead,
                    ArtisanProductEnum.PaleAle,
                    ArtisanProductEnum.Wine))),
    Dehydrator ("Dehydrator",
            new ArrayList<>(List.of(
                    ArtisanProductEnum.DriedMushrooms,
                    ArtisanProductEnum.DriedFruit,
                    ArtisanProductEnum.Raisins))),
    CharcoalKiln ("Charcoal Kiln",
            new ArrayList<>(List.of(ArtisanProductEnum.Coal))),
    Loom ("Loom",
            new ArrayList<>(List.of(ArtisanProductEnum.Cloth))),
    MayonnaiseMachine ("Mayonnaise Machine",
            new ArrayList<>(List.of(
                    ArtisanProductEnum.Mayonnaise,
                    ArtisanProductEnum.DuckMayonnaise,
                    ArtisanProductEnum.DinosaurMayonnaise))),
    OilMaker ("Oil Maker",
            new ArrayList<>(List.of(
                    ArtisanProductEnum.TruffleOil,
                    ArtisanProductEnum.Oil))),
    PreservesJar ("Preserves Jar",
            new ArrayList<>(List.of(
                    ArtisanProductEnum.Pickles,
                    ArtisanProductEnum.Jelly))),
    FishSmoker ("Fish Smoker",
            new ArrayList<>(List.of(ArtisanProductEnum.SmokedFish))),
    Furnace ("Furnace",
            new ArrayList<>(List.of(ArtisanProductEnum.AnyMetalBar))),
    ;

    private final String name;
    private final ArrayList<ArtisanProductEnum> products;

    private ArtisanEnum(String name, ArrayList<ArtisanProductEnum> products) {
        this.name = name;
        this.products = products;
    }
}
