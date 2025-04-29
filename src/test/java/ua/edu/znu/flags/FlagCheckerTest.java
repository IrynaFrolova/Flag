package ua.edu.znu.flags;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assumptions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlagCheckerTest {

    @Test
    void testIsCorrectAnswerWithValidInput() {
        // Припущення: користувацький ввід не порожній
        Assumptions.assumeTrue("userInput".length() > 0, "Вхідне значення не може бути порожнім");

        String expectedCountry = "Ukraine";
        String userInput = "Ukraine";

        // Перевірка правильності відповіді
        assertTrue(expectedCountry.equals(userInput), "Відповідь не є правильною");
    }

    @Test
    void testIsCorrectAnswerWithEmptyInput() {
        // Припущення: користувацький ввід не порожній
        Assumptions.assumeTrue("userInput".length() > 0, "Вхідне значення не може бути порожнім");

        String expectedCountry = "Ukraine";
        String userInput = "";

        // Перевірка правильності відповіді
        assertTrue(expectedCountry.equals(userInput), "Відповідь не є правильною");
    }
}
