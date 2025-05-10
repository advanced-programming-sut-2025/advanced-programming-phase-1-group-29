package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum SeedEnum {
    JazzSeed(new ArrayList<>(List.of(Season.SPRING))),
    CarrotSeed(new ArrayList<>(List.of(Season.SPRING))),
    CauliflowerSeed(new ArrayList<>(List.of(Season.SPRING))),
    CoffeeBean(new ArrayList<>(List.of(Season.SPRING))),
    GarlicSeed(new ArrayList<>(List.of(Season.SPRING))),
    BeanStarter(new ArrayList<>(List.of(Season.SPRING))),
    KaleSeed(new ArrayList<>(List.of(Season.SPRING))),
    ParsnipSeed(new ArrayList<>(List.of(Season.SPRING))),
    PotatoSeed(new ArrayList<>(List.of(Season.SPRING))),
    RhubarbSeed(new ArrayList<>(List.of(Season.SPRING))),
    StrawberrySeed(new ArrayList<>(List.of(Season.SPRING))),
    TulipBulb(new ArrayList<>(List.of(Season.SPRING))),
    RiceShoot(new ArrayList<>(List.of(Season.SPRING))),
    BlueberrySeed(new ArrayList<>(List.of(Season.SUMMER))),
    CornSeed(new ArrayList<>(List.of(Season.SUMMER))),
    HopsStarter(new ArrayList<>(List.of(Season.SUMMER))),
    PepperSeed(new ArrayList<>(List.of(Season.SUMMER))),
    MelonSeed(new ArrayList<>(List.of(Season.SUMMER))),
    PoppySeed(new ArrayList<>(List.of(Season.SUMMER))),
    RadishSeed(new ArrayList<>(List.of(Season.SUMMER))),
    RedCabbageSeed(new ArrayList<>(List.of(Season.SUMMER))),
    StarfruitSeed(new ArrayList<>(List.of(Season.SUMMER))),
    SpangleSeed(new ArrayList<>(List.of(Season.SUMMER))),
    SummerSquashSeed(new ArrayList<>(List.of(Season.SUMMER))),
    SunflowerSeed(new ArrayList<>(List.of(Season.SUMMER))),
    TomatoSeed(new ArrayList<>(List.of(Season.SUMMER))),
    WheatSeed(new ArrayList<>(List.of(Season.SUMMER))),
    AmaranthSeed(new ArrayList<>(List.of(Season.AUTUMN))),
    ArtichokeSeed(new ArrayList<>(List.of(Season.AUTUMN))),
    BeetSeed(new ArrayList<>(List.of(Season.AUTUMN))),
    BokChoySeed(new ArrayList<>(List.of(Season.AUTUMN))),
    BroccoliSeed(new ArrayList<>(List.of(Season.AUTUMN))),
    CranberrySeed(new ArrayList<>(List.of(Season.AUTUMN))),
    EggplantSeed(new ArrayList<>(List.of(Season.AUTUMN))),
    FairySeed(new ArrayList<>(List.of(Season.AUTUMN))),
    GrapeStarter(new ArrayList<>(List.of(Season.AUTUMN))),
    PumpkinSeed(new ArrayList<>(List.of(Season.AUTUMN))),
    YamSeed(new ArrayList<>(List.of(Season.AUTUMN))),
    RareSeed(new ArrayList<>(List.of(Season.AUTUMN))),
    PowderMelonSeed(new ArrayList<>(List.of(Season.WINTER))),
    AncientSeed(new ArrayList<>(List.of(Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER))),
    MixedSeed(new ArrayList<>(List.of(Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER)));
    private final ArrayList<Season> seasons;

    SeedEnum(ArrayList<Season> seasons) {
        this.seasons = seasons;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }
}
