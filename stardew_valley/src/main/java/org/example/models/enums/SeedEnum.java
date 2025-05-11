package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum SeedEnum {
    JAZZ_SEED("Jazz Seeds", new ArrayList<>(List.of("Spring"))),
    CARROT_SEED("Carrot Seeds", new ArrayList<>(List.of("Spring"))),
    CAULIFLOWER_SEED("Cauliflower Seeds", new ArrayList<>(List.of("Spring"))),
    COFFEE_BEAN("Coffee Bean", new ArrayList<>(List.of("Spring"))),
    GARLIC_SEED("Garlic Seeds", new ArrayList<>(List.of("Spring"))),
    BEAN_STARTER("Bean Starter", new ArrayList<>(List.of("Spring"))),
    KALE_SEED("Kale Seeds", new ArrayList<>(List.of("Spring"))),
    PARSNIP_SEED("Parsnip Seeds", new ArrayList<>(List.of("Spring"))),
    POTATO_SEED("Potato Seeds", new ArrayList<>(List.of("Spring"))),
    RHUBARB_SEED("Rhubarb Seeds", new ArrayList<>(List.of("Spring"))),
    STRAWBERRY_SEED("Strawberry Seeds", new ArrayList<>(List.of("Spring"))),
    TULIP_BULB("Tulip Bulb", new ArrayList<>(List.of("Spring"))),
    RICE_SHOOT("Rice Shoot", new ArrayList<>(List.of("Spring"))),
    BLUEBERRY_SEED("Blueberry Seeds", new ArrayList<>(List.of("Summer"))),
    CORN_SEED("Corn Seeds", new ArrayList<>(List.of("Summer"))),
    HOPS_STARTER("Hops Starter", new ArrayList<>(List.of("Summer"))),
    PEPPER_SEED("Pepper Seeds", new ArrayList<>(List.of("Summer"))),
    MELON_SEED("Melon Seeds", new ArrayList<>(List.of("Summer"))),
    POPPY_SEED("Poppy Seeds", new ArrayList<>(List.of("Summer"))),
    RADISH_SEED("Radish Seeds", new ArrayList<>(List.of("Summer"))),
    RED_CABBAGE_SEED("Red Cabbage Seeds", new ArrayList<>(List.of("Summer"))),
    STARFRUIT_SEED("Starfruit Seeds", new ArrayList<>(List.of("Summer"))),
    SPANGLE_SEED("Spangle Seeds", new ArrayList<>(List.of("Summer"))),
    SUMMER_SQUASH_SEED("Summer Squash Seeds", new ArrayList<>(List.of("Summer"))),
    SUNFLOWER_SEED("Sunflower Seeds", new ArrayList<>(List.of("Summer"))),
    TOMATO_SEED("Tomato Seeds", new ArrayList<>(List.of("Summer"))),
    WHEAT_SEED("Wheat Seeds", new ArrayList<>(List.of("Summer"))),
    AMARANTH_SEED("Amaranth Seeds", new ArrayList<>(List.of("Fall"))),
    ARTICHOKE_SEED("Artichoke Seeds", new ArrayList<>(List.of("Fall"))),
    BEET_SEED("Beet Seeds", new ArrayList<>(List.of("Fall"))),
    BOK_CHOY_SEED("Bok Choy Seeds", new ArrayList<>(List.of("Fall"))),
    BROCCOLI_SEED("Broccoli Seeds", new ArrayList<>(List.of("Fall"))),
    CRANBERRY_SEED("Cranberry Seeds", new ArrayList<>(List.of("Fall"))),
    EGGPLANT_SEED("Eggplant Seeds", new ArrayList<>(List.of("Fall"))),
    FAIRY_SEED("Fairy Seeds", new ArrayList<>(List.of("Fall"))),
    GRAPE_STARTER("Grape Starter", new ArrayList<>(List.of("Fall"))),
    PUMPKIN_SEED("Pumpkin Seeds", new ArrayList<>(List.of("Fall"))),
    YAM_SEED("Yam Seeds", new ArrayList<>(List.of("Fall"))),
    RARE_SEED("Rare Seeds", new ArrayList<>(List.of("Fall"))),
    POWDER_MELON_SEED("Powder Melon Seeds", new ArrayList<>(List.of("Winter"))),
    ANCIENT_SEED("Ancient Seeds", new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter"))),
    MIXED_SEED("Mixed Seeds", new ArrayList<>(List.of("Spring", "Summer", "Fall", "Winter")));

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
