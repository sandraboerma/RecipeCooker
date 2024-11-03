package recipe;

import java.util.List;

public class VegetarianRecipe extends Recipe {
    protected boolean isVegan;

    public VegetarianRecipe(String name, DietaryPreference dietaryPreference,
                            List<Ingredient> ingredientList, List<String> instructionList, boolean isVegan) {
        super(name, dietaryPreference);
        this.isVegan = isVegan;
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }

    public boolean isVegan() {
        return this.isVegan;
    }
}
