package service;

import recipe.*;

import java.util.List;

public class RecipeFactory {
    public static Recipe createRecipe(DietaryPreference method, String name, DietaryPreference dietaryPreference,
                                      List<Ingredient> ingredientList, List<String> instructionList,
                                      boolean isVegan, boolean containsOats) {
        return switch (method) {
            case VEGETARIAN -> new VegetarianRecipe(name, dietaryPreference, ingredientList,
                    instructionList, isVegan);
            case GLUTEN_FREE -> new GlutenFreeRecipe(name, dietaryPreference, ingredientList,
                    instructionList, containsOats);
            case ANY_DIET -> new AnyDietRecipe(name, dietaryPreference, ingredientList, instructionList);
        };
    }
}