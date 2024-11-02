package service;

import utility.InputScanner;

public class MenuServices {

    public static void navigateMainMenu() {
        boolean exitMainMenu = false;
        while (!exitMainMenu) {
            System.out.println("\n" + PromptProvider.getFormattedMainMenu());
            int mainMenuChoice = InputScanner.getValidatedIntegerInput("What would you like to do (1-3): ",1,3);

            switch (mainMenuChoice) {
                case 1 -> RecipeBuilder.createRecipeFromUserInput();
                case 2 -> {
                    System.out.println("\n");
                    RecipeFiler.displayExistingRecipes();
                    System.out.println("More logic to be implemented to VIEW a specific recipe");
                }
                case 3 -> {
                    System.out.println(PromptProvider.getFarewells());
                    exitMainMenu = true;
                }
                default -> System.out.println(PromptProvider.getAskForValidInput());
            }
        }
    }
}
