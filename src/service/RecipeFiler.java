package service;

import recipe.Recipe;
import utility.AnsiPalette;
import utility.DisplayFormatter;
import utility.FileOperators;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RecipeFiler {
    private static final String RECIPE_DIRECTORY = "recipes/";

    public static boolean recipeExists(String recipeName) {
        Path recipePath = Path.of(RECIPE_DIRECTORY, recipeName.replace(" ", "_") + ".txt");
        return Files.exists(recipePath);
    }

    public static void saveRecipe(Recipe recipe){
        String formattedRecipe = DisplayFormatter.getFormattedRecipe(recipe);
        Path recipePath = Path.of(Path.of(RECIPE_DIRECTORY,
                recipe.getRecipeName().replace(" ", "_")) + ".txt");
        if (FileOperators.createPath(recipePath)) {
            FileOperators.writeToPath(recipePath, formattedRecipe);
        }
    }

    public static void displayExistingRecipes() {
        List<Path> recipeFiles = FileOperators.listRecipeFiles();
        for (Path recipeFile : recipeFiles) {
            String recipeNameToDisplay = FileOperators.readRecipeName(recipeFile);
            if (recipeNameToDisplay != null) {
                String recipeNameDisplayed = DisplayFormatter.formatFileNameForDisplay(
                        recipeFile.getFileName().toString());
                System.out.println("- " + recipeNameDisplayed);
            }
        }
    }
}
