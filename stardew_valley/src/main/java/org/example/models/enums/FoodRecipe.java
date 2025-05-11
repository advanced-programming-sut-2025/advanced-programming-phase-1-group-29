package org.example.models.enums;

public enum FoodRecipe {

    HashbrownsRecipe ("Hashbrowns Recipe", Food.HashBrowns),
    OmeletRecipe ("Omelet Recipe", Food.Omelet),
    PancakesRecipe ("Pancakes Recipe", Food.Pancakes),
    BreadRecipe ("Bread Recipe", Food.Bread),
    TortillaRecipe ("Tortilla Recipe", Food.Tortilla),
    PizzaRecipe ("Pizza Recipe", Food.Pizza),
    MakiRollRecipe ("Maki Roll Recipe", Food.MakiRoll),
    TripleShotEspressoRecipe ("Triple Shot Espresso Recipe", Food.TripleShotEspresso),
    CookieRecipe ("Cookie Recipe", Food.Cookie),
    FishSmokerRecipe ("Fish Smoker Recipe", Food.BakedFish),//?
    ;

    private final String name;
    private final Food food;

    private FoodRecipe(String name, Food food) {
        this.name = name;
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public Food getFood() {
        return food;
    }

    public static FoodRecipe getRecipeByName(String recipeName) {
        for (FoodRecipe recipe : FoodRecipe.values()) {
            if(recipe.name.equals(recipeName)){
                return recipe;
            }
        }
        return null;
    }
}
