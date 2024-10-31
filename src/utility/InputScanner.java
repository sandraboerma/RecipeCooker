package utility;

import service.PromptProvider;

import java.util.Scanner;

public class InputScanner {

    private static final Scanner input = new Scanner(System.in);

public static String getUserInput(String prompt) {
    String userInput;
    while (true) {
        System.out.print(prompt);
        userInput = input.nextLine().trim();
        if (!userInput.isEmpty() && userInput.matches(".*[a-zA-Z].*")) {
            break;
        } else {
            System.out.println(AnsiPalette.RED + PromptProvider.getAskForValidInput() + AnsiPalette.RESET);
        }
    }
    return userInput;
}

    public static double getValidatedDoubleInput(String prompt) {
        double doubleInput;
        while (true) {
            System.out.print(prompt);
            try {
                doubleInput = Double.parseDouble(input.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println(AnsiPalette.RED + PromptProvider.getAskForValidInput() + AnsiPalette.RESET);
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
                    System.out.println(AnsiPalette.RED + PromptProvider.getAskForValidInput() + AnsiPalette.RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(AnsiPalette.RED + PromptProvider.getAskForValidInput() + AnsiPalette.RESET);
            }
        }
        return intInput;
    }

    public static boolean getValidatedBooleanInput(String prompt) {
        while (true) {
            System.out.print(prompt + "\n1. Yes\n2. No\nCast your choice, and let fate be decided: ");
            String booleanInput = input.nextLine().trim();
            switch (booleanInput) {
                case "1", "yes", "Yes", "YES" -> { return true; }
                case "2", "no", "No", "NO" -> { return false; }
                default -> System.out.println(AnsiPalette.RED + PromptProvider.getAskForValidInput() +
                        AnsiPalette.RESET);
            }
        }
    }

    public static void closeScanner() {
        input.close();
    }
}
