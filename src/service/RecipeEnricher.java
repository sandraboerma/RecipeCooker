package service;

import recipe.Ingredient;
import recipe.Recipe;
import utility.InputScanner;

public class RecipeEnricher {
    public static void ingredients(Recipe recipe) {
        boolean addingIngredient;

        do {
            String name = InputScanner.getUserInput("""
                    Pray tell, what be the name of the ingredient?
                    Speak its name, O wise one:\s""").trim();
            String unit = InputScanner.getUserInput("""
                    By what measure shall we quantify this ingredient?
                    (dl? hg? grams? cc? ounces)?:\s""").trim();
            double quantity = InputScanner.getValidatedDoubleInput("""
                    Tell me, how much of this ingredient dost thou require?:\s""");
            Ingredient newIngredient = new Ingredient(name, unit, quantity);
            recipe.addIngredient(newIngredient);
            addingIngredient = InputScanner.getValidatedBooleanInput("""
                    \nWouldst thou add another ingredient to this concoction?\s""");

        } while (addingIngredient);
    }

    public static void instructions(Recipe recipe) {
        boolean addingInstruction;

        do {
            String newInstruction = InputScanner.getUserInput("Recite the cooking instructions, " +
                    "one task at a time, as though casting a spell: ");
            recipe.addInstruction(newInstruction);
            addingInstruction = InputScanner.getValidatedBooleanInput("""
                    \nShall we weave more instructions into this culinary ritual?\s""");
        } while (addingInstruction);
    }
}
