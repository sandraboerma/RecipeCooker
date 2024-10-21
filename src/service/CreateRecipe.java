package service;

import recipe.Ingredient;
import utility.ScannerManagement;

public class CreateRecipe {
    public static void addIngredient(){
        boolean keepAddingIngredient = false;
        Ingredient addIngredient = new Ingredient();
        do {
            System.out.println("Enter the ingredient name: "); // change phrase later
            String input = ScannerManagement.getUserInput();
            String[] collectIngredient = input.split(",");
            String name = collectIngredient[0].trim();
            double quantity = Double.parseDouble(collectIngredient[1].trim());
            String unit = collectIngredient[2].trim();
            if (collectIngredient.length == 3) {
                addIngredient.setName(name);
                addIngredient.setQuantity(quantity);
                addIngredient.setUnit(unit);

                System.out.println("Would you like to add another ingredient?");
            } else {
                System.out.println("Wrong input. please try again");
            }




        } while (keepAddingIngredient);
    }



}
