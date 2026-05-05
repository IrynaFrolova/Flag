package ua.edu.znu.flags;

/**
 * Утилітарний клас для перевірки відповідей користувача.
 * Не призначений для інстанціювання — має приватний конструктор.
 */
public final class FlagChecker {

    private FlagChecker() {
        throw new AssertionError("Утилітарний клас — не для інстанціювання");
    }

    /**
     * Перевіряє, чи введене користувачем значення збігається з очікуваною
     * назвою країни (без врахування регістру і обрамляючих пробілів).
     *
     * @param userInput       значення, введене користувачем
     * @param expectedCountry очікувана назва країни
     * @return true, якщо значення співпадають
     * @throws IllegalArgumentException якщо хоча б один з аргументів null або порожній
     */
    public static boolean isCorrectAnswer(final String userInput, final String expectedCountry) {
        validateNotBlank(userInput, "userInput");
        validateNotBlank(expectedCountry, "expectedCountry");
        return expectedCountry.equalsIgnoreCase(userInput.trim());
    }

    private static void validateNotBlank(final String value, final String name) {
        if (value == null) {
            throw new IllegalArgumentException(name + " не повинен бути null");
        }
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException(name + " не повинен бути порожнім");
        }
    }
}
