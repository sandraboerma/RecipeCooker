package recipe;

import java.util.ArrayList;
import java.util.List;

public abstract class Recipe {

    private final String name;
    private final DietaryPreference dietaryPreference;
    private final List<Ingredient> ingredientList;
    private final List<String> instructionsList;

    public Recipe(String name, DietaryPreference dietaryPreference) {
        this.name = name;
        this.ingredientList = new ArrayList<>();
        this.instructionsList = new ArrayList<>();
        this.dietaryPreference = dietaryPreference;
    }

    public String getRecipeName() {
        return name;
    }

    public DietaryPreference getDietaryPreference() {
        return dietaryPreference;
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
