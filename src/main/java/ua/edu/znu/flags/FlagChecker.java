package ua.edu.znu.flags;

/**
 * Утилітарний клас для перевірки відповідей користувача.
 */
public final class FlagChecker {

    private FlagChecker() {
        throw new AssertionError("Утилітарний клас — не для інстанціювання");
    }

    public static boolean isCorrectAnswer(String userInput, String expectedCountry) {
        validateNotBlank(userInput, "userInput");
        validateNotBlank(expectedCountry, "expectedCountry");
        return expectedCountry.equalsIgnoreCase(userInput.trim());
    }

    private static void validateNotBlank(String value, String name) {
        if (value == null) {
            throw new IllegalArgumentException(name + " не повинен бути null");
        }
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException(name + " не повинен бути порожнім");
        }
    }
}
