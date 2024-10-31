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
            newRecipeName = InputScanner.getUserInput("Bestow upon this creation a name " +
                    "worthy of its taste and power!\nThe name of this dish is: ");
            if (RecipeFiler.recipeExists(newRecipeName)) {
                System.out.println("A recipe with this name already exists! Please choose a different name.\n");
            }
        } while (RecipeFiler.recipeExists(newRecipeName));

        String newRecipeCookingMethod = InputScanner.getUserInput("""
                \nBy what arcane method shall this dish be prepared?
                1. Enchanted within the fiery depths of the oven, either baked or roasted.
                2. Simmered in a cauldron, pan-seared over flame, or gently steamed atop the hearth.
                3. An ancient ritual, known only to seasoned culinary wizards... Or just a simple salad.
                Make thy choice (1-3):\s""");

        Recipe recipe = null;

        switch (newRecipeCookingMethod) {
            case "1" -> {
                String ovenRecipeProtein = InputScanner.getUserInput("What is the main protein of this dish?");
                int ovenTimeMinute = InputScanner.getValidatedIntegerInput(
                        "\nHow many minutes must this dish endure the flames of the oven: ",5,100);
                int ovenTempCelsius = InputScanner.getValidatedIntegerInput(
                        "\nTo what degree in celsius must the fires of the oven burn?: ",50,300);
                boolean isSweet = InputScanner.getValidatedBooleanInput("\nAre we preparing to summon " +
                        "a treat from the realms of sweetness and indulgence?");

                recipe = RecipeFactory.createRecipe(CookingMethod.OVEN, newRecipeName,
                        ovenRecipeProtein, new ArrayList<>(), new ArrayList<>(),
                        ovenTimeMinute, ovenTempCelsius, isSweet, null);
            }
            case "2" -> {
                String stoveRecipeProtein = InputScanner.getUserInput("sustenance shall fuel this creation? " +
                        "Is it the flesh of beasts, bounty from the sea, or nature's verdant gifts");
                String stoveHeatStrength = InputScanner.getUserInput("What strength of fire do you summon for " +
                        "this dish—gentle embers, a steady flame, or a roaring inferno?");
                recipe = RecipeFactory.createRecipe(CookingMethod.STOVE, newRecipeName,
                        stoveRecipeProtein, new ArrayList<>(), new ArrayList<>(),
                        0, 0, false, stoveHeatStrength);
            }
            case "3" -> {
                String anyMethodProtein = InputScanner.getUserInput("What sustenance shall fuel this creation? " +
                        "Is it the flesh of beasts, bounty from the sea, or nature's verdant gifts?");
                recipe = RecipeFactory.createRecipe(CookingMethod.ANY_METHOD, newRecipeName,
                        anyMethodProtein, new ArrayList<>(), new ArrayList<>(),
                        0,0,false,null);
            }
            default -> System.out.println(RandomizedPrompt.getAskForValidInput());
        }

        if (recipe != null) {
            RecipeEnricher.ingredients(recipe);
            RecipeEnricher.instructions(recipe);
            System.out.println(DisplayFormatter.getFormattedRecipe(recipe));
            RecipeFiler.saveRecipe(recipe);
        }
    }
}