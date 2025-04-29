package ua.edu.znu.flags;

public class FlagChecker {

    // Рефакторинг для генерації виключення при некоректних даних
    public static boolean isCorrectAnswer(String userInput, String expectedCountry) {
        // Перевірка на null або пусті значення
        if (userInput == null || expectedCountry == null) {
            throw new IllegalArgumentException("Вхідні дані не повинні бути null");
        }

        if (userInput.trim().isEmpty() || expectedCountry.trim().isEmpty()) {
            throw new IllegalArgumentException("Вхідні дані не повинні бути порожніми");
        }

        return expectedCountry.equalsIgnoreCase(userInput.trim());
    }
}
