import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileManagementTest {

    @Test
    public void testCreatePath(){
        Path path = Path.of("testyFile.txt");
        assertTrue(FileManagement.createPath(path));
    }

    @Test
    public void testWriteToPath(){
        Path path = Path.of("testyFile.txt");
        assertTrue(FileManagement.writeToPath(path));
    }

    @Test
    public void testReadPath(){
        Path path = Path.of("testyFile.txt");
        assertTrue(FileManagement.readPath(path));
    }

/*

    @Test
    public void testDeletePath(){
        Path path = Path.of("testRecipe.txt");
        assertTrue(FileManagement.deletePath(path));
    }
*/
    //@TODO Only attempt this when G requirements are met.
//    @Test
//    public void testModifyPath(){
//        Path path = Path.of("testRecipe.txt");
//        assertTrue(FileManagement.modifyPath(path));
//    }

}
