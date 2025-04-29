package ua.edu.znu.flags;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private List<Integer> correctAnswers;
    private boolean multiple;

    public Question(String questionText, List<String> options, List<Integer> correctAnswers, boolean multiple) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswers = correctAnswers;
        this.multiple = multiple;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public List<Integer> getCorrectAnswers() {
        return correctAnswers;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public boolean isCorrect(List<Integer> userAnswers) {
        return correctAnswers.size() == userAnswers.size() && correctAnswers.containsAll(userAnswers);
    }
}
