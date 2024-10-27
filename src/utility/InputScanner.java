package utility;

import service.RandomizedPrompt;

import java.util.Scanner;

public class InputScanner {

    private static final Scanner input = new Scanner(System.in);

    public static String getUserInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    public static double getValidatedDoubleInput(String prompt) {
        double doubleInput;
        while (true) {
            System.out.print(prompt);
            try {
                doubleInput = Double.parseDouble(input.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ah, that doesn't seem like a proper amount. Pray, try again!");
            }
        }
        return doubleInput;
    }

    public static int getValidatedIntegerInput(String prompt, int min, int max) {
        int intInput;
        while (true) {
            System.out.print(prompt);
            try {
                intInput = Integer.parseInt(input.nextLine());
                if (intInput >= min && intInput <= max) {
                    break;
                } else {
                    System.out.println("""
                            Alas, that time defies the laws of the culinary realm.
                            Please provide a more suitable cooking duration.
                            """);
                }
            } catch (NumberFormatException e) {
                System.out.println(RandomizedPrompt.getAskForValidInput());
            }
        }
        return intInput;
    }

    public static boolean getValidatedBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt + "\n1. Yes\n2. No\nCast your choice, and let fate be decided: ");
            String booleanInput = input.nextLine().trim();
            switch (booleanInput) {
                case "1" -> { return true; }
                case "2" -> { return false; }
                default -> System.out.println(RandomizedPrompt.getAskForValidInput());
            }
        }
    }

    public static void closeScanner() {
        input.close();
    }
}
