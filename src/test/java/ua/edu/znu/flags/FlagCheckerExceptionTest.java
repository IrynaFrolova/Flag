package ua.edu.znu.flags;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FlagCheckerExceptionTest {

    @Test
    void testIsCorrectAnswerWithNullUserInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FlagChecker.isCorrectAnswer(null, "Франция");
        });
        assertEquals("Вхідні дані не повинні бути null", exception.getMessage());
    }

    @Test
    void testIsCorrectAnswerWithNullExpectedCountry() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FlagChecker.isCorrectAnswer("Франция", null);
        });
        assertEquals("Вхідні дані не повинні бути null", exception.getMessage());
    }

    @Test
    void testIsCorrectAnswerWithEmptyUserInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FlagChecker.isCorrectAnswer("  ", "Франция");
        });
        assertEquals("Вхідні дані не повинні бути порожніми", exception.getMessage());
    }

    @Test
    void testIsCorrectAnswerWithEmptyExpectedCountry() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            FlagChecker.isCorrectAnswer("Франция", "  ");
        });
        assertEquals("Вхідні дані не повинні бути порожніми", exception.getMessage());
    }
}
