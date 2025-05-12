package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum SeedEnum {
    JAZZSEED("Jazz Seeds", new ArrayList<>(List.of("Spring"))),
    CARROTSEED("Carrot Seeds", new ArrayList<>(List.of("Spring"))),
    CAULIFLOWERSEED("Cauliflower Seeds", new ArrayList<>(List.of("Spring"))),
    COFFEEBEAN("Coffee Bean", new ArrayList<>(List.of("Spring"))),
    GARLICSEED("Garlic Seeds", new ArrayList<>(List.of("Spring"))),
    BEANSTARTER("Bean Starter", new ArrayList<>(List.of("Spring"))),
    KALESEED("Kale Seeds", new ArrayList<>(List.of("Spring"))),
    PARSNIPSEED("Parsnip Seeds", new ArrayList<>(List.of("Spring"))),
    POTATOSEED("Potato Seeds", new ArrayList<>(List.of("Spring"))),
    RHUBARBSEED("Rhubarb Seeds", new ArrayList<>(List.of("Spring"))),
    STRAWBERRYSEED("Strawberry Seeds", new ArrayList<>(List.of("Spring"))),
    TULIPBULB("Tulip Bulb", new ArrayList<>(List.of("Spring"))),
    RICESHOOT("Rice Shoot", new ArrayList<>(List.of("Spring"))),
    BLUEBERRYSEED("Blueberry Seeds", new ArrayList<>(List.of("Summer"))),
    CORNSEED("Corn Seeds", new ArrayList<>(List.of("Summer"))),
    HOPSSTARTER("Hops Starter", new ArrayList<>(List.of("Summer"))),
    PEPPERSEED("Pepper Seeds", new ArrayList<>(List.of("Summer"))),
    MELONSEED("Melon Seeds", new ArrayList<>(List.of("Summer"))),
    POPPYSEED("Poppy Seeds", new ArrayList<>(List.of("Summer"))),
    RADISHSEED("Radish Seeds", new ArrayList<>(List.of("Summer"))),
    REDCABBAGESEED("Red Cabbage Seeds", new ArrayList<>(List.of("Summer"))),
    STARFRUITSEED("Starfruit Seeds", new ArrayList<>(List.of("Summer"))),
    SPANGLESEED("Spangle Seeds", new ArrayList<>(List.of("Summer"))),
    SUMMERSQUASHSEED("Summer Squash Seeds", new ArrayList<>(List.of("Summer"))),
    SUNFLOWERSEED("Sunflower Seeds", new ArrayList<>(List.of("Summer"))),
    TOMATOSEED("Tomato Seeds", new ArrayList<>(List.of("Summer"))),
    WHEATSEED("Wheat Seeds", new ArrayList<>(List.of("Summer"))),
    AMARANTHSEED("Amaranth Seeds", new ArrayList<>(List.of("Fall"))),
    ARTICHOKESEED("Artichoke Seeds", new ArrayList<>(List.of("Fall"))),
    BEETSEED("Beet Seeds", new ArrayList<>(List.of("Fall"))),
    BOKCHOYSEED("Bok Choy Seeds", new ArrayList<>(List.of("Fall"))),
    BROCCOLISEED("Broccoli Seeds", new ArrayList<>(List.of("Fall"))),
    CRANBERRYSEED("Cranberry Seeds", new ArrayList<>(List.of("Fall"))),
    EGGPLANTSEED("Eggplant Seeds", new ArrayList<>(List.of("Fall"))),
    FAIRYSEED("Fairy Seeds", new ArrayList<>(List.of("Fall"))),
    GRAPESTARTER("Grape Starter", new ArrayList<>(List.of("Fall"))),
    PUMPKINSEED("Pumpkin Seeds", new ArrayList<>(List.of("Fall"))),
    YAMSEED("Yam Seeds", new ArrayList<>(List.of("Fall"))),
    RARESEED("Rare Seeds", new ArrayList<>(List.of("Fall"))),
    POWDERMELONSEED("Powder Melon Seeds", new ArrayList<>(List.of("Winter"))),
    ANCIENTSEED("Ancient Seeds", new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))),
    MIXEDSEED("Mixed Seeds", new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter")));

    private final String name;
    private final ArrayList<String> seasons;

    SeedEnum(String name, ArrayList<String> seasons) {
        this.name = name;
        this.seasons = seasons;
    }

    public ArrayList<String> getSeasons() {
        return seasons;
    }

    public String getName() {
        return name;
    }
}
