import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManagement {
    /*

    This class includes functions relate to file management such as
    - create file
    - read file
    - delete file
    - modify file

    */

    //@TODO Add code for creating a file.
    //@TODO Validate file creation logic.
    //@TODO Identify and handle possible exceptions

    /*
     * @TODO validate
     *   case 1: File already exist
     *   case 2: File parent directory missing
     *   case 3: Other I/O Exceptions?
     * */

    public static boolean createPath(Path pathName){
        try {
            Files.createFile(pathName);
            return true;
        } catch (FileAlreadyExistsException e) {
            System.out.println("A recipe with the name " + pathName + " already exists.");
            return true;
            //@TODO Another prompt to be implemented asking user to give another name.
        } catch (IOException e){
            e.printStackTrace();
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
