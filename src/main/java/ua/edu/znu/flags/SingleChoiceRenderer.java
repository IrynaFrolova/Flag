package ua.edu.znu.flags;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JRadioButton;

/**
 * Стратегія для одноваріантного питання — JRadioButton у спільній ButtonGroup.
 * Спільну логіку циклу рендерингу та збору відповідей успадковано з default-методів
 * інтерфейсу QuestionRenderer.
 */
public final class SingleChoiceRenderer implements QuestionRenderer {

    private final ButtonGroup group = new ButtonGroup();

    /** {@inheritDoc} */
    @Override
    public JComponent createOptionComponent(final int index, final String label) {
        JRadioButton button = new JRadioButton(label);
        button.setActionCommand(String.valueOf(index));
        return button;
    }

    /** {@inheritDoc} */
    @Override
    public void afterComponentCreated(final JComponent component) {
        if (component instanceof JRadioButton button) {
            group.add(button);
        }
    }
}
