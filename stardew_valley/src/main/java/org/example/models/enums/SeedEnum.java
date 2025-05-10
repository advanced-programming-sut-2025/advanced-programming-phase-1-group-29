package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum SeedEnum {
    JAZZ_SEED("Jazz Seeds", new ArrayList<>(List.of(Season.SPRING))),
    CARROT_SEED("Carrot Seeds", new ArrayList<>(List.of(Season.SPRING))),
    CAULIFLOWER_SEED("Cauliflower Seeds", new ArrayList<>(List.of(Season.SPRING))),
    COFFEE_BEAN("Coffee Bean", new ArrayList<>(List.of(Season.SPRING))),
    GARLIC_SEED("Garlic Seeds", new ArrayList<>(List.of(Season.SPRING))),
    BEAN_STARTER("Bean Starter", new ArrayList<>(List.of(Season.SPRING))),
    KALE_SEED("Kale Seeds", new ArrayList<>(List.of(Season.SPRING))),
    PARSNIP_SEED("Parsnip Seeds", new ArrayList<>(List.of(Season.SPRING))),
    POTATO_SEED("Potato Seeds", new ArrayList<>(List.of(Season.SPRING))),
    RHUBARB_SEED("Rhubarb Seeds", new ArrayList<>(List.of(Season.SPRING))),
    STRAWBERRY_SEED("Strawberry Seeds", new ArrayList<>(List.of(Season.SPRING))),
    TULIP_BULB("Tulip Bulb", new ArrayList<>(List.of(Season.SPRING))),
    RICE_SHOOT("Rice Shoot", new ArrayList<>(List.of(Season.SPRING))),
    BLUEBERRY_SEED("Blueberry Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    CORN_SEED("Corn Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    HOPS_STARTER("Hops Starter", new ArrayList<>(List.of(Season.SUMMER))),
    PEPPER_SEED("Pepper Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    MELON_SEED("Melon Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    POPPY_SEED("Poppy Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    RADISH_SEED("Radish Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    RED_CABBAGE_SEED("Red Cabbage Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    STARFRUIT_SEED("Starfruit Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    SPANGLE_SEED("Spangle Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    SUMMER_SQUASH_SEED("Summer Squash Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    SUNFLOWER_SEED("Sunflower Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    TOMATO_SEED("Tomato Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    WHEAT_SEED("Wheat Seeds", new ArrayList<>(List.of(Season.SUMMER))),
    AMARANTH_SEED("Amaranth Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    ARTICHOKE_SEED("Artichoke Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    BEET_SEED("Beet Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    BOK_CHOY_SEED("Bok Choy Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    BROCCOLI_SEED("Broccoli Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    CRANBERRY_SEED("Cranberry Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    EGGPLANT_SEED("Eggplant Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    FAIRY_SEED("Fairy Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    GRAPE_STARTER("Grape Starter", new ArrayList<>(List.of(Season.AUTUMN))),
    PUMPKIN_SEED("Pumpkin Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    YAM_SEED("Yam Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    RARE_SEED("Rare Seeds", new ArrayList<>(List.of(Season.AUTUMN))),
    POWDER_MELON_SEED("Powder Melon Seeds", new ArrayList<>(List.of(Season.WINTER))),
    ANCIENT_SEED("Ancient Seeds", new ArrayList<>(List.of(Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER))),
    MIXED_SEED("Mixed Seeds", new ArrayList<>(List.of(Season.SPRING, Season.SUMMER, Season.AUTUMN, Season.WINTER)));

    private final String name;
    private final ArrayList<Season> seasons;

    SeedEnum(String name, ArrayList<Season> seasons) {
        this.name = name;
        this.seasons = seasons;
    }

    public ArrayList<Season> getSeasons() {
        return seasons;
    }

    public String getName() {
        return name;
    }
}
