package ua.edu.znu.flags;

public class FlagChecker {
    public static boolean isCorrectAnswer(String userInput, String expectedCountry) {
        if (userInput == null || expectedCountry == null) return false;
        return expectedCountry.equalsIgnoreCase(userInput.trim());
    }
}
