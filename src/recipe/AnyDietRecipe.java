package recipe;

import java.util.List;

public class AnyDietRecipe extends Recipe{
    public AnyDietRecipe(String name, DietaryPreference dietaryPreference,
                         List<Ingredient> ingredientList, List<String> instructionList){
        super(name, dietaryPreference);
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }
}
