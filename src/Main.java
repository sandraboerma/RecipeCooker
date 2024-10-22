import service.RandomizedPrompt;
import service.MenuHub;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nRecipeCooker is being prepared...\n");
        System.out.println(RandomizedPrompt.getGreetings());
        System.out.println(MenuHub.getFormattedMainMenu());
        System.out.println(MenuHub.getFormattedCreateRecipeMenu());

    /*
    Short workflow description
    Upon startup user chooses to
    1. Create Recipe ->
    @TODO call operation method to create recipe -> submenus for related operations and prompt user to select operation
       -> Add ingredient - validation pending
       -> Add instructions - validation pending
       -> Assign category
       -> Preview recipe
       -> Save recipe
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



    }
}