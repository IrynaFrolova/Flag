package ua.edu.znu.flags;

import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * Стратегія для багатоваріантного питання — JCheckBox без групи.
 */
public final class MultiChoiceRenderer implements QuestionRenderer {

    /** {@inheritDoc} */
    @Override
    public void renderInto(final JPanel panel, final Question question) {
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            JCheckBox box = new JCheckBox(options.get(i));
            box.setActionCommand(String.valueOf(i));
            panel.add(box);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<Integer> collectAnswers(final JPanel panel) {
        return RendererSupport.collectSelectedIndices(panel);
    }
}
