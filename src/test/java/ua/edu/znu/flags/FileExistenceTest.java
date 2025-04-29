package ua.edu.znu.flags;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.io.IOException;

class FileExistenceTest {

    @Test
    void testFileExists() throws IOException {
        File file = new File("path_to_your_file");
        assertTrue(file.exists(), "The file should exist");
    }
}
