import service.MenuServices;
import service.PromptProvider;
import service.RecipeFiler;
import utility.InputScanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nRecipeCooker is being prepared...\n");
        System.out.println(PromptProvider.getGreetings());
        RecipeFiler.displayExistingRecipes(); // call to display existing recipes
        MenuServices.navigateMainMenu();
//        System.out.println(PromptProvider.getFormattedCreateRecipeMenu());

    /*
    Short workflow description
    Upon startup user chooses to
    1. Create Recipe ->
    @TODO call operation method to create recipe -> submenus for related operations and prompt user to select operation
       -> Add ingredient - done
       -> Add instructions - done
       -> Assign category
       -> Preview recipe - done
       -> Save recipe - done
       -> Discard current creation

    2. View Recipe ->
    @TODO call operation method to display existing recipes
      -> prompt to select the recipe to view*
      -> print full summary of selected recipe

    3. Delete Recipe -
    @TODO call operation method to display existing recipes
      -> prompt to select the recipe to view*
      -> delete the selected recipe (maybe add a "are you sure you want to disintegrate this creation?"

    4. Exit Program



     */

        InputScanner.closeScanner();

    }
}