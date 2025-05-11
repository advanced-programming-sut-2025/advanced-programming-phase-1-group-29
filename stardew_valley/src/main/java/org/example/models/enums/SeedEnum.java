package org.example.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum SeedEnum {
    JAZZ_SEED("Jazz Seeds", new ArrayList<>(List.of(Season.Spring))),
    CARROT_SEED("Carrot Seeds", new ArrayList<>(List.of(Season.Spring))),
    CAULIFLOWER_SEED("Cauliflower Seeds", new ArrayList<>(List.of(Season.Spring))),
    COFFEE_BEAN("Coffee Bean", new ArrayList<>(List.of(Season.Spring))),
    GARLIC_SEED("Garlic Seeds", new ArrayList<>(List.of(Season.Spring))),
    BEAN_STARTER("Bean Starter", new ArrayList<>(List.of(Season.Spring))),
    KALE_SEED("Kale Seeds", new ArrayList<>(List.of(Season.Spring))),
    PARSNIP_SEED("Parsnip Seeds", new ArrayList<>(List.of(Season.Spring))),
    POTATO_SEED("Potato Seeds", new ArrayList<>(List.of(Season.Spring))),
    RHUBARB_SEED("Rhubarb Seeds", new ArrayList<>(List.of(Season.Spring))),
    STRAWBERRY_SEED("Strawberry Seeds", new ArrayList<>(List.of(Season.Spring))),
    TULIP_BULB("Tulip Bulb", new ArrayList<>(List.of(Season.Spring))),
    RICE_SHOOT("Rice Shoot", new ArrayList<>(List.of(Season.Spring))),
    BLUEBERRY_SEED("Blueberry Seeds", new ArrayList<>(List.of(Season.Summer))),
    CORN_SEED("Corn Seeds", new ArrayList<>(List.of(Season.Summer))),
    HOPS_STARTER("Hops Starter", new ArrayList<>(List.of(Season.Summer))),
    PEPPER_SEED("Pepper Seeds", new ArrayList<>(List.of(Season.Summer))),
    MELON_SEED("Melon Seeds", new ArrayList<>(List.of(Season.Summer))),
    POPPY_SEED("Poppy Seeds", new ArrayList<>(List.of(Season.Summer))),
    RADISH_SEED("Radish Seeds", new ArrayList<>(List.of(Season.Summer))),
    RED_CABBAGE_SEED("Red Cabbage Seeds", new ArrayList<>(List.of(Season.Summer))),
    STARFRUIT_SEED("Starfruit Seeds", new ArrayList<>(List.of(Season.Summer))),
    SPANGLE_SEED("Spangle Seeds", new ArrayList<>(List.of(Season.Summer))),
    SUMMER_SQUASH_SEED("Summer Squash Seeds", new ArrayList<>(List.of(Season.Summer))),
    SUNFLOWER_SEED("Sunflower Seeds", new ArrayList<>(List.of(Season.Summer))),
    TOMATO_SEED("Tomato Seeds", new ArrayList<>(List.of(Season.Summer))),
    WHEAT_SEED("Wheat Seeds", new ArrayList<>(List.of(Season.Summer))),
    AMARANTH_SEED("Amaranth Seeds", new ArrayList<>(List.of(Season.Fall))),
    ARTICHOKE_SEED("Artichoke Seeds", new ArrayList<>(List.of(Season.Fall))),
    BEET_SEED("Beet Seeds", new ArrayList<>(List.of(Season.Fall))),
    BOK_CHOY_SEED("Bok Choy Seeds", new ArrayList<>(List.of(Season.Fall))),
    BROCCOLI_SEED("Broccoli Seeds", new ArrayList<>(List.of(Season.Fall))),
    CRANBERRY_SEED("Cranberry Seeds", new ArrayList<>(List.of(Season.Fall))),
    EGGPLANT_SEED("Eggplant Seeds", new ArrayList<>(List.of(Season.Fall))),
    FAIRY_SEED("Fairy Seeds", new ArrayList<>(List.of(Season.Fall))),
    GRAPE_STARTER("Grape Starter", new ArrayList<>(List.of(Season.Fall))),
    PUMPKIN_SEED("Pumpkin Seeds", new ArrayList<>(List.of(Season.Fall))),
    YAM_SEED("Yam Seeds", new ArrayList<>(List.of(Season.Fall))),
    RARE_SEED("Rare Seeds", new ArrayList<>(List.of(Season.Fall))),
    POWDER_MELON_SEED("Powder Melon Seeds", new ArrayList<>(List.of(Season.Winter))),
    ANCIENT_SEED("Ancient Seeds", new ArrayList<>(List.of(Season.Spring, Season.Summer, Season.Fall, Season.Winter))),
    MIXED_SEED("Mixed Seeds", new ArrayList<>(List.of(Season.Spring, Season.Summer, Season.Fall, Season.Winter)));

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
