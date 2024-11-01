package recipe;

import java.util.ArrayList;
import java.util.List;

public abstract class Recipe {

    private String name;
    private List<Ingredient> ingredientList;
    private List<String> instructionsList;

    public Recipe(String name) {
        this.name = name;
        this.ingredientList = new ArrayList<>();
        this.instructionsList = new ArrayList<>();
    }

    public String getRecipeName() {
        return name;
    }

    public void addIngredient(Ingredient item) {
        ingredientList.add(item);
    }

    public List<Ingredient> getIngredientsList() {
        return new ArrayList<>(ingredientList);
    }

    public void addInstruction(String steps) {
        instructionsList.add(steps);
    }

    public List<String> getInstructionsList() {
        return new ArrayList<>(instructionsList);
    }
}
