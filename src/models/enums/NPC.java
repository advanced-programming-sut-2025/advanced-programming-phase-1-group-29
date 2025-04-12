package models.enums;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public enum NPC {
    Sebastien("Sebastien", new ArrayList<String>(List.of("wool","paye kadoo","pizza"))),
    Abigail("Abigail", new ArrayList<String>(List.of("stone","iron","coffee"))),
    Harvy("Harvy", new ArrayList<String>(List.of("coffee","torshi","wine"))),
    Lia("Lia", new ArrayList<String>(List.of("salad","grape","wine"))),
    Robin("Robin", new ArrayList<String>(List.of("spaghetti","wood","iron")));


    private String name;
    private ArrayList<String> favorites;

    NPC(String name, ArrayList<String> favorites) {
        this.name = name;
        this.favorites = favorites;
    }
}
