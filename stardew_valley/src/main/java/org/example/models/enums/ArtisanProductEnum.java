package org.example.models.enums;

public enum ArtisanProductEnum {

    //-1 -> inedible
    //0 -> based on ingredients

    Honey (75),
    Cheese (100),
    GoatCheese (10),
    Beer (50),
    Vinegar (13),
    Coffee (75),
    Juice (0),
    Mead (100),
    PaleAle (50),
    Wine (0),
    DriedMushrooms (50),
    DriedFruit (75),
    Raisins (125),
    Coal (-1),
    Cloth (-1),
    Mayonnaise (50),
    DuckMayonnaise (75),
    DinosaurMayonnaise (125),
    TruffleOil (38),
    Oil (13),
    Pickles (0),
    Jelly (0),
    SmokedFish (0),
    AnyMetalBar (-1),
    ;

    private final int energy;

    private ArtisanProductEnum (int energy) {
        this.energy = energy;
    }
}
