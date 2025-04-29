package ua.edu.znu.flags;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Duration;

class FlagCheckerTimeoutTest {

    @Test
    void testIsCorrectAnswerTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {  // Тайм-аут увеличен до 2 секунд
            try {
                Thread.sleep(1500); // Задержка 1.5 секунды
                FlagChecker.isCorrectAnswer("Франция", "Франция");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
