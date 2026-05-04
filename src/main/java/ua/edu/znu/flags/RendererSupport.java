package ua.edu.znu.flags;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JPanel;

/**
 * Спільні утиліти для стратегій. Інкапсулює знання про внутрішню структуру JPanel,
 * щоб клас QuizApp не порушував закон Деметри.
 */
final class RendererSupport {

    private RendererSupport() {
        throw new AssertionError("Утилітарний клас");
    }

    static List<Integer> collectSelectedIndices(JPanel panel) {
        List<Integer> answers = new ArrayList<>();
        for (Component c : panel.getComponents()) {
            if (c instanceof AbstractButton button && button.isSelected()) {
                answers.add(Integer.parseInt(button.getActionCommand()));
            }
        }
        return answers;
    }
}
