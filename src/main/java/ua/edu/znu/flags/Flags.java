package ua.edu.znu.flags;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Гра «Впізнай прапор». Користувач вводить назву країни і клікає на її прапор.
 */
public class Flags extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static final String IMAGES_PATH = "/images/";

    private final transient JTextField jtf = new JTextField(15);
    private final transient JLabel isCorrect = new JLabel();
    private final transient JLabel prompt = new JLabel(
            "<html>Введіть назву країни в текстове поле і виконайте"
                    + "<br>клік на її прапорі</html>");

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
        add(createFlagButton("france.gif", "Франція"));
        add(createFlagButton("germany.gif", "Німеччина"));
        add(createFlagButton("sweden.gif", "Швеція"));
        add(createFlagButton("belgium.gif", "Бельгія"));
    }

    private JButton createFlagButton(String iconName, String countryCode) {
        URL url = getClass().getResource(IMAGES_PATH + iconName);
        if (url == null) {
            throw new IllegalStateException("Ресурс не знайдено: " + iconName);
        }
        JButton button = new JButton(new ImageIcon(url));
        button.setActionCommand(countryCode);
        button.addActionListener(this);
        return button;
    }

    private void addInputControls() {
        add(jtf);
        add(prompt);
        add(isCorrect);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            boolean correct = FlagChecker.isCorrectAnswer(
                    jtf.getText(), ae.getActionCommand());
            isCorrect.setText(correct ? "Правильно" : "Неправильно");
        } catch (IllegalArgumentException ex) {
            isCorrect.setText("Введіть назву країни");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Flags::new);
    }
}
