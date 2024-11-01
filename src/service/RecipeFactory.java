package service;

import recipe.*;

import java.util.List;

public class RecipeFactory {
    public static Recipe createRecipe(DietaryPreference method, String name,
                                      List<Ingredient> ingredientList, List<String> instructionList,
                                      boolean isVegetarian,String stoveHeatStrength) {
        return switch (method) {
            case VEGETARIAN -> new VegetarianRecipe(name, ingredientList, instructionList, isVegetarian);
            case GLUTEN_FREE -> new GlutenFreeRecipe(name, ingredientList, instructionList, stoveHeatStrength);
            case ANY_DIET -> new AnyDietRecipe(name, ingredientList, instructionList);
            default -> throw new IllegalArgumentException("Unknown recipe method: " + method);
        };
    }
}
