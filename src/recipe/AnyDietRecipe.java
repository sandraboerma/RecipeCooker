package recipe;

import java.util.List;

public class AnyDietRecipe extends Recipe{
    public AnyDietRecipe(String name, List<Ingredient> ingredientList, List<String> instructionList){
        super(name);
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }
}
