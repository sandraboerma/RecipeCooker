package recipe;

import java.util.ArrayList;
import java.util.List;

public abstract class Recipe {

    private String name;
    private List<Ingredient> ingredientList = new ArrayList<>();
    private List<Instructions> instructionsList = new ArrayList<>();

    public void addIngredient(Ingredient item){
        ingredientList.add(item);
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredientList);
    }

}
