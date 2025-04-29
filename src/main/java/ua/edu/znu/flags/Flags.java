package ua.edu.znu.flags;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Flags extends JFrame implements ActionListener {
    JTextField jtf;
    JLabel isCorrect;
    JLabel prompt;

    public Flags() {
        setTitle("Flags Quiz");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Кнопка з прапором Франції
        ImageIcon france = new ImageIcon("src/main/resources/images/france.gif");
        JButton jb = new JButton(france);
        jb.setActionCommand("Франция");
        jb.addActionListener(this);
        add(jb);

        // Кнопка з прапором Німеччини
        ImageIcon germany = new ImageIcon("src/main/resources/images/germany.gif");
        jb = new JButton(germany);
        jb.setActionCommand("Германия");
        jb.addActionListener(this);
        add(jb);

        // Кнопка з прапором Швеції
        ImageIcon sweden = new ImageIcon("src/main/resources/images/sweden.gif");
        jb = new JButton(sweden);
        jb.setActionCommand("Швеция");
        jb.addActionListener(this);
        add(jb);

        // Кнопка з прапором Бельгії
        ImageIcon belgium = new ImageIcon("src/main/resources/images/belgium.gif");
        jb = new JButton(belgium);
        jb.setActionCommand("Бельгия");
        jb.addActionListener(this);
        add(jb);

        // Текстове поле для введення назви країни
        jtf = new JTextField(15);
        add(jtf);

        // Пояснення користувачу
        prompt = new JLabel("<html>Введите название страны в текстовое поле и выполните <br>щелчок на ее флаге</html>");
        add(prompt);

        // Поле для відображення результату
        isCorrect = new JLabel();
        add(isCorrect);

        setVisible(true);
    }

    // Обробник натискання на кнопку
    public void actionPerformed(ActionEvent ae) {
        String userInput = jtf.getText().trim();
        if (ae.getActionCommand().equalsIgnoreCase(userInput)) {
            isCorrect.setText("Правильно");
        } else {
            isCorrect.setText("Неправильно");
        }
    }

    public static void main(String[] args) {
        new Flags();
    }
}
