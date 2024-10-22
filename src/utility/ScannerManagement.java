package utility;

import service.RandomizedPrompt;

import java.util.Scanner;

public class ScannerManagement {

    private static final Scanner sc = new Scanner(System.in);

    public static String getUserInput() {
        return sc.nextLine();
    }

    public static int getValidatedCookingTime(String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input >= min && input <= max) {
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
        return input;
    }

    public static boolean getIsDesert(String prompt) {
        while (true) {
            System.out.println(prompt + "\n1. Yes\n2. No\nCast your choice, and let fate be decided: ");
            String input = sc.nextLine().trim();
            switch (input) {
                case "1" -> { return true; }
                case "2" -> { return false; }
                default -> System.out.println(RandomizedPrompt.getAskForValidInput());
            }
        }
    }

    public static void closeScanner() {
        sc.close();
    }
}
