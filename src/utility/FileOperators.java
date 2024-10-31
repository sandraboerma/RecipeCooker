package utility;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperators {

    private static final String RECIPE_DIRECTORY = "recipes/";

    public static boolean createPath(Path pathName){
        try {
            Files.createFile(pathName);
            System.out.println(pathName + " created.");
            return true;
        } catch (FileAlreadyExistsException e) {
            System.out.println("A recipe with the name " + pathName + " already exists.");
            return true;
        } catch (NoSuchFileException e) {
            System.out.println("The targeted folder is missing.");
            return true;
        } catch (AccessDeniedException e) {
            System.out.println("Access denied for creating the recipe " + pathName);
            return true;
        } catch (IOException e){
            System.out.println("An I/O error occurred: " + e);
            return false;
        }
    }

    public static void writeToPath(Path pathName, String formattedRecipe){
        try (PrintWriter writeToPath = new PrintWriter(new FileWriter(pathName.toFile(),true))) {
            writeToPath.println(formattedRecipe);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the recipe.");
        }  catch (AccessDeniedException e) {
            System.out.println("Access denied. Unable to open " + pathName);
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e);
        }
    }

    public static boolean readPath(Path pathName){
        try {
            Files.readAllLines(pathName).forEach(System.out::println);
            return true;
        } catch (NoSuchFileException e) {
            System.out.println("Selected recipe: " + pathName + " is not found.");
            return true;
        } catch (AccessDeniedException e) {
            System.out.println("You don't have permission to read this recipe.");
            return true;
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e);
            return false;
        }
    }

    public static List<Path> listRecipeFiles() {
        List<Path> recipeFiles = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path.of(RECIPE_DIRECTORY), "*.txt")) {
            for (Path path : stream) {
                recipeFiles.add(path);
            }
            if (recipeFiles.isEmpty()) {
                System.out.println(AnsiPalette.ORANGE +
                        "\nNo recipes have been created yet. Please add some to get started.\n" + AnsiPalette.RESET);
            }
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
        return recipeFiles;
    }

    public static String readRecipeName(Path recipeFile){
        try {
            List<String> headLines = Files.readAllLines(recipeFile);
            if (!headLines.isEmpty()) {
                return headLines.get(0);
            }
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
        return "Looks like mistake has happened here? Recipe had no name?!";
    }

    public static boolean deletePath(Path pathName){
        try {
            Files.delete(pathName);
            return true;
        } catch (NoSuchFileException e) {
            System.out.println("This recipe does not exist.");
            return true;
        } catch (FileSystemException e) {
            System.out.println("The recipe cannot be deleted as it's currently being used elsewhere.");
            return true;
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e);
            return false;
        }
    }
}
