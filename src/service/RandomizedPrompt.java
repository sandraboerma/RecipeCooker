package service;

import java.util.ArrayList;
import java.util.Random;

public class RandomizedPrompt {

    private static final ArrayList<String> greetings = new ArrayList<>();
    private static final ArrayList<String> askForValidInput = new ArrayList<>();

    static {
        initializeGreetings();
        initializeAskForValidInput();
    }

    private static void initializeGreetings(){
        greetings.add("Hail, culinary adventurer! Welcome to the kitchen realm.\n");
        greetings.add("Well met, brave chef! What gastronomic quest brings you here?\n");
        greetings.add("Greetings, master of the magical cauldron! Shall we brew some delicious concoctions?\n");
        greetings.add("Welcome, noble epicurean! Your flavor journey awaits.\n");
        greetings.add("Ho there, kitchen warrior! Ready to vanquish hunger with your mighty spatula?\n");
        greetings.add("Salutations, potion master of the pantry! What savory spells shall we cast today?\n");
        greetings.add("Oh my, it's the guardian of the sacred recipes! What delectable treasures do you seek?\n");
        greetings.add("Hark, valiant taste-seeker! Your culinary crusade begins now.\n");
        greetings.add("Greetings, wise sage of seasonings! What aromatic wisdom do you pursue?\n");
        greetings.add("Well met, intrepid explorer of flavors! What delicious lands shall we chart on your plate?\n");
    }

    public static String getGreetings() {
        Random random = new Random();
        return greetings.get(random.nextInt(0,greetings.size() - 1));
    }

    private static void initializeAskForValidInput(){
        askForValidInput.add("Alas, that input is not recognized. Try again, brave one!");
        askForValidInput.add("The fates do not favor that input. Attempt once more, valiant adventurer!");
        askForValidInput.add("Your words fall upon deaf ears. Speak again with clarity!");
        askForValidInput.add("The arcane symbols you entered are misaligned. Try again, lest you tempt the gods of confusion!");
        askForValidInput.add("The scroll rejects your input. Forge anew and try once more!");
        askForValidInput.add("The magic falters with that command. Give it another go, hero!");
    }

    public static String getAskForValidInput(){
        Random random = new Random();
        return askForValidInput.get(random.nextInt(0,askForValidInput.size() - 1));
    }

}
