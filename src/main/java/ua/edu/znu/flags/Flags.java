package ua.edu.znu.flags;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Гра «Впізнай прапор». Користувач вводить назву країни і клікає на її прапор.
 */
public final class Flags extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final transient JTextField jtf = new JTextField(15);
    private final transient JLabel resultLabel = new JLabel();
    private final transient JLabel prompt = new JLabel(
            "<html>Введіть назву країни в текстове поле і виконайте"
                    + "<br>клік на її прапорі</html>");

    /**
     * Створює та налаштовує головне вікно гри.
     */
    public Flags() {
        super();
        configureFrame();
        addFlagButtons();
        addInputControls();
        setVisible(true);
    }

    private void configureFrame() {
        setTitle("Flags Quiz");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void addFlagButtons() {
        for (FlagCountry country : FlagCountry.values()) {
            add(createFlagButton(country));
        }
    }

    private JButton createFlagButton(final FlagCountry country) {
        JButton button = new JButton(country.loadIcon());
        button.setActionCommand(country.countryName());
        button.addActionListener(this);
        return button;
    }

    private void addInputControls() {
        add(jtf);
        add(prompt);
        add(resultLabel);
    }

    @Override
    public void actionPerformed(final ActionEvent ae) {
        try {
            boolean correct = FlagChecker.isCorrectAnswer(
                    jtf.getText(), ae.getActionCommand());
            resultLabel.setText(correct ? "Правильно" : "Неправильно");
        } catch (IllegalArgumentException ex) {
            resultLabel.setText("Введіть назву країни");
        }
    }

    /**
     * Точка входу у програму.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(Flags::new);
    }
}
