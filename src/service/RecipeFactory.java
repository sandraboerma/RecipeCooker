package service;

import recipe.*;

import java.util.List;

public class RecipeFactory {
    public static Recipe createRecipe(DietaryPreference method, String name,
                                      List<Ingredient> ingredientList, List<String> instructionList,
                                      boolean isVegan, boolean containsOats) {
        return switch (method) {
            case VEGETARIAN -> new VegetarianRecipe(name, ingredientList, instructionList, isVegan);
            case GLUTEN_FREE -> new GlutenFreeRecipe(name, ingredientList, instructionList, containsOats);
            case ANY_DIET -> new AnyDietRecipe(name, ingredientList, instructionList);
        };
    }
}
