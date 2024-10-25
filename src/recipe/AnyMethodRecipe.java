package recipe;

import java.util.List;

public class AnyMethodRecipe extends Recipe{
    public AnyMethodRecipe(String name, String proteinCategory,
                           List<Ingredient> ingredientList, List<String> instructionList){
        super(name, proteinCategory);
        ingredientList.forEach(this::addIngredient);
        instructionList.forEach(this::addInstruction);
    }
}
