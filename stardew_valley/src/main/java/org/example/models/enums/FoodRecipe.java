package org.example.models.enums;

public enum FoodRecipe {

    HashbrownsRecipe ("Hashbrowns Recipe", FoodEnum.HashBrowns),
    OmeletRecipe ("Omelet Recipe", FoodEnum.Omelet),
    PancakesRecipe ("Pancakes Recipe", FoodEnum.Pancakes),
    BreadRecipe ("Bread Recipe", FoodEnum.Bread),
    TortillaRecipe ("Tortilla Recipe", FoodEnum.Tortilla),
    PizzaRecipe ("Pizza Recipe", FoodEnum.Pizza),
    MakiRollRecipe ("Maki Roll Recipe", FoodEnum.MakiRoll),
    TripleShotEspressoRecipe ("Triple Shot Espresso Recipe", FoodEnum.TripleShotEspresso),
    CookieRecipe ("Cookie Recipe", FoodEnum.Cookie),
    FishSmokerRecipe ("Fish Smoker Recipe", FoodEnum.BakedFish),//?
    ;

    private final String name;
    private final FoodEnum food;

    private FoodRecipe(String name, FoodEnum foodEnum) {
        this.name = name;
        this.food = foodEnum;
    }

    public String getName() {
        return name;
    }

    public FoodEnum getFood() {
        return food;
    }

    public static FoodRecipe getRecipeByName(String recipeName) {
        for (FoodRecipe recipe : FoodRecipe.values()) {
            if(recipe.toString().equalsIgnoreCase(recipeName)){
                return recipe;
            }
        }
        return null;
    }
}
