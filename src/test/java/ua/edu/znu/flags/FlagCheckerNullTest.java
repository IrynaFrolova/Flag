package ua.edu.znu.flags;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlagCheckerNullTest {

    private String validCountry;

    @BeforeEach
    void setUp() {
        validCountry = "Германия";
    }

    @Test
    void testNullUserInput() {
        assertFalse(FlagChecker.isCorrectAnswer(null, validCountry));
    }

    @Test
    void testNullExpectedValue() {
        assertFalse(FlagChecker.isCorrectAnswer("Германия", null));
    }

    @Test
    void testBothNull() {
        assertFalse(FlagChecker.isCorrectAnswer(null, null));
    }

    @Test
    void testEmptyUserInput() {
        assertFalse(FlagChecker.isCorrectAnswer("    ", validCountry));
    }
}
