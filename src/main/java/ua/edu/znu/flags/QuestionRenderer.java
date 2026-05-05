package ua.edu.znu.flags;

import java.util.List;
import javax.swing.JPanel;

/**
 * Стратегія відображення питання та збору відповідей.
 * Дозволяє розширювати застосунок новими типами питань без модифікації QuizApp
 * (принцип відкритості/закритості).
 */
public interface QuestionRenderer {

    /**
     * Будує елементи відповіді для одного питання у наданій панелі.
     *
     * @param panel    панель, у яку додаються елементи інтерфейсу
     * @param question питання, для якого формується інтерфейс
     */
    void renderInto(JPanel panel, Question question);

    /**
     * Збирає вибрані користувачем відповіді з елементів панелі.
     *
     * @param panel панель, з якої збираються вибрані варіанти
     * @return список індексів обраних варіантів
     */
    List<Integer> collectAnswers(JPanel panel);
}
