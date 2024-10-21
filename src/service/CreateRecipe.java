package service;

import recipe.Ingredient;
import recipe.Recipe;
import utility.ScannerManagement;

public class CreateRecipe {
    public static void addIngredientsToRecipe(Recipe recipe) {
        boolean addingIngredient = false;

        do {
            System.out.print("""
                    Pray tell, what be the name of the ingredient, along with its quantity and unit of measure?
                    Speak it in one breath, separated by space. (e.g. sugar 20 gram, milk 1.5 dl)
                    """);
            String input = ScannerManagement.getUserInput();
            String[] collectIngredient = input.split("\\s+");

            if (collectIngredient.length == 3) {
                String name = collectIngredient[0].trim();
                double quantity = Double.parseDouble(collectIngredient[1].trim());
                String unit = collectIngredient[2].trim();
                Ingredient newIngredient = new Ingredient(name, quantity, unit);
                recipe.addIngredient(newIngredient);
            } else {
                System.out.println("Wrong input. please try again");
            }

            addingIngredient = shouldContinueAdding("Wouldst thou add another ingredient to this concoction?");

        } while (addingIngredient);
    }

    public static void addInstructionsToRecipe(Recipe recipe) {
        boolean addingInstruction = false;

        do {
            System.out.println("Recite the cooking instructions, one task at a time, as though casting a spell.");
            String newInstruction = ScannerManagement.getUserInput();
            recipe.addInstruction(newInstruction);
            addingInstruction = shouldContinueAdding("Shall we weave more instructions into this culinary ritual?");
        } while (addingInstruction);
    }

    private static boolean shouldContinueAdding(String prompt) {
        String continueToAdd;
        do {
            System.out.println(prompt);
            continueToAdd = ScannerManagement.getUserInput();
            if (!continueToAdd.equals("1") && !continueToAdd.equals("2")){
                System.out.println("Invalid input...");
            }
        } while (!continueToAdd.equals("1") && !continueToAdd.equals("2"));

        return continueToAdd.equals("1");
    }
        //@TODO Add another method to gather input and determine e.g. if addingIngredient would be true or false
        //@TODO Add another method addInstructionsToRecipe

}
