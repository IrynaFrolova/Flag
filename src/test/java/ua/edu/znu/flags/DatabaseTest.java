package ua.edu.znu.flags;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Arrays;

public class DatabaseTest {

    // Приклад використання List і Arrays
    public void testListSize() {
        List<String> countries = Arrays.asList("Ukraine", "USA", "Germany");
        assertTrue(countries.size() == 3, "Size should be 3");
    }

    // Приклад для параметра query
    public void testDatabaseQuery(String query) {
        String expectedQuery = "SELECT * FROM countries";
        assertTrue(query.equals(expectedQuery), "Query should be: " + expectedQuery);
    }
}
