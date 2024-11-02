package service;

import recipe.Ingredient;
import recipe.Recipe;
import utility.InputScanner;

public class RecipeEnricher {
    public static void ingredients(Recipe recipe) {
        boolean addingIngredient;
        do {
            String name = InputScanner.getUserInput("\nAdd ingredient name: ").trim();
            String unit = InputScanner.getUserInput("Measuring unit (e.g. gram, dl, pcs): ").trim();
            double quantity = InputScanner.getValidatedDoubleInput("Required amount: ");
            Ingredient newIngredient = new Ingredient(name, unit, quantity);
            recipe.addIngredient(newIngredient);
            addingIngredient = InputScanner.getValidatedBooleanInput("Add more ingredients? Yes/No: ");
        } while (addingIngredient);
    }

    public static void instructions(Recipe recipe) {
        boolean addingInstruction;
        do {
            String newInstruction = InputScanner.getUserInput("\nAdd instruction: ");
            recipe.addInstruction(newInstruction);
            addingInstruction = InputScanner.getValidatedBooleanInput("Add more instructions? Yes/No: ");
        } while (addingInstruction);
    }
}
