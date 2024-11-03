package service;

import recipe.Recipe;
import utility.AnsiPalette;
import utility.DisplayFormatter;
import utility.FileOperators;
import utility.InputScanner;

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

    public static List<Path> listRecipeFiles() {
        return FileOperators.listRecipeFiles();
    }

    public static Path displayExistingRecipes(List<Path> recipeFiles) {
        int existingRecipeIndex = 1;
        for (Path recipeFile : recipeFiles) {
            String recipeNameToDisplay = FileOperators.readRecipeName(recipeFile);
            if (recipeNameToDisplay != null) {
                String recipeNameDisplayed = DisplayFormatter.formatFileNameForDisplay(
                        recipeFile.getFileName().toString());
                System.out.println(existingRecipeIndex + ". " + recipeNameDisplayed);
                existingRecipeIndex++;
            }
        }

        int selectedRecipeIndex = InputScanner.getValidatedIntegerInput(
                "Which recipe would you like to retrieve?: ",1,recipeFiles.size());
        System.out.println("\n============================================================");
        Path selectedRecipeFile = recipeFiles.get(selectedRecipeIndex -1);
        List<String> recipeContent = FileOperators.readPath(selectedRecipeFile);

        if (recipeContent != null) {
            recipeContent.forEach(System.out::println);
        } else {
            System.out.println(AnsiPalette.ORANGE + "Ahoy looks like another 404 ERROR!" + AnsiPalette.RESET);
        }
        return selectedRecipeFile;
    }
}

