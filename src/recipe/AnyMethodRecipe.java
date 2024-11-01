package recipe;

import java.util.List;

public class AnyMethodRecipe extends Recipe{
    public AnyMethodRecipe(String name,
                           List<Ingredient> ingredientList, List<String> instructionList){
        super(name);
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }
}
