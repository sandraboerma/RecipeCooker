package utility;

import recipe.Ingredient;
import recipe.Recipe;

import java.util.TreeMap;

public class DisplayFormatter {

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
        System.out.println("\n");
        recipeString.append(recipe.getRecipeName())
                .append("\n------------------------------------------------------------\n")
                .append("Main Protein Type: ")
                .append(recipe.getProteinCategory())
                .append("\n------------------------------------------------------------\n")
                .append("Ingredients: \n");
        for (Ingredient ingredient : recipe.getIngredientsList()){
            recipeString.append("- ").append(ingredient).append("\n");
        }

        recipeString.append("------------------------------------------------------------")
                .append("\nCooking steps:\n");
        int stepNumber = 1;
        for (String instruction : recipe.getInstructionsList()){
            recipeString.append(stepNumber).append(". ").append(instruction).append("\n");
            stepNumber++;
        }
        recipeString.append("============================================================");
        return recipeString.toString();
    }

    public static String formatFileNameForDisplay(String recipeFileName) {
        String nameWithoutExtension = recipeFileName.replace(".txt","");
        String formattedRecipeName = nameWithoutExtension.replace("_", " ");
        return capitalizeFirstLetterOfFileName(formattedRecipeName);
    }

    public static String getFormattedMenu(TreeMap<Integer, String> menu) {
        return formatMenu(menu);
    }

    public static String getFormattedRecipe(Recipe recipe) {
        return formatRecipe(recipe);
    }

    private static String capitalizeFirstLetterOfFileName(String inputToFormat) {
        return inputToFormat.substring(0,1).toUpperCase() + inputToFormat.substring(1).toLowerCase();
    }
}
