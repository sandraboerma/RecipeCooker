package utility;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;

public class FileManagement {

    public static boolean createPath(Path pathName){
        try {
            Files.createFile(pathName);
            System.out.println("Recipe " + pathName + " created.");
            return true;
        } catch (FileAlreadyExistsException e) {
            System.out.println("A recipe with the name " + pathName + " already exists.");
            return true;
            //@TODO Another prompt to be implemented asking user to give another name.
        } catch (NoSuchFileException e) {
            System.out.println("The targeted folder is missing.");
            return true;
        } catch (AccessDeniedException e) {
            System.out.println("Access denied for creating the recipe " + pathName);
            return true;
        } catch (IOException e){
            //e.printStackTrace();
            System.out.println("An I/O error occurred: " + e);
            return false;
        }
    }

    public static boolean writeToPath(Path pathName){
        try (PrintWriter writeToPath = new PrintWriter(new FileWriter(pathName.toFile(),true))) {
            writeToPath.println("This text is a placeholder.");
            //@TODO need to evaluate how to execute writing options.
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the recipe.");
            return true;
        }  catch (AccessDeniedException e) {
            System.out.println("Access denied. Unable to open " + pathName);
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("An I/O error occurred: " + e);
            return false;
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
            //e.printStackTrace();
            System.out.println("An I/O error occurred: " + e);
            return false;
        }
    }

    public static boolean deletePath(Path pathName){
        try {
            Files.delete(pathName);
            return true;
        } catch (NoSuchFileException e) {
            System.out.println("This recipe does not exist.");
            return true;
        } catch (FileSystemException e) {
            System.out.println(e);
            System.out.println("The recipe cannot be deleted as it's currently being used elsewhere.");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    //@TODO Optional - only attempt this if the main program is completed.
    //@TODO Add code for modifying a file.
    //@TODO Validate file modification logic.
    //@TODO Identify and handle possible exceptions
//    public static boolean modifyPath(Path pathName){
//        System.out.println("Init method, code not implemented. Method expected to fail.");
//        return false;
//    }

}
