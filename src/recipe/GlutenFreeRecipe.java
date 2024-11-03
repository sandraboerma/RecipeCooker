package recipe;

import java.util.List;

public class GlutenFreeRecipe extends Recipe {
    boolean containsOats;

    public GlutenFreeRecipe(String name, List<Ingredient> ingredientList,
                            List<String> instructionList, boolean containsOats) {
        super(name);
        this.containsOats = containsOats;
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }
}