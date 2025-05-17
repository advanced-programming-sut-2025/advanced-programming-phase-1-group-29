package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum CropSeedEnum {
    JAZZSEEDS("Jazz Seeds", new ArrayList<>(List.of("Spring"))),
    CARROTSEEDS("Carrot Seeds", new ArrayList<>(List.of("Spring"))),
    CAULIFLOWERSEEDS("Cauliflower Seeds", new ArrayList<>(List.of("Spring"))),
    COFFEEBEAN("Coffee Bean", new ArrayList<>(List.of("Spring"))),
    GARLICSEEDS("Garlic Seeds", new ArrayList<>(List.of("Spring"))),
    BEANSTARTERS("Bean Starter", new ArrayList<>(List.of("Spring"))),
    KALESEEDS("Kale Seeds", new ArrayList<>(List.of("Spring"))),
    PARSNIPSEEDS("Parsnip Seeds", new ArrayList<>(List.of("Spring"))),
    POTATOSEEDS("Potato Seeds", new ArrayList<>(List.of("Spring"))),
    RHUBARBSEEDS("Rhubarb Seeds", new ArrayList<>(List.of("Spring"))),
    STRAWBERRYSEEDS("Strawberry Seeds", new ArrayList<>(List.of("Spring"))),
    TULIPBULB("Tulip Bulb", new ArrayList<>(List.of("Spring"))),
    RICESHOOT("Rice Shoot", new ArrayList<>(List.of("Spring"))),
    BLUEBERRYSEEDS("Blueberry Seeds", new ArrayList<>(List.of("Summer"))),
    CORNSEEDS("Corn Seeds", new ArrayList<>(List.of("Summer"))),
    HOPSSTARTER("Hops Starter", new ArrayList<>(List.of("Summer"))),
    PEPPERSEEDS("Pepper Seeds", new ArrayList<>(List.of("Summer"))),
    MELONSEEDS("Melon Seeds", new ArrayList<>(List.of("Summer"))),
    POPPYSEEDS("Poppy Seeds", new ArrayList<>(List.of("Summer"))),
    RADISHSEEDS("Radish Seeds", new ArrayList<>(List.of("Summer"))),
    REDCABBAGESEEDS("Red Cabbage Seeds", new ArrayList<>(List.of("Summer"))),
    STARFRUITSEEDS("Starfruit Seeds", new ArrayList<>(List.of("Summer"))),
    SPANGLESEEDS("Spangle Seeds", new ArrayList<>(List.of("Summer"))),
    SUMMERSQUASHSEEDS("Summer Squash Seeds", new ArrayList<>(List.of("Summer"))),
    SUNFLOWERSEEDS("Sunflower Seeds", new ArrayList<>(List.of("Summer"))),
    TOMATOSEEDS("Tomato Seeds", new ArrayList<>(List.of("Summer"))),
    WHEATSEEDS("Wheat Seeds", new ArrayList<>(List.of("Summer"))),
    AMARANTHSEEDS("Amaranth Seeds", new ArrayList<>(List.of("Fall"))),
    ARTICHOKESEEDS("Artichoke Seeds", new ArrayList<>(List.of("Fall"))),
    BEETSEEDS("Beet Seeds", new ArrayList<>(List.of("Fall"))),
    BOKCHOYSEEDS("Bok Choy Seeds", new ArrayList<>(List.of("Fall"))),
    BROCCOLISEEDS("Broccoli Seeds", new ArrayList<>(List.of("Fall"))),
    CRANBERRYSEEDS("Cranberry Seeds", new ArrayList<>(List.of("Fall"))),
    EGGPLANTSEEDS("Eggplant Seeds", new ArrayList<>(List.of("Fall"))),
    FAIRYSEEDS("Fairy Seeds", new ArrayList<>(List.of("Fall"))),
    GRAPESTARTER("Grape Starter", new ArrayList<>(List.of("Fall"))),
    PUMPKINSEEDS("Pumpkin Seeds", new ArrayList<>(List.of("Fall"))),
    YAMSEEDS("Yam Seeds", new ArrayList<>(List.of("Fall"))),
    RARESEEDS("Rare Seeds", new ArrayList<>(List.of("Fall"))),
    POWDERMELONSEEDS("Powder Melon Seeds", new ArrayList<>(List.of("Winter"))),
    ANCIENTSEEDS("Ancient Seeds", new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))),
    MIXEDSEEDS("Mixed Seeds", new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter")));

    private final String name;
    private final ArrayList<String> seasons;

    CropSeedEnum(String name, ArrayList<String> seasons) {
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
