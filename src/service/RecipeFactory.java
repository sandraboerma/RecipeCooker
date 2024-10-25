package service;

import recipe.*;

public class RecipeFactory {
    public static Recipe createRecipe(CookingMethod method, String name, String proteinCategory,
                                      int ovenTimeInMinuts, int ovenTemperatureInCelcius, boolean isSweet,
                                      String stoveHeatStrength) {
        return switch (method) {
            case OVEN -> new OvenRecipe(name, proteinCategory, ovenTimeInMinuts, ovenTemperatureInCelcius, isSweet);
            case STOVE -> new StoveRecipe(name, proteinCategory, stoveHeatStrength);
            case ANY_METHOD -> new AnyMethodRecipe(name, proteinCategory);
            default -> throw new IllegalArgumentException("Unknown recipe method: " + method);
        };
    }
}
