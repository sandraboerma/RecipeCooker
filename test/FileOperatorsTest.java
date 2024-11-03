import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import utility.FileOperators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileOperatorsTest {

    @TempDir
    Path tempDir;

    @Test
    public void testCreatePath(){
        Path path = tempDir.resolve("testRecipe.txt");
        assertTrue(FileOperators.createPath(path));
        assertTrue(Files.exists(path));
    }

    @Test
    public void testWriteToPath() throws IOException {
        Path path = tempDir.resolve("writeTestRecipe.txt");
        FileOperators.createPath(path);
        String content = "Test Recipe Content";
        FileOperators.writeToPath(path, content);
        List<String> testLines = Files.readAllLines(path);
        assertEquals(content, testLines.get(0), "File content should match written content.");
    }

    @Test
    public void testReadPath() throws IOException {
        Path path = tempDir.resolve("readTestRecipe.txt");
        String content = "Test Recipe Content";
        Files.write(path, List.of(content));
        List<String> testLines = FileOperators.readPath(path);
        assertEquals(content, testLines.get(0), "File content should match expected content");
    }

    @Test
    public void testDeletePath() throws IOException {
        Path path = tempDir.resolve("deleteTestRecipe.txt");
        Files.createFile(path);
        assertTrue(FileOperators.deletePath(path));
        assertFalse(Files.exists(path));
    }
}
