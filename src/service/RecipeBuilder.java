package service;

import recipe.*;
import utility.DisplayFormatter;
import utility.InputScanner;

import java.lang.String;
import java.util.ArrayList;

public class RecipeBuilder {

    public static void createRecipeFromUserInput() {
        String newRecipeName;
        do {
            newRecipeName = InputScanner.getUserInput("""
                    Bestow upon this creation a name worthy of its taste and power!
                    The name of this dish is:\s""");
            if (RecipeFiler.recipeExists(newRecipeName)) {
                System.out.println("A recipe with this name already exists! Please choose a different name.\n");
            }
        } while (RecipeFiler.recipeExists(newRecipeName));

        int newRecipeCookingMethod = InputScanner.getValidatedIntegerInput("""
                \nBy what arcane method shall this dish be prepared?
                1. Enchanted within the fiery depths of the oven, either baked or roasted.
                2. Simmered in a cauldron, pan-seared over flame, or gently steamed atop the hearth.
                3. An ancient ritual, known only to seasoned culinary wizards... Or just a simple salad.
                Make thy choice (1-3):\s""",1,3);

        Recipe recipe = null;

        switch (newRecipeCookingMethod) {
            case 1 -> {
                boolean isVegetarian = InputScanner.getValidatedBooleanInput("\nAre we preparing to summon " +
                        "a treat from the realms of sweetness and indulgence?");

                recipe = RecipeFactory.createRecipe(DietaryPreference.VEGETARIAN, newRecipeName, new ArrayList<>(),
                        new ArrayList<>(), isVegetarian, false);
            }
            case 2 -> {
                boolean containsOats = InputScanner.getValidatedBooleanInput("Will the recipe contain oats? :");
                recipe = RecipeFactory.createRecipe(DietaryPreference.GLUTEN_FREE, newRecipeName, new ArrayList<>(),
                        new ArrayList<>(), false, containsOats);
            }
            case 3 -> recipe = RecipeFactory.createRecipe(DietaryPreference.ANY_DIET, newRecipeName, new ArrayList<>(),
                    new ArrayList<>(),false,false);
        }

        if (recipe != null) {
            RecipeEnricher.ingredients(recipe);
            RecipeEnricher.instructions(recipe);
            System.out.println(DisplayFormatter.getFormattedRecipe(recipe));
            RecipeFiler.saveRecipe(recipe);
        }
    }
}