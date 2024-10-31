import service.MenuServices;
import service.PromptProvider;
import utility.InputScanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n" + PromptProvider.getGreetings());
        MenuServices.navigateMainMenu();
        InputScanner.closeScanner();
    }
}