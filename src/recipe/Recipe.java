package recipe;

import java.util.ArrayList;
import java.util.List;

public abstract class Recipe {

    private String name;
    private String proteinCategory;
    private List<Ingredient> ingredientList = new ArrayList<>();
    private List<String> instructionsList = new ArrayList<>();

    public void assignCategory(String mainProteinType){
        this.proteinCategory = mainProteinType;
    }

    public String getProteinCategory() {
        return proteinCategory;
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
