package utility;

import recipe.GlutenFreeRecipe;
import recipe.Ingredient;
import recipe.Recipe;
import recipe.VegetarianRecipe;

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

    private static <T> String formatRecipe(T recipeData){
        StringBuilder recipeString = new StringBuilder();

        if (recipeData instanceof Recipe recipe) {
            System.out.println("\n");
            recipeString.append(recipe.getRecipeName())
                    .append("\n------------------------------------------------------------\n");

            if (recipe instanceof VegetarianRecipe vegetarianRecipe) {
                recipeString.append("Category: ").append(recipe.getDietaryPreference()).append("\n").
                        append("Suitable for Vegans: ")
                        .append(getFormattedIsVegan(vegetarianRecipe))
                        .append("\n------------------------------------------------------------\n");
            } else if (recipe instanceof GlutenFreeRecipe glutenFreeRecipe) {
                recipeString.append("Category: ").append(recipe.getDietaryPreference()).append("\n").
                        append("Contains Oats: ")
                        .append(getFormattedContainsOats(glutenFreeRecipe))
                        .append("\n------------------------------------------------------------\n");
            }

            recipeString.append("Ingredients: \n");
            for (Ingredient ingredient : recipe.getIngredientsList()) {
                recipeString.append("- ").append(ingredient).append("\n");
            }

            recipeString.append("------------------------------------------------------------")
                    .append("\nCooking Instructions:\n");
            int stepNumber = 1;
            for (String instruction : recipe.getInstructionsList()) {
                recipeString.append(stepNumber).append(". ").append(instruction).append("\n");
                stepNumber++;
            }
        } else if (recipeData instanceof String recipeText) {
            recipeString.append(recipeText);
        }
        recipeString.append("============================================================");
        return recipeString.toString();
    }

    public static String formatFileNameForDisplay(String recipeFileName) {
        String nameWithoutExtension = recipeFileName.replace(".txt","");
        String formattedRecipeName = nameWithoutExtension.replace("_", " ");
        return capitalizeFirstLetter(formattedRecipeName);
    }

    public static String getFormattedMenu(TreeMap<Integer, String> menu) {
        return formatMenu(menu);
    }

    public static String getFormattedRecipe(Recipe recipe) {
        return formatRecipe(recipe);
    }

    public static String getFormattedIsVegan(VegetarianRecipe recipe) {
        return recipe.isVegan() ? "Yes" : "No";
    }

    public static String getFormattedContainsOats(GlutenFreeRecipe recipe) {
        return recipe.containsOats() ? "Yes" : "No";
    }

    public static String capitalizeFirstLetter(String inputToFormat) {
        return inputToFormat.substring(0,1).toUpperCase() + inputToFormat.substring(1).toLowerCase();
    }
}
