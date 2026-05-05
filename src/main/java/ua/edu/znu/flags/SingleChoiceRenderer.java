package ua.edu.znu.flags;

import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Стратегія для одноваріантного питання — JRadioButton у ButtonGroup.
 */
public final class SingleChoiceRenderer implements QuestionRenderer {

    /** {@inheritDoc} */
    @Override
    public void renderInto(final JPanel panel, final Question question) {
        ButtonGroup group = new ButtonGroup();
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            JRadioButton button = new JRadioButton(options.get(i));
            button.setActionCommand(String.valueOf(i));
            group.add(button);
            panel.add(button);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Integer> collectAnswers(final JPanel panel) {
        return RendererSupport.collectSelectedIndices(panel);
    }
}
