package ua.edu.znu.flags;

import java.util.List;
import javax.swing.JPanel;

/**
 * Стратегія відображення питання та збору відповідей.
 * Дозволяє розширювати застосунок новими типами питань без модифікації QuizApp
 * (принцип відкритості/закритості).
 */
public interface QuestionRenderer {

    /** Будує елементи відповіді для одного питання у наданій панелі. */
    void renderInto(JPanel panel, Question question);

    /** Збирає вибрані користувачем відповіді з елементів панелі. */
    List<Integer> collectAnswers(JPanel panel);
}
