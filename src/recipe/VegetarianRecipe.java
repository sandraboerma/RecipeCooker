package recipe;

import java.util.List;

public class VegetarianRecipe extends Recipe {
    protected boolean isVegan;

    public VegetarianRecipe(String name,
                            List<Ingredient> ingredientList, List<String> instructionList, boolean isVegan) {
        super(name);
        this.isVegan = isVegan;
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }
}
