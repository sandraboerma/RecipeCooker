package service;

import utility.InputScanner;

public class MenuServices {

    public static void navigateMainMenu() {
        boolean exitMainMenu = false;
        while (!exitMainMenu) {
            System.out.println("\nChoose an option to continue...\n" +
                    PromptProvider.getFormattedMainMenu());
            int mainMenuChoice = InputScanner.getValidatedIntegerInput("What would you like to do (1-4): ",1,4);

            switch (mainMenuChoice) {
                case 1 -> RecipeBuilder.createRecipeFromUserInput();
                case 2 -> {
                    RecipeFiler.displayExistingRecipes();
                    System.out.println("More logic to be implemented to VIEW a specific recipe");
                }
                case 3 -> {
                    RecipeFiler.displayExistingRecipes();
                    System.out.println("More logic to be implemented to DELETE a specific recipe");
                }
                case 4 -> {
                    System.out.println(PromptProvider.getFarewells());
                    exitMainMenu = true;
                }
                default -> System.out.println(PromptProvider.getAskForValidInput());
            }
        }
    }
}
