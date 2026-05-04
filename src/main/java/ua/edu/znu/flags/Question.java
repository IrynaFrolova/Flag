package ua.edu.znu.flags;

import java.util.List;

/**
 * Питання тесту з варіантами відповідей.
 * Тип питання (одно- або багатоваріантне) задається стратегією {@link QuestionRenderer}.
 */
public class Question {

    private final String questionText;
    private final List<String> options;
    private final List<Integer> correctAnswers;
    private final QuestionRenderer renderer;

    public Question(String questionText,
                    List<String> options,
                    List<Integer> correctAnswers,
                    QuestionRenderer renderer) {
        this.questionText = questionText;
        this.options = List.copyOf(options);
        this.correctAnswers = List.copyOf(correctAnswers);
        this.renderer = renderer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public QuestionRenderer getRenderer() {
        return renderer;
    }

    public boolean isCorrect(List<Integer> userAnswers) {
        return correctAnswers.size() == userAnswers.size()
                && correctAnswers.containsAll(userAnswers);
    }
}
