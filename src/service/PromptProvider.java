package service;

import utility.AnsiPalette;
import utility.DisplayFormatter;

import java.util.*;

public class PromptProvider {

    private static final List<String> greetings = new ArrayList<>();
    private static final List<String> askForValidInput = new ArrayList<>();
    private static final TreeMap<Integer, String> mainMenu = new TreeMap<>();
    private static final TreeMap<Integer, String> recipeActionMenu = new TreeMap<>();
    private static final List<String> farewells = new ArrayList<>();

    static {
        initializeGreetings();
        initializeAskForValidInput();
        initializeMainMenu();
        initializeFarewells();
    }

    private static void initializeGreetings() {
        greetings.add(AnsiPalette.PURPLE +
                "Hail, culinary adventurer! Welcome to the kitchen realm." +
                AnsiPalette.RESET);
        greetings.add(AnsiPalette.YELLOW +
                "Well met, brave chef! What gastronomic quest brings you here?" +
                AnsiPalette.RESET);
        greetings.add(AnsiPalette.CYAN +
                "Greetings, master of the magical cauldron! Shall we brew some delicious concoctions?" +
                AnsiPalette.RESET);
        greetings.add(AnsiPalette.YELLOW +
                "Welcome, noble epicurean! Your flavor journey awaits." +
                AnsiPalette.RESET);
        greetings.add(AnsiPalette.CYAN +
                "Salutations, potion master of the pantry! What savory spells shall we cast today?" +
                AnsiPalette.RESET);
        greetings.add(AnsiPalette.PURPLE +
                "Greetings, wise sage of seasonings! What aromatic wisdom do you pursue?" +
                AnsiPalette.RESET);
    }

    private static void initializeAskForValidInput() {
        askForValidInput.add(AnsiPalette.RED +
                "Alas, that input is not recognized. Try again, brave one!" +
                AnsiPalette.RESET);
        askForValidInput.add(AnsiPalette.RED +
                "The fates do not favor that input. Attempt once more, valiant adventurer!" +
                AnsiPalette.RESET);
        askForValidInput.add(AnsiPalette.RED +
                "Your words fall upon deaf ears. Speak again with clarity!" +
                AnsiPalette.RESET);
        askForValidInput.add(AnsiPalette.RED +
                "The arcane symbols you entered are misaligned. Try again, lest you tempt the gods of confusion!" +
                AnsiPalette.RESET);
        askForValidInput.add(AnsiPalette.RED +
                "The scroll rejects your input. Forge anew and try once more!" +
                AnsiPalette.RESET);
        askForValidInput.add(AnsiPalette.RED +
                "The magic falters with that command. Give it another go, hero!" +
                AnsiPalette.RESET);
    }

    private static void initializeMainMenu() {
        mainMenu.put(1, "Create Recipe");
        mainMenu.put(2, "Show Recipes");
        mainMenu.put(3, "Exit");
    }

    private static void initializeRecipeActionMenu() {
        recipeActionMenu.put(1, "");
        recipeActionMenu.put(2, "");
        recipeActionMenu.put(3, "");
    }

    private static void initializeFarewells() {
        farewells.add(AnsiPalette.GREEN +
                "\nThe journey ends here, but legends live on. Until next we meet!");
        farewells.add(AnsiPalette.GREEN +
                "\nYour quest is complete… for now. Rest well.");
        farewells.add(AnsiPalette.GREEN +
                "\nThe portal closes behind you. Return when you're ready for more adventure!");
        farewells.add(AnsiPalette.GREEN +
                "\nThe scroll is rolled up and stored. Ready your spells for next time!");
        farewells.add(AnsiPalette.GREEN +
                "\nAs the last torch is extinguished, you step into the unknown. Safe travels, wanderer.");
        farewells.add(AnsiPalette.GREEN +
                "\nFare thee well, brave adventurer! May your path be clear and your dice roll high!");
    }

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

    public static String getFormattedMainMenu(){
        return DisplayFormatter.getFormattedMenu(getMainMenu());
    }

}
