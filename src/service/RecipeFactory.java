package service;

import recipe.*;

import java.util.List;

public class RecipeFactory {
    public static Recipe createRecipe(CookingMethod method, String name, String proteinCategory,
                                      List<Ingredient> ingredientList, List<String> instructionList,
                                      int ovenTimeInMinutes, int ovenTemperatureInCelsius, boolean isSweet,
                                      String stoveHeatStrength) {
        return switch (method) {
            case OVEN -> new OvenRecipe(name, proteinCategory, ingredientList, instructionList,
                    ovenTimeInMinutes, ovenTemperatureInCelsius, isSweet);
            case STOVE -> new StoveRecipe(name, proteinCategory, ingredientList, instructionList,
                    stoveHeatStrength);
            case ANY_METHOD -> new AnyMethodRecipe(name, proteinCategory, ingredientList, instructionList);
            default -> throw new IllegalArgumentException("Unknown recipe method: " + method);
        };
    }
}
