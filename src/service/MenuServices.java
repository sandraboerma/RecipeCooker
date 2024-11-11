package service;

import utility.FileOperators;
import utility.InputScanner;

import java.nio.file.Path;
import java.util.List;

public class MenuServices {

    public static void navigateMainMenu() {
        boolean exitMainMenu = false;
        while (!exitMainMenu) {
            System.out.println("\n" + PromptProvider.getFormattedMainMenu());
            int mainMenuChoice = InputScanner.getValidatedIntegerInput("What would you like to do (1-3): ",1,3);
            System.out.println("\n");
            switch (mainMenuChoice) {
                case 1 -> RecipeBuilder.createRecipeFromUserInput();
                case 2 -> {
                    List<Path> recipeFiles = RecipeFiler.listRecipeFiles();
                    Path selectedRecipeFile = RecipeFiler.displayExistingRecipes(recipeFiles);
                    navigateRecipeActionMenu(selectedRecipeFile);
                }
                case 3 -> {
                    System.out.println(PromptProvider.getFarewells());
                    exitMainMenu = true;
                }
                default -> System.out.println(PromptProvider.getAskForValidInput());
            }
        }
    }

    private static void navigateRecipeActionMenu(Path selectedRecipeFile) {
        boolean exitRecipeActionMenu = false;
        while (!exitRecipeActionMenu) {
            int recipeActionChoice = InputScanner.getValidatedIntegerInput(
                    "\nWhat would you like to do with this recipe?\n" +
                    PromptProvider.getFormattedRecipeActionMenu() + "\nChoose an option to continue: ",1,3);

            switch (recipeActionChoice) {
                case 1 -> {
                    boolean keepShowingRecipe;
                    do {
                        System.out.println("\n");
                        List<Path> recipeFiles = RecipeFiler.listRecipeFiles();
                        RecipeFiler.displayExistingRecipes(recipeFiles);
                        keepShowingRecipe = InputScanner.getValidatedBooleanInput("Check another? Yes/No: ");
                    } while (keepShowingRecipe);
                }
                case 2 -> {
                    FileOperators.deletePath(selectedRecipeFile);
                    System.out.println("Recipe " + selectedRecipeFile + " deleted.");
                    exitRecipeActionMenu = true;
                }
                case 3 -> exitRecipeActionMenu = true;
                default -> System.out.println(PromptProvider.getAskForValidInput());
            }
        }
    }
}
