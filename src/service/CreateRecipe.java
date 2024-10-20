package service;

import recipe.Ingredient;
import utility.ScannerManagement;

public class CreateRecipe {
    public static void addIngredient(){
        boolean keepAddingIngredient = false;
        do {
            System.out.println("");
        } while (keepAddingIngredient);
        ScannerManagement.getUserInput();
        Ingredient abc = new Ingredient();
    }



}
