package service;

import recipe.Ingredient;
import recipe.OvenRecipe;
import recipe.Recipe;
import utility.ScannerManagement;

import static recipe.CookingMethod.OVEN;

public class CreateRecipe {

    //@TODO - implement sub feature to get recipe name
    //@TODO - implement sub feature to get recipe main protein type category

    public static void tempNameForNameAndSelectChild(Recipe recipe) {
        System.out.print("Bestow upon this creation a name worthy of its taste and power! > ");
        String newRecipeName = ScannerManagement.getUserInput();
        System.out.println("""
                By what arcane method shall this dish be prepared? 
                1. Enchanted within the fiery depths of the oven, either baked or roasted.
                2. Simmered in a cauldron, pan-seared over flame, or gently steamed atop the hearth.
                3. An ancient ritual, known only to seasoned culinary wizards... Or just a simple salad.
                """);
        String newRecipeCookingMethod = ScannerManagement.getUserInput();

        switch (newRecipeCookingMethod) {
            case "1" -> {
                String ovenRecipeProtein = ScannerManagement.getUserInput();
                String ovenTime = ScannerManagement.getUserInput();
                String ovenTemp = ScannerManagement.getUserInput();
                String isSweet = ScannerManagement.getUserInput();
                new OvenRecipe(newRecipeName, ovenRecipeProtein, Integer.parseInt(ovenTime),
                        Integer.parseInt(ovenTemp), Boolean.parseBoolean(isSweet));
            }
            case "2" -> {}
            case "3" -> {}
            default -> System.out.println(RandomizedPrompt.getAskForValidInput());
        }

    }

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
                System.out.println(RandomizedPrompt.getAskForValidInput());
            }

            addingIngredient = shouldContinueAdding("Wouldst thou add another ingredient to this concoction?");

        } while (addingIngredient);
    }

    //@TODO - implement sub feature to get main cooking method

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
                System.out.println(RandomizedPrompt.getAskForValidInput());
            }
        } while (!continueToAdd.equals("1") && !continueToAdd.equals("2"));

        return continueToAdd.equals("1");
    }
}
