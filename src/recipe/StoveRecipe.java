package recipe;

import java.util.List;

public class StoveRecipe extends Recipe{
    protected String stoveHeatStrength;

    public StoveRecipe(String name,
                       List<Ingredient> ingredientList, List<String> instructionList,
                       String stoveHeatStrength) {
        super(name);
        this.stoveHeatStrength = stoveHeatStrength;
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }
}
