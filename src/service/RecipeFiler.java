package service;

import recipe.Recipe;
import utility.DisplayFormatter;
import utility.FileOperators;

import java.nio.file.Path;

public class RecipeFiler {
    private static final String RECIPE_DIRECTORY = "recipes/";

    public static void saveRecipe(Recipe recipe){
        String formattedRecipe = DisplayFormatter.getFormattedRecipe(recipe);
        Path recipePath = Path.of(Path.of(RECIPE_DIRECTORY,
                recipe.getRecipeName().replace(" ", "_")) + ".txt");

        if (FileOperators.createPath(recipePath)) {
            FileOperators.writeToPath(recipePath, formattedRecipe);
        }
    }
}
