package service;

import utility.DisplayFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class PromptProvider {

    private static final List<String> greetings = new ArrayList<>();
    private static final List<String> askForValidInput = new ArrayList<>();
    private static final TreeMap<Integer, String> mainMenu = new TreeMap<>();
//    private static final TreeMap<Integer, String> createRecipeMenu = new TreeMap<>();
    private static final List<String> farewells = new ArrayList<>();

    static {
        initializeGreetings();
        initializeAskForValidInput();
        initializeMainMenu();
//        initializeCreateRecipeMenu();
        initializeFarewells();
    }

    private static void initializeGreetings() {
        greetings.add("Hail, culinary adventurer! Welcome to the kitchen realm.\n");
        greetings.add("Well met, brave chef! What gastronomic quest brings you here?\n");
        greetings.add("Greetings, master of the magical cauldron! Shall we brew some delicious concoctions?\n");
        greetings.add("Welcome, noble epicurean! Your flavor journey awaits.\n");
        greetings.add("Salutations, potion master of the pantry! What savory spells shall we cast today?\n");
        greetings.add("Greetings, wise sage of seasonings! What aromatic wisdom do you pursue?\n");
    }

    private static void initializeAskForValidInput() {
        askForValidInput.add("Alas, that input is not recognized. Try again, brave one!");
        askForValidInput.add("The fates do not favor that input. Attempt once more, valiant adventurer!");
        askForValidInput.add("Your words fall upon deaf ears. Speak again with clarity!");
        askForValidInput.add("The arcane symbols you entered are misaligned. Try again, lest you tempt the gods of confusion!");
        askForValidInput.add("The scroll rejects your input. Forge anew and try once more!");
        askForValidInput.add("The magic falters with that command. Give it another go, hero!");
    }

    private static void initializeMainMenu() {
        mainMenu.put(1, "Create Recipe");
        mainMenu.put(2, "View Recipe");
        mainMenu.put(3, "Delete Recipe");
        mainMenu.put(4, "Exit");
    }

    private static void initializeFarewells() {
        farewells.add("\nFare thee well, brave adventurer! May your path be clear and your dice roll high!");
        farewells.add("\nThe journey ends here, but legends live on. Until next we meet!");
        farewells.add("\nYour quest is complete… for now. Rest well.");
        farewells.add("\nThe portal closes behind you. Return when you're ready for more adventure!");
        farewells.add("\nThe scroll is rolled up and stored. Ready your spells for next time!");
        farewells.add("\nAs the last torch is extinguished, you step into the unknown. Safe travels, wanderer.");
    }

//    private static void initializeCreateRecipeMenu(){
//        createRecipeMenu.put(1, "Add ingredient");
//        createRecipeMenu.put(2, "Add instructions");
//        createRecipeMenu.put(3, "Assign category");
//        createRecipeMenu.put(4, "Preview recipe");
//        createRecipeMenu.put(5, "Save recipe");
//        createRecipeMenu.put(6, "Discard current creation");
//    }

    public static String getGreetings() {
        Random random = new Random();
        return greetings.get(random.nextInt(0,greetings.size() - 1));
    }

    public static String getAskForValidInput() {
        Random random = new Random();
        return askForValidInput.get(random.nextInt(0,askForValidInput.size() - 1));
    }

    public static String getFarewells() {
        Random random = new Random();
        return farewells.get(random.nextInt(0,farewells.size() - 1));
    }

    private static TreeMap<Integer, String> getMainMenu(){
        return mainMenu;
    }

//    private static TreeMap<Integer, String> getCreateRecipeMenu(){
//        return createRecipeMenu;
//    }

    public static String getFormattedMainMenu(){
        return DisplayFormatter.getFormattedMenu(getMainMenu()) + "\nLet's start this visit with > ";
    }

//    public static String getFormattedCreateRecipeMenu() {
//        return "\nAwesome, then let's cook up some recipe! What would you like to do first?\n\n" +
//                DisplayFormatter.getFormattedMenu(getCreateRecipeMenu()) + "\nI would like to: ";
//    }

}
