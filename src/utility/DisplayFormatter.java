package utility;

import com.sun.source.tree.Tree;
import recipe.Ingredient;
import recipe.Recipe;

import java.util.TreeMap;

public class DisplayFormatter {

    private final StringBuilder stringToBuild;
    private final int cliDisplayWidth;

    public DisplayFormatter(StringBuilder stringToBuild, int cliDisplayWidth) {
        this.stringToBuild = stringToBuild;
        this.cliDisplayWidth = cliDisplayWidth;
    }

    public static String formatMenu(TreeMap<Integer, String> menu) {
        StringBuilder menuString = new StringBuilder();
        for (Integer key : menu.keySet()) {
            menuString.append(key)
                    .append(": ")
                    .append(menu.get(key))
                    .append("\n");
        }
        return menuString.toString();
    }

    private static String formatRecipe(Recipe recipe){
        StringBuilder recipeString = new StringBuilder();
        recipeString.append("## ").append(recipe.getRecipeName()).append("\n\n")
                .append("**Main Protein Type**: ").append(recipe.getProteinCategory()).append("\n\n")
                .append("**Ingredients**: \n");
        for (Ingredient ingredient : recipe.getIngredientsList()){
            recipeString.append("- ").append(ingredient).append("\n");
        }

        recipeString.append("\n**Cooking steps**:\n");
        int stepNumber = 1;
        for (String instruction : recipe.getInstructionsList()){
            recipeString.append(stepNumber).append(". ").append(instruction).append("\n");
            stepNumber++;
        }
        return recipeString.toString();
    }

    public static String getFormattedMenu(TreeMap<Integer, String> menu) {
        return formatMenu(menu);
    }

    public static String getFormattedRecipe(Recipe recipe) {
        return formatRecipe(recipe);
    }
}
