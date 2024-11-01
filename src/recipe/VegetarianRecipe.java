package recipe;

import java.util.List;

public class VegetarianRecipe extends Recipe {
    protected boolean isVegetarian;

    public VegetarianRecipe(String name,
                            List<Ingredient> ingredientList, List<String> instructionList, boolean isVegetarian) {
        super(name);
        this.isVegetarian = isVegetarian;
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }
}
