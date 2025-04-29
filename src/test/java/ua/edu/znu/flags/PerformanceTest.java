package ua.edu.znu.flags;

import static org.junit.jupiter.api.Assertions.assertTrue; // для assertTrue
import java.util.logging.Logger; // для логування

public class PerformanceTest {

    // Ініціалізація логера
    private static final Logger logger = Logger.getLogger(PerformanceTest.class.getName());

    public void testPerformance() {
        try {
            // Приклад перевірки
            assertTrue(true, "This should be true!");
        } catch (Exception e) {
            // Замість printStackTrace, використовуємо логування
            logger.severe("An error occurred: " + e.getMessage());
        }
    }
}
