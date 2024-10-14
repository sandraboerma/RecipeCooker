import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileManagementTest {

    @Test
    public void testCreatePath(){
        Path path = Path.of("testRecipe.txt");
        assertEquals(1,FileManagement.createPath(path));
    }

    @Test
    public void testReadPath(){
        Path path = Path.of("testRecipe.txt");
        assertEquals(1,FileManagement.readPath(path));
    }

    @Test
    public void testDeletePath(){
        Path path = Path.of("testRecipe.txt");
        assertEquals(1,FileManagement.deletePath(path));
    }

    @Test
    public void testModifyPath(){
        Path path = Path.of("testRecipe.txt");
        assertEquals(1,FileManagement.modifyPath(path));
    }

}
