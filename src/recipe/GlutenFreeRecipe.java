package recipe;

import java.util.List;

public class GlutenFreeRecipe extends Recipe {
    protected boolean containsOats;

    public GlutenFreeRecipe(String name, DietaryPreference dietaryPreference, List<Ingredient> ingredientList,
                            List<String> instructionList, boolean containsOats) {
        super(name, dietaryPreference);
        this.containsOats = containsOats;
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }

    public boolean containsOats() {
        return this.containsOats;
    }
}