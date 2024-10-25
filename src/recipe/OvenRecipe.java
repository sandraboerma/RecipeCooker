package recipe;

import java.util.List;

public class OvenRecipe extends Recipe {
    protected int ovenTimeInMinutes;
    protected int ovenTemperatureInCelsius;
    protected boolean isSweet;

    public OvenRecipe(String name, String proteinCategory,
                      List<Ingredient> ingredientList, List<String> instructionList,
                      int ovenTimeInMinutes, int ovenTemperatureInCelsius, boolean isSweet) {
        super(name, proteinCategory);
        this.ovenTimeInMinutes = ovenTimeInMinutes;
        this.ovenTemperatureInCelsius = ovenTemperatureInCelsius;
        this.isSweet = isSweet;
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }
}
