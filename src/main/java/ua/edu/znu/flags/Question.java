package ua.edu.znu.flags;

import java.util.List;

/**
 * Питання тесту з варіантами відповідей.
 * Тип питання (одно- або багатоваріантне) задається стратегією {@link QuestionRenderer}.
 */
public final class Question {

    private final String questionText;
    private final List<String> options;
    private final List<Integer> correctAnswers;
    private final QuestionRenderer renderer;

    /**
     * Створює нове питання з фіксованими списками варіантів і правильних відповідей.
     *
     * @param questionText   текст питання
     * @param options        список варіантів відповідей
     * @param correctAnswers список індексів правильних варіантів
     * @param renderer       стратегія відображення/збору відповідей
     */
    public Question(final String questionText,
                    final List<String> options,
                    final List<Integer> correctAnswers,
                    final QuestionRenderer renderer) {
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

    /**
     * Перевіряє, чи відповідь користувача збігається з правильною.
     *
     * @param userAnswers індекси обраних варіантів
     * @return true, якщо набір відповідей точно збігається з правильним
     */
    public boolean isCorrect(final List<Integer> userAnswers) {
        return correctAnswers.size() == userAnswers.size()
                && correctAnswers.containsAll(userAnswers);
    }
}
