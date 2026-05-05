package ua.edu.znu.flags;

import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Стратегія відображення питання та збору відповідей.
 * Дозволяє розширювати застосунок новими типами питань без модифікації QuizApp
 * (принцип відкритості/закритості).
 *
 * <p>Загальний цикл рендерингу варіантів і збір вибраних відповідей реалізовано
 * у самому інтерфейсі через default-методи, щоб уникнути дублювання коду
 * у конкретних реалізаціях.
 */
public interface QuestionRenderer {

    /**
     * Створює UI-компонент для одного варіанту відповіді з заданим індексом.
     *
     * @param index індекс варіанта
     * @param label текст варіанта
     * @return компонент-перемикач (JRadioButton, JCheckBox тощо)
     */
    JComponent createOptionComponent(int index, String label);

    /**
     * Виконує додаткові дії з компонентом одразу після його створення:
     * додавання у групу, налаштування поведінки тощо. За замовчуванням не робить нічого.
     *
     * @param component компонент, що був створений у createOptionComponent
     */
    default void afterComponentCreated(JComponent component) {
        // hook for subclasses
    }

    /**
     * Будує елементи відповіді для одного питання у наданій панелі.
     * Реалізація-шаблон, спільна для всіх типів питань.
     *
     * @param panel    панель, у яку додаються елементи інтерфейсу
     * @param question питання, для якого формується інтерфейс
     */
    default void renderInto(final JPanel panel, final Question question) {
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            JComponent component = createOptionComponent(i, options.get(i));
            afterComponentCreated(component);
            panel.add(component);
        }
    }

    /**
     * Збирає вибрані користувачем відповіді з елементів панелі.
     * Реалізація за замовчуванням делегує у RendererSupport,
     * оскільки логіка збору відповідей однакова для всіх типів питань.
     *
     * @param panel панель, з якої збираються вибрані варіанти
     * @return список індексів обраних варіантів
     */
    default List<Integer> collectAnswers(final JPanel panel) {
        return RendererSupport.collectSelectedIndices(panel);
    }
}
