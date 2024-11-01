package recipe;

import java.util.List;

public class VegetarianRecipe extends Recipe {
    protected int ovenTimeInMinutes;
    protected int ovenTemperatureInCelsius;
    protected boolean isSweet;

    public VegetarianRecipe(String name,
                            List<Ingredient> ingredientList, List<String> instructionList,
                            int ovenTimeInMinutes, int ovenTemperatureInCelsius, boolean isSweet) {
        super(name);
        this.ovenTimeInMinutes = ovenTimeInMinutes;
        this.ovenTemperatureInCelsius = ovenTemperatureInCelsius;
        this.isSweet = isSweet;
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }
}