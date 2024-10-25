package service;

import recipe.*;
import utility.InputScanner;

public class CreateRecipe {

    public static void delegateRecipeNameAndClass(Recipe recipe) {
        String newRecipeName = InputScanner.getUserInput("Bestow upon this creation a name worthy of its taste and power! > ");
        String newRecipeCookingMethod = InputScanner.getUserInput("""
                By what arcane method shall this dish be prepared? 
                1. Enchanted within the fiery depths of the oven, either baked or roasted.
                2. Simmered in a cauldron, pan-seared over flame, or gently steamed atop the hearth.
                3. An ancient ritual, known only to seasoned culinary wizards... Or just a simple salad.
                """);

        switch (newRecipeCookingMethod) {
            case "1" -> {
                String ovenRecipeProtein = InputScanner.getUserInput("Which source of power energizes this recipe? " +
                        "The strength of beasts, the wealth of the seas, or the blessings of the soil?");
                int ovenTimeMinute = InputScanner.getValidatedIntegerInput(
                        "",10,60);
                int ovenTempCelcius = InputScanner.getValidatedIntegerInput(
                        "",50,300);
                boolean isSweet = InputScanner.getValidatedBooleanInput("Are we preparing to summon " +
                        "a treat from the realms of sweetness and indulgence?");
                new OvenRecipe(newRecipeName, ovenRecipeProtein, ovenTimeMinute, ovenTempCelcius, isSweet);
            }
            case "2" -> {
                String stoveRecipeProtein = InputScanner.getUserInput("What sustenance shall fuel this creation? " +
                        "Is it the flesh of beasts, bounty from the sea, or nature's verdant gifts");
                String stoveHeatStrength = InputScanner.getUserInput("What strength of fire do you summon for " +
                        "this dish—gentle embers, a steady flame, or a roaring inferno?");
                new StoveRecipe(newRecipeName, stoveRecipeProtein, stoveHeatStrength);
            }
            case "3" -> {
                String anyMethodProtein = InputScanner.getUserInput("What sustenance shall fuel this creation? " +
                        "Is it the flesh of beasts, bounty from the sea, or nature's verdant gifts?");
                new AnyMethodRecipe(newRecipeName, anyMethodProtein);
            }
            default -> System.out.println(RandomizedPrompt.getAskForValidInput());
        }
    }

    public static void addIngredientsToRecipe(Recipe recipe) {
        boolean addingIngredient = false;

        do {
            String input = InputScanner.getUserInput("""
                    Pray tell, what be the name of the ingredient, along with its quantity and unit of measure?
                    Speak it in one breath, separated by space. (e.g. sugar 20 gram, milk 1.5 dl)
                    """);
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

    public static void addInstructionsToRecipe(Recipe recipe) {
        boolean addingInstruction = false;

        do {
            String newInstruction = InputScanner.getUserInput("Recite the cooking instructions, " +
                    "one task at a time, as though casting a spell.");
            recipe.addInstruction(newInstruction);
            addingInstruction = shouldContinueAdding("Shall we weave more instructions into this culinary ritual?");
        } while (addingInstruction);
    }

    private static boolean shouldContinueAdding(String prompt) {
        String continueToAdd;
        do {
            continueToAdd = InputScanner.getUserInput(prompt);
            if (!continueToAdd.equals("1") && !continueToAdd.equals("2")){
                System.out.println(RandomizedPrompt.getAskForValidInput());
            }
        } while (!continueToAdd.equals("1") && !continueToAdd.equals("2"));

        return continueToAdd.equals("1");
    }
}
