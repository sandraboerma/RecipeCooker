import org.junit.jupiter.api.Test;
import utility.FileOperators;

import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileOperatorsTest {

    @Test
    public void testCreatePath(){
        Path path = Path.of("");
        assertTrue(FileOperators.createPath(path));
    }

    @Test
    public void testWriteToPath(){
        Path path = Path.of("");
        assertTrue(FileOperators.writeToPath(path));
    }

    @Test
    public void testReadPath(){
        Path path = Path.of("");
        assertTrue(FileOperators.readPath(path));
    }

    @Test
    public void testDeletePath(){
        Path path = Path.of("");
        assertTrue(FileOperators.deletePath(path));
    }

    //@TODO Only attempt this when G requirements are met.
//    @Test
//    public void testModifyPath(){
//        Path path = Path.of("testRecipe.txt");
//        assertTrue(utility.FileOperators.modifyPath(path));
//    }

}
