import java.io.IOException;
import java.nio.file.*;

public class FileManagement {
    /*
    This class includes functions relate to file management such as
    - read file
    - delete file
    - modify file
    */

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
            System.out.println("An I/O error occurred: " + e.getMessage());
            return false;
        }
    }
/*
    //@TODO Add code for reading a file
    //@TODO Validate file reading logic.
    //@TODO Identify and handle possible exceptions
    public static boolean readPath(Path pathName){
        System.out.println("Init method, code not implemented. Method expected to fail.");
        return false;
    }

    //@TODO Add code for deleting a file
    //@TODO Validate file deletion logic.
    //@TODO Identify and handle possible exceptions
    public static boolean deletePath(Path pathName){
        System.out.println("Init method, code not implemented. Method expected to fail.");
        return false;
    }
*/
    //@TODO Optional - only attempt this if the main program is completed.
    //@TODO Add code for modifying a file.
    //@TODO Validate file modification logic.
    //@TODO Identify and handle possible exceptions
//    public static boolean modifyPath(Path pathName){
//        System.out.println("Init method, code not implemented. Method expected to fail.");
//        return false;
//    }

}
