package ua.edu.znu.flags;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

/**
 * Стратегія для багатоваріантного питання — JCheckBox без групування.
 * Спільну логіку циклу рендерингу та збору відповідей успадковано з default-методів
 * інтерфейсу QuestionRenderer.
 */
public final class MultiChoiceRenderer implements QuestionRenderer {

    /** {@inheritDoc} */
    @Override
    public JComponent createOptionComponent(final int index, final String label) {
        JCheckBox box = new JCheckBox(label);
        box.setActionCommand(String.valueOf(index));
        return box;
    }
}
