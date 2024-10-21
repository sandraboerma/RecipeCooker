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
                Ingredient newIngredient = new Ingredient(name,quantity,unit);
                recipe.addIngredient(newIngredient);
            } else {
                System.out.println("Wrong input. please try again");
            }
            
            System.out.print("Would you like to add another ingredient? \n1. Yes\n2. No: ");

        } while (addingIngredient);

        //@TODO Add another method addInstructionsToRecipe
        //@TODO Add another method to gather input and determine e.g. if addingIngredient would be true or false
    }
}
